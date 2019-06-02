namespace CandyFactory
{
	public class Chocolate : Dessert
	{
		public ChocolateType Type { get; set; }

		private float cocoaSolidsPercent;

		public float CocoaSolidsPercent
		{
			get { return cocoaSolidsPercent; }
			set
			{
				if (value < 0) cocoaSolidsPercent = 0;
				else if (value > 1) cocoaSolidsPercent = 1;
				else cocoaSolidsPercent = value;
			}
		}
	}

	public enum ChocolateType
	{
		Milk, White,Dark,Unsweetened
	}
}