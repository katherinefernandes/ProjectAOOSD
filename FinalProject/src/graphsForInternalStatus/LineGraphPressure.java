package graphsForInternalStatus;

import java.awt.Component;
import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;
import businessObjects.Container;
import dataBase.DataBase;

public class LineGraphPressure extends JFrame {  
  
  private static final long serialVersionUID = 1L;
private DefaultCategoryDataset dataset;
  
  public LineGraphPressure(String title, String ContainerID) {  
    super(title);  
    // Create dataset  
     dataset = createDataset(ContainerID);  
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
    List<Container> historys = DataBase.searchHistory(ContainerID); 
    
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
    
    for (Container history: historys) {
    	dataset.addValue(history.getInternalStatus().getAtmosphere(), series1, history.getUpdated());
    }
    
  
    return dataset;  
  }


//this method is just used in side the tests
  public String getValues() {
	  System.out.println(dataset.getColumnCount());
	  String values ="";
	  for(int i=0;i<dataset.getRowCount();i++) {
		  values = values+(dataset.getValue(i, 0));
		  System.out.println(dataset.getValue(i, 0));
	  }
	  return values;
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