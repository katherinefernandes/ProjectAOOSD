package businessObjects;

import java.util.*;

public interface BusinessObject{
	public long getID();
	public void save();
	public List<String> getAllValues();
}