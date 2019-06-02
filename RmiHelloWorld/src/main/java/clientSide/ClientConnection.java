package clientSide;

import common.IChat;
import common.IMessage;
import common.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ANSI;

import static utils.MessageUtils.*;

import javax.security.auth.login.LoginException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static utils.Colorizer.userColor;

public class ClientConnection {

    private static IChat chat;
    private Client client;
    private List<IMessage> usedMessages = new ArrayList<>();

    public ClientConnection(Client client) {
        this.client = client;
    }
    public void chatConnect(String hostname, int port){
        try {
            Registry registry = LocateRegistry.getRegistry(hostname, port);
            IChat chat = (IChat) registry.lookup("chataq");
            ClientConnection.setChat(chat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final static Logger logger = LogManager.getLogger(ClientConnection.class);

    public static void setChat(IChat chat) {
        ClientConnection.chat = chat;
    }

    public void sendMessage(String message){
        try {
            chat.sendMessage(client.getName(),client.getPassword(),message);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (LoginException e) {
            logger.error("login error: ", e.getMessage());
        }
    }
    public void register(){
        try {
            chat.register(client.getName(),client.getPassword());
        } catch (LoginException e) {
            logger.error("login error: ", e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public List<IMessage> getMessages(){
        try {
            List<IMessage> messages = chat.getMessages(client.getName(),client.getPassword());
            List<IMessage> current = intersect(messages,usedMessages);
            usedMessages.addAll(current);
            return current;
        } catch (LoginException e) {
            logger.error("login error: ", e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    public String getAllmessage(){
        List<IMessage> messages = null;
        try {
            messages = chat.getMessages(client.getName(),client.getPassword());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (LoginException e) {
            return "uncorrect login";
        }
        StringBuilder result = new StringBuilder();
        if (messages != null) {
            messages.forEach((x)->result.append(formatMessage(x)));
        }
        return result.toString();
    }

    private String formatMessage(LocalDateTime dateTime, String user,String msg){
        return String.format("(%s) %s : %s\n", dateTime.toLocalTime().toString(), user,msg);
    }
    private String formatMessage(IMessage message){
        return formatMessage(message.getTime(),message.getUser(),message.getMessage());
    }

}
