package dataBase;

import businessObjects.BusinessObject;
import exceptions.ElementNotFoundException;

public interface IdentifiablePersistency<T extends BusinessObject> extends GeneralPersistency<T>{
	public T getEntry(long ID) throws ElementNotFoundException;
	
	public void deleteEntry(long ID);
	
	public boolean isSavedID(long ID);
}
