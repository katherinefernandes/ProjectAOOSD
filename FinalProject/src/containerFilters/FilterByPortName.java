package containerFilters;

import java.util.ArrayList;

import objectsData.ClientData;
import objectsData.ContainerData;

public class FilterByPortName extends FilteringContainersForAClient{
	private long portID;
	
	public FilterByPortName(ClientData client,long portID) {
		super(client);
		this.portID=portID;
	}

	@Override
	public ArrayList<ContainerData> filterContainers() {
		// TODO Auto-generated method stub
		for (int i=0;i<containers.size();i++) {
			if (containers.get(i).getStartPortID()!=portID) {
				containers.remove(i);
			}
		}
		return containers;
	}

}