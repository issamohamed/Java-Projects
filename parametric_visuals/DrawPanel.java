import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private Color[] colors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA };
    private int numColors = colors.length;
    private int size = 50;
    private int colorIndex = 0;
    private int x, y;

    public DrawPanel() {
        Timer timer = new Timer(1000, e -> {
            colorIndex = (colorIndex + 1) % numColors;
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        x = (int) (Math.random() * (getWidth() - size));
        y = (int) (Math.random() * (getHeight() - size));

        g2d.setColor(colors[colorIndex]);
        g2d.setStroke(new BasicStroke(5));
        g2d.draw(new Rectangle2D.Double(x, y, size, size));
        g2d.draw(new Line2D.Double(x, y, x + size, y + size));
        g2d.draw(new Line2D.Double(x + size, y, x, y + size));
    }
}
