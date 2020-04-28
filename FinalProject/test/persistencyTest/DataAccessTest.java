package persistencyTest;

import java.util.*;
import org.junit.jupiter.api.*;

import businessObjects.*;
import exceptions.ElementSelectionException;

public abstract class DataAccessTest<T extends BusinessObject> {
	T data1;
	T data2;
	T data1_v2;
	List<T> sortTestData;
	List<Long> toBeDeleted;
	Random random;
	
	public DataAccessTest() {
		random = new Random();
		toBeDeleted = new ArrayList<Long>();
		sortTestData = new ArrayList<T>();
	}
	
	@AfterEach
	public abstract void cleanUp();
	
	protected abstract T getObject(long ID) throws ElementSelectionException;

	public void persistencyTest() throws NumberFormatException, ElementSelectionException {
		insertData(data1);		
		T pulledData = getObject(data1.getID());
		assertEqualData(pulledData,data1);
	}
	
	protected void insertData(T data){
		data.save();
	}
	
	protected abstract void assertEqualData(T data1, T data2);
}
