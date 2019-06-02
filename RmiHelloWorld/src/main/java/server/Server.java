package server;

import common.Chat;
import common.IChat;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] argv) {
        try {
//            if(System.getSecurityManager()==null){
//                System.setSecurityManager(new SecurityManager());
//            }
            IChat chat = (IChat) UnicastRemoteObject.exportObject(new Chat(), 0);
            Registry registry = LocateRegistry.createRegistry(13004);
            //Registry registry = LocateRegistry.getRegistry("localhost",13004);
            registry.bind("chataq", chat);
            System.err.println("server.Server ready");
        } catch (Exception ex) {
            System.err.println("server.Server exception: " + ex.toString());
            ex.printStackTrace();
        }
        while (true);
    }
}
