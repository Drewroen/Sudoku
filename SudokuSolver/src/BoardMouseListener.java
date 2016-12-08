import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardMouseListener implements MouseListener
{
	private Board b;
	private InputBox c;
	
	public BoardMouseListener(Board b, InputBox c)
	{
		this.b = b;
		this.c = c;
	}
	
    public void mousePressed(MouseEvent e)
    {
        int mouseColumn = e.getX() / 70;
        int mouseRow = e.getY() / 70;
        
        if(c.getInput() <= 8)
        {
        	b.changeBoxRegion(mouseRow, mouseColumn, c.getInput() + 1);
        }
        else if(c.getInput() >= 9 && c.getInput() <= 17)
        {
        	b.placeNumber(mouseRow, mouseColumn, c.getInput() - 8);
        }
        
        else if(c.getInput() == 18)
        {
        	b.placeNumber(mouseRow, mouseColumn, 0);
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
