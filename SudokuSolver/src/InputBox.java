import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class InputBox extends JComponent
{
    
    public InputBox()
    {
    }
    
    public void paintComponent(Graphics g)
    {
    	setBackground(Color.BLACK);
		Graphics2D g2 = (Graphics2D)g;
    			
    	
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
			{
				Image box = null;
				box = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/Buttons.png"));
				BufferedImage boxBuffered = new BufferedImage(613, 214, BufferedImage.TYPE_INT_ARGB);
				boxBuffered.getGraphics().drawImage(box, 0, 0, null);
				g2.drawImage(boxBuffered, 0, 0, (int)getSize().getWidth(), (int)getSize().getHeight(), this);
			}	
    }
}