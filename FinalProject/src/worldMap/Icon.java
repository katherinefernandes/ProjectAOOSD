package worldMap;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import dataWrappers.Location;

/**
 * This class is the superclass of icons to place on the map.
 * @author simon
 *
 */
public abstract class Icon {
	protected int width;
	protected int height;
	protected int xPosition;
	protected int yPosition;
	
	protected Icon(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	protected abstract Image getImage();
	
	/**
	 * Sets the pixel position to match geographical coordinates
	 * @param coordinates
	 */
	public void setPositionToCoordinates(Location coordinates) {
		//these variables are both the pixel position of 0.,0. and the number of pixels per positive extent of coordinates
		int zeroPixelX = MapPane.mapWidth/2; 
		int zeroPixelY = MapPane.mapHeigth/2;
		
		int pixelDistanceX = (int) (coordinates.getLongitude()*((float) zeroPixelX)/180F);
		int pixelDistanceY = (int) (coordinates.getLatitude()*((float) zeroPixelY)/90F);
		
		xPosition = zeroPixelX + pixelDistanceX - width/2;
		yPosition = zeroPixelY - pixelDistanceY - height/2;
	}
	
	/**
	 * Draws the icon on a given panel, though a given graphics object
	 * @param g - the Graphics object
	 * @param p - the JPanel
	 */
	public void drawIcon(Graphics g, JPanel p) {
		g.drawImage(getImage(), xPosition, yPosition, width, height, p);
	}
}
