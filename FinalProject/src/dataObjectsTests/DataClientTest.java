package dataObjectsTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dataObjects.DataClient;

public class DataClientTest {
	private DataClient client;
	@Before
	public void testDataClient() {
		client=new DataClient(1, "client1", "+404899000", "random@gmail.com", "trustedperson");
	}
	
	@Test
	public void testGetClientId() {
		assertEquals("should be equal",1,client.getClientId());
	}
	@Test
	public void testGetName() {
		assertEquals("should be equal","client1",client.getName());
	}
	@Test
	public void testGetPhone() {
		assertEquals("should be equal","+404899000",client.getPhone());
	}
	@Test
	public void testGetEmail() {
		assertEquals("should be equal","random@gmail.com",client.getEmail());
	}
	@Test
	public void testGetRefName() {
		assertEquals("should be equal","trustedperson",client.getRefName());
	}
	
}
