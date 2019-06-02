using System;
using System.Net;

namespace Client {
	internal static class Program {
		public static void Main(string[] args) {
			var connection = new Connection(IPAddress.Parse("127.0.0.1"),14000);
			Console.WriteLine(connection.Calculate("2*(43+20)"));
		}
	}
}