public class SudokuSolver {

	public static void main(String[] args)
	{
		Board b = new Board();
		//b.placeNumber(1, 2, 5);
		System.out.println(b.canAddNumber(0, 0, 3));
		b.printBoard();
		System.out.println();
		b.printBoxRegion();
		System.out.println();
		Board solved = Solver.solveBoard(b);
		solved.printBoard();
	}
}
