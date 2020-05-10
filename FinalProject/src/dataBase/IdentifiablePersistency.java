package dataBase;

import exceptions.ElementSelectionException;
import objects.BusinessObject;

/**
 * The interface for databases guaranteeing a maximum of one entry per unique ID
 * @author simon
 *
 * @param <T> a class extending BusinessObject, with methods like getID() and getAllValues()
 */
public interface IdentifiablePersistency<T extends BusinessObject> extends GeneralPersistency<T>{
	/**
	 * Retrieves the a single element guaranteed to have the unique ID
	 * @param ID - the ID of the element to be retrieved
	 * @return The matching element as a domain object
	 * @throws ElementSelectionException if the element could not be found, or the database is malformed with multiple entries with the ID
	 */
	public T getEntry(long ID) throws ElementSelectionException;
	
	/**
	 * Deletes the element with the given ID
	 * @param ID - the ID of the element to be deleted
	 */
	public void deleteEntry(long ID);
	
	/**
	 * Checks whether the ID exists in the database
	 * @param ID - the ID to be searched for
	 * @return true if the ID was found, false otherwise
	 */
	public boolean isSavedID(long ID);
}
