import java.awt.*;
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