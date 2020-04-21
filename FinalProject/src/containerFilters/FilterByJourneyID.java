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
		for (int i=0;i<containers.size();i++) {
			if (containers.get(i).getJourneyID()!=journeyID) {
				containers.remove(i);
			}
		}
		return containers;
	}

}
