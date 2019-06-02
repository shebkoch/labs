using System;

namespace Server {
	public static class Utils {
		public static bool IsOperator(char с) {
			return "+-/*()".IndexOf(с) != -1;
		}
		public static byte GetPriority(char c) {
			switch (c) {
				case '(':
				case ')':
					return 0;
				case '+':
				case '-':
					return 1;
				case '*':
				case '/':
					return 2;
				default:
					return 3;
			}
		}

		public static bool IsDigit(char c) {
			return char.IsDigit(c);
		}
		public static bool IsDelimeter(char c) {
			return c == ' ';
		}
	}
}