package containerFilters;

import java.util.ArrayList;
import java.util.List;

import dataBase.DataBase;
import objects.Client;
import objects.Container;
/**
 * This class collects a list of containers which are registered for a journey
 * for the client
 * @author Mamuna
 *
 */
public abstract class FilteringContainersForAClient implements FilterContainer {

	protected ArrayList<Container> containers;
	private List<Long> activeJourneys;
	
	public FilteringContainersForAClient(Client client) {
		this.activeJourneys=client.getActiveShipments();
		containers= new ArrayList<Container>();
		getContainersByActiveJourneyIDs();
	}
	
	
	/**
	 * getContainersByActiveJourneysIDs will extract all the containers from the database 
	 * which are registered as an active journey for the client
	 */
	private  void getContainersByActiveJourneyIDs() {
		List<Container> containerExtractedByDataBase;
		System.out.println("activeJourneys: "+activeJourneys.size());
		for(int i=0;i<this.activeJourneys.size();i++) {
			String journeyIDInString = this.activeJourneys.get(i).toString();
			containerExtractedByDataBase = DataBase.searchContainers(journeyIDInString);
			System.out.println("Containers found "+containerExtractedByDataBase.size());
			if(containerExtractedByDataBase.size()>0) {
				System.out.println(containerExtractedByDataBase.get(0).getJourneyID());
				this.containers.add(containerExtractedByDataBase.get(0));
			}
		}
		
	}
	
	/**
	 * filterContainers will filter out the list of containers on an active journey for the 
	 * client depending on the filter chosen
	 * @return ArrayList<Container>
	 */
	
	@Override
	public abstract ArrayList<Container> filterContainers();

}
