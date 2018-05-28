package bridge;

import java.util.Map;

public class DrawCircle implements DrawApi {
    @Override
    public void drawShape(Map<String, Object> params) {
        System.out.println("circle: "+ params);
    }
}
