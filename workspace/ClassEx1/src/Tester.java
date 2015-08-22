import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tester {

	public static void main(String[] args)
	{
	    JFrame frame = new JFrame("Star Trek");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(700, 700);
	    
	    StartsPanel panel = new StartsPanel();
	    frame.add(panel);
	    frame.setVisible(true);
	}
}
