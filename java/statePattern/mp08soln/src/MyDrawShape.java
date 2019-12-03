import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by G209_30 on 2015-05-18.
 */
public class MyDrawShape implements DrawShapeInterface {
    RectShapeFactory.RectShapeEnum shape;
    ArrayList<RectShape> shapes;

    int state;

    public MyDrawShape() {
        state = DRAWING_STATE;
        shapes = new ArrayList<RectShape>();
    }

    public void draw(Graphics2D g) {
        for (RectShape s : shapes) {
            s.draw(g);
        }
    }

/*
    public RectShape select(int x, int y) {
        for (RectShape s : shapes) {
            if (s.isInside(x, y))
                return s;
        }
        return null;
    }
*/
    public RectShape select(int x, int y) {
        ListIterator<RectShape> r = shapes.listIterator(shapes.size());
        while (r.hasPrevious()) {
            RectShape s = r.previous();
            if (s.isInside(x, y))
                return s;
        }
        return null;
    }

    public void createShape(int x, int y) {
        RectShape s = RectShapeFactory.create(shape, x, y, 30, 30);
        if (s != null)
            shapes.add(s);
    }

    public void selectDrawingShape(RectShapeFactory.RectShapeEnum shape) {
        this.shape = shape;
    }

    public void open(String fileName) {
        String line;
        RectShape r = null;
        try {
            FileInputStream fin = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fin);
            BufferedReader br = new BufferedReader(isr);

            line = br.readLine();
            while (line != null) {
                if (line.equals("Rectangle")) {
                    r = new Rectangle();
                }
                else if (line.equals("Ellipse")) {
                    r = new Ellipse();
                }
                else if (line.equals("Circle")) {
                    r = new Circle();
                }
                else if (line.equals("Parallelogram")) {
                    r = new Parallelogram();
                }
                else if (line.equals("Trapezoid")) {
                    r = new Trapezoid();
                }
                if (r != null) {
                    r.open(br);
                    shapes.add(0, r);
                }
                line = br.readLine();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void save(String fileName) {
        try {
            FileOutputStream fout = new FileOutputStream(fileName);
            OutputStreamWriter osr = new OutputStreamWriter(fout);
            BufferedWriter bw = new BufferedWriter(osr);

            for (RectShape s : shapes) {
                s.save(bw);
            }
            bw.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int getState() { return state; }

    public void setState(int state) {
        this.state = state;
    }
}