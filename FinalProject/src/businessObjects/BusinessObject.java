package businessObjects;

import java.util.*;

public abstract class BusinessObject{
	public abstract long getID();
	public abstract void save();
	public abstract List<String> getAllValues();
	
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