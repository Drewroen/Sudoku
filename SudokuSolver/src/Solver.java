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
			if(firstTime)
				firstTime = false;
			added = false;
			s.push(temp.clone());
			if(!temp.checkNumber(coord / 9, coord % 9))
			{
				for(int i = 0; i < 9; i++)
				{
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
}
