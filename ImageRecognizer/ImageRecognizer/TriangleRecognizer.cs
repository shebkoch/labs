namespace ImageRecognizer
{
	public class TriangleRecognizer : IRecognizer
	{
		public bool Recognize(Image image)
		{
			return image.IsClosed && image.AngleCount == 3;
		}
	}
}