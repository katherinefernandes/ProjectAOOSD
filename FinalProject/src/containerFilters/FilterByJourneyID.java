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
			System.out.println("Journey ID entered: "+journeyID);
			System.out.println("Journey ID in container"+containers.get(i).getJourneyID());
			if (containers.get(i).getJourneyID()!=journeyID) {
				System.out.println("Removing the container");
				containers.remove(i); // need to test this 
			}
		}
		return containers;
	}

}
