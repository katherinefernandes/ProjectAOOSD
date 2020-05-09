package containerFilters;

import java.util.ArrayList;

import objects.Client;
import objects.Container;
/**
 * This class filters the list of containers by the given port name
 * @author Mamuna
 *
 */
public class FilterByPortName extends FilteringContainersForAClient{
	private long portID;
	
	public FilterByPortName(Client client,long portID) {
		super(client);
		this.portID=portID;
	}

	@Override
	public ArrayList<Container> filterContainers() {

		System.out.println("containers: "+containers.size());
		for (int i=0;i<containers.size();i++) {
			if (containers.get(i).getStartPortID()!=portID) {
				containers.remove(i); 
			}
		}
		return containers;
	}

}
