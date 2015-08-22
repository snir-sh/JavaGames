
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * GraphicsPanel - shows various of Graphics' methods
 */

/**
 *
 * @author Shay Tavor
 */
public class GraphicsPanel extends JPanel {
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Drawing Shapes", 50, 20);
        
        g.setColor(Color.GREEN);
        g.fillRect(50, 50, 150, 100);
        
        g.setColor(Color.ORANGE);
        g.drawOval(75, 75, 150, 150);
        
        
        Color c = new Color(150, 50, 100, 150);
        g.setColor(c);
        int[] xPoints = {70, 150, 100, 85, 30};
        int[] yPoints = {75, 150, 300, 100, 60};
        g.fillPolygon(xPoints, yPoints, 5);
        
        int w = getWidth();
        int h = getHeight();
        
        g.setColor(Color.BLUE);
        g.drawLine(w-50, h/2, w, h/2);
        g.drawLine(w-25, h/2-25, w-25, h/2+25);
        g.drawString("Rational Positioning: ", w-250, h/2 + 5);
        
    }
}
