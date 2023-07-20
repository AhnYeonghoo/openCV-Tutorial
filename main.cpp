#include <iostream>
#include <opencv2/opencv.hpp>
#include <vector>

using namespace cv;
using namespace std;

/* SSIM 값 구하기 */
Scalar getMSSIM(const Mat& i1, const Mat& i2)
{
	const double C1 = 6.5025, C2 = 58.5225;
	/***************************** INITS **********************************/
	int d = CV_32F;
	Mat I1, I2;
	i1.convertTo(I1, d);           // cannot calculate on one byte large values
	i2.convertTo(I2, d);
	Mat I2_2 = I2.mul(I2);        // I2^2
	Mat I1_2 = I1.mul(I1);        // I1^2
	Mat I1_I2 = I1.mul(I2);        // I1 * I2
	/*************************** END INITS **********************************/
	Mat mu1, mu2;   // PRELIMINARY COMPUTING
	GaussianBlur(I1, mu1, Size(11, 11), 1.5);
	GaussianBlur(I2, mu2, Size(11, 11), 1.5);
	Mat mu1_2 = mu1.mul(mu1);
	Mat mu2_2 = mu2.mul(mu2);
	Mat mu1_mu2 = mu1.mul(mu2);
	Mat sigma1_2, sigma2_2, sigma12;
	GaussianBlur(I1_2, sigma1_2, Size(11, 11), 1.5);
	sigma1_2 -= mu1_2;
	GaussianBlur(I2_2, sigma2_2, Size(11, 11), 1.5);
	sigma2_2 -= mu2_2;
	GaussianBlur(I1_I2, sigma12, Size(11, 11), 1.5);
	sigma12 -= mu1_mu2;
	Mat t1, t2, t3;
	t1 = 2 * mu1_mu2 + C1;
	t2 = 2 * sigma12 + C2;
	t3 = t1.mul(t2);              // t3 = ((2*mu1_mu2 + C1).*(2*sigma12 + C2))
	t1 = mu1_2 + mu2_2 + C1;
	t2 = sigma1_2 + sigma2_2 + C2;
	t1 = t1.mul(t2);               // t1 =((mu1_2 + mu2_2 + C1).*(sigma1_2 + sigma2_2 + C2))
	Mat ssim_map;
	divide(t3, t1, ssim_map);      // ssim_map =  t3./t1;
	Scalar mssim = mean(ssim_map); // mssim = average of ssim map
	return mssim;
}



int mainTemp()
{
	/* 이미지 불러오기 및 리사이즈 */
	const char* ok = "./images/result/ok.jpg";
	const char* anomaly = "./images/result/anomaly.jpg";
	Mat src = imread(ok, IMREAD_GRAYSCALE);
	Mat compressed = imread(anomaly, IMREAD_GRAYSCALE);
	resize(src, src, Size(555, 555), 0.3, 0.3, INTER_LINEAR);
	resize(compressed, compressed, Size(555, 555), 0.3, 0.3, INTER_LINEAR);
	/*   끝     */

	/* SSIM 계산 */
	Scalar ssim = getMSSIM(src, compressed);
	cout << ssim << endl;
	/* 끝  */
	
	/* 임계치로 이진화  */
	Mat thresh1, thresh2;
	threshold(src, thresh1, 0, 255, THRESH_BINARY);
	threshold(src, thresh2, 0, 255, THRESH_BINARY);
	/*    끝    */

	/* 외각점 찾기  */
	vector<vector<Point>> contours;
	vector<Vec4i> hierarchy;
	findContours(thresh1, contours, hierarchy, RETR_EXTERNAL, CHAIN_APPROX_SIMPLE);
	cout << contours.size() << endl;
	/* 끝 */


	/* 바운딩 박스 찾기 */
	vector<vector<Point>> contours_poly(contours.size());
	vector<Rect> boundRect(contours.size());
	vector<Point2f> centers(contours.size());
	vector<float> radius(contours.size());
	Mat canny_output;
	Canny(thresh1, canny_output, 100, 100 * 2);
	for (size_t i = 0; i < contours.size(); i++)
	{
		approxPolyDP(contours[i], contours_poly[i], 3, true);
		boundRect[i] = boundingRect(contours_poly[i]);
		minEnclosingCircle(contours_poly[i], centers[i], radius[i]);
	}
	/* 끝 */

	/* 바운딩 박스 그리기 */
	Mat drawing = Mat::zeros(canny_output.size(), CV_8UC3);
	for (size_t i = 0; i < contours.size(); i++)
	{
		Scalar color = Scalar(RNG(0), RNG(0), RNG(0));
		drawContours(drawing, contours_poly, (int)i, color);
		rectangle(drawing, boundRect[i].tl(), boundRect[i].br(), color, 2);
		circle(drawing, centers[i], (int)radius[i], color, 2);
	}
	/* 끝 */
	

	imshow("src", drawing);
	imshow("compressed", compressed);
	waitKey(0);
	



	return 0;

}