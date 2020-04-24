package dataAccessTest;

import java.util.*;

import org.junit.jupiter.api.*;

import XMLParser.DataAccess;
import exceptions.ElementNotFoundException;
import objectsData.*;

public abstract class DataAccessTest<T extends ObjectDataInterface, A extends DataAccess<T>> {
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
	public abstract void cleanUp();
	
	public abstract void persistencyTest() throws NumberFormatException, ElementNotFoundException;
	
	public void insertData(T data){
		dataAccess.newEntry(data);
	}
	
	protected abstract void assertEqualData(T data1, T data2);
}
