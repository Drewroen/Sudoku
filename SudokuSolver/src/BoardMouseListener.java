import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BoardMouseListener implements MouseListener
{
	private Board b;
	private InputBox c;
	private int numberSelected;
	private boolean eraseSelected;
	
	public BoardMouseListener(Board b, InputBox c)
	{
		this.b = b;
		this.c = c;
		this.numberSelected = 1;
		this.eraseSelected = false;
	}
	
    public void mousePressed(MouseEvent e)
    {
        int mouseX = e.getX();
        int mouseY = e.getY();
        int mouseColumn = mouseX / 70;
        int mouseRow = mouseY / 70;
        
        
        if (eraseSelected)
        {
        	
        }
        else
        {
        	b.placeNumber(mouseRow, mouseColumn, numberSelected);
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
