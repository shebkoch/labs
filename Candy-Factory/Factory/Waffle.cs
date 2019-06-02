namespace CandyFactory
{
	public class Waffle : Dessert
	{
		public Ingredient Topping { get; set; }
		public WaffleType Type { get; set; }
	}

	public enum WaffleType
	{
		Brussels,
		Liege,
		Flemish,
		American,
		Belgian,
		HongKong,
		Pandan,
		Gofri,
		Stroopwafels,
		Hotdog
	}


}