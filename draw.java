import javax.swing.*;
import java.awt.*;

public class draw extends JPanel{
    private int x = 0;
    private int y = 0;
    private int size = 0;
    private int width = 0;

    public draw(int x, int y, int size, int width) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.width = width;
    }

    public void drawing() {
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(x, y, size, width);
        g.setColor(Color.RED);
        g.fillRect(x, y, size, width);
    }
}
