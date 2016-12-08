import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class SudokuSolver{


	public static final JFrame main = new JFrame("Irregular Sudoku Solver");
	private static InputBox c = new InputBox();
	private static Board b = new Board(c);
	public static void main(String[] args) throws Exception
	{
		init(b, c);
	}
	
	public static void init(Board b, InputBox c)
	{
		b.addMouseListener(new BoardMouseListener(b, c));
		c.addMouseListener(new InputMouseListener(b, c));

		b.setPreferredSize(new Dimension(630, 630));
		c.setPreferredSize(new Dimension(630, 269));
		
		main.add(b);
		main.add(c, BorderLayout.SOUTH);
		main.pack();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setBackground(Color.BLACK);
		main.setResizable(false);
		main.setVisible(true);
//		try {
//			b.solve(0, 0);
//		} catch (Exception e) {
//		}
	}
	
	public static void clearFrame()
	{
		main.remove(b);
		main.remove(c);
	}
	
}