package dataObjectsTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dataObjects.DataHistory;
import dataObjects.InternalStatus;

public class DataHistoryTest {
	private DataHistory history;
	private InternalStatus object = new InternalStatus(1,25,79);
	@Before
	public void testDataHistory() {
		history = new DataHistory(1, "banana",object, 33,"netherlands");
		
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
