package worldMap;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import simulation.Simulator;


public class MapPane extends Canvas{
	private static final long serialVersionUID = 1540837497004158859L;
	public final static int mapWidth = 1500;
	public final static int mapHeigth = 750;
	Image mapImage;
	IconGenerator iconGenerator; 
	
    public void paint(Graphics g) {  
    	iconGenerator = new IconGenerator();
        paintMap(g);
        paintIcons(g,iconGenerator.getPortIcons());
        paintIcons(g,iconGenerator.getContainerIcons());
    }

	private void paintMap(Graphics g) {
		Toolkit t=Toolkit.getDefaultToolkit();  
        mapImage = t.getImage("graphics/world_map.jpg");
        g.drawImage(mapImage, 0, 0, mapWidth, mapHeigth, this);
	}  
    
    private void paintIcons(Graphics g, List<Icon> icons) {
		for(Icon i : icons) {
			i.drawIcon(g, this);
		}
	}

	public static void main(String[] args) {  
		SwingUtilities.invokeLater(() -> {  
			MapPane m=new MapPane();
			JFrame f=new JFrame();  
	        f.add(m);
	        f.pack();
	        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        f.setSize(1500,750);  
	        f.setVisible(true);
	        
	        int delayMS = 250;
	        Simulator simulator = new Simulator();
			Timer timer = new Timer(delayMS, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					simulator.simulateOneHour();
					simulator.simulateOneHour();
					simulator.simulateOneHour();
					f.remove(m);
					m.update(f.getGraphics());
					f.add(m);
		         }
			});
			
			timer.start();
		});
	}  
}
