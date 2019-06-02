namespace CandyFactory
{
	public class Utils
	{
		public delegate bool Compare<T> (T a, T b, out bool res) where T : Dessert;
	}
}