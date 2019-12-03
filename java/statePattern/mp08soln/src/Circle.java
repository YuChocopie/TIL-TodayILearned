import java.awt.*;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by G209_30 on 2015-05-07.
 */
public class Circle extends Ellipse {
    public Circle() {
        super();
    }

    public Circle(Point ulc, Point brc) {
        super(ulc, brc);
        calcNewBottomRightCorner(ulc);
    }

    public void setUpperLeftCorner(Point ulc) {
        super.setUpperLeftCorner(ulc);
        calcNewBottomRightCorner(ulc);
    }

    public void setBottomRightCorner(Point brc) {
        super.setBottomRightCorner(brc);
        calcNewBottomRightCorner(getUpperLeftCorner());
    }

    public void draw(Graphics2D g) {
        super.draw(g);
    }

    private void calcNewBottomRightCorner(Point ulc) {
        double w = getWidth();
        double h = getHeight();
        if (w > h) {
            super.setBottomRightCorner(new Point(ulc.getX() + w, ulc.getY() + w));
        }
        else {
            super.setBottomRightCorner(new Point(ulc.getX() + h, ulc.getY() + h));
        }
    }

    public void save(BufferedWriter writer) {
        super.save(writer, "Circle");
    }
}
