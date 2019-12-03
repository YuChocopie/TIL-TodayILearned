/**
 * Created by G209_30 on 2015-05-07.
 */
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public abstract class RectShape {
    private Point upperLeftCorner, bottomRightCorner;

    public RectShape() {
        upperLeftCorner = new Point();
        bottomRightCorner = new Point();
    }

    public RectShape(Point ulc, Point brc) {
        upperLeftCorner = ulc;
        bottomRightCorner = brc;
    }

    Point getUpperLeftCorner() { return new Point(upperLeftCorner); }

    public Point getBottomRightCorner() {
        return new Point(bottomRightCorner);
    }

    public void setUpperLeftCorner(Point ulc) {
        upperLeftCorner = ulc;
    }

    public void setBottomRightCorner(Point brc) {
        bottomRightCorner = brc;
    }

    public double getWidth() {
        return bottomRightCorner.getX() - upperLeftCorner.getX();
    }

    public double getHeight() {
        return bottomRightCorner.getY() - upperLeftCorner.getY();
    }

    public abstract void draw(Graphics2D g);

    // �Ʒ� �޼ҵ���� �߰��� ������ ��
    // x, y ��ǥ�� �� RectShape ��ü �ȿ� ��ġ�Ѵٸ� true�� �׷��� �ʴٸ� false�� ��ȯ
    public boolean isInside(int x, int y) {
        if (x >= getUpperLeftCorner().getX() && x <= getBottomRightCorner().getX()
                && y >= getUpperLeftCorner().getY() && y <= getBottomRightCorner().getY()) {
            return true;
        }
        return false;
    }

    // �� ��ü�� ��ġ�� x, y ��ŭ �̵�
    public void move(int x, int y) {
        setUpperLeftCorner(new Point(getUpperLeftCorner().getX() + x, getUpperLeftCorner().getY() + y));
        setBottomRightCorner(new Point(getBottomRightCorner().getX() + x, getBottomRightCorner().getY() + y));
    }

    public void open(BufferedReader reader) {
        upperLeftCorner = new Point();
        upperLeftCorner.open(reader);
        bottomRightCorner = new Point();
        bottomRightCorner.open(reader);
    }

    public void save(BufferedWriter writer, String name) {
        try {
            writer.write(name + "\n");
            getUpperLeftCorner().save(writer);
            getBottomRightCorner().save(writer);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public abstract void save(BufferedWriter writer);
}
