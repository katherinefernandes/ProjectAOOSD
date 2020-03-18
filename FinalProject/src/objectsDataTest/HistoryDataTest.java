package objectsDataTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import objectsData.HistoryData;
import objectsData.InternalStatusData;

public class HistoryDataTest {
	private HistoryData history;
	private InternalStatusData object = new InternalStatusData(1,25,79);
	@Before
	public void testDataHistory() {
		history = new HistoryData(1, "banana",object, 33,"netherlands");
		
	}
	@Test 
	public void testGetStatus() {
		assertSame(object,history.getStatus());
	}
	@Test
	public void testGetLocation() {
		assertSame("netherlands",history.getLocation());
	}
	@Test
	public void testGetContains() {
		assertSame("banana",history.getContains());
	}

}
