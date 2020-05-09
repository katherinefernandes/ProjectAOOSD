package worldMap;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PortIcon extends Icon{
	private static Toolkit t = Toolkit.getDefaultToolkit();
	private static Image image = t.getImage("graphics/port.jpg");
	private String portName;
	
	public PortIcon() {
		super(30,30);
	}
	
	public void setPortName(String portName) {
		this.portName = portName;
	}
	
	@Override
	protected Image getImage() {
		return image;
	}
	
	@Override
	public void drawIcon(Graphics g, JPanel p) {
		super.drawIcon(g, p);
		g.drawString(portName, xPosition, yPosition - 5);
	}
}
