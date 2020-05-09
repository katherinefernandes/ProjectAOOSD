package worldMap;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JPanel;


public class MapPane extends JPanel{
	private static final long serialVersionUID = 1540837497004158859L;
	public final static int mapWidth = 1500;
	public final static int mapHeigth = 750;
	Image mapImage;
	IconGenerator iconGenerator; 
	
	public MapPane(String containerSelection) {
		Toolkit t=Toolkit.getDefaultToolkit();  
        mapImage = t.getImage("graphics/world_map.jpg");
        iconGenerator = new IconGenerator(containerSelection);
	}
	
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponents(g);
        paintMap(g);
        paintIcons(g,iconGenerator.getPortIcons());
        paintIcons(g,iconGenerator.getContainerIcons());
    }

	private void paintMap(Graphics g) {
        g.drawImage(mapImage, 0, 0, mapWidth, mapHeigth, this);
	}  
    
    private void paintIcons(Graphics g, List<Icon> icons) {
		for(Icon i : icons) {
			i.drawIcon(g, this);
		}
	}
}
