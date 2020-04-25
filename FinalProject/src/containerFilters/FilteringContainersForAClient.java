package containerFilters;

import java.util.ArrayList;
import java.util.List;

import dataBase.DataBase;
import objectsData.ClientData;
import objectsData.ContainerData;

public abstract class FilteringContainersForAClient implements FilterContainer {

	protected ArrayList<ContainerData> containers;
	private ArrayList<Long> activeJourneys;
	
	public FilteringContainersForAClient(ClientData client) {
		this.activeJourneys=client.getActiveShipment();
		containers= new ArrayList<ContainerData>();
		getContainersByActiveJourneyIDs();
	}
	
	private  void getContainersByActiveJourneyIDs() {
		List<ContainerData> containerExtractedByDataBase;
		System.out.println("activeJourneys: "+activeJourneys.size());
		for(int i=0;i<this.activeJourneys.size();i++) {
			String journeyIDInString = this.activeJourneys.get(i).toString();
			containerExtractedByDataBase = DataBase.searchContainers(journeyIDInString);
			//Need to check if there is actually a container
			System.out.println(containerExtractedByDataBase.size());
			if(containerExtractedByDataBase.size()>0) {
				this.containers.add(containerExtractedByDataBase.get(0));
			}
		}
		//So this method ensures that the containers contain all the containers registered by the client which are on an active journey
	}
	
	
	@Override
	public abstract ArrayList<ContainerData> filterContainers();

}
