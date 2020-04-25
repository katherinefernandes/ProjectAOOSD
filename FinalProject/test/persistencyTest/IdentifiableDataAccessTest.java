package persistencyTest;

import java.util.*;
import org.junit.jupiter.api.AfterEach;
import exceptions.ElementNotFoundException;
import objectsData.IdentifiableData;

public abstract class IdentifiableDataAccessTest<T extends IdentifiableData> extends DataAccessTest<T>{
	public IdentifiableDataAccessTest() {
		super();
	}
	
	protected abstract void delete(long ID);
	protected abstract T getObject(long ID) throws ElementNotFoundException;
	
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
	
	@Override
	public void persistencyTest() throws NumberFormatException, ElementNotFoundException {
		insertData(data1_v2);
		insertData(data1);		
		T pulledData = getObject(getDataID(data1));
		assertEqualData(pulledData,data1);
	}
	
	public void editTest() throws ElementNotFoundException, NumberFormatException {
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
