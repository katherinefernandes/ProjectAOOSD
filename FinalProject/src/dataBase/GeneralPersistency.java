
package dataBase;

import java.util.List;

import objects.BusinessObject;

/**
 * The interface for all databases
 * @author simon
 *
 * @param <T> a class extending BusinessObject, with methods like getID() and getAllValues()
 */
public interface GeneralPersistency<T extends BusinessObject> {
	/**
	 * Creates a new entry in the database, saving the object.
	 * @param data - the object to be saved
	 */
	public abstract void newEntry(T data);
	
	/**
	 * Returns all entries in the database with value(s) containing the search word
	 * @param searchWord
	 * @return a list of all matching entries, converted into domain objects
	 */
	public abstract List<T> searchEntries(String searchWord);
	
	/**
	 * Resets the database. I. e. clears all entries
	 */
	public void wipe();
}
