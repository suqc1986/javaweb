package bridge;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestMain {
    public static void main(String[] args){
        DrawApi api = new DrawCircle();
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("x",0);
        params.put("y",0);
        params.put("r",5);
        DrawShapeAbs drawShape = new DrawCircleShape(api, params);
        drawShape.drawShape();
    }
}
