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
				boxArray[i][j] = (3*(i/3)) + (j/3) + 1;
	}
	
	public void placeNumber(int i, int j, int num)
	{
		boardArray[i][j] = num;
	}
	
	public boolean canAddNumber(int i, int j, int num)
	{
		if(!checkNumRow(i, num) && !checkNumColumn(j, num) && !checkNumBox(i, j, num))
		{
			return true;
		}
		return false;
	}
	
	public boolean checkNumber(int i, int j)
	{
		return boardArray[i][j] != 0;
	}
	
	public int getNumber(int i, int j)
	{
		return boardArray[i][j];
	}
	
	public boolean checkNumRow(int i, int num)
	{
		for(int j = 0; j < 9; j++)
			if (boardArray[i][j] == num)
				return true;
		return false;
	}
	
	public boolean checkNumColumn(int j, int num)
	{
		for(int i = 0; i < 9; i++)
			if (boardArray[i][j] == num)
				return true;
		return false;
	}
	
	public boolean checkNumBox(int i, int j, int num)
	{
		for(int k = 0; k < 9; k++)
			for(int l = 0; l < 9; l++)
				if(boxArray[k][l] == boxArray[i][j])
					if(boardArray[k][l] == num)
						return true;
		return false;
	}
	
	public boolean checkNumBox(int i, int num)
	{
		for(int k = 0; k < 9; k++)
			for(int l = 0; l < 9; l++)
				if(boxArray[k][l] == i)
					if(boardArray[k][l] == num)
						return true;
		return false;
	}

	public void printBoard()
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
				System.out.print(boardArray[i][j] + " ");
			System.out.println();
		}
	}
	
	public void printBoxRegion()
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
				System.out.print(boxArray[i][j] + " ");
			System.out.println();
		}
	}
	
	public boolean confirmBoxSize()
	{
		int[] temp = new int[9];
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				temp[boxArray[i][j]-1]++;
		for(int i: temp)
			if (i != 9)
				return false;
		return true;
	}
	
	public void changeBoxRegion(int i, int j, int box)
	{
		boxArray[i][j] = box;
	}
	
	public boolean checkSolution()
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 1; j <= 9; j++)
			{
				if(!checkNumRow(i, j))
					return false;
				if(!checkNumColumn(i, j))
					return false;
				if(!checkNumBox(i+1, j))
					return false;
			}
		}
		return true;
	}
	
	public static boolean equals(Board a, Board b)
	{
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				if((a.boardArray[i][j] != b.boardArray[i][j]) || (a.boxArray[i][j] != b.boxArray[i][j]))
					return false;
		return true;
	}
	
}
