using System.Drawing;
using System.Linq;

namespace ImageRecognizer
{
	public static class AnglesCounter
	{
		public static int CountAngle(Image image)
		{
			int angleCount = 0;
			for (int i = 2; i < image.ListView.Count; i++)
			{
				Point
					p1 = image.ListView[i - 2],
					p2 = image.ListView[i - 1],
					p3 = image.ListView[i];
				if (IsRightAngle(p1, p2, p3) || IsDiagonalAngle(p1, p2, p3)) angleCount++;
			}

			return angleCount;
		}

		public static bool IsRightAngle(Point p1, Point p2, Point p3)
		{
			Point vector = p1.Vector(p3);
			return vector.X == 1 && vector.Y == 1;
		}

		public static bool IsDiagonalAngle(Point p1, Point p2, Point p3)
		{
			Point vector1 = p2.Vector(p1);
			Point vector2 = p2.Vector(p3);
			bool isDiagonal = vector1.X == 1 && vector1.Y == 1 && vector2.X == 1 && vector2.Y == 1;
			return isDiagonal && (p1.X == p3.X || p1.Y == p3.Y);
		}
	}
}