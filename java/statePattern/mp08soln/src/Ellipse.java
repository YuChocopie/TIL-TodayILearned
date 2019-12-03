/**
 * Created by G209_30 on 2015-05-07.
 */
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Ellipse extends RectShape {
    public Ellipse() {
        super();
    }

    public Ellipse(Point ulc, Point brc) {
        super(ulc, brc);
    }

    public void draw(Graphics2D g) {
        g.drawOval((int) getUpperLeftCorner().getX(),
                   (int) getUpperLeftCorner().getY(),
                   (int) getWidth(), (int) getHeight());
    }

    public void save(BufferedWriter writer) {
        super.save(writer, "Ellipse");
    }
}
