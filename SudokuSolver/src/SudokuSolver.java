import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class SudokuSolver {

	public static final JFrame main = new JFrame("Irregular Sudoku Solver");
	public static void main(String[] args)
	{
		Board b = new Board();
		
		main.setLayout(new BorderLayout());
		JComponent board = new JPanel(new GridLayout(9, 9));
		JComponent numbers = new JPanel(new GridLayout(2, 10));
		
		numbers.add(new InputBox("1"));
		numbers.add(new InputBox("2"));
		numbers.add(new InputBox("3"));
		numbers.add(new InputBox("4"));
		numbers.add(new InputBox("5"));
		numbers.add(new InputBox("6"));
		numbers.add(new InputBox("7"));
		numbers.add(new InputBox("8"));
		numbers.add(new InputBox("9"));
		numbers.add(new InputBox("ERASE"));
		numbers.add(new InputBox("A"));
		numbers.add(new InputBox("B"));
		numbers.add(new InputBox("C"));
		numbers.add(new InputBox("D"));
		numbers.add(new InputBox("E"));
		numbers.add(new InputBox("F"));
		numbers.add(new InputBox("G"));
		numbers.add(new InputBox("H"));
		numbers.add(new InputBox("I"));
		
		numbers.setPreferredSize(new Dimension(200, 200));
		board.setPreferredSize(new Dimension(600, 620));
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9; j++)
				board.add(new Box(i, j, b));
		}

		main.add(board);
		main.add(numbers, BorderLayout.SOUTH);
		
		main.pack();
		
		main.setVisible(true);
		
		
		b.placeNumber(0, 1, 5);
		b.placeNumber(0, 2, 3);
		b.placeNumber(0, 5, 9);
		b.placeNumber(1, 7, 2);
		b.placeNumber(2, 3, 7);
		b.placeNumber(2, 5, 6);
		b.placeNumber(3, 0, 1);
		b.placeNumber(3, 1, 2);
		b.placeNumber(3, 2, 6);
		b.placeNumber(3, 7, 4);
		b.placeNumber(3, 8, 7);
		b.placeNumber(4, 3, 3);
		b.placeNumber(4, 5, 5);
		b.placeNumber(5, 0, 6);
		b.placeNumber(5, 2, 9);
		b.placeNumber(5, 8, 2);
		b.placeNumber(6, 7, 7);
		b.placeNumber(6, 8, 9);
		b.placeNumber(7, 1, 1);
		b.placeNumber(7, 3, 4);
		b.placeNumber(7, 4, 9);
		b.placeNumber(8, 8, 1);
		
		b.changeBoxRegion(3, 0, 1);
		b.changeBoxRegion(3, 1, 1);
		b.changeBoxRegion(1, 2, 2);
		b.changeBoxRegion(2, 2, 2);
		b.changeBoxRegion(3, 2, 2);
		b.changeBoxRegion(3, 3, 2);
		b.changeBoxRegion(0, 5, 3);
		b.changeBoxRegion(1, 5, 3);
		
		b.changeBoxRegion(5, 3, 4);
		b.changeBoxRegion(6, 1, 4);
		b.changeBoxRegion(6, 2, 4);
		b.changeBoxRegion(6, 3, 4);
		
		b.changeBoxRegion(2, 4, 5);
		b.changeBoxRegion(4, 2, 5);
		b.changeBoxRegion(4, 6, 5);
		b.changeBoxRegion(6, 4, 5);
		
		b.changeBoxRegion(2, 5, 6);
		b.changeBoxRegion(2, 6, 6);
		b.changeBoxRegion(2, 7, 6);	
		b.changeBoxRegion(3, 5, 6);
		
		b.changeBoxRegion(7, 3, 7);
		b.changeBoxRegion(8, 3, 7);
		
		b.changeBoxRegion(5, 6, 8);
		b.changeBoxRegion(5, 5, 8);
		b.changeBoxRegion(6, 6, 8);
		b.changeBoxRegion(7, 6, 8);
		
		b.changeBoxRegion(5, 7, 9);
		b.changeBoxRegion(5, 8, 9);
		
		b.printBoard();
		System.out.println();
		b.printBoxRegion();
		System.out.println();
		try
		{
			b.solve(0, 0);
		}
		catch (Exception e) {}
		b.printBoard();
	}
	
	public static void init()
	{
		
	}
}

class Box extends JPanel
{ 
    private int x;
    private int y;
    private Board b;
    
    public Box(int x, int y, Board b)
    {
    	this.x = x;
    	this.y = y;
    	this.b = b;
    }
    
    public void paintComponent(Graphics g)
    {
    	g.drawLine(0 + 2, 0 + 2, 0 + 2, this.getHeight() - 2);
    	g.drawLine(0 + 2, 0 + 2, this.getWidth() - 2, 0 + 2);
    	//g.drawLine(this.getWidth() - 2, 0 + 2, this.getWidth() - 2, this.getHeight() - 2);
    	//g.drawLine(0 + 2, this.getHeight() - 2, this.getWidth() - 2, this.getHeight() - 2);
    	
    	if(y != 8 && (b.getBox(x, y) != b.getBox(x, y + 1)))
    		g.drawLine(this.getWidth() - 1, 0 + 1, this.getWidth() - 1, this.getHeight() - 1);
    	g.drawLine(this.getWidth() - 2, 0 + 2, this.getWidth() - 2, this.getHeight() - 2);
    	if(x != 8 && (b.getBox(x, y) != b.getBox(x + 1, y)))
    		g.drawLine(0 + 1, this.getHeight() - 1, this.getWidth() - 1, this.getHeight() - 1);
    	g.drawLine(0 + 2, this.getHeight() - 2, this.getWidth() - 2, this.getHeight() - 2);
    	if(y != 0 && (b.getBox(x, y) != b.getBox(x, y - 1)))
    		g.drawLine(0 + 1, 0 + 1, 0 + 1, this.getHeight() - 1);
    	g.drawLine(0 + 2, 0 + 2, 0 + 2, this.getHeight() - 2);
    	if(x != 0 && (b.getBox(x, y) != b.getBox(x - 1, y)))
    		g.drawLine(0 + 1, 0 + 1, this.getWidth() - 1, 0  + 1);
    	g.drawLine(0 + 2, 0 + 2, this.getWidth() - 2, 0 + 2);
    	
    	if(b.getNumber(x, y) == 1)
    		g.drawString("1", (int)(this.getWidth() / 2.3), (int)(this.getHeight() / 1.8));
    	else if(b.getNumber(x, y) == 2)
    		g.drawString("2", (int)(this.getWidth() / 2.3), (int)(this.getHeight() / 1.8));
    	else if(b.getNumber(x, y) == 3)
    		g.drawString("3", (int)(this.getWidth() / 2.3), (int)(this.getHeight() / 1.8));
    	else if(b.getNumber(x, y) == 4)
    		g.drawString("4", (int)(this.getWidth() / 2.3), (int)(this.getHeight() / 1.8));
    	else if(b.getNumber(x, y) == 5)
    		g.drawString("5", (int)(this.getWidth() / 2.3), (int)(this.getHeight() / 1.8));
    	else if(b.getNumber(x, y) == 6)
    		g.drawString("6", (int)(this.getWidth() / 2.3), (int)(this.getHeight() / 1.8));
    	else if(b.getNumber(x, y) == 7)
    		g.drawString("7", (int)(this.getWidth() / 2.3), (int)(this.getHeight() / 1.8));
    	else if(b.getNumber(x, y) == 8)
    		g.drawString("8", (int)(this.getWidth() / 2.3), (int)(this.getHeight() / 1.8));
    	else if(b.getNumber(x, y) == 9)
    		g.drawString("9", (int)(this.getWidth() / 2.3), (int)(this.getHeight() / 1.8));
    	
    	
    			
    }
}

class InputBox extends JComponent
{
    private String x;
    
    public InputBox(String x)
    {
    	this.x = x;
    }
    
    public void paintComponent(Graphics g)
    {
    	g.drawLine(0 + 2, 0 + 2, 0 + 2, this.getHeight() - 2);
    	g.drawLine(0 + 2, 0 + 2, this.getWidth() - 2, 0 + 2);
    	g.drawLine(this.getWidth() - 2, 0 + 2, this.getWidth() - 2, this.getHeight() - 2);
    	g.drawLine(0 + 2, this.getHeight() - 2, this.getWidth() - 2, this.getHeight() - 2);
    	g.drawString(x, (int)(this.getWidth() / 2.3), (int)(this.getHeight() / 1.8));
    }
}