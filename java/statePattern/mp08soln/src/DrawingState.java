import javax.swing.*;
import java.awt.event.MouseEvent;

public class DrawingState implements StateInterface {
    DrawShapeInterface dsi;
    JComponent canvas;

    DrawingState (DrawShapeInterface dsi, JComponent canvas) {
        this.dsi = dsi;
        this.canvas = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        dsi.createShape(e.getX(), e.getY());
        canvas.validate();
        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
}
