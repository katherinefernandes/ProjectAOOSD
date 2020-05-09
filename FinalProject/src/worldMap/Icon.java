package worldMap;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import dataWrappers.Location;

public abstract class Icon {
	private int width;
	private int height;
	private int xPosition;
	private int yPosition;
	
	protected Icon(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	protected abstract Image getImage();
	
	public void setPositionToCoordinates(Location coordinates) {
		//these variables are both the pixel position of 0.,0. and the number of pixels per positive extent of coordinates
		int zeroPixelX = MapPane.mapWidth/2; 
		int zeroPixelY = MapPane.mapHeigth/2;
		
		int pixelDistanceX = (int) (coordinates.getLongitude()*((float) zeroPixelX)/180F);
		int pixelDistanceY = (int) (coordinates.getLatitude()*((float) zeroPixelY)/90F);
		
		xPosition = zeroPixelX + pixelDistanceX - width/2;
		yPosition = zeroPixelY - pixelDistanceY - height/2;
	}
	
	public void drawIcon(Graphics g, JPanel p) {
		g.drawImage(getImage(), xPosition, yPosition, width, height, p);
	}
	
	/**
	 * Converts a given Image into a BufferedImage
	 *
	 * @param img The Image to be converted
	 * @return The converted BufferedImage
	 */
	public static BufferedImage toBufferedImage(Image img, int width, int height)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
	}
}
