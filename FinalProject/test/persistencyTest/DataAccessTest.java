package persistencyTest;

import java.util.*;
import org.junit.jupiter.api.*;
import exceptions.ElementNotFoundException;
import objectsData.*;

public abstract class DataAccessTest<T extends ObjectDataInterface> {
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
	
	public abstract void persistencyTest() throws NumberFormatException, ElementNotFoundException;
	
	public void insertData(T data){
		data.save();
	}
	
	protected abstract void assertEqualData(T data1, T data2);
}
