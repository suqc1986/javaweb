package see;

import java.util.EventObject;

public interface EventListener {
    public void receiveEvent(EventObject eventObject) throws Exception;
}
