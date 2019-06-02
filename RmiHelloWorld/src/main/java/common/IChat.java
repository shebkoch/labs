package common;

import javax.security.auth.login.LoginException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IChat extends Remote {
    void sendMessage(String name, String password, String msg) throws RemoteException, LoginException;
    void register(String name,String password) throws RemoteException,LoginException;
    List<IMessage> getMessages(String name, String password) throws RemoteException, LoginException;
}
