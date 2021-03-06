
import java.util.Random;


public class SlidesBoard {
    public static final int EMPTY = 0;
    private final int SIZE, N = 16;
    private int[][] board;
    private int emptyRow, emptyCol;
    
    public SlidesBoard(int s)
    {
        SIZE = s;
        board = new int[SIZE][SIZE];
        randomLocation();
        randomLocation();
        
    }
       
    public int[][] getBoard()
    {
        return board;
    }
    
    public void move(int row, int col)
    {

    }
           
    private void randomLocation()
    {
    	int[] location = new int[2];
    	Random rand = new Random();    	
    	location[0] = rand.nextInt(SIZE);
    	location[1] = rand.nextInt(SIZE);  	
    	
    	while (board[location[0]][location[1]]!=0)
    	{
        	location[0] = rand.nextInt(SIZE);
        	location[1] = rand.nextInt(SIZE);
    	}
    	
    	board[location[0]][location[1]] = 2;
    }
}
