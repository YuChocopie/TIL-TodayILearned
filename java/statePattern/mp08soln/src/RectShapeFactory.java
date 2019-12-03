import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2015-05-24.
 */
public class RectShapeFactory {
    public static enum RectShapeEnum { RS_RECTANGLE, RS_ELLIPSE, RS_PARALLELOGRAM, RS_TRAPEZOID }

    public static RectShape create(RectShapeEnum shape, int x, int y, int width, int height) {
        if (shape == RectShapeEnum.RS_RECTANGLE) {
            return new Rectangle(new Point(x, y), new Point(x + width, y + height));
        }
        else if (shape == RectShapeEnum.RS_ELLIPSE) {
            return new Ellipse(new Point(x, y), new Point(x + width, y + height));
        }
        else if (shape == RectShapeEnum.RS_PARALLELOGRAM) {
            return new Parallelogram(new Point(x, y), new Point(x + width - 10, y + height - 10), width, height);
        }
        else if (shape == RectShapeEnum.RS_TRAPEZOID) {
            return new Trapezoid(new Point(x + 10, y), new Point(x + width, y + height),
                                     new Point(x, y + height), new Point(x + width - 10, y));
        }
        else
            return null;
    }
}
