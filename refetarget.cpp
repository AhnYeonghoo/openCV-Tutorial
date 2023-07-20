#include <iostream>
#include <opencv2/opencv.hpp>
#include <string>
#include <fstream>
#include <vector>


using namespace cv;
using namespace std;
using namespace cv::dnn;

// Constants
const float INPUT_WIDTH = 640.0;
const float INPUT_HEIGHT = 640.0;
const float SCORE_THRESHOLD = 0.5;
const float NMS_THRESHOLD = 0.45;
const float CONFIDENCE_THRESHOLD = 0.45;

const float FONT_SCALE = 0.7;
const int FONT_FACE = FONT_HERSHEY_SIMPLEX;
const int THICKNESS = 1;

Scalar BLACK = Scalar(0, 0, 0);
Scalar BLUE = Scalar(255, 178, 50);
Scalar YELLOW = Scalar(0, 255, 255);
Scalar RED = Scalar(0, 0, 255);

void draw_label(Mat& input_image, string label, int left, int top)
{
    int baseLine;
    Size label_size = getTextSize(label, FONT_FACE, FONT_SCALE, THICKNESS, &baseLine);
    top = max(top, label_size.height);

    Point tlc = Point(left, top);

    Point brc = Point(left + label_size.width, top + label_size.height + baseLine);

    rectangle(input_image, tlc, brc, BLACK, FILLED);

    putText(input_image, label, Point(left, top + label_size.height), FONT_FACE, FONT_SCALE, YELLOW, THICKNESS);
}

vector<Mat> pre_process(Mat& input_image, Net& net)
{
    // Convert to blob.
    Mat blob;
    blobFromImage(input_image, blob, 1. / 255., Size(INPUT_WIDTH, INPUT_HEIGHT), Scalar(), true, false);

    net.setInput(blob);

    // Forward propagate.
    vector<Mat> outputs;
    net.forward(outputs, net.getUnconnectedOutLayersNames());

    return outputs;
}

Mat post_process(Mat& input_image, vector<Mat>& outputs, const vector<string>& class_name)
{
    // Initialize vectors to hold respective outputs while unwrapping     detections.
    vector<int> class_ids;
    vector<float> confidences;
    vector<Rect> boxes;
    // Resizing factor.
    float x_factor = input_image.cols / INPUT_WIDTH;
    float y_factor = input_image.rows / INPUT_HEIGHT;
    float* data = (float*)outputs[0].data;
    const int dimensions = 85;
    // 25200 for default size 640.
    const int rows = 25200;
    // Iterate through 25200 detections.
    for (int i = 0; i < rows; ++i)
    {
        float confidence = data[4];
        // Discard bad detections and continue.
        if (confidence >= CONFIDENCE_THRESHOLD)
        {
            float* classes_scores = data + 5;
            // Create a 1x85 Mat and store class scores of 80 classes.
            Mat scores(1, class_name.size(), CV_32FC1, classes_scores);
            // Perform minMaxLoc and acquire the index of best class  score.
            Point class_id;
            double max_class_score;
            minMaxLoc(scores, 0, &max_class_score, 0, &class_id);
            // Continue if the class score is above the threshold.
            if (max_class_score > SCORE_THRESHOLD)
            {
                // Store class ID and confidence in the pre-defined respective vectors.
                confidences.push_back(confidence);
                class_ids.push_back(class_id.x);
                // Center.
                float cx = data[0];
                float cy = data[1];
                // Box dimension.
                float w = data[2];
                float h = data[3];
                // Bounding box coordinates.
                int left = int((cx - 0.5 * w) * x_factor);
                int top = int((cy - 0.5 * h) * y_factor);
                int width = int(w * x_factor);
                int height = int(h * y_factor);
                // Store good detections in the boxes vector.
                boxes.push_back(Rect(left, top, width, height));
            }
        }
        // Jump to the next row.
        data += 85;
    }
    // Perform Non-Maximum Suppression and draw predictions.
    vector<int> indices;
    NMSBoxes(boxes, confidences, SCORE_THRESHOLD, NMS_THRESHOLD, indices);
    for (int i = 0; i < indices.size(); i++)
    {
        int idx = indices[i];
        Rect box = boxes[idx];
        int left = box.x;
        int top = box.y;
        int width = box.width;
        int height = box.height;
        // Draw bounding box.
        rectangle(input_image, Point(left, top), Point(left + width, top + height), BLUE, 3 * THICKNESS);
        // Get the label for the class name and its confidence.
        string label = format("%.2f", confidences[idx]);
        label = class_name[class_ids[idx]] + ":" + label;
        // Draw class labels.
        draw_label(input_image, label, left, top);
    }
    return input_image;
}

int main()
{
    // 영상흭득
    Mat reference_image;
    Mat target_image;
    reference_image = imread("./images/sample-06/ok.jpg"); // 정상 커패시터
    target_image = imread("./images/sample-06/anomaly.jpg"); // 비정상 커패시터
    Mat all_image = imread("./images/sample-06/_IMG06-A_raw.jpg");
 
    // 예외처리
    if (reference_image.empty() || target_image.empty())
    {
        cerr << "Image Load Failed!" << endl;
        return -1;
    }

    // mean 필터링 & median 필터링
    Mat avg_kernel = Mat::ones(5, 5, CV_32F) / 25;
    filter2D(reference_image, reference_image, -1, avg_kernel, Point(-1, -1), (0, 0), 0);
    filter2D(target_image, target_image, -1, avg_kernel, Point(-1, -1), (0, 0), 0);
    
    // 그레이스케일로 변환
    cvtColor(reference_image, reference_image, COLOR_BGR2GRAY);
    cvtColor(target_image, target_image, COLOR_BGR2GRAY);
    cvtColor(all_image, all_image, COLOR_BGR2GRAY);

    // 영상 이진화
    threshold(reference_image, reference_image, 0, 255, THRESH_BINARY | THRESH_OTSU);
    threshold(target_image, target_image, 0, 255, THRESH_BINARY | THRESH_OTSU);
    threshold(all_image, all_image, 0, 255, THRESH_BINARY | THRESH_OTSU);

    // 이미지 크기 조절
    resize(reference_image, reference_image, Size(555, 555), 0.3, 0.3, INTER_AREA);
    resize(target_image, target_image, Size(555, 555), 0.3, 0.3, INTER_AREA);
    resize(all_image, all_image, Size(555, 555), 0.3, 0.3, INTER_AREA);

    Mat result;
    bitwise_and(reference_image, target_image, result);
    
    

    imshow("reference_image", reference_image);
    imshow("target_image", target_image);
    imshow("result", result);

    waitKey(0);
    
    return 0;
}