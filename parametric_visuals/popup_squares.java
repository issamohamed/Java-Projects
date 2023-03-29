import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;


class DrawPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private Color[] colors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA };
    private int numColors = colors.length;
    private int size = 50;
    private int colorIndex = 0;
    private int x, y;

    public DrawPanel() {
        // Use a timer to update the color of the shape every second
        Timer timer = new Timer(1000, e -> {
            colorIndex = (colorIndex + 1) % numColors;
            repaint(); // Trigger a repaint of the panel to update the color
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Randomly generate x and y positions within the panel bounds
        x = (int) (Math.random() * (getWidth() - size));
        y = (int) (Math.random() * (getHeight() - size));

        // Draw the shape with the current color and stroke
        g2d.setColor(colors[colorIndex]);
        g2d.setStroke(new BasicStroke(5));
        g2d.draw(new Rectangle(x, y, size, size));
        g2d.draw(new Line2D.Double(x, y, x + size, y + size));
        g2d.draw(new Line2D.Double(x + size, y, x, y + size));
    }
}
