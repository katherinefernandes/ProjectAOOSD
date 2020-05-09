package worldMap;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class PortIcon extends Icon{
	private static Toolkit t = Toolkit.getDefaultToolkit();
	private static Image image = t.getImage("graphics/port.jpg");
	
	public PortIcon() {
		super(30,30);
	}
	@Override
	protected Image getImage() {
		return image;
	}
}
