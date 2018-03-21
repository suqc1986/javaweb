package see;

import java.util.EventObject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ItemEventService implements  EventService {
    private Map<String,EventListener> listenersMap = new ConcurrentHashMap<String,EventListener>();
    @Override
    public void fireEvent(EventObject event) {
        for(EventListener listener:listenersMap.values()){
            try {
                listener.receiveEvent(event);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void registerEventListener(EventListener listener) {
        if(listener == null){
            throw new IllegalArgumentException("cannot register a listener that is null");
        }
        String key = listener.getClass().getName();
        this.listenersMap.put(key,listener);
    }
}
