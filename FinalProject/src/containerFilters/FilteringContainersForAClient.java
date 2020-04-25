package containerFilters;

import java.util.ArrayList;
import java.util.List;

import objectsData.ClientData;
import objectsData.ContainerData;
import xmlParser.ContainerXMLManipulation;

public abstract class FilteringContainersForAClient implements FilterContainer {

	protected ArrayList<ContainerData> containers;
	private ContainerXMLManipulation databaseContainer;
	private ArrayList<Long> activeJourneys;
	
	public FilteringContainersForAClient(ClientData client) {
		 databaseContainer = new ContainerXMLManipulation();
		 
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
			//Need to check if there is actually a container
			this.containers.add(containerExtractedByDataBase.get(0));
		}
		//So this method ensures that the containers contain all the containers registered by the client which are on an active journey
	}
	
	
	@Override
	public abstract ArrayList<ContainerData> filterContainers();

}
