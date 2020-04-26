package containerFilters;

import java.util.ArrayList;

import objectsData.ClientData;
import objectsData.ContainerData;

public class FilterByJourneyID  extends FilteringContainersForAClient{
	private long journeyID;
	
	public FilterByJourneyID(ClientData client,long journeyID) {
		super(client);
		this.journeyID=journeyID;
	}

	@Override
	public ArrayList<ContainerData> filterContainers() {
		for (int i=0;i<this.containers.size();i++) {
			System.out.println("Journey ID entered: "+journeyID);
			System.out.println("Journey ID in container"+containers.get(i).getJourneyID());
			if (containers.get(i).getJourneyID()!=journeyID) {
				System.out.println("Removing the container");
				containers.remove(i);
			}
		}
		return containers;
	}

}
