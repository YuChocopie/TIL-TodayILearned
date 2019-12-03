import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

/**
 * Created by Administrator on 2015-05-24.
 */
public class MainPanel extends JPanel implements ActionListener {
    static final String RECTANGLE_CMD = "Rectangle";
    static final String ELLIPSE_CMD = "Ellipse";
    static final String PARALLELOGRAM_CMD = "Parallelogram";
    static final String TRAPEZOID_CMD = "Trapezoid";
    static final String SELECTION_CMD = "Selection";
    static final String DRAWING_CMD = "Drawing";
    DrawShapeInterface dsi;

    public MainPanel(DrawShapeInterface dsi) {
        super(new BorderLayout());

        this.dsi = dsi;
        JToolBar toolBar = new JToolBar("");
        addButtons(toolBar);

        add(toolBar, BorderLayout.NORTH);
        dsi.selectDrawingShape(RectShapeFactory.RectShapeEnum.RS_RECTANGLE);

        DrawShapeCanvas s = new DrawShapeCanvas(dsi);
        add(s, BorderLayout.CENTER);
    }

    protected void addButtons(JToolBar toolBar) {
        JButton button1;
        button1 = makeButton("Selection", SELECTION_CMD, "Selecting mode", "Selecting");
        toolBar.add(button1);
        button1 = makeButton("Drawing", DRAWING_CMD, "Drawing mode", "Drawing");
        toolBar.add(button1);


        ButtonGroup buttonGroup = new ButtonGroup();
        JToggleButton button = null;

        // first button
        button = makeToggleButton("Rectangle", RECTANGLE_CMD, "Select rectangle drawing tool", "Rectangle");
        button.setSelected(true);
        buttonGroup.add(button);
        toolBar.add(button);

        // second button
        button = makeToggleButton("Ellipse", ELLIPSE_CMD, "Select ellipse drawing tool", "Ellipse");
        buttonGroup.add(button);
        toolBar.add(button);

        // third button
        button = makeToggleButton("Parallelogram", PARALLELOGRAM_CMD, "Select parallelogram drawing tool", "Parallelogram");
        buttonGroup.add(button);
        toolBar.add(button);

        // fourth button
        button = makeToggleButton("Trapezoid", TRAPEZOID_CMD, "Select trapezoid drawing tool", "Trapezoid");
        buttonGroup.add(button);
        toolBar.add(button);

    }

    protected JButton makeButton(String imageName,
                                       String actionCommand,
                                       String toolTipText,
                                       String altText) {
        //Look for the image.
        String imgLocation = "images/"
                + imageName
                + ".png";
        URL imageURL = MainPanel.class.getResource(imgLocation);

        //Create and initialize the button.
        JButton button = new JButton();
        button.setActionCommand(actionCommand);
        button.setToolTipText(toolTipText);
        button.addActionListener(this);

        if (imageURL != null) {                      //image found
            button.setIcon(new ImageIcon(imageURL, altText));
        } else {                                     //no image found
            button.setText(altText);
            System.err.println("Resource not found: "
                    + imgLocation);
        }

        return button;
    }


    protected JToggleButton makeToggleButton(String imageName,
                                             String actionCommand,
                                             String toolTipText,
                                             String altText) {
        //Look for the image.
        String imgLocation = "images/"
                + imageName
                + ".png";
        URL imageURL = MainPanel.class.getResource(imgLocation);

        //Create and initialize the button.
        JToggleButton button = new JToggleButton();
        button.setActionCommand(actionCommand);
        button.setToolTipText(toolTipText);
        button.addActionListener(this);

        if (imageURL != null) {                      //image found
            button.setIcon(new ImageIcon(imageURL, altText));
        } else {                                     //no image found
            button.setText(altText);
            System.err.println("Resource not found: "
                    + imgLocation);
        }

        return button;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals(DRAWING_CMD)) {
            dsi.setState(DrawShapeInterface.DRAWING_STATE);
        }
        else if (cmd.equals(SELECTION_CMD)) {
            dsi.setState(DrawShapeInterface.SELECTING_STATE);
        }
        else if (cmd.equals(RECTANGLE_CMD)) {
            dsi.selectDrawingShape(RectShapeFactory.RectShapeEnum.RS_RECTANGLE);
        }
        else if (cmd.equals(ELLIPSE_CMD)) {
            dsi.selectDrawingShape(RectShapeFactory.RectShapeEnum.RS_ELLIPSE);
        }
        else if (cmd.equals(PARALLELOGRAM_CMD)) {
            dsi.selectDrawingShape(RectShapeFactory.RectShapeEnum.RS_PARALLELOGRAM);
        }
        else if (cmd.equals(TRAPEZOID_CMD)) {
            dsi.selectDrawingShape(RectShapeFactory.RectShapeEnum.RS_TRAPEZOID);
        }
    }
}
