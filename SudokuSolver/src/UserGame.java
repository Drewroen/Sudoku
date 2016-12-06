import java.util.Scanner;

public class UserGame {
	
	private Board b;
	
	public UserGame(Board b)
	{
		this.b = b;
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
			
			switch (userInput) {
			case 1:
				break;
				
			case 2:
				break;
				
			case 3:
				break;
				
			case 4:
				break;
				
			case 5:
				done = true;
				try
				{
					b.solve(0, 0);
				}
				catch (Exception e) {}
				b.printBoard();
				break;
				
			default:
				System.out.println("Invalid option\n");
			
			}
		}
		
		
		
		return b;
	}

}
