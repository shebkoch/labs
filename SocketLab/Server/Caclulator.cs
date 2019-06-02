using System;
using System.Collections.Generic;

using static Server.Utils;

namespace Server {
	public static class Caclulator {
		private const string Delimiter = " ";

		public static double Calculate(string input) {
			string output = GetExpression(input);
			double result = Counting(output);
			return result;
		}

		private static string GetExpression(string input) {
			string output = string.Empty;
			var operStack = new Stack<char>();

			for (var i = 0; i < input.Length; i++) {
				if (IsDelimeter(input[i])) continue;

				if (IsDigit(input[i])) {
					for (; i < input.Length; i++) {
						if (IsDelimeter(input[i]) || IsOperator(input[i])) break;
						output += input[i].ToString();
					}

					output += Delimiter;
					i--;
				}

				if (!IsOperator(input[i])) continue;

				if (input[i] == '(')
					operStack.Push(input[i]);
				else {
					if (input[i] == ')') {
						char c = operStack.Pop();

						while (c != '(') {
							output += c.ToString() + Delimiter;
							c = operStack.Pop();
						}
					}
					else {
						if (operStack.Count > 0)
							if (GetPriority(input[i]) <= GetPriority(operStack.Peek()))
								output += operStack.Pop() + Delimiter;

						operStack.Push(input[i]);
					}
				}
			} 

			while (operStack.Count > 0)
				output += operStack.Pop().ToString() + Delimiter;

			return output;
		}

		private static double Counting(string input) {
			double result = 0;
			var temp = new Stack<double>();

			for (var i = 0; i < input.Length; i++) {
				if (IsDigit(input[i])) {
					string toNubmer = string.Empty;

					for (; i < input.Length; i++) {
						if(IsDelimeter(input[i]) || IsOperator(input[i])) break;
						toNubmer += input[i];
					}
					temp.Push(double.Parse(toNubmer));
					i--;
				}
				else if (IsOperator(input[i])) 
				{
					double a = temp.Pop();
					double b = temp.Pop();
					switch (input[i])
					{
						case '+':
							result = b + a;
							break;
						case '-':
							result = b - a;
							break;
						case '*':
							result = b * a;
							break;
						case '/':
							result = b / a;
							break;
					}

					temp.Push(result);
				}
			}

			return temp.Peek();
		}
	}
}