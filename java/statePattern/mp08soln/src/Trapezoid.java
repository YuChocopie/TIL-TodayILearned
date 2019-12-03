import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by G209_30 on 2015-05-18.
 */
public class Trapezoid extends RectShape {
    Point upperRightCorner, bottomLeftCorner;

    public Trapezoid() {
        super();
    }

    public Trapezoid(Point ulc, Point brc, Point blc, Point urc) {
        super(ulc, brc);
        upperRightCorner = urc;
        bottomLeftCorner = blc;
    }

    public double getWidth() {
        double minX, maxX;

        minX = min(getUpperLeftCorner().getX(), bottomLeftCorner.getX());
        maxX = max(upperRightCorner.getX(), getBottomRightCorner().getX());
        return maxX - minX;
    }

    public double getHeight() {
        double minY, maxY;

        maxY = min(bottomLeftCorner.getY(), getBottomRightCorner().getY());
        minY = max(upperRightCorner.getY(), getUpperLeftCorner().getY());
        return maxY - minY;
    }

    public void draw(Graphics2D g) {
        int x1, y1, x2, y2, x3, y3, x4, y4;
        x1 = (int) getUpperLeftCorner().getX();
        y1 = (int) getUpperLeftCorner().getY();
        x2 = (int) getBottomRightCorner().getX();
        y2 = (int) getBottomRightCorner().getY();
        x3 = (int) bottomLeftCorner.getX();
        y3 = (int) bottomLeftCorner.getY();
        x4 = (int) upperRightCorner.getX();
        y4 = (int) upperRightCorner.getY();
        g.drawLine(x1, y1, x3, y3);
        g.drawLine(x1, y1, x4, y4);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x2, y2, x4, y4);
    }

    public void move(int x, int y) {
        super.move(x, y);
        upperRightCorner.setX(upperRightCorner.getX() + x);
        upperRightCorner.setY(upperRightCorner.getY() + y);
        bottomLeftCorner.setX(bottomLeftCorner.getX() + x);
        bottomLeftCorner.setY(bottomLeftCorner.getY() + y);
    }

    public void open(BufferedReader reader) {
        super.open(reader);
        bottomLeftCorner = new Point();
        bottomLeftCorner.open(reader);
        upperRightCorner = new Point();
        upperRightCorner.open(reader);
    }

    public void save(BufferedWriter writer) {
        super.save(writer, "Trapezoid");
        upperRightCorner.save(writer);
        bottomLeftCorner.save(writer);
    }

    private double min(double d1, double d2) {
        return (d1 <= d2) ? d1 : d2;
    }

    private double max(double d1, double d2) {
        return (d1 >= d2) ? d1 : d2;
    }
}
