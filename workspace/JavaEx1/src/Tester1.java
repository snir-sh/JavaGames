
import javax.swing.JFrame;


public class Tester1 {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        FallingBall p = new FallingBall();

        frame.add(p);
        frame.setVisible(true);        
    }
}
