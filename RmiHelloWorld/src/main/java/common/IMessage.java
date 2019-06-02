package common;

import java.time.LocalDateTime;

public interface IMessage {
    String getId();
    String getUser();
    String getMessage();
    LocalDateTime getTime();
}
