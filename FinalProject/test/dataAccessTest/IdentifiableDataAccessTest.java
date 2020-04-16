package dataAccessTest;

import java.util.*;

import org.junit.jupiter.api.AfterEach;

import dataAccess.DataAccess;
import dataAccess.IdentifiedDataAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import objectsData.ObjectData;

public abstract class IdentifiableDataAccessTest<T extends ObjectData, A extends IdentifiedDataAccess<T>> extends DataAccessTest<T,A>{
	public IdentifiableDataAccessTest() {
		super();
	}
	
	public void editTest() throws ElementNotFoundException, NumberFormatException, AmbiguousElementSelectionException {
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
	
	@Override
	@AfterEach
	public void cleanUp() {
		for(long id : toBeDeleted) {
			dataAccess.deleteEntry(id);
		}
	}
	
	@Override
	public void persistencyTest() throws NumberFormatException, ElementNotFoundException, AmbiguousElementSelectionException {
		insertData(data1);
		
		dataAccess.flushActiveData();
		
		T pulledData = dataAccess.getEntry(getDataID(data1));
		
		assertEqualData(pulledData,data1);
	}
}
