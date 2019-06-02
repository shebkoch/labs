using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;

namespace ImageRecognizer
{
	public class Image
	{
		public byte[,] ByteView;
		public List<Point> ListView = new List<Point>();
		
		public Point StartPoint => ListView[0];
		public Point EndPoint => ListView[ListView.Count-1];
		public bool IsClosed => StartPoint.IsNeighbor(EndPoint);

		public int AngleCount { get; private set; }

		public Image(byte[,] byteView)
		{
			ByteView = byteView;
			SetListView();
		}

		
		private void SetListView()
		{
			byte[,] byteImage = ByteView;
			Point startPoint = GetAnyPoint(byteImage);
			if (startPoint == Point.Empty) throw new InvalidDataException("Image is empty");
			Point nextPoint = startPoint;
			while (nextPoint != Point.Empty)
			{
				nextPoint = AddNextPoint(nextPoint, ref byteImage);
			}
			if (GetAnyPoint(byteImage) != Point.Empty) throw new InvalidDataException("Image has not supported format");
		}
		
		private static Point GetAnyPoint(byte[,] byteImage)
		{
			for (int y = 0; y < byteImage.GetLength(0); y++)
			{
				for (int x = 0; x < byteImage.GetLength(1); x++)
				{
					if (byteImage[x, y] == 1)
					{
						return new Point(x, y);
					}
				}
			}
			return Point.Empty;
		}
		private Point AddNextPoint(Point point,ref byte[,] byteImage)
		{
			List<Point> neighbors = GetPointNeighbors(point, byteImage,new List<Point>{point});
			Point nextPoint = new Point();
			if (neighbors.Count > 2) throw new InvalidDataException("Image has not supported format");

			if (neighbors.Count == 2)
			{
				AngleCount++;
				
				List<Point> exclusive = new List<Point> {neighbors[0], neighbors[1], point};
				List<Point> neighbors0 = GetPointNeighbors(neighbors[0], byteImage, exclusive);
				List<Point> neighbors1 = GetPointNeighbors(neighbors[1], byteImage, exclusive);

				int count0 = neighbors0.Count;
				int count1 = neighbors1.Count;
				if (count0 > 0 && count1 == 0)
				{
					AddPointsByOrder(new List<Point> {point, neighbors[1]}, ref byteImage);
					nextPoint = neighbors[0];
				}
				if (count0 == 0 && count1 > 0)
				{
					AddPointsByOrder(new List<Point> {point, neighbors[0]}, ref byteImage);
					nextPoint = neighbors[1];
				}
				if (count0 > 0 && count1 > 0)
				{
					AddPointsByOrder(new List<Point> {neighbors[0], point}, ref byteImage);
					nextPoint = neighbors[1];
				}
			}
			else if (neighbors.Count == 0)
			{
				AddPointsByOrder(new List<Point> {point}, ref byteImage);
				return Point.Empty;
			}
			else
			{
				AddPointsByOrder(new List<Point> {point}, ref byteImage);
				nextPoint = neighbors[0];
			}

			return nextPoint;
		}

		private Point AddPointsByOrder(List<Point> points,ref byte[,] byteImage)
		{
			foreach (var point in points)
			{
				ListView.Add(point);
				ClearPoint(point, ref byteImage);
			}
			return ListView.Last();
		}
		private static void ClearPoint(Point point, ref byte[,] byteImage)
		{
			byteImage[point.X, point.Y] = 0;
		}

		private static void ClearPoints(List<Point> points,ref byte[,] byteImage)
		{
			foreach (var point in points)
			{
				ClearPoint(point, ref byteImage);
			}
		}

		private static List<Point> GetPointNeighbors(Point point, byte[,] byteImage)
		{
			return GetPointNeighbors(point, byteImage, null);
		}

		private static List<Point> GetPointNeighbors(Point point, byte[,] byteImage, List<Point> exclusive)
		{
			List<Point> neighbors = new List<Point>();
			for (int y = point.Y - 1; y <= point.Y + 1; y++)
			{
				for (int x = point.X - 1; x <= point.X + 1; x++)
				{
					if (byteImage[x, y] == 1)
					{
						Point neighbor = new Point(x, y);
						if (exclusive != null && exclusive.Contains(neighbor)) continue;
						neighbors.Add(neighbor);
					}
				}
			}

			return neighbors;
		}
		public override string ToString()
		{
			StringBuilder stringBuilder = new StringBuilder();
			for (int y = 0; y < ByteView.GetLength(0); y++)
			{
				for (int x = 0; x < ByteView.GetLength(1); x++)
				{
					stringBuilder.Append(ByteView[x, y]).Append(" ");
				}

				stringBuilder.Append("\n");
			}

			return stringBuilder.ToString();
		}
	}
}