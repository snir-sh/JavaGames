
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.Timer;

public class FallingBall extends JPanel  {
   private JComboBox<String> cboLocation;
   private JTextField txtHigh;
   private JTextField txtGravityConstant;
   private JTextField txtElasticConstant;
   private String trans = "";
   private JButton cmdStart;
   private GravityPanel t;
   private Timer timer;
   private Image img;
   private boolean init=false;
   private int currentLocation;
   
   public FallingBall()
   {
       String[] s = {"Earth", "Moon", "Mars", "Other"};
       cboLocation = new JComboBox<>(s);
       txtHigh = new JTextField(7);
       txtGravityConstant = new JTextField(7);
       txtElasticConstant = new JTextField(7);
       cmdStart = new JButton("Start");
       cmdStart.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               trans = (String)cboLocation.getSelectedItem();
               t.repaint();
           }
       });
       
       setLayout(new BorderLayout());
       
       System.out.println(init);
       JPanel pNorth = new JPanel();
       pNorth.add(cboLocation);
       pNorth.add(cmdStart);
       pNorth.add(txtHigh);
       pNorth.add(txtGravityConstant);
       pNorth.add(txtElasticConstant);
       txtHigh.setText("10");
       txtGravityConstant.setText("9.8");
       txtElasticConstant.setText("0.8");
       add(pNorth, BorderLayout.NORTH);
    
       t = new GravityPanel();
       add(t, BorderLayout.CENTER);
   }
   
   
   private class GravityPanel extends JPanel implements ActionListener{
	public GravityPanel()
	{
        timer = new Timer(100, this);
    //    timer.start();
	}
    public void paintComponent(Graphics g)
    {
       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;
       g2d.setColor(Color.RED);
       
       firstPaint(g2d);
    }

    public void firstPaint(Graphics2D g2d)
    {
        if(trans.equals("Earth"))   // translate
        {
        	img = Toolkit.getDefaultToolkit().getImage("C:\\img\\earth.jpg");
        	g2d.drawImage(img, 0, 0, this);
        	txtGravityConstant.setText("9.8");
        	txtElasticConstant.setText("0.8");
            int nHigh = (Integer.parseInt(txtHigh.getText())*500)/100;
            currentLocation = getHeight()-20-nHigh;
            g2d.fillOval(getWidth()/2, currentLocation, 20, 20);  
        }
        else if(trans.equals("Moon"))
        {
        	img = Toolkit.getDefaultToolkit().getImage("C:\\img\\earth.jpg");
        	g2d.drawImage(img, 0, 0, this);        	
        }
        else if(trans.equals("Mars"))
        {
        	img = Toolkit.getDefaultToolkit().getImage("C:\\img\\earth.jpg");
        	g2d.drawImage(img, 0, 0, this);        	
        }
        else if(trans.equals("Other"))
        {
        	img = Toolkit.getDefaultToolkit().getImage("C:\\img\\earth.jpg");
        	g2d.drawImage(img, 0, 0, this);        	
        }
    }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		currentLocation--;
		repaint();
		
	}
    
   }
    
}
