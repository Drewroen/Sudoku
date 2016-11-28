public class SudokuSolver {

	public static void main(String[] args)
	{
		Board b = new Board();
		b.placeNumber(0, 0, 9);
		b.placeNumber(0, 4, 2);
		b.placeNumber(0, 6, 7);
		b.placeNumber(0, 7, 5);
		b.placeNumber(1, 0, 6);
		b.placeNumber(1, 4, 5);
		b.placeNumber(1, 7, 4);
		b.placeNumber(2, 1, 2);
		b.placeNumber(2, 3, 4);
		b.placeNumber(2, 7, 1);
		b.placeNumber(3, 0, 2);
		b.placeNumber(3, 2, 8);
		b.placeNumber(4, 1, 7);
		b.placeNumber(4, 3, 5);
		b.placeNumber(4, 5, 9);
		b.placeNumber(4, 7, 6);
		b.placeNumber(5, 6, 4);
		b.placeNumber(5, 8, 1);
		b.placeNumber(6, 5, 5);
		b.placeNumber(6, 7, 8);
		b.placeNumber(7, 1, 9);
		b.placeNumber(7, 4, 7);
		b.placeNumber(7, 8, 4);
		b.placeNumber(8, 1, 8);
		b.placeNumber(8, 2, 2);
		b.placeNumber(8, 4, 4);
		b.placeNumber(8, 8, 6);
		System.out.println(b.canAddNumber(0, 0, 3));
		b.printBoard();
		System.out.println();
		try
		{
			b.solve(0, 0);
		}
		catch (Exception e) {}
		b.printBoard();
	}
}
