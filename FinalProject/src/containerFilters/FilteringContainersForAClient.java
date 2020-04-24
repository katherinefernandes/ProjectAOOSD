package containerFilters;

import java.util.ArrayList;
import java.util.List;

import XMLParser.ContainerAccess;
import objectsData.ClientData;
import objectsData.ContainerData;

public abstract class FilteringContainersForAClient implements FilterContainer {

	protected ArrayList<ContainerData> containers;
	private ContainerAccess databaseContainer;
	private ArrayList<Long> activeJourneys;
	
	public FilteringContainersForAClient(ClientData client) {
		 databaseContainer = new ContainerAccess();
		 
		this.activeJourneys=client.getActiveShipment();
		containers= new ArrayList<ContainerData>();
		getContainersByActiveJourneyIDs();
	}
	
	private  void getContainersByActiveJourneyIDs() {
		List<ContainerData> containerExtractedByDataBase;
		System.out.println("activeJourneys: "+activeJourneys.size());
		for(int i=0;i<this.activeJourneys.size();i++) {
			String journeyIDInString = this.activeJourneys.get(i).toString();
			containerExtractedByDataBase = databaseContainer.searchEntries(journeyIDInString);
			this.containers.add(containerExtractedByDataBase.get(0));
		}
		//So this method ensures that the containers contain all the containers registered by the client which are on an active journey
	}
	
	
	@Override
	public abstract ArrayList<ContainerData> filterContainers();

}
