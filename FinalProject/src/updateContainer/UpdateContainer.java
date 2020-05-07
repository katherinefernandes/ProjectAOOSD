package updateContainer;

import businessObjects.Container;

public interface UpdateContainer {
	
	boolean getUpdated();
	Container updateInformation(Container container);
	
}
