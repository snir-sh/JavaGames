
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Tester1 {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Testing1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 500);
  //      GraphicsPanel p = new GraphicsPanel();
        Graphics2DPanel p = new Graphics2DPanel();
       // ClipPanel p = new ClipPanel();
       // ListenerPanel p = new ListenerPanel();
      // TimerPanel p = new TimerPanel();
       // DiminishPanel p = new DiminishPanel();
        frame.add(p);
        frame.setVisible(true);
        
    }
}
