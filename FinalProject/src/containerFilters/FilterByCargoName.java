package containerFilters;

import java.util.ArrayList;

import objectsData.ClientData;
import objectsData.ContainerData;

public class FilterByCargoName extends FilteringContainersForAClient{
	
	private String cargo;
	
	
	
	public FilterByCargoName(ClientData client,String cargo) {
		super(client);
		this.cargo=cargo;
	}

	@Override
	public ArrayList<ContainerData> filterContainers() {
		
		for (int i=0;i<containers.size();i++) {
			if (!containers.get(i).getCargo().equals(cargo)) {
				containers.remove(i);
			}
		}
		return containers;
	}
	
}
