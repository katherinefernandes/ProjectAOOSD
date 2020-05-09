package worldMap;
import java.awt.*;  
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;  

public class MapPane extends Canvas{
	Image mapImage;
	Image boatImage;
	Image portImage;
    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        mapImage = t.getImage("graphics/world_map.jpg");  
        boatImage = t.getImage("graphics/boat.png");
        g.drawImage(mapImage, 0, 0, 1500, 750, this);
        g.drawImage(boatImage, 0, 0, 30, 30, this);  
    }  
    
    public static void main(String[] args) {  
        SwingUtilities.invokeLater(() -> {  
        	MapPane m=new MapPane();  
            JFrame f=new JFrame();  
            f.add(m);  
            f.setAlwaysOnTop(true); 
            f.pack();
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.setSize(1500,750);  
            f.setVisible(true);
        });  
	}  
}
