namespace CandyFactory
{
	public class Halva : Dessert
	{
		public HalvaBase HalvaBase { get; set; }
	}
	public enum HalvaBase
	{
		Semolina, Cornstarch, Rice,
		Sesame, Sunflower
	}
}