import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
		main.addKeyListener(new HotKey(b));

		b.setPreferredSize(new Dimension(630, 630));
		c.setPreferredSize(new Dimension(630, 269));
		
		main.add(b);
		main.add(c, BorderLayout.SOUTH);
		main.pack();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setBackground(Color.BLACK);
		main.setResizable(false);
		main.setVisible(true);
		try {
			b.solve(0, 0);
		} catch (Exception e) {
		}
	}
}

class HotKey implements KeyListener
{
	private Board b;
	public HotKey(Board b)
	{
		this.b = b;
	}
	
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_1)
        {
			b.clearBoard();
        	
			int[][] b1Array = 
				{
					{1, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 2, 0, 0, 0, 0, 0, 0, 0},
					{0, 0, 3, 0, 0, 0, 0, 0, 0},
					{0, 0, 0, 4, 0, 0, 0, 0, 0},
					{0, 0, 0, 0, 5, 0, 0, 0, 0},
					{0, 0, 0, 0, 0, 6, 0, 0, 0},
					{0, 0, 0, 0, 0, 0, 7, 0, 0},
					{0, 0, 0, 0, 0, 0, 0, 8, 0},
					{0, 0, 0, 0, 0, 0, 0, 0, 9}
				};
			
			int[][] b1Box = 
				{
					{1, 1, 1, 2, 2, 2, 3, 3, 3},
					{1, 1, 1, 2, 2, 2, 3, 3, 3},
					{1, 1, 1, 2, 2, 2, 3, 3, 3},
					{4, 4, 4, 5, 5, 5, 6, 6, 6},
					{4, 4, 4, 5, 5, 5, 6, 6, 6},
					{4, 4, 4, 5, 5, 5, 6, 6, 6},
					{7, 7, 7, 8, 8, 8, 9, 9, 9},
					{7, 7, 7, 8, 8, 8, 9, 9, 9},
					{7, 7, 7, 8, 8, 8, 9, 9, 9}
				};
			
			b.setBoardArray(b1Array);
			b.setBoxArray(b1Box);
        }
		if (e.getKeyCode() == KeyEvent.VK_2)
        {
			b.clearBoard();
        	
			int[][] b2Array = 
				{
					{0, 0, 0, 0, 0, 0, 0, 9, 0},
					{0, 0, 9, 0, 0, 2, 0, 1, 7},
					{0, 4, 0, 9, 0, 0, 8, 0, 2},
					{0, 0, 0, 7, 5, 0, 0, 0, 1},
					{7, 0, 0, 2, 0, 8, 0, 0, 5},
					{2, 0, 0, 0, 9, 1, 0, 0, 0},
					{5, 0, 1, 0, 0, 6, 0, 7, 0},
					{4, 2, 0, 5, 0, 0, 6, 0, 0},
					{0, 3, 0, 0, 0, 0, 0, 0, 0}
				};
			
			int[][] b2Box = 
				{
					{1, 1, 1, 2, 2, 2, 3, 3, 3},
					{1, 1, 1, 2, 2, 2, 3, 3, 3},
					{1, 1, 1, 2, 2, 2, 3, 3, 3},
					{4, 4, 4, 5, 5, 5, 6, 6, 6},
					{4, 4, 4, 5, 5, 5, 6, 6, 6},
					{4, 4, 4, 5, 5, 5, 6, 6, 6},
					{7, 7, 7, 8, 8, 8, 9, 9, 9},
					{7, 7, 7, 8, 8, 8, 9, 9, 9},
					{7, 7, 7, 8, 8, 8, 9, 9, 9}
				};
			
			b.setBoardArray(b2Array);
			b.setBoxArray(b2Box);
        }
		if (e.getKeyCode() == KeyEvent.VK_3)
        {
			b.clearBoard();
        	
			int[][] b3Array = 
				{
					{0, 0, 0, 0, 5, 0, 0, 0, 7},
					{0, 0, 0, 0, 0, 0, 0, 4, 0},
					{3, 0, 4, 0, 0, 5, 2, 0, 0},
					{7, 2, 0, 0, 0, 1, 0, 5, 0},
					{0, 0, 0, 0, 0, 0, 0, 0, 0},
					{0, 6, 0, 4, 0, 0, 0, 9, 2},
					{0, 0, 9, 8, 0, 0, 7, 0, 5},
					{0, 3, 0, 0, 0, 0, 0, 0, 0},
					{8, 0, 0, 0, 6, 0, 0, 0, 0}
				};
			
			int[][] b3Box = 
				{
					{1, 1, 1, 1, 1, 2, 2, 2, 2},
					{1, 1, 3, 3, 1, 1, 2, 2, 2},
					{3, 3, 3, 4, 4, 5, 5, 2, 2},
					{3, 3, 4, 4, 4, 5, 6, 6, 6},
					{3, 3, 4, 5, 5, 5, 6, 9, 9},
					{4, 4, 4, 5, 6, 6, 6, 9, 9},
					{7, 7, 5, 5, 6, 6, 9, 9, 9},
					{7, 7, 7, 8, 8, 9, 9, 8, 8},
					{7, 7, 7, 7, 8, 8, 8, 8, 8}
				};
			
			b.setBoardArray(b3Array);
			b.setBoxArray(b3Box);
        }
		if (e.getKeyCode() == KeyEvent.VK_4)
        {
			b.clearBoard();
        	
			int[][] b4Array = 
				{
					{0, 0, 0, 0, 0, 0, 8, 4, 0},
					{0, 0, 0, 0, 0, 0, 0, 1, 8},
					{0, 0, 0, 0, 6, 0, 0, 0, 4},
					{0, 0, 9, 0, 0, 0, 7, 0, 0},
					{0, 9, 0, 2, 0, 1, 0, 3, 0},
					{0, 0, 3, 0, 0, 0, 5, 0, 0},
					{1, 0, 0, 0, 4, 0, 0, 0, 0},
					{6, 1, 0, 0, 0, 0, 0, 0, 0},
					{0, 7, 6, 0, 0, 0, 0, 0, 0}
				};
			
			int[][] b4Box = 
				{
					{1, 1, 1, 1, 1, 2, 2, 3, 4},
					{1, 5, 6, 2, 2, 2, 2, 3, 4},
					{1, 5, 6, 2, 7, 7, 3, 3, 4},
					{1, 5, 6, 2, 7, 7, 3, 4, 4},
					{1, 5, 6, 2, 7, 8, 3, 4, 9},
					{5, 5, 6, 7, 7, 8, 3, 4, 9},
					{5, 6, 6, 7, 7, 8, 3, 4, 9},
					{5, 6, 8, 8, 8, 8, 3, 4, 9},
					{5, 6, 8, 8, 9, 9, 9, 9, 9}
				};
			
			b.setBoardArray(b4Array);
			b.setBoxArray(b4Box);
        }
    }

	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {}
}