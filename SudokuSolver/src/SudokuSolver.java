import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class SudokuSolver {


	public static final JFrame main = new JFrame("Irregular Sudoku Solver");
	public static void main(String[] args) throws Exception
	{
		init();
	}
	
	public static void init()
	{
		InputBox c = new InputBox();
		Board b = new Board(c);
		b.addMouseListener(new BoardMouseListener(b, c));
		c.addMouseListener(new InputMouseListener(b, c));
		
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

<<<<<<< HEAD
		b.setPreferredSize(new Dimension(630, 630));
		c.setPreferredSize(new Dimension(630, 214));
=======
		//main.setPreferredSize(new Dimension(613, 710));
		b.setPreferredSize(new Dimension(630, 630));
		c.setPreferredSize(new Dimension(613, 214));
>>>>>>> 89fcec009bc92b202889c73d0a893431da4fb2d4
		
		main.add(b);
		main.add(c, BorderLayout.SOUTH);
		main.pack();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setBackground(Color.BLACK);
		main.setResizable(false);
		main.setVisible(true);
		
		UserGame game = new UserGame(b);
		try {
			Board userBoard = game.play();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
<<<<<<< HEAD

=======
	
>>>>>>> 89fcec009bc92b202889c73d0a893431da4fb2d4
}