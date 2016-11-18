public class SudokuSolver {

	public static void main(String[] args)
	{
		Board b = new Board();
		b.placeNumber(1, 2, 5);
		if (b.checkNumber(1, 2))
			System.out.println("There is a number at 1,2");
		System.out.println(b.getNumber(1, 2));
		System.out.println(b.checkRow(1, 5));
		System.out.println(b.checkColumn(1, 5));
		b.printBoard();
		System.out.println();
		b.printBoxRegion();
	}
}
