public class Board
{
	private int[][] boardArray;
	private int[][] boxArray;
	
	public Board()
	{
		boardArray = new int[9][9];
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				boardArray[i][j] = 0;
		boxArray = new int[9][9];
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				boxArray[i][j] = (i/3) + (3*(j/3)) + 1;
	}
	
	public void placeNumber(int i, int j, int num)
	{
		boardArray[i][j] = num;
	}
	
	public boolean checkNumber(int i, int j)
	{
		return boardArray[i][j] != 0;
	}
	
	public int getNumber(int i, int j)
	{
		return boardArray[i][j];
	}
	
	public boolean checkColumn(int i, int num)
	{
		for(int j = 0; j < 9; i++)
			if (boardArray[i][j] == num)
				return true;
		return false;
	}
	
	public boolean checkRow(int j, int num)
	{
		for(int i = 0; i < 9; i++)
			if (boardArray[i][j] == num)
				return true;
		return false;
	}
	
<<<<<<< HEAD
	public void printBox()
	{
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
			{
			}
			
	}
=======
	// hi, my name is nathan
>>>>>>> e995538fcb0be4467a958aa20c05c371136f5b53
}
