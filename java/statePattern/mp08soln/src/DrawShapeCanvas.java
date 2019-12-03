import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.*;

/**
 * Created by Administrator on 2015-05-10.
 */
public class DrawShapeCanvas extends JComponent implements MouseListener, MouseMotionListener {
    StateInterface state;

    public DrawShapeCanvas(DrawShapeInterface dsi) {
        this.dsi = dsi;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void setState(StateInterface state) {
        this.state = state;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        state.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        state.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        state.mouseDragged(e);
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
