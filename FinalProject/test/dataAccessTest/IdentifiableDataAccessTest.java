package dataAccessTest;

import java.util.*;

import org.junit.jupiter.api.AfterEach;

import exceptions.ElementNotFoundException;
import objectsData.IdentifiableData;
import objectsData.ObjectData;
import xmlParser.GeneralXMLManipulation;
import xmlParser.IdentifiableXMLManipulation;

public abstract class IdentifiableDataAccessTest<T extends IdentifiableData, A extends IdentifiableXMLManipulation<T>> extends DataAccessTest<T,A>{
	public IdentifiableDataAccessTest() {
		super();
	}
	
	@Override
	@AfterEach
	public void cleanUp() {
		for(long id : toBeDeleted) {
			dataAccess.deleteEntry(id);
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
		insertData(data1);
		
		dataAccess.flushActiveData();
		insertData(data1_v2);
		
		dataAccess.flushActiveData();
		
		T pulledData = dataAccess.getEntry(getDataID(data1));
		
		assertEqualData(pulledData,data1_v2);
	}
	
	public void editTest() throws ElementNotFoundException, NumberFormatException {
		for(T data : sortTestData) {
			insertData(data);
		}
		insertData(data1);
		dataAccess.flushActiveData();
		dataAccess.editEntry(data1_v2);
		dataAccess.flushActiveData();
		T pulledData = dataAccess.getEntry(getDataID(data1));
		
		assertEqualData(pulledData,data1_v2);
	}
	
	protected long getDataID(T data) {
		return data.getID();
	}
}
