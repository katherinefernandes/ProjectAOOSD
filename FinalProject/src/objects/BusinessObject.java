package objects;

import java.util.*;

public abstract class BusinessObject{
	/**
	 * Returns unique id of a business object
	 * @author simon
	 * @return ID
	 */
	public abstract long getID();
	/**
	 * saves business object to database. 
	 * @author simon
	 */
	public abstract void save();
	/**
	 * an access method for all data fields
	 * @author simon
	 * @return a list of all data fields as strings
	 */
	public abstract List<String> getAllValues();
	
	
	//need a test case for this method and javadoc comment
	@Override
	public boolean equals(Object object) {
		if(object == null || (object.getClass() != this.getClass())) {
			return false;
		}
		BusinessObject businessObject = (BusinessObject) object;
		return getAllValues().equals(businessObject.getAllValues());
	}
	
	@Override
	public int hashCode() {
		return getAllValues().hashCode();
	}
}