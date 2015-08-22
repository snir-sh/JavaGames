import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StartsPanel extends JPanel implements ActionListener {
	
	private Timer timer;
	private double scale;
	private JButton cmdStart; 
	private Star allStars[];
	private int xDim, yDim;
	
	public StartsPanel()
	{
        timer = new Timer(200, this);
        scale = 1.0;
        cmdStart = new JButton("Start");
        cmdStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveNow();
            }
        });
        
        add(cmdStart, BorderLayout.NORTH);
        
		setBackground(Color.BLACK);
	}
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    	
        Graphics2D g2d = (Graphics2D) g;

        // for diminish
        g2d.translate(xDim, yDim);
        g2d.scale(scale, scale);
        
        Color c = new Color(255, 255, 255,100);
        g.setColor(c);
        
//        allStars = new Star[100];
//        for (int i=0; i<1; i++)       	
//        {
//        	allStars[i] = new Star(g, getHeight(), getWidth());
//        }
        Random generateX = new Random();
        g2d.fillOval(generateX.nextInt(getHeight()), generateX.nextInt(getWidth()), 5, 5);
    }
    
    public void moveNow()
    {
    	timer.start();
    }
        
	public void actionPerformed(ActionEvent e) {

		scale -= 0.01;        
        xDim = (int)(getWidth() * (1 - scale) / 2);
        yDim = (int)(getHeight() * (1- scale) / 2);
        if(scale < 0.0001)
        {
            scale = 0.0001;
            timer.stop();
        }

        repaint();		
	}

}
