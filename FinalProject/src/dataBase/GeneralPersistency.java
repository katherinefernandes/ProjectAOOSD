
package dataBase;

import java.util.List;

import objectsData.ObjectDataInterface;

public interface GeneralPersistency<T extends ObjectDataInterface> {
	public abstract void newEntry(T data);
	
	public abstract List<T> searchEntries(String searchWord);
	
	public void wipe();
}
