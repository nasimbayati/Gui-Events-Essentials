package src.awt;

import java.awt.*;
import java.awt.event.*;

public class AwtTracker extends Frame implements MouseMotionListener, WindowListener {
    private int x = -1, y = -1;
    private Color color = Color.BLACK;
    private final String name;

    private AwtTracker(String name) {
        super("AWT Tracker — " + name);
        this.name = name;
        setSize(300, 100);
        addMouseMotionListener(this);
        addWindowListener(this);
        setVisible(true);
    }

    public static void launch(String name) {
        EventQueue.invokeLater(() -> new AwtTracker(name));
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.DARK_GRAY);
        g.drawString(name, 8, 14);

        if (x >= 0 && y >= 0) {
            g.setColor(color);
            g.drawString(x + "," + y, x + 2, Math.max(12, y - 2));
        }
    }

    @Override public void mouseMoved(MouseEvent e)  { x = e.getX(); y = e.getY(); color = Color.BLACK; repaint(); }
    @Override public void mouseDragged(MouseEvent e){ x = e.getX(); y = e.getY(); color = Color.RED;   repaint(); }

    @Override public void windowClosing(WindowEvent e) { dispose(); System.exit(0); }
    @Override public void windowOpened(WindowEvent e) { }
    @Override public void windowClosed(WindowEvent e) { }
    @Override public void windowIconified(WindowEvent e) { }
    @Override public void windowDeiconified(WindowEvent e) { }
    @Override public void windowActivated(WindowEvent e) { }
    @Override public void windowDeactivated(WindowEvent e) { }
}
