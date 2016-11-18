public class SudokuSolver {

	public static void main(String[] args)
	{
		Board b = new Board();
		b.placeNumber(1, 2, 5);
		System.out.println(b.placeNumberWithCheck(1, 1, 6));
		if (b.checkNumber(1, 2))
			System.out.println("There is a number at 1,2");
		System.out.println(b.getNumber(1, 2));
		System.out.println(b.checkNumRow(1, 5));
		System.out.println(b.checkNumColumn(1, 5));
		System.out.println(b.checkNumBox(1, 2, 5));
		b.changeBoxRegion(0, 3, 1);
		b.changeBoxRegion(2, 2, 2);
		System.out.println(b.confirmBoxSize());
		b.printBoard();
		System.out.println();
		b.printBoxRegion();
		
	}
}
