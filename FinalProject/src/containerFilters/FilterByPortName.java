package containerFilters;

import java.util.ArrayList;

import businessObjects.Client;
import businessObjects.Container;

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
				containers.remove(i); //write more test cases for this
			}
		}
		return containers;
	}

}
