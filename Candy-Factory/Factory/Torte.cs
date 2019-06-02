namespace CandyFactory
{
	public class Torte : Dessert
	{
		public TorteLayer Layer { get; set; }
		public Ingredient filling;
	}

	public enum TorteLayer
	{
		biscuit,
		shortbread,
		puffPastry,
		waffel
	}
}