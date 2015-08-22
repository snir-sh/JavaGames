import java.awt.Graphics;
import java.util.Random;

public class Star {
	public int cordX, cordY;
	
	public Star(Graphics g, int h, int w)
	{
		Random generateX = new Random();
		cordX = generateX.nextInt(500);
		
		Random generateY = new Random();
		cordX = generateY.nextInt(500);
		
		//g.fillOval(generateX.nextInt(h), generateY.nextInt(w), 5, 5);
	}
	
	public void moveStar()
	{	
		
	}
}
