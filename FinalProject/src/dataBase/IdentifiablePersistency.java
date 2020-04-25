package dataBase;

import exceptions.ElementNotFoundException;
import objectsData.IdentifiableData;

public interface IdentifiablePersistency<T extends IdentifiableData> extends GeneralPersistency<T>{
	public T getEntry(long ID) throws ElementNotFoundException;
	
	public void deleteEntry(long ID);
	
	public boolean isSavedID(long ID);
}
