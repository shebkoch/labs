package common;

import javax.security.auth.login.LoginException;
import java.rmi.RemoteException;
import java.util.*;

public class Chat implements IChat {
    private List<IMessage> messages = new ArrayList<>();
    private Map<String,String> users = new HashMap<>();
    @Override
    public void sendMessage(String name, String password, String msg) throws LoginException, RemoteException {
        if(!isLoginCorrect(name,password)) throw new LoginException("password or login is incorrect");
        IMessage message = new Message(name,msg);
        messages.add(message);
    }

    @Override
    public void register(String name, String password) throws LoginException, RemoteException {
        if(users.containsKey(name)) throw new LoginException("login exists");
        users.put(name,password);
    }

    @Override
    public List<IMessage> getMessages(String name, String password) throws LoginException, RemoteException {
        if(!isLoginCorrect(name,password)) throw new LoginException("password or login is incorrect");
        return messages;
    }

    private boolean isLoginCorrect(String name, String password){
        return Objects.equals(users.get(name), password);
    }
}
