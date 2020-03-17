package dataObjectsTests;

import static org.junit.Assert.*;

import org.junit.Test;

import dataObjects.DataClient;

public class DataClientTest {
	private DataClient client;
	@Test
	public void testDataClient() {
		client=new DataClient(1, "client1", "+404899000", "random@gmail.com", "trustedperson");
	}

}
