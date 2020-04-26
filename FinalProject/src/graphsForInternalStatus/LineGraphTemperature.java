package graphsForInternalStatus;

import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;

import businessObjects.Container;
import dataBase.DataBase;
  
public class LineGraphTemperature extends JFrame {  
  
  private static final long serialVersionUID = 1L;  
  
  public LineGraphTemperature(String title, String ContainerID) {  
    super(title);  
    // Create dataset  
    DefaultCategoryDataset dataset = createDataset(ContainerID);  
    // Create chart  
    JFreeChart chart = ChartFactory.createLineChart(  
        "Internal Temperature of Container: " + ContainerID, // Chart title  
        "Date", // X-Axis Label  
        "Temperature (c) ", // Y-Axis Label  
        dataset  
        );  
  
    ChartPanel panel = new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private DefaultCategoryDataset createDataset(String ContainerID) {  
  
    String series1 = "Temperature";   
    System.out.println(ContainerID);
    List<Container> historys = DataBase.searchHistory(ContainerID); 
    
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
    
    for (Container history: historys) {
    	dataset.addValue(history.getInternalStatus().getTemperature(), series1, history.getUpdated());
    }
    
  
    return dataset;  
  }  
  
//  public static void main(String[] args) {  
//    SwingUtilities.invokeLater(() -> {  
//      LineGraphTemperature example = new LineGraphTemperature("Temperature Fluctuations",Long.toString(10849147913510l));  
//      example.setAlwaysOnTop(true);  
//      example.pack();  
//      example.setSize(600, 400);  
//      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
//      example.setVisible(true);  
//    });  
//  }  
}  