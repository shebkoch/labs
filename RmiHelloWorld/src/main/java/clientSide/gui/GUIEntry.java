package clientSide.gui;

import clientSide.Client;
import clientSide.ClientConnection;
import common.IMessage;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GUIEntry {
    private static Stack<String> messageOrder = new Stack<>();
    private static volatile String name;
    private static String password;
    public static void setPerson(String name, String password){
        GUIEntry.name = name;
        GUIEntry.password = password;
    }
    public static void addMessagetoOrder(String msg){
        messageOrder.add(msg);
    }

    public static void main(String[] argv) {
//        Client client = new Client("Alex", "12345");
//        ClientConnection clientConnection = new ClientConnection(client);
//        clientConnection.chatConnect("localhost",13004);
//        clientConnection.register();
        var guichat = new GUIChat();
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(guichat.getMainPanel());
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setSize(400,500);
        jFrame.setLocation(0,0);
        var register = new Register();
        register.setSize(400,200);
        jFrame.setLocation(0,0);
        register.setVisible(true);
        while (name == null) Thread.onSpinWait();
        Client client = new Client(name,password);
        ClientConnection clientConnection = new ClientConnection(client);
        clientConnection.chatConnect("localhost",13004);
        clientConnection.register();



        while (true){
            if(!messageOrder.isEmpty())
                clientConnection.sendMessage(messageOrder.pop());
            var mes = clientConnection.getAllmessage();
            if(!guichat.getTextPane1().getText().equals(mes))
                guichat.getTextPane1().setText(mes);
        }

    }

}
