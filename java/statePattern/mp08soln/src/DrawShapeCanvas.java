import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by Administrator on 2015-05-10.
 */
public class DrawShapeCanvas extends JComponent implements MouseListener, MouseMotionListener {
    public DrawShapeCanvas(DrawShapeInterface dsi) {
        this.dsi = dsi;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        if (dsi.getState() == DrawShapeInterface.DRAWING_STATE) {
            dsi.createShape(e.getX(), e.getY());
            validate();
            repaint();
        }
        else if (dsi.getState() == DrawShapeInterface.SELECTING_STATE) {
            dragging = true;
            sx = e.getX();
            sy = e.getY();
            selectedShape = dsi.select(sx, sy);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (dsi.getState() == DrawShapeInterface.SELECTING_STATE) {
            dragging = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (dsi.getState() == DrawShapeInterface.SELECTING_STATE) {
            if (dragging && selectedShape != null) {
                int x = e.getX();
                int y = e.getY();
                int diffX = x - sx;
                int diffY = y - sy;
                selectedShape.move(diffX, diffY);
                sx = x;
                sy = y;
                validate();
                repaint();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public void paint(Graphics g) {
        dsi.draw((Graphics2D) g);
    }

    boolean dragging = false;
    RectShape selectedShape = null;
    int sx;
    int sy;

    DrawShapeInterface dsi;
}
