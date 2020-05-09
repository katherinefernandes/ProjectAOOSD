package worldMap;

import java.awt.Image;
import java.awt.Toolkit;

public class BoatIcon extends Icon{
	private static Toolkit t = Toolkit.getDefaultToolkit();
	private static Image image = t.getImage("graphics/boat.png");
	
	public BoatIcon(){
		super(15,15);
	}

	@Override
	protected Image getImage() {
		return image;
	}
}
