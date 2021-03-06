
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
        
        int[] randomBatch = generateRandom();
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length; j++)
            {
                board[i][j] = randomBatch[SIZE*i + j];
                if(board[i][j] == EMPTY)
                {
                    emptyRow = i;
                    emptyCol = j;
                }
            }
    }
       
    public int[][] getBoard()
    {
        return board;
    }
    
    public void move(int row, int col)
    {
        if(nearEmpty(row, col))
        {
            int temp = board[row][col];
            board[row][col] = board[emptyRow][emptyCol];
            board[emptyRow][emptyCol] = temp;
            emptyRow = row;
            emptyCol = col;
        }
    }
    
    public boolean isOrdered()
    {
        int last = 0;
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board.length; j++)
            {
                if(board[i][j] < last && !lastCell(i, j))
                    return false;
                last = board[i][j];
            }
        return true;
    }
    
    
    private int[] generateRandom()
    {
        int[] res = new int[N];
        Random rand = new Random();
        
        for(int i = 0; i < N; i++)
            res[i] = i;
       
        
        for(int i = 0; i < N; i++)
        {
            int pos = rand.nextInt(N);
            int temp = res[i];
            res[i] = res[pos];
            res[pos] = temp;
        }
  
        return res;       
    }
    
    private boolean nearEmpty(int row, int col)
    {
        int diffRow = Math.abs(row - emptyRow);
        int diffCol = Math.abs(col - emptyCol);
        
        if((diffRow == 1 && col == emptyCol) || (diffCol == 1 && row == emptyRow))
            return true;
        return false;
    }
    
    private boolean lastCell(int row, int col)
    {
        return row == SIZE - 1 && col == SIZE - 1;
    }
}
