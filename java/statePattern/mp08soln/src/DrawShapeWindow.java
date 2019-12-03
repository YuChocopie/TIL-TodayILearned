import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class DrawShapeWindow implements ActionListener {
    DrawShapeWindow(DrawShapeInterface ds) {
        this(ds, 30, 30, 600, 600);
    }

    DrawShapeWindow(DrawShapeInterface ds, String title) {
        this (ds, title, 30, 30, 600, 600);
    }

    DrawShapeWindow(DrawShapeInterface ds, int x, int y, int width, int height) {
        this(ds, "", x, y, width, height);
    }

    DrawShapeWindow(DrawShapeInterface ds, String title, int x, int y, int width, int height) {
        dsi = ds;
        window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(x, y, width, height);
        mainPanel = new MainPanel(dsi);
        window.getContentPane().add(mainPanel);

        JMenuBar menuBar = createMenu();
        window.setJMenuBar(menuBar);
        
        window.setVisible(true);
    }

    protected JMenuBar createMenu() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem;

        menuBar = new JMenuBar();

        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);

        openMenuItem = new JMenuItem("Open...", KeyEvent.VK_O);
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openMenuItem.addActionListener(this);
        menu.add(openMenuItem);

        saveMenuItem = new JMenuItem("Save", KeyEvent.VK_S);
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveMenuItem.addActionListener(this);
        menu.add(saveMenuItem);

/*        saveAsMenuItem = new JMenuItem("Save as...", KeyEvent.VK_A);
        saveAsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        saveAsMenuItem.addActionListener(this);
        menu.add(saveAsMenuItem);
*/
        menu.addSeparator();

        exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_X);
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        exitMenuItem.addActionListener(this);
        menu.add(exitMenuItem);

        return menuBar;
    }

    public void actionPerformed(ActionEvent e) {
        JMenuItem src = (JMenuItem) e.getSource();

        if (src == openMenuItem) {
            dsi.open("DrawShape.txt");
            mainPanel.validate();
            mainPanel.repaint();
        }
        else if (src == saveMenuItem) {
            dsi.save("DrawShape.txt");
        }
        else if (src == saveAsMenuItem) {

        }
        else if (src == exitMenuItem) {
            System.exit(0);
        }
    }

    JMenuItem openMenuItem, saveMenuItem, saveAsMenuItem, exitMenuItem;
    DrawShapeInterface dsi;
    JFrame window;
    JPanel mainPanel;
}
