package bridge;

import java.util.Map;

public class DrawRect implements DrawApi {
    @Override
    public void drawShape(Map<String, Object> params) {
        System.out.println("rect:   "+params);
    }
}
