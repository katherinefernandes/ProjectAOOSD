
package dataBase;

import java.util.List;

import businessObjects.BusinessObject;

public interface GeneralPersistency<T extends BusinessObject> {
	public abstract void newEntry(T data);
	
	public abstract List<T> searchEntries(String searchWord);
	
	public void wipe();
}
