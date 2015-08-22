
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class ClipPanel extends JPanel {
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\snir\\Documents\\School\\JavaGames\\Examples\\NY.jpg");
        g2d.drawImage(img, 0, 0, this);
        
        Color c = new Color(0, 0, 0, 150);
        g2d.setColor(c);
        
        Area area = new Area(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        Area hole = new Area(new Ellipse2D.Double(100, 100, 100, 70));
        area.subtract(hole);
        
        g2d.setClip(area);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
    
}
