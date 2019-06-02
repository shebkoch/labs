import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static final int PORT = 19000;
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Started, waiting for connection");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted. " + socket.getInetAddress());
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                while (true) {
                    byte[] buf = new byte[32 * 1024];
                    int readBytes = in.read(buf);
                    String line = new String(buf, 0, readBytes);
                    if(line.equals("stop")) break;
                    String ans;
                    try {
                        ans = Calculator.Calculate(line).toString();
                    } catch (Throwable e) {
                        ans = "Invalid input";
                    }

                    out.write(ans.getBytes());
                    out.flush();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}

