
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.Timer;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Graphics2DPanel extends JPanel  {
   private JComboBox<String> cboTrans;
   private String trans = "";
   private JButton cmdSelect;
   private TransPanel t;
   
   public Graphics2DPanel()
   {
       String[] s = {"Translate", "Rotate", "Scale", "Shear"};
       cboTrans = new JComboBox<>(s);
       cmdSelect = new JButton("Select");
       cmdSelect.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               trans = (String)cboTrans.getSelectedItem();
               t.repaint();
           }
       });
       
       setLayout(new BorderLayout());
       
       JPanel pNorth = new JPanel();
       pNorth.add(cboTrans);
       pNorth.add(cmdSelect);
       add(pNorth, BorderLayout.NORTH);
       
       t = new TransPanel();
       add(t, BorderLayout.CENTER);
   }
   
   
   private class TransPanel extends JPanel {
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        
        if(trans.equals("Translate"))   // translate
        {
            g2d.setColor(Color.GREEN);
            g2d.fillRect(100, 100, 200, 100);

            g2d.translate(100, 100);
            g2d.setColor(Color.BLUE);
            g2d.fillRect(100, 100, 200, 100);
        }
        else if(trans.equals("Rotate")) // rotate
        {
            g2d.setColor(Color.GREEN);
            g2d.fillRect(100, 100, 200, 100);
        
            g2d.rotate(Math.PI / 4);
            g2d.setColor(Color.BLUE);
            g2d.fillRect(100, 100, 200, 100);
        }
        else if(trans.equals("Scale")) // scale
        {
        
            g2d.setColor(Color.GREEN);
            g2d.fillRect(100, 100, 200, 100);

            g2d.scale(0.5, 0.5);
            g2d.setColor(Color.BLUE);
            g2d.fillRect(100, 100, 200, 100);
        }
        else if(trans.equals("Shear")) // shear
        {
            g2d.setColor(Color.GREEN);
            g2d.fillRect(100, 100, 200, 100);

            g2d.shear(0.5, 0.6);
            g2d.setColor(Color.BLUE);
            g2d.fillRect(100, 100, 200, 100);
        }  
    }
   }
    
}
