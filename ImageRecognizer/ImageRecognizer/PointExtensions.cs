using System;
using System.Drawing;
using System.Net;

namespace ImageRecognizer
{
	public static class PointExtensions
	{
		public static Point Vector(this Point startPoint, Point endPoint)
		{
			return new Point(Math.Abs(endPoint.X - startPoint.X), Math.Abs(endPoint.Y - startPoint.Y));
		}

		public static bool IsNeighbor(this Point startPoint, Point endPoint)
		{
			Point point = startPoint.Vector(endPoint);
			return point.X == 1 || point.Y == 1;
		}
	}
}