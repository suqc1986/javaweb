package bridge;

import java.util.Map;

public class DrawCircleShape extends DrawShapeAbs{
    Map<String,Object>  params;
    public DrawCircleShape(DrawApi api, Map<String,Object> params){
        super(api);
        this.params = params;
    }
    @Override
    public void drawShape() {
        drawApi.drawShape(params);
    }
}
