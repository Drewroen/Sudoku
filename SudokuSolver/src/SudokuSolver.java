import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class SudokuSolver {

	public static void main(String[] args)
	{
		
		JFrame frame = new JFrame("Irregular Sudoku Solver");
		frame.setLayout(new GridLayout(3, 3));
		JComponent box1 = new JPanel(new GridLayout(3, 3));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1000, 1000));
		
		for(int i = 0; i < 9; i++)
		{
			JComponent box = new JPanel(new GridLayout(3, 3));
			for(int j = 0; j < 9; j++)
				box.add(new Box());
			frame.add(box);
		}

		
		
		frame.pack();
		
		frame.setVisible(true);
		
		Board b = new Board();
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
}

class Box extends JPanel{ 
    BufferedImage image;
    public void paintComponent(Graphics g)
    {
    	g.drawLine(0 + 2, 0 + 2, 0 + 2, this.getHeight() - 2);
    	g.drawLine(0 + 2, 0 + 2, this.getWidth() - 2, 0 + 2);
    	g.drawLine(this.getWidth() - 2, 0 + 2, this.getWidth() - 2, this.getHeight() - 2);
    	g.drawLine(0 + 2, this.getHeight() - 2, this.getWidth() - 2, this.getHeight() - 2);
    }
}