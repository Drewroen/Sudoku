import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputMouseListener implements MouseListener
{
	private Board b;
	private InputBox c;
	
	public InputMouseListener(Board b, InputBox c)
	{
		this.b = b;
		this.c = c;
	}
	
    public void mousePressed(MouseEvent e)
    {
    	if((e.getY() < 170) && (e.getY() > 29))
	        c.setInput((e.getX() / 70) + (9 * ((e.getY() - 30) / 70)));
    	else if((e.getY() >= 170) && (e.getY() <= 239))
    	{
    		if((e.getX() >= 105) && (e.getX() <= 524))
    			if((e.getX() - 105) / 140 == 0)
    				c.setInput(18);
    			if((e.getX() - 105) / 140 == 1)
    			{
					try {
						b.solve(0, 0);
					} catch (Exception e1){}
    				b.repaint();
    			}
    			if((e.getX() - 105) / 140 == 2)
    			{
    				b.clearBoard();
    			}
    	}
    }
    public void mouseReleased(MouseEvent e)
    {
    }
    public void mouseEntered(MouseEvent e)
    {
    }
    public void mouseExited(MouseEvent e)
    {
    }
    public void mouseClicked(MouseEvent e)
    {
    }
}
