package see;

import java.util.EventObject;

public class ItemEventListener implements EventListener {
    @Override
    public void receiveEvent(EventObject eventObject) throws Exception {
        String msg = (String)eventObject.getSource();
        System.out.println(msg);
    }
    public void setEventService(EventService service){
        if(service == null)
            throw new IllegalArgumentException("EventService handed to Listener cannot  be null.");
        else
            service.registerEventListener(this);
    }
}
