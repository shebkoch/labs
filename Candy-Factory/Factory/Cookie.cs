using System.Collections.Generic;

namespace CandyFactory
{
	public class Cookie : Dessert
	{
		public CookieType CookieType { get; set; }
		public Ingredient Filling { get; set; }
	}

	public enum CookieType
	{
		Filled,
		Molded,
		Bar,
		Drop,
		NoBake,
		Pressed,
		Icebox,
		Rolled,
		Sandwich
	}
}