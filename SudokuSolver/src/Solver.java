import java.util.Stack;
public class Solver {
	public static Board solveBoard(Board b)
	{
		Stack<Board> s = new Stack<Board>();
		s.push(b);
		int coord = 0;
		Board temp = b;
		boolean add = false;
		while(!temp.checkSolution() || !(coord < 81))
		{
			if(temp.checkNumber(coord / 9, coord % 9))
				coord++;
			else
			{
				add = false;
				for(int i = 1; i <= 9; i++)
				{
					if(temp.canAddNumber(coord / 9, coord % 9, i))
					{
						Board temp2 = temp;
						temp2.placeNumber(coord / 9, coord % 9, i);
						s.push(temp2);
						add = true;
					}
				}	
				if(!add)
				{
					coord--;
				}
			temp.printBoard();
			System.out.println();
			System.out.println(s.size());
			s.pop();
			temp = s.pop();		
			}
			
		}
		return b;
	}
}
