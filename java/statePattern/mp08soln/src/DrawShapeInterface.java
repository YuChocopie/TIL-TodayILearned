import java.awt.Graphics2D;

public interface DrawShapeInterface {
    int DRAWING_STATE = 0;
    int SELECTING_STATE = 1;

    void open(String fileName);
    void save(String fileName);
    void createShape(int x, int y);
    void draw(Graphics2D g);
    RectShape select(int x, int y);
    void selectDrawingShape(RectShapeFactory.RectShapeEnum shape);
    int getState();
    void setState(int state);
}
