#include <iostream>
#include <opencv2/opencv.hpp>

using namespace cv;
using namespace std;

Mat src, dst;
int morph_elem = 0;
int morph_size = 0;
int morph_operator = 0;
int const max_operator = 4;
int const max_eleme = 2;
int const max_kernel_size = 21;

String window_name = "Morphology Transformations Demo";

void morphologyOperations(int, void*);

int mainMoreMorphologyTransformations(int argc, char** argv)
{
	CommandLineParser parser(argc, argv, "{@input | baboon.jpg | input image}");
	src = imread(samples::findFile(parser.get<String>("@input")), IMREAD_COLOR);
	if (src.empty())
	{
		cout << "Could not open or find the image\n";
		cout << "Usage: " << argv[0] << " <Input image>" << endl;
		return EXIT_FAILURE;
	}
	String window_name = "Morphology Transformations Demo";
	namedWindow(window_name, WINDOW_AUTOSIZE);
	
	createTrackbar("Operator:\n 0: Opening - 1: Closing\n 2: Gradient: - 3: Top Hat\n 4: Black Hat",
		window_name, &morph_operator, max_operator, morphologyOperations);
	
	createTrackbar("Kernel size:\n 2n +1", window_name, &morph_size, max_kernel_size,
		morphologyOperations);
	morphologyOperations(0, 0);
	return 0;
}

void morphologyOperations(int, void*)
{
	int operation = morph_operator + 2;
	String window_name = "Morphology Transformations Demo";
	Mat element = getStructuringElement(morph_elem,
		Size(2 * morph_size + 1, 2 * morph_size + 1), Point(morph_size,
			morph_size));
	
	morphologyEx(src, dst, operation, element);
	imshow(window_name, dst);
}