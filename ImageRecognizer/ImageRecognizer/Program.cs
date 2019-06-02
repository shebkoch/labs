using System;
using System.Drawing;

namespace ImageRecognizer
{
    class Program
    {
        static void Main(string[] args)
        {
            Bitmap bitmap = new Bitmap("/home/shebkoch/RiderProjects/ImageRecognizer/ImageRecognizer/bin/Debug/netcoreapp2.1/Images/triangle.png");
            Image image = ImageReader.ReadImage(bitmap);
            TriangleRecognizer triangleRecognizer = new TriangleRecognizer();
            Console.WriteLine(triangleRecognizer.Recognize(image));
        }
    }
}