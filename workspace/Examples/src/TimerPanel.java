
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class TimerPanel extends JPanel implements ActionListener {
    private double theta;
    private Timer timer;
    private final double EPSILON = Math.PI / 12;
    
    public TimerPanel()
    {
        theta = 0.0;
        timer = new Timer(100, this);
        timer.start();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        int w = getWidth();
        int h = getHeight();
        
        g2d.rotate(theta, w/2, h/2);
        Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\snir\\Documents\\School\\JavaGames\\Examples\\NY.jpg");
        g2d.drawImage(img, 0, 0, this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        theta += EPSILON;
        repaint();
    }
}
