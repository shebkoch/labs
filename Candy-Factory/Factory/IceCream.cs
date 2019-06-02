using System.Collections.Generic;

namespace CandyFactory
{
	public class IceCream
	{
		public IceCreamType type { get; set; }
		public List<Ingredient> Topping { get; set; }
	}

	public enum IceCreamType
	{
		Sorbet,
		Sherbet,
		IceMilk,
		Sandwich,
		CremeBrulee,
		Plombir
	}
}