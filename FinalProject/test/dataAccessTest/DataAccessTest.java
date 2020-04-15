package dataAccessTest;

import java.util.*;

import org.junit.jupiter.api.*;

import dataAccess.*;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import objectsData.*;

public abstract class DataAccessTest<T extends ObjectData, A extends DataAccess<T>> {
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
		
	}
	
	public abstract void persistencyTest() throws NumberFormatException, ElementNotFoundException, AmbiguousElementSelectionException;
	
	public void insertData(T data) throws AmbiguousElementSelectionException {
		toBeDeleted.add(data.getID());
		dataAccess.newEntry(data);
	}
	
	protected long getDataID(T data) {
		return data.getID();
	}
	
	protected abstract void assertEqualData(T data1, T data2);
}
