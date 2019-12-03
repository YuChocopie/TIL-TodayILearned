import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * Created by G209_30 on 2015-05-07.
 */
public class Point {
    private double x, y;
    Point() {
        x = 0;
        y = 0;
    }

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    double getX() { return x; }

    double getY() { return y; }

    void setX(double x) {
        this.x = x;
    }

    void setY(double y) {
        this.y = y;
    }

    void draw(String name) {
        System.out.println(name + ": (" + x + ", " + y + ")");
    }

    void open(BufferedReader reader) {
        try {
            String line = reader.readLine();
            System.out.println(line);
            x = Double.parseDouble(line);
            line = reader.readLine();
            y = Double.parseDouble(line);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void save(BufferedWriter writer) {
        try {
            writer.write("" + x + "\n");
            writer.write("" + y + "\n");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
