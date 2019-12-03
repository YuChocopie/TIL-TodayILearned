import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyButton extends JButton {
    MyButton(String text) {
        super(text);
    }

    public void setProperties(ActionListener listener, int width, int height) {
        addActionListener(listener);
        Dimension buttonDimension = new Dimension(width, height);
        setMaximumSize(buttonDimension);
        setMinimumSize(buttonDimension);
        setPreferredSize(buttonDimension);
    }
}
