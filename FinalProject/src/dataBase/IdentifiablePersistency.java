package dataBase;

import businessObjects.BusinessObject;
import exceptions.ElementSelectionException;

public interface IdentifiablePersistency<T extends BusinessObject> extends GeneralPersistency<T>{
	public T getEntry(long ID) throws ElementSelectionException;
	
	public void deleteEntry(long ID);
	
	public boolean isSavedID(long ID);
}
