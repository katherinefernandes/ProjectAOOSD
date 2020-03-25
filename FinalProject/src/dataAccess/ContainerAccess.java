package dataAccess;


import objectsData.ContainerData;

public class ContainerAccess extends DataAccess<ContainerData> {
	
	 ContainerAccess() {
		super("storage/activeData/containers.xml");
	}
	
	public void newEntry(ContainerData data) {
	
	}


	public void editEntry(ContainerData data) {
		
	}

	public ContainerData getEntry(long ID) {
		return null;
	}
}
