package updateContainer;

import objectsData.ContainerData;

public interface UpdateContainer {
	
	boolean updated();
	
	ContainerData updateInformation(ContainerData container);
	
}
