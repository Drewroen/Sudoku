import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

<<<<<<< HEAD
		b.setPreferredSize(new Dimension(630, 630));
		c.setPreferredSize(new Dimension(630, 269));
=======
		b.setPreferredSize(new Dimension(630, 630));
		c.setPreferredSize(new Dimension(630, 214));

		//main.setPreferredSize(new Dimension(613, 710));
		b.setPreferredSize(new Dimension(630, 630));
		c.setPreferredSize(new Dimension(613, 214));

>>>>>>> 796ddbd4fd8de621c7d09378369714b13d3c1cef
		
		main.add(b);
		main.add(c, BorderLayout.SOUTH);
		main.pack();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setBackground(Color.BLACK);
		main.setResizable(false);
		main.setVisible(true);
<<<<<<< HEAD
=======
		
/*		UserGame game = new UserGame(b);
>>>>>>> 796ddbd4fd8de621c7d09378369714b13d3c1cef
		try {
			b.solve(0, 0);
		} catch (Exception e) {
<<<<<<< HEAD
		}
		b.repaint();
		b.revalidate();
		main.repaint();
=======
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
>>>>>>> 796ddbd4fd8de621c7d09378369714b13d3c1cef
	}
}