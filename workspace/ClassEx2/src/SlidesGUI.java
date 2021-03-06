
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
        win = game.gameOver();
        addMouseListener(new Listener());
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
                if(a[i][j] != SlidesBoard.EMPTY)
                    drawSquare(g2d, a[i][j], x, y);
        }
    }
    
    private void drawSquare(Graphics2D g2d, int num, int x, int y)
    {
        g2d.setColor(Color.BLUE);
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
    
    private class Listener extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            int x = e.getX();
            int y = e.getY();
            int[] cell = clickedCell(x, y);
            if(cell != null)
            {
                game.move(cell[0], cell[1]);
                win = game.gameOver();
                repaint();
            }
        }
        
        private int[] clickedCell(int x, int y)
        {
           if(!isInBoard(x, y))
               return null;
           int[] cell = new int[2];
           cell[1] = x / width - 1;
           cell[0] = y / width - 1;
           return cell;
        }
        
        private boolean isInBoard(int x, int y)
        {
            if(x >= width && x <= getWidth() - width && y >= width && y <= getHeight() - width) 
                return true;
            return false;
        }
    }
}
