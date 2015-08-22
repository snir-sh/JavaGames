/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class SlidesGame {
    private SlidesBoard board;
    public final int SIZE;
    public SlidesGame(int s)
    {
        SIZE = s;
        board = new SlidesBoard(s);
    }
    
    public void move(int row, int col)
    {
        board.move(row, col);
    }
    
    public boolean gameOver()
    {
        return board.isOrdered();
    }
    
    public int[][] getBoard()
    {
        return board.getBoard();
    }
}
