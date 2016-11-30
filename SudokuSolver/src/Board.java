public class Board
{
	private int[][] boardArray;
	private int[][] boxArray;
	private boolean[][][] potentialArray;
	
	public Board()
	{
		// board itself
		boardArray = new int[9][9];
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				boardArray[i][j] = 0;
		// regions
		boxArray = new int[9][9];
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				boxArray[i][j] = (3*(i/3)) + (j/3) + 1;
		
		potentialArray = new boolean[9][9][9];
		for(int i = 0; i < 9; i ++)
			for(int j = 0; j < 9; j++)
				for(int k = 0; k < 9; k++)
					potentialArray[i][j][k] = true;
	}
	
	public Board(int[][] board, int[][] box, boolean[][][] potential)
	{
		boardArray = board;
		boxArray = box;
		potentialArray = potential;
	}
	
	public Board(Board b)
	{
		boardArray = b.boardArray;
		boxArray = b.boxArray;
		potentialArray = b.potentialArray;
	}
	
	public void placeNumber(int i, int j, int num)
	{
		boardArray[i][j] = num;
		for(int k = 0; k < 9; k++)
			potentialArray[i][j][k] = false;
	}
	
	public void setPotential(int i, int j, int k, boolean l)
	{
		potentialArray[i][j][k - 1] = l;
	}
	
	public boolean noPotential(int i, int j)
	{
		for(int k = 0; k < 9; k++)
			if(potentialArray[i][j][k] == true)
				return false;
		return true;
	}
	
	public boolean canAddNumber(int i, int j, int num)
	{
		if(!checkNumRow(i, num) && !checkNumColumn(j, num) && !checkNumBox(i, j, num) && potentialArray[i][j][num-1])
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
	
	public int getBox(int i, int j)
	{
		return boxArray[i][j];
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
	
	public int[][] getBoardArray()
	{
		return boardArray.clone();
	}
	
	public int[][] getBoxArray()
	{
		return boxArray.clone();
	}
	
	public Board clone()
	{
		int[][] boardArrayNew = new int[9][9];
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				boardArrayNew[i][j] = boardArray[i][j];
		int[][] boxArrayNew = new int[9][9];
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				boxArrayNew[i][j] = boxArray[i][j];
		boolean[][][] potentialArrayNew = new boolean[9][9][9];
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				for(int k = 0; k < 9; k++)
					potentialArrayNew[i][j][k] = potentialArray[i][j][k];
		return new Board(boardArrayNew, boxArrayNew, potentialArrayNew);
	}
	
	public boolean equals(Board a)
	{
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				if (a.boardArray[i][j] != boardArray[i][j])
					return false;
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				if (a.boxArray[i][j] != boxArray[i][j])
					return false;
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				for(int k = 0; k < 9; k++)
					if	(a.potentialArray[i][j][k] != potentialArray[i][j][k])
						return false;
		return true;
	}
	
	public void solve(int row, int column) throws Exception
	{
		if(row > 8)
			throw new Exception();

		if(boardArray[row][column] != 0)
		{
			if(column < 8)
				solve(row, column + 1);
			else
				solve(row + 1, 0);
		}
		else
		{
			for(int i = 0; i < 9; i++)
			{
				if(!checkNumRow(row, i + 1) && !checkNumColumn(column, i + 1) && !checkNumBox(row,column, i + 1))
				{
					boardArray[row][column] = i + 1;
					if(column < 8)
						solve(row, column + 1);
					else
						solve(row + 1, 0);
				}
			}
			boardArray[row][column] = 0;
		}
	}
}
