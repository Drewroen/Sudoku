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
        System.out.println("You clicked the input area!");
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
