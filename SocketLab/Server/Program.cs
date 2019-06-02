using System;
using System.Net;

namespace Server {
	internal static class Program {
		public static void Main() {
			Host.StartServer(IPAddress.Parse("127.0.0.1"),14000);
		}
	}
}