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
        	b.placeNumber(0, 0, 5);
        }
		if (e.getKeyCode() == KeyEvent.VK_2)
        {
        	b.placeNumber(0, 1, 5);
        }
		if (e.getKeyCode() == KeyEvent.VK_3)
        {
        	b.placeNumber(0, 2, 5);
        }
		if (e.getKeyCode() == KeyEvent.VK_4)
        {
        	b.placeNumber(0, 3, 5);
        }
    }

	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {}
}