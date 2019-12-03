import javax.swing.*;
import java.awt.event.MouseEvent;

public class SelectingState implements StateInterface {
    DrawShapeInterface dsi;
    JComponent canvas;
    boolean dragging = false;
    int sx;
    int sy;
    RectShape selectedShape;

    SelectingState(DrawShapeInterface dsi, JComponent canvas) {
        this.dsi = dsi;
        this.canvas = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        dragging = true;
        sx = e.getX();
        sy = e.getY();
        selectedShape = dsi.select(sx, sy);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        dragging = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (dragging && selectedShape != null) {
            int x = e.getX();
            int y = e.getY();
            int diffX = x - sx;
            int diffY = y - sy;
            selectedShape.move(diffX, diffY);
            sx = x;
            sy = y;
            canvas.validate();
            canvas.repaint();
        }
    }
}
