package common;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class Message implements IMessage, Serializable {
    private String user;
    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Message)) return false;
        return id.equals(((Message) obj).getId());
    }

    private String message;
    private String id;
    private LocalDateTime dateTime;

    public Message(String user, String message, String id, LocalDateTime dateTime) {
        this.user = user;
        this.message = message;
        this.id = id;
        this.dateTime = dateTime;
    }
    public Message(String user, String message) {
        this.user = user;
        this.message = message;
        this.id = UUID.randomUUID().toString();
        this.dateTime = LocalDateTime.now().withNano(0);
    }

    @Override
    public String getId() {
        return id;
    }
    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public LocalDateTime getTime() {
        return dateTime;
    }
}
