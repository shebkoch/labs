using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace CandyFactory
{
	public class Gift<T> : List<T>,IGift<T>, ICloneable, IEnumerator where T : Dessert
	{
		public float Cost;
		
		private int currentId = 0;

		
		public void Discount(Action<T> action)
		{
			foreach (T dessert in this) action(dessert);
		}

		public Gift<U> SelectByType<U>(Func<T, U> func) where U : Dessert
		{
			Gift<U> list = new Gift<U>();
			foreach (T dessert in this)
			{
				U result = func(dessert);
				if(result != null) list.Add(result);
			}

			return list;
		}

		public void Sort(Utils.Compare<T> compare)
		{
			throw new NotImplementedException();
		}


		public object Clone()
		{
			Gift<T> gift = new Gift<T>();
			this.ForEach(gift.Add);
			return gift;
		}

		public bool MoveNext()
		{
			if (currentId < this.Count)
			{
				currentId++;
				return true;
			}
			else
			{
				Reset();
				return false;
			}
		}

		public void Reset()
		{
			currentId = 0;
		}

		object IEnumerator.Current
		{
			get { return this[currentId]; }
		}
	}
}