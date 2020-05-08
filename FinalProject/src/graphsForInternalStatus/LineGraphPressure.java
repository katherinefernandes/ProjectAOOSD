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
 * Creates a line graph for the Pressure changes for a container
 * @author Mamuna Azam
 *
 */
public class LineGraphPressure extends JFrame {  
  
  private static final long serialVersionUID = 1L;
private DefaultCategoryDataset dataset;
  
  public LineGraphPressure(String title, String ContainerID) {  
    super(title);  
     dataset = createDataset(ContainerID);  
    JFreeChart chart = ChartFactory.createLineChart(  
        "Internal Pressure of Container: " + ContainerID,  
        "Date", 
        "Pressure (atm) ",
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

  public String getValues() {
	  System.out.println(dataset.getColumnCount());
	  String values ="";
	  for(int i=0;i<dataset.getRowCount();i++) {
		  values = values+(dataset.getValue(i, 0));
		  System.out.println(dataset.getValue(i, 0));
	  }
	  return values;
  }
  

}  