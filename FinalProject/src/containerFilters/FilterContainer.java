package containerFilters;

import java.util.ArrayList;

import objects.Container;

public interface FilterContainer {
    /**
     * Returns a list of filtered containers
     * @return ArrayList<Container> containers
     */
	ArrayList<Container> filterContainers();
}
