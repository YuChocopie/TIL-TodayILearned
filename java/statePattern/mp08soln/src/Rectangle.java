/**
 * Created by G209_30 on 2015-05-18.
 */
import java.awt.Graphics2D;
import java.io.BufferedWriter;
import java.io.IOException;

public class Rectangle extends RectShape {
    public Rectangle() {
        super();
    }

    public Rectangle(Point ulc, Point brc) {
        super(ulc, brc);
    }

    public void draw(Graphics2D g) {
        int x1, y1, x2, y2, x3, y3, x4, y4;
        x1 = (int) getUpperLeftCorner().getX();
        y1 = (int) getUpperLeftCorner().getY();
        x2 = (int) getBottomRightCorner().getX();
        y2 = (int) getBottomRightCorner().getY();
        x3 = x1;
        y3 = (int) (y1 + getHeight());
        x4 = (int) (x1 + getWidth());
        y4 = y1;
        g.drawLine(x1, y1, x3, y3);
        g.drawLine(x1, y1, x4, y4);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x2, y2, x4, y4);
    }

    public void save(BufferedWriter writer) {
        super.save(writer, "Rectangle");
    }
}
