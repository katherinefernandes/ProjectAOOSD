package dataAccessTest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.*;

import org.junit.jupiter.api.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import dataAccess.*;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import objectsData.*;
import dataAccess.NodeMethods;

public class DataAccessTest<T extends ObjectData, A extends DataAccess<T>> {
	T data1;
	T data2;
	T data1_v2;
	List<T> sortTestData;
	List<Long> toBeDeleted;
	A dataAccess;
	Random random;
	
	public DataAccessTest() {
		random = new Random();
		toBeDeleted = new ArrayList<Long>();
		sortTestData = new ArrayList<T>();
	}
	
	@AfterEach
	public void cleanUp() {
		for(long ID : toBeDeleted) {
			try {
				dataAccess.deleteEntry(ID);
			} catch (DOMException e) {
				fail("DOMException in clean up");
				e.printStackTrace();
			} catch (ElementNotFoundException e) {
			}
		}
		toBeDeleted = new ArrayList<Long>();
	}
	
	@Test
	public void persistencyTest() throws NumberFormatException, ElementNotFoundException, AmbiguousElementSelectionException {
		insertData(data1);
	
		T pulledData = dataAccess.getEntry(getDataID(data1));
		
		assertEqualData(pulledData,data1);
	}
	
	@Test
	public void editTest() throws ElementNotFoundException, NumberFormatException, AmbiguousElementSelectionException {
		insertData(data1);
		dataAccess.editEntry(data1_v2);
		T pulledData = dataAccess.getEntry(getDataID(data1));
		
		assertEqualData(pulledData,data1_v2);
	}
	
	@Test
	public void sortTest() throws AmbiguousElementSelectionException {
		for(T clientData : sortTestData) {
			insertData(clientData);
		}
		
		NodeList elements = dataAccess.getRoot().getChildNodes();
		int elementsLen = elements.getLength();
		long previousID = NodeMethods.getElementID((Element) elements.item(0));
		for(int i = 1; i < elementsLen; i++) {
			long currentID = NodeMethods.getElementID((Element) elements.item(i));
			assertTrue(previousID < currentID);
			previousID = currentID;
		}
	}
	
	@Test
	public void exceptionTest() throws AmbiguousElementSelectionException{
		insertData(data1);
		insertData(data2);
		
		assertThrows(ElementNotFoundException.class,()->dataAccess.getEntry(29199));
		assertThrows(ElementNotFoundException.class,()->dataAccess.getEntry(29199));
		assertThrows(AmbiguousElementSelectionException.class,()->insertData(data1_v2));
	}
	
	public void insertData(T data) throws AmbiguousElementSelectionException {
		dataAccess.newEntry(data);
		toBeDeleted.add(getDataID(data));
	}
	
	protected long getDataID(T data) {
		return 0L;
	}
	
	protected void assertEqualData(T data1, T data2) {
		
	}
}
