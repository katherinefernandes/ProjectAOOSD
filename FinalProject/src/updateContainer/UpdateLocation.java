package updateContainer;

import dataAccess.ContainerAccess;
import objectsData.ContainerData;
import objectsData.HistoryData;
import supportingClasses.UpdateHistory;

public class UpdateLocation implements UpdateContainer{

	private boolean setUpdate;
	private ContainerAccess databaseContainer;
	private float lon;
	private float lat;
	private UpdateHistory history;
	
	public UpdateLocation(float lon, float lat) {
		this.lon = lon;
		this.lat = lat;
		this.setUpdate = false;
		databaseContainer = new ContainerAccess();
		history = new UpdateHistory();
	}
	
	
	@Override
	public boolean updated() {
		// TODO Auto-generated method stub
		return setUpdate;
	}
	
	@Override
	public ContainerData updateInformation(ContainerData container) {
		// TODO Auto-generated method stub
		container.setCurrentPosition(lat, lon);
		databaseContainer.editEntry(container);
		databaseContainer.flushActiveData();
		history.updateHistoryDataBase(container);
		setUpdate = true;
		return container;
	}
	
}