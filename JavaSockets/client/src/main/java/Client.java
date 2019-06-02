import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static final int PORT = 19000;
    public static final String HOST = "localhost";
    public static void main(String[] args) {
        Socket socket = null;
        System.out.println("input expression or input 'stop' to stop");
        try {
            socket = new Socket(HOST, PORT);
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    String exp = scanner.nextLine();
                    out.write(exp.getBytes());
                    out.flush();
                    if(exp.equals("stop")) break;
                    byte[] buf = new byte[32 * 1024];
                    int readBytes = in.read(buf);
                    System.out.printf("%s\n", new String(buf, 0,
                            readBytes));
                }
            }
        } catch (Throwable e){
            System.out.println("Server unreachable");
        }
    }
}