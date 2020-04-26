package updateContainer;

import businessObjects.Container;

public interface UpdateContainer {
	
	boolean updated();
	
	Container updateInformation(Container container);
	
}
