package containerFilters;

import java.util.ArrayList;
import java.util.List;

import businessObjects.Client;
import businessObjects.Container;
import dataBase.DataBase;

public abstract class FilteringContainersForAClient implements FilterContainer {

	protected ArrayList<Container> containers;
	private List<Long> activeJourneys;
	
	public FilteringContainersForAClient(Client client) {
		this.activeJourneys=client.getActiveShipments();
		containers= new ArrayList<Container>();
		getContainersByActiveJourneyIDs();
	}
	
	private  void getContainersByActiveJourneyIDs() {
		List<Container> containerExtractedByDataBase;
		System.out.println("activeJourneys: "+activeJourneys.size());
		for(int i=0;i<this.activeJourneys.size();i++) {
			String journeyIDInString = this.activeJourneys.get(i).toString();
			containerExtractedByDataBase = DataBase.searchContainers(journeyIDInString);
			//Need to check if there is actually a container
			System.out.println("Containers found "+containerExtractedByDataBase.size());
			if(containerExtractedByDataBase.size()>0) {
				System.out.println(containerExtractedByDataBase.get(0).getJourneyID());
				this.containers.add(containerExtractedByDataBase.get(0));
			}
		}
		//So this method ensures that the containers contain all the containers registered by the client which are on an active journey
	}
	
	
	@Override
	public abstract ArrayList<Container> filterContainers();

}
