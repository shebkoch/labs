using System;

namespace CandyFactory
{
	public interface IGift<T> where T : Dessert
	{
		void Discount(Action<T> action);
		Gift<U> SelectByType<U>(Func<T, U> func) where  U : Dessert;
		void Sort(Utils.Compare<T> compare);
	 
	}
	
}