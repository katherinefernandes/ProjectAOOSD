package persistencyTest;

import java.util.*;
import org.junit.jupiter.api.AfterEach;

import businessObjects.BusinessObject;
import exceptions.ElementSelectionException;

public abstract class IdentifiableDataAccessTest<T extends BusinessObject> extends DataAccessTest<T>{
	public IdentifiableDataAccessTest() {
		super();
	}
	
	protected abstract void delete(long ID);
	
	@Override
	@AfterEach
	public void cleanUp() {
		for(long id : toBeDeleted) {
			delete(id);
		}
		toBeDeleted = new ArrayList<>();
	}
	
	@Override
	public void insertData(T data) {
		super.insertData(data);
		toBeDeleted.add(data.getID());
	}
	
	public void editTest() throws ElementSelectionException, NumberFormatException {
		insertData(data1);
		for(T data : sortTestData) {
			insertData(data);
		}
		insertData(data1_v2);
		T pulledData = getObject(getDataID(data1));
		
		assertEqualData(pulledData,data1_v2);
	}
	
	protected long getDataID(T data) {
		return data.getID();
	}
}
