package containerFilters;

import java.util.ArrayList;

import businessObjects.Client;
import businessObjects.Container;
/**
 * This class filters the list of containers by the given cargo name
 * @author Mamuna
 *
 */
public class FilterByCargoName extends FilteringContainersForAClient{
	private String cargo;

	public FilterByCargoName(Client client,String cargo) {
		super(client);
		this.cargo=cargo;
	}

	@Override
	public ArrayList<Container> filterContainers() {
		
		for (int i=0;i<containers.size();i++) {
			if (!containers.get(i).getCargo().equals(cargo)) {
				containers.remove(i); 
			}
		}
		return containers;
	}
	
}
