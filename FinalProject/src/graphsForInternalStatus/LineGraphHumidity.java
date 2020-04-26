package graphsForInternalStatus;

import java.util.List;
import javax.swing.JFrame;  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;
import businessObjects.Container;
import dataBase.DataBase;
  
public class LineGraphHumidity extends JFrame {  
  
  private static final long serialVersionUID = 1L;  
  
  public LineGraphHumidity(String title, String ContainerID) {  
    super(title);  
    // Create dataset  
    DefaultCategoryDataset dataset = createDataset(ContainerID);  
    // Create chart  
    JFreeChart chart = ChartFactory.createLineChart(  
        "Internal Humidity of Container: " + ContainerID, // Chart title  
        "Date", // X-Axis Label  
        "Humidity (%)", // Y-Axis Label  
        dataset  
        );  
  
    ChartPanel panel = new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private DefaultCategoryDataset createDataset(String ContainerID) {  
  
    String series1 = "Humidity";   
    System.out.println(ContainerID);
    List<Container> historys = DataBase.searchHistory(ContainerID); 
    
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
    
    for (Container history: historys) {
    	dataset.addValue(history.getInternalStatus().getHumidity(), series1, history.getUpdated());
    }
    
  
    return dataset;  
  }  
  
//  public static void main(String[] args) {  
//    SwingUtilities.invokeLater(() -> {  
//      LineGraphHumidity example = new LineGraphHumidity("Humidity Fluctuations",Long.toString(10849147913510l));  
//      example.setAlwaysOnTop(true);  
//      example.pack();  
//      example.setSize(600, 400);  
//      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
//      example.setVisible(true);  
//    });  
//  }  
}  