package worldMap;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import dataWrappers.Location;

public class Icon {
	private Image image;
	private int width;
	private int height;
	private int xPosition;
	private int yPosition;
	
	protected Icon(int width, int height, String imagePath) {
		this.width = width;
		this.height = height;
		Toolkit t=Toolkit.getDefaultToolkit();  
        image = t.getImage(imagePath);
	}
	
	public void setPositionToCoordinates(Location coordinates) {
		//these variables are both the pixel position of 0.,0. and the number of pixels per positive extent of coordinates
		int zeroPixelX = MapPane.mapWidth/2; 
		int zeroPixelY = MapPane.mapHeigth/2;
		
		int pixelDistanceX = (int) (coordinates.getLongitude()*((float) zeroPixelX)/180F);
		int pixelDistanceY = (int) (coordinates.getLatitude()*((float) zeroPixelY)/90F);
		
		xPosition = zeroPixelX + pixelDistanceX - width/2;
		yPosition = zeroPixelY - pixelDistanceY - height/2;
	}
	
	public void drawIcon(Graphics g, Canvas c) {
		g.drawImage(image, xPosition, yPosition, width, height, c);
	}
}
