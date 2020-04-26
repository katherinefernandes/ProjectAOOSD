package graphsForInternalStatus;
import java.util.List;

import javax.swing.JFrame;  
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;  
   

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;

import dataBase.DataBase;
import objectsData.ContainerData;
import objectsData.HistoryData;
import supportingClasses.parseInput; 
  
public class LineGraphPressure extends JFrame {  
  
  private static final long serialVersionUID = 1L;  
  
  public LineGraphPressure(String title, String ContainerID) {  
    super(title);  
    // Create dataset  
    DefaultCategoryDataset dataset = createDataset(ContainerID);  
    // Create chart  
    JFreeChart chart = ChartFactory.createLineChart(  
        "Internal Pressure of Container: " + ContainerID, // Chart title  
        "Date", // X-Axis Label  
        "Pressure (atm) ", // Y-Axis Label  
        dataset  
        );  
  
    ChartPanel panel = new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private DefaultCategoryDataset createDataset(String ContainerID) {  
  
    String series1 = "Pressure";   
    System.out.println(ContainerID);
    List<HistoryData> historys = DataBase.searchHistory(ContainerID); 
    
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
    
    for (HistoryData history: historys) {
    	dataset.addValue(history.getInternalStatus().getAtmosphere(), series1, parseInput.getDate(history.getTimeStamp()));
    }
    
  
    return dataset;  
  }  
  
//  public static void main(String[] args) {  
//    SwingUtilities.invokeLater(() -> {  
//      LineGraphPressure example = new LineGraphPressure("Pressure Fluctuations",Long.toString(10849147913510l));  
//      example.setAlwaysOnTop(true);  
//      example.pack();  
//      example.setSize(600, 400);  
//      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
//      example.setVisible(true);  
//    });  
//  }  
}  