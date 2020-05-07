package graphsForInternalStatus;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Test;

import businessObjects.Container;
import dataBase.DataBase;

public class LineGraphPressureTest {

	private LineGraphPressure graph;
	
	@Test
	public void testGraphData() {
		Container container = new Container(112031L, 102621L, 675465457L, 357983327889100L, 357983327946100L, 357983327979100L, 45.6F, 34.787F, "Fish n' chips", 3.5F, 108.2F, 66F,LocalDateTime.of(2020, 2, 11, 14, 24).toString(),LocalDateTime.now().toString());
	    container.save();
	    DataBase.saveToHistory(container);
	    graph = new LineGraphPressure("Pressure graph","112031");
	    String values = graph.getValues();
	    assertTrue(values.contains("108"));
	    
	}
	
}
