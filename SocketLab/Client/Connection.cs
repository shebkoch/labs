using System;
using System.Net;
using System.Net.Sockets;

namespace Client {
	public class Connection {
		private readonly IPAddress address;
		private readonly int port;
		private readonly Socket sender;
		public Connection(IPAddress address, int port) {
			this.address = address;
			this.port = port;
			sender = new Socket(SocketType.Stream, ProtocolType.Tcp);
			sender.Connect(new IPEndPoint(address,port));
		}
		public string Calculate(string expression) {
			byte[] bytes = System.Text.Encoding.UTF8.GetBytes($"{expression}<EOF>");
			sender.Send(bytes);  
			int bytesRec = sender.Receive(bytes); 
			return System.Text.Encoding.UTF8.GetString(bytes, 0, bytesRec);
		}
		~Connection() {
			sender.Shutdown(SocketShutdown.Both);  
			sender.Close();  
		}
	}
}