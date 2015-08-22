
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class ListenerPanel extends JPanel  {
    private double scale;
    private final double EPSILON = 0.01;
    private double xTranslate, yTranslate;
    
    public ListenerPanel()
    {
        scale = 1.0;
        xTranslate = yTranslate = 0.0;
        Listener lis = new Listener();
        addMouseWheelListener(lis);
        addMouseListener(lis);
        addMouseMotionListener(lis);
    }
    
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.scale(scale, scale);
        g2d.translate(xTranslate, yTranslate);
        
        for(int i = 0; i < 5; i++)
        {
            g2d.setColor(new Color(150, 200, 40, 255-i*50));
            g2d.fillOval(50 + i * 30, 50 + i * 50, 70, 70);
        }
    }
    
    
    private class Listener extends MouseAdapter implements  MouseWheelListener
    {
        private int oldX, oldY;
        public void mouseWheelMoved(MouseWheelEvent e)
        {
            scale += EPSILON * e.getWheelRotation();
            scale = Math.max(0.0001, scale);
            repaint();
        }
        
        public void mousePressed(MouseEvent e)
        {
            oldX = e.getX();
            oldY = e.getY();
        }
        
        public void mouseDragged(MouseEvent e)
        {
            int x = e.getX() - oldX;
            int y = e.getY() - oldY;
            oldX = e.getX();
            oldY = e.getY();
            xTranslate += x;
            yTranslate += y;
            repaint();
        }
        
    }
    
}
