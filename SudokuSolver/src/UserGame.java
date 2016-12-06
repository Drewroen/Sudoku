import java.util.Scanner;

public class UserGame {
	
	private Board b;
	private Board initialBoard;
	
	public UserGame(Board b)
	{
		this.b = b;
		this.initialBoard = b;
	}
	
	public Board play() throws Exception
	{
		Scanner scanner = new Scanner(System.in);
		int userInput = 0;
		boolean done = false;
		
		while (!done)
		{
			System.out.println("Welcome to your sudoku board");
			System.out.println("\t1: Show board");
			System.out.println("\t2: Show regions");
			System.out.println("\t3: Enter number");
			System.out.println("\t4: Show available numbers in a region");
			System.out.println("\t5: Give up");
			System.out.println("What would you like to do?: ");
			
			userInput = scanner.nextInt();
			
            // create functions for each individual case statement. this way they can be used via the GUI jpanel
			switch (userInput) {
			case 1:
				b.printBoard(1);
				break;
				
			case 2:
				b.printBoxRegion();
				break;
				
			case 3:
				b.printBoard(1);
				System.out.println();
				
				System.out.println("Enter the coordinates you would like to change (row, column) (enter '10' to go back): ");
				int row = scanner.nextInt();
				if (row == 10) break;
				int column = scanner.nextInt();
				
				System.out.println("Enter the number you would like to place at (" + row + " , " + column + ") (enter '10' to go back): ");
				int number = scanner.nextInt();
				if (number == 10) break;
				
				boolean canAddNumber = b.canAddNumber(row, column, number);
				if (canAddNumber)
				{
					b.placeNumber(row, column, number);
				}
				else
				{
					System.out.println("You cannot place a number there!");
				}
				
				break;
				
			case 4:
				break;
				
			case 5:
				done = true;
				try
				{
					initialBoard.solve(0, 0);
				}
				catch (Exception e) {}
				initialBoard.printBoard();
				break;
				
			default:
				System.out.println("Invalid option\n");
			
			}
		}
		
		
		
		return b;
	}

}
