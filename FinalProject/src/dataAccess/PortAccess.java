package dataAccess;

import objectsData.PortData;

public class PortAccess extends DataAccess<PortData> {
	
	PortAccess() {
		super("storage/activeData/ports.xml");
	}
	
	public void newEntry(PortData data) {
	
	}


	public void editEntry(PortData data) {
		
	}

	public PortData getEntry(long ID) {
		return null;
	}
}
