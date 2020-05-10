package updateContainer;

import objects.Container;

public interface UpdateContainer {
	
	boolean getUpdated();
	/**
	 * 
	 * @param container
	 * @return returns the updated container
	 */
	Container updateInformation(Container container);
	
}
