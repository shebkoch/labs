using System;
using System.Text;

namespace Server {
	using System.Net;
	using System.Net.Sockets;
	public static class Host {
		public static void StartServer(IPAddress address, int port) {
			var listener = new Socket(SocketType.Stream, ProtocolType.Tcp ); 
			listener.Bind(new IPEndPoint(address, port));  
			listener.Listen(10); 
			while (true) {    
				Socket handler = listener.Accept();  
				string data = string.Empty;
				var bytes = new byte[256];
				while (true) {  
					int bytesRec = handler.Receive(bytes);  
					data += Encoding.UTF8.GetString(bytes,0,bytesRec);  
					if (data.IndexOf("<EOF>") > -1) break;  
					
				}

				double result = Caclulator.Calculate(data);
				
				byte[] msg = Encoding.UTF8.GetBytes(result.ToString());  

				handler.Send(msg);  
				handler.Shutdown(SocketShutdown.Both);  
				handler.Close();  
			}  
		}
	}
}