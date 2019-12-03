import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by G209_30 on 2015-05-18.
 */
public class Parallelogram extends RectShape {
    double width, height;

    public Parallelogram() {
        super();
    }

    public Parallelogram(Point ulc, Point brc, double width, double height) {
        super(ulc, brc);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void draw(Graphics2D g) {
        int x1, y1, x2, y2, x3, y3, x4, y4;
        x1 = (int) getUpperLeftCorner().getX();
        y1 = (int) getUpperLeftCorner().getY();
        x2 = (int) getBottomRightCorner().getX();
        y2 = (int) getBottomRightCorner().getY();
        x3 = (int) (x2 - getWidth());
        y3 = y2;
        x4 = (int) (x1 + getWidth());
        y4 = y1;
        g.drawLine(x1, y1, x3, y3);
        g.drawLine(x1, y1, x4, y4);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x2, y2, x4, y4);
    }

    public void open(BufferedReader reader) {
        super.open(reader);
        try {
            String line = reader.readLine();
            width = Double.parseDouble(line);
            line = reader.readLine();
            height = Double.parseDouble(line);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void save(BufferedWriter writer) {
        try {
            super.save(writer, "Parallelogram");
            writer.write("" + width + "\n");
            writer.write("" + height + "\n");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
