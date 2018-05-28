package bridge;

public abstract class DrawShapeAbs {
    DrawApi drawApi;

    public DrawShapeAbs(DrawApi drawApi) {
        this.drawApi = drawApi;
    }

    public void setDrawApi(DrawApi drawApi) {
        this.drawApi = drawApi;
    }
    public abstract void drawShape();
}
