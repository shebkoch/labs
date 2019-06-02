package clientSide;

import java.util.Scanner;

public class ClientEntry {
    public static void main(String[] argv) {
        Client client = new Client("Alex2", "12345");
        ClientConnection clientConnection = new ClientConnection(client);
        clientConnection.chatConnect("localhost",13004);
        clientConnection.register();

        while (true){
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            if(!s.equals("")) clientConnection.sendMessage(s);
            System.out.print(clientConnection.getMessages());
        }
    }
}
