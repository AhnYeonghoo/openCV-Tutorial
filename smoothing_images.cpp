#include <iostream>
#include <opencv2/opencv.hpp>

using namespace std;
using namespace cv;

const int DELAY_CAPTION = 1500;
const int DELAY_BLUR = 100;
const int MAX_KERNEL_LENGTH = 31;

Mat src, dst;
char window_name[] = "Smoothing Demo";

int displayCaption(const char* caption);
int displayDst(int delay);

int main(int argc, char** argv)
{
	namedWindow(window_name, WINDOW_AUTOSIZE);
	const char* filename = "./images/sample-06R/_IMG06R-C_raw.jpg";
	
	src = imread(samples::findFile(filename), IMREAD_COLOR);
	if (src.empty())
	{
		printf("Error opening image\n");
		printf("Usage:\n %s [image_name-- default lena.jpg] \n", argv[0]);
		return EXIT_FAILURE;
	}

	if (displayCaption("Original Image") != 0)
	{
		return 0;
	}
	
	dst = src.clone();
	if (displayDst(DELAY_CAPTION) != 0)
	{
		return 0;
	}

	if (displayCaption("Homogeneous Blur") != 0)
	{
		return 0;
	}

	for (int i = 1; i < MAX_KERNEL_LENGTH; i = i + 2)
	{
		blur(src, dst, Size(i, i), Point(-1, -1));
		if (displayDst(DELAY_BLUR) != 0) return 0;
	}

	if (displayCaption("Gaussian Blur") != 0)
	{
		return 0;
	}
	
	for (int i = 1; i < MAX_KERNEL_LENGTH; i = i + 2)
	{
		medianBlur(src, dst, i);
		if (displayDst(DELAY_BLUR) != 0) return 0;
	}

	if (displayCaption("Bilateral Blur") != 0)
	{
		return 0;
	}

	for (int i = 1; i < MAX_KERNEL_LENGTH; i += 2)
	{
		bilateralFilter(src, dst, i, i * 2, i / 2);
		if (displayDst(DELAY_BLUR) != 0) return 0;
	}

	displayCaption("done!");

	return 0;
}

int displayCaption(const char* caption)
{
	dst = Mat::zeros(src.size(), src.type());
	putText(dst, caption, Point(src.cols / 4, src.rows / 2),
		FONT_HERSHEY_COMPLEX, 1, Scalar(255, 255, 255));
	return displayDst(DELAY_CAPTION);
}

int displayDst(int delay)
{
	resize(src, src, Size(555, 555), 0.25, 0.25, INTER_AREA);
	imshow(window_name, dst);
	int c = waitKey(delay);
	if (c >= 0) { return -1; }
	return 0;
}

