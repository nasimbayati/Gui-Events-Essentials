package src.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingTracker extends JPanel implements MouseListener {
    private int lastX = -1, lastY = -1;
    private final String name;

    private SwingTracker(String name) {
        this.name = name;
        setPreferredSize(new Dimension(300, 100));
        addMouseListener(this);
        setBackground(Color.WHITE);
        setFocusable(true);
    }

    public static void launch(String name) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Swing Tracker — " + name);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setContentPane(new SwingTracker(name));
            f.pack();
            f.setLocationByPlatform(true);
            f.setVisible(true);
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // clears old text
        if (lastX >= 0 && lastY >= 0) {
            g.setColor(Color.BLACK);
            g.drawString(lastX + "," + lastY, lastX + 2, Math.max(12, lastY - 2));
        }
    }

    @Override public void mouseClicked(MouseEvent e) { lastX = e.getX(); lastY = e.getY(); repaint(); }
    @Override public void mousePressed(MouseEvent e) { }
    @Override public void mouseReleased(MouseEvent e) { }
    @Override public void mouseEntered(MouseEvent e) { }
    @Override public void mouseExited(MouseEvent e) { }
}
