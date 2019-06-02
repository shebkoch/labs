using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Linq;

namespace ImageRecognizer
{
	public static class ImageReader
	{
		private static readonly int Background = Color.White.ToArgb();

		public static Image ReadImage(Bitmap bitmap)
		{
			byte[,] byteImage = GetByteView(bitmap);

			Image image = new Image(byteImage);
			return image;
		}

		private static byte[,] GetByteView(Bitmap bitmap)
		{
			byte[,] byteImage = new byte[bitmap.Height, bitmap.Width];
			for (int y = 0; y < bitmap.Height; y++)
			{
				for (int x = 0; x < bitmap.Width; x++)
				{
					if (bitmap.GetPixel(x, y).ToArgb() != Background)
						byteImage[x, y] = 1;
				}
			}

			return byteImage;
		}
	}
}