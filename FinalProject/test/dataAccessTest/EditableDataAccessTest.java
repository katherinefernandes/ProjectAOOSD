package dataAccessTest;

import java.util.*;

import org.junit.jupiter.api.AfterEach;

import dataAccess.DataAccess;
import dataAccess.EditableDataAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import objectsData.ObjectData;

public abstract class EditableDataAccessTest<T extends ObjectData, A extends EditableDataAccess<T>> extends DataAccessTest<T,A>{
	public EditableDataAccessTest() {
		super();
	}
	
	public void editTest() throws ElementNotFoundException, NumberFormatException, AmbiguousElementSelectionException {
		insertData(data1);
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
