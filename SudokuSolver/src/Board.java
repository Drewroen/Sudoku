import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.*;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Board extends JComponent
{
	private int[][] boardArray;
	private int[][] boxArray;
	private boolean[][][] potentialArray;
	private InputBox input;
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Constructors for the Board class
	 *----------------------------------------------------------------------------------------------------------------*/
	public Board(InputBox input)
	{
		this.input = input;
		// board itself
		// create a new array to store the numbers in the board
		boardArray = new int[9][9];
		// fill the array with zeroes to initialize it
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				boardArray[i][j] = 0;
		
		// regions
		// create a new array to store the regions of the board
		boxArray = new int[9][9];
		// creates a normal sudoku board with region 1 at the top left, region 3 at the top right, and so on. Region 9 is in the bottom right
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				boxArray[i][j] = (3*(i/3)) + (j/3) + 1;
		
		// potential
		// create a new array to store if a number can be placed in that location
		potentialArray = new boolean[9][9][9];
		for(int i = 0; i < 9; i ++)
			for(int j = 0; j < 9; j++)
				for(int k = 0; k < 9; k++)
					potentialArray[i][j][k] = true;
		
		setPreferredSize(new Dimension(64*9, 64*9));
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
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Changes the number at location (i, j) in the boardArray to num
	 * Changes the potentialArray to reflect the board is full at that location
	 *----------------------------------------------------------------------------------------------------------------*/
	public void placeNumber(int i, int j, int num)
	{
		boardArray[i][j] = num;
		for(int k = 0; k < 9; k++)
			potentialArray[i][j][k] = false;
		repaint();
	}
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Sets the potentialArray at location (i, j, k) to the boolean bool
	 *----------------------------------------------------------------------------------------------------------------*/
	public void setPotential(int i, int j, int k, boolean bool)
	{
		potentialArray[i][j][k - 1] = bool;
	}
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Returns true if there are no potential slots left in the board
	 *----------------------------------------------------------------------------------------------------------------*/
	public boolean noPotential(int i, int j)
	{
		for(int k = 0; k < 9; k++)
			if(potentialArray[i][j][k] == true)
				return false;
		return true;
	}
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Returns true if a number can be added at location (i, j)
	 *----------------------------------------------------------------------------------------------------------------*/
	public boolean canAddNumber(int i, int j, int num)
	{
		if(!checkNumRow(i, num) && !checkNumColumn(j, num) && !checkNumBox(i, j, num) && potentialArray[i][j][num-1])
		{
			return true;
		}
		return false;
	}
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Returns true if a number is currently at location (i, j)
	 *----------------------------------------------------------------------------------------------------------------*/
	public boolean checkNumber(int i, int j)
	{
		return boardArray[i][j] != 0;
	}
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Returns the number at location (i, j)
	 *----------------------------------------------------------------------------------------------------------------*/
	public int getNumber(int i, int j)
	{
		return boardArray[i][j];
	}
	

	public int getRegion(int i, int j)
	{
		return boxArray[i][j];
	}
	

	/*----------------------------------------------------------------------------------------------------------------*
	 * Returns true if the number num is currently in the specified row i
	 *----------------------------------------------------------------------------------------------------------------*/
	public boolean checkNumRow(int i, int num)
	{
		for(int j = 0; j < 9; j++)
			if (boardArray[i][j] == num)
				return true;
		return false;
	}
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Returns true if the number num is currently in the specified column j
	 *----------------------------------------------------------------------------------------------------------------*/
	public boolean checkNumColumn(int j, int num)
	{
		for(int i = 0; i < 9; i++)
			if (boardArray[i][j] == num)
				return true;
		return false;
	}
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Returns true if the region at location (i, j) contains the number num
	 *----------------------------------------------------------------------------------------------------------------*/
	public boolean checkNumBox(int i, int j, int num)
	{
		for(int k = 0; k < 9; k++)
			for(int l = 0; l < 9; l++)
				if(boxArray[k][l] == boxArray[i][j])
					if(boardArray[k][l] == num)
						return true;
		return false;
	}
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Overloaded
	 * Returns true if a number num is in region i
	 *----------------------------------------------------------------------------------------------------------------*/
	public boolean checkNumBox(int i, int num)
	{
		for(int k = 0; k < 9; k++)
			for(int l = 0; l < 9; l++)
				if(boxArray[k][l] == i)
					if(boardArray[k][l] == num)
						return true;
		return false;
	}

	/*----------------------------------------------------------------------------------------------------------------*
	 * Prints the Board to the console
	 * I overloaded it just to differentiate between the version I made and the regular printBoard
	 * Modify to create a visual board in the console
	 * Looks ugly, but gets the job done at the moment
	 *----------------------------------------------------------------------------------------------------------------*/
	public void printBoard()
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
				System.out.print(boardArray[i][j] + " ");
			System.out.println();
		}
	}
	
	public void printBoard(int asdf)
	{
		String printString = new String();
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				// add the number to the string
				printString += boardArray[i][j];
				
				// juxtapose '|' between the numbers to create a column grid
				if (j < 8)
				{
					// if the regions are different between the two numbers, make the region more noticeable
					if (boxArray[i][j] != boxArray[i][j+1])
					{
						printString += " } ";
					}
					// otherwise, create a normal grid
					else 
					{
						printString += " : ";
					}
					
				}
			}
			
			// create a new line
			printString += "\n";
			
			// add a line of dashes between the numbers to create a row grid
			// 33, 1 for 9 numbers + 3 for 8 vertical bars
			if (i < 8)
			{
				for (int j = 0; j < 9; j++)
				{
					// if the regions are different between the top and bottom numbers, make the region noticeable
					if (boxArray[i][j] != boxArray[i + 1][j])
					{
						// if it's the first number in the row, less characters
						if (j == 0)
						{
							printString += "==";
						}
						else
						{
							printString += "====";
						}
					}
					// otherwise, create a normal grid
					else
					{
						// if it's the first number in the row, less characters
						if (j == 0)
						{
							printString += "--";
						}
						else
						{
							printString += "----";
						}
					}
				}
			}
			
			// create a new line
			printString += "\n";
		}
		
		System.out.println(printString);
	}
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Prints the regions of each location on the board
	 *----------------------------------------------------------------------------------------------------------------*/
	public void printBoxRegion()
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
				System.out.print(boxArray[i][j] + " ");
			System.out.println();
		}
	}
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Ask Drew - this is the only time this method is seen
	 *----------------------------------------------------------------------------------------------------------------*/
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
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Changes the region at location (i, j) to the region box
	 *----------------------------------------------------------------------------------------------------------------*/
	public void changeBoxRegion(int i, int j, int box)
	{
		boxArray[i][j] = box;
	}
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Returns true if the board is completely filled
	 *----------------------------------------------------------------------------------------------------------------*/
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
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Returns true if two boards are equal to another
	 *----------------------------------------------------------------------------------------------------------------*/
	public static boolean equals(Board a, Board b)
	{
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
				if((a.boardArray[i][j] != b.boardArray[i][j]) || (a.boxArray[i][j] != b.boxArray[i][j]))
					return false;
		return true;
	}
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Returns the boardArray
	 *----------------------------------------------------------------------------------------------------------------*/
	public int[][] getBoardArray()
	{
		return boardArray.clone();
	}
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Returns the boxArray
	 *----------------------------------------------------------------------------------------------------------------*/
	public int[][] getBoxArray()
	{
		return boxArray.clone();
	}
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Returns a cloned board that is equal to the board that called the function
	 *----------------------------------------------------------------------------------------------------------------*/
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
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Returns true if the board that called the function is equal to Board A
	 *----------------------------------------------------------------------------------------------------------------*/
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
	
	/*----------------------------------------------------------------------------------------------------------------*
	 * Recursive function that solves the board
	 *
	 * This reads the board by row from left to right.
	 * 
	 * 1st case: Row is greater than 8
	 * 		Throw an exception - this means the board is filled
	 * 
	 * 2nd case: A number has been entered at location (row, column)
	 * 		1st case: There are existing elements in the row
	 * 			Recursively call the function again, but move ahead one slot
	 * 		2nd case: The program has read all the elements in the row
	 * 			Recursively call the function again, but move to the left-most element on the next row
	 * 
	 * 3rd case: A number has not been entered at location (row, column)
	 * 		Run a loop through each number
	 * 		1st case: The lowest available number can be placed in this location
	 * 			Place the lowest available number in that location
	 * 			1st case: There are existing elements in the row
	 * 				Recursively call the function again, but move ahead one slot
	 * 			2nd case: The program has read all the elements in the row
	 * 				Recursively call the function again, but move to the left-most element on the next row
	 * 		Clear the slot at location (row, column) - ask Drew how the function moves backwards if it goes down a wrong path
	 *----------------------------------------------------------------------------------------------------------------*/
	public void solve(int row, int column) throws Exception
	{
		if(row > 8)
			throw new Exception();

		// a number has been entered at (row, column)
		if(boardArray[row][column] != 0)
		{
			if(column < 8)
				solve(row, column + 1);
			else
				solve(row + 1, 0);
		}
		// a number has not been entered at (row, column)
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
		repaint();
	}
	
	public void solveWithVisual(int row, int column) throws Exception
	{
		if(row > 8)
			throw new Exception();

		// a number has been entered at (row, column)
		if(boardArray[row][column] != 0)
		{
			if(column < 8)
				solve(row, column + 1);
			else
				solve(row + 1, 0);
		}
		// a number has not been entered at (row, column)
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
		Thread.sleep(1);
		repaint();
	}
	
	public void paintComponent(Graphics g)
    {
		setBackground(Color.BLACK);
		Graphics2D g2 = (Graphics2D)g;
    			
    	
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
			{
				Image box = null;
				if(boxArray[i][j] == 1)
					box = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Box1.png"));
				if(boxArray[i][j] == 2)
					box = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Box2.png"));
				if(boxArray[i][j] == 3)
					box = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Box3.png"));
				if(boxArray[i][j] == 4)
					box = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Box4.png"));
				if(boxArray[i][j] == 5)
					box = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Box5.png"));
				if(boxArray[i][j] == 6)
					box = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Box6.png"));
				if(boxArray[i][j] == 7)
					box = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Box7.png"));
				if(boxArray[i][j] == 8)
					box = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Box8.png"));
				if(boxArray[i][j] == 9)
					box = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Box9.png"));
				BufferedImage boxBuffered = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
				boxBuffered.getGraphics().drawImage(box, 0, 0, null);
				g2.drawImage(boxBuffered, ((int)getSize().getWidth() / 9)*j, ((int)getSize().getHeight() / 9)*i, (int)getSize().getWidth() / 9, (int)getSize().getHeight() / 9, this);
				
				Image number = null;
				if(boardArray[i][j] != 0)
				{
					if(boardArray[i][j] == 1)
						number = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Number1.png"));
					if(boardArray[i][j] == 2)
						number = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Number2.png"));
					if(boardArray[i][j] == 3)
						number = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Number3.png"));
					if(boardArray[i][j] == 4)
						number = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Number4.png"));
					if(boardArray[i][j] == 5)
						number = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Number5.png"));
					if(boardArray[i][j] == 6)
						number = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Number6.png"));
					if(boardArray[i][j] == 7)
						number = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Number7.png"));
					if(boardArray[i][j] == 8)
						number = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Number8.png"));
					if(boardArray[i][j] == 9)
						number = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Number9.png"));
					BufferedImage numberBuffered = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
					numberBuffered.getGraphics().drawImage(number, 0, 0, null);
					g2.drawImage(numberBuffered, ((int)getSize().getWidth() / 9)*j, ((int)getSize().getHeight() / 9)*i, (int)getSize().getWidth() / 9, (int)getSize().getHeight() / 9, this);
				}
			}		
    }
}
