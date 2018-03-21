package see;

import java.util.EventObject;

public interface EventService {
    public void fireEvent(EventObject event);

    public void registerEventListener(EventListener listener);
}
