import java.util.ArrayList;
import java.util.Stack;
public class Solver {
	public static Board solveBoard(Board b)
	{
		Stack<Board> s = new Stack<Board>();
		Board temp = b.clone();
		int coord = 0;
		boolean added;
		boolean firstTime = true;
		ArrayList<Board> failed = new ArrayList<Board>();
		while(!temp.checkSolution() && (!s.isEmpty() || firstTime))
		{
			added = false;
			s.push(temp.clone());
			if(!temp.checkNumber(coord / 9, coord % 9))
			{
				for(int i = 0; i < 9; i++)
				{
					if(firstTime)
						firstTime = false;
					if(temp.canAddNumber(coord / 9, coord % 9, i + 1))
					{
						Board temp2 = temp.clone();
						temp2.placeNumber(coord / 9, coord % 9, i + 1);
						if(!failedState(temp2, failed))
						{
							s.push(temp2);
							added = true;
						}
					}
				}
				if(!added)
				{
					Board temp2 = s.pop().clone();
					failed.add(temp2);
					coord--;
				}
				else
				{
					coord++;
					temp.printBoard();
					System.out.println();
				}
			}
			else
			{
				coord++;
			}
			temp = s.pop().clone();
		}
		return temp;
	}
	
	public static boolean failedState(Board b, ArrayList<Board> failed)
	{
		for(Board a: failed)
			if(a.equals(b))
				return true;
		return false;
	}
	
	public static void solveBoard2(Board b, int row, int column)
	{
	      // Throw an exception to stop the process if the puzzle is solved
	      if( row > 8 )
	         return;

	      // If the cell is not empty, continue with the next cell
	      if(b.getBoardArray()[row][column] != 0)
	      {
	    	  if(column < 8 )
	    	         solveBoard2(b, row, column + 1);
	    	      else
	    	         solveBoard2(b,  row + 1, 0);
	      }
	      else
	      {
	         // Find a valid number for the empty cell
	         for(int num = 1; num < 10; num++)
	         {
	            if(!b.checkNumRow(row,num) && !b.checkNumColumn(column,num) && !b.checkNumBox(row, column, num))
	            {
	               b.placeNumber(row,  column,num);
	               // Delegate work on the next cell to a recursive call
	               if(column < 8 )
		    	         solveBoard2(b, row, column + 1);
		    	      else
		    	         solveBoard2(b,  row + 1, 0);
	            }
	         }

	         // No valid number was found, clean up and return to caller
	         b.placeNumber(row, column, 0);
	      }
	}
}
