public class Board
{
	private int boardArray[][];
	
	public Board()
	{
		boardArray = new int[9][9];
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				boardArray[i][j] = 0;
	}
	
	public void placeNumber(int i, int j, int num)
	{
		boardArray[i][j] = num;
	}
	
	public boolean checkNumber(int i, int j)
	{
		return boardArray[i][j] != 0;
	}
}
