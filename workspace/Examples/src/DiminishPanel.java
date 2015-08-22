
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;
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
public class DiminishPanel extends JPanel {
    private JButton cmdStart;
    private EffectPanel p;
    
    public DiminishPanel()
    {
        p = new EffectPanel();
        cmdStart = new JButton("Start");
        cmdStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.start();
            }
        });
        
        setLayout(new BorderLayout());
        add(cmdStart, BorderLayout.NORTH);
        add(p, BorderLayout.CENTER);
    }
    
    private class EffectPanel extends JPanel implements ActionListener
    {
        private double scale;
        private Timer timer;
        private int xDim, yDim;

        public EffectPanel()
        {
            timer = new Timer(100, this);
            scale = 1.0;
        }
        
        public void start()
        {
            timer.start();
        }
        
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\snir\\Documents\\School\\JavaGames\\Examples\\NY.jpg");     
            // for diminish
            g2d.translate(xDim, yDim);
            g2d.scale(scale, scale);
            g2d.drawImage(img, 0, 0, this);
        }

        public void actionPerformed(ActionEvent e)
        {
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
    
}
