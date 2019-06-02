namespace CandyFactory
{
	public class Candy : Dessert
	{
		public CandyType Type { get; set; }
	}

	public enum CandyType
	{
		Gummie,
		Licorice,
		Lollipop,
		Caramels,
		Chocolate
	}
}