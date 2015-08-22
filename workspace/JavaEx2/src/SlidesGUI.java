
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class SlidesGUI extends JPanel {
    private SlidesGame game;
    private int width;
    private boolean win;
        
    public SlidesGUI()
    {
        game = new SlidesGame(4);
        win = false;
        addKeyListener(new Listener());
        setFocusable(true);
        requestFocus();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawBoard(g2d);
        
        if(win)
            gameOver(g2d);
    }
    
    private void drawBoard(Graphics2D g2d)
    {
        int w = getWidth();
        int h = getHeight();
        width = w / (game.SIZE + 2);
        int[][] a = game.getBoard();
        int x, y;
        x = y = width;
        
        for(int i = 0; i < a.length; i++, y += width)
        {
            x = width;
            for(int j = 0; j < a.length; j++, x += width)
            	drawSquare(g2d, a[i][j], x, y);
        }
    }
    
    private void drawSquare(Graphics2D g2d, int num, int x, int y)
    {
    	if (num != 0)
    		g2d.setColor(Color.BLUE);
    	else
    		g2d.setColor(Color.GRAY);    	
        g2d.fillRect(x+1, y+1, width-2, width-2);
        g2d.setFont(new Font("arial", Font.BOLD, 20));
        g2d.setColor(Color.WHITE);        
        g2d.drawString("" + num, x + width/2 - 5, y + width/2 + 5);                 
    }
    
    private void gameOver(Graphics2D g2d)
    {
        g2d.setColor(Color.GREEN);
        g2d.drawString("Well Done :)", getWidth() / 2 - 50, 30);
    }
    
    private class Listener extends KeyAdapter
    {
    	public void keyPressed(KeyEvent event)
    	{
    		System.out.println("in listiner pressed");
    		int key = event.getKeyCode();
    		if (key == event.VK_LEFT)
    		{
    			System.out.println("left");
    		}
    		else if (key == event.VK_UP)
    		{
    			System.out.println("up");
    		}   		
    	}
    	
        public void keyReleased(KeyEvent event) 
        {
        	
        }
    }
}
