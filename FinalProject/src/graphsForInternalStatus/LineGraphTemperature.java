package graphsForInternalStatus;

import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;

import businessObjects.Container;
import dataBase.DataBase;
  
/**
 * Creates a line graph for the Temperature changes for a container
 * @author Mamuna Azam
 *
 */
public class LineGraphTemperature extends JFrame {  
  
  private static final long serialVersionUID = 1L;
private DefaultCategoryDataset dataset;  
  
  public LineGraphTemperature(String title, String ContainerID) {  
    super(title);  
     dataset = createDataset(ContainerID);  
    JFreeChart chart = ChartFactory.createLineChart(  
        "Internal Temperature of Container: " + ContainerID,   
        "Date", 
        "Temperature (c) ", 
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

  public String getValues() {
	  String values ="";
	  for(int i=0;i<dataset.getRowCount();i++) {
		  values = values+(dataset.getValue(i, 0));
	  }
	  return values;
  }
  
}  