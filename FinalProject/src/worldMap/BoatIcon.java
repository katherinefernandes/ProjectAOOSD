package worldMap;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class BoatIcon extends Canvas{
	
	public void paint(Graphics g) {  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("graphics/boat.png");  
        g.drawImage(i, 0, 0, 860, 901, this);  
    } 
}
