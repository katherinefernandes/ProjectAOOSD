package containerFilters;

import java.util.ArrayList;

import businessObjects.Client;
import businessObjects.Container;

public class FilterByJourneyID  extends FilteringContainersForAClient{
	private long journeyID;
	
	public FilterByJourneyID(Client client,long journeyID) {
		super(client);
		this.journeyID=journeyID;
	}

	@Override
	public ArrayList<Container> filterContainers() {
		for (int i=0;i<containers.size();i++) {
			if (containers.get(i).getJourneyID()!=journeyID) {
				containers.remove(i);
			}
		}
		return containers;
	}

}
