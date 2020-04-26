package updateContainer;

import businessObjects.Container;
import supportingClasses.UpdateHistory;

public class UpdateLocation implements UpdateContainer{

	private boolean setUpdate;
	private float lon;
	private float lat;
	private UpdateHistory history;
	
	public UpdateLocation(float lon, float lat) {
		this.lon = lon;
		this.lat = lat;
		this.setUpdate = false;
		history = new UpdateHistory();
	}
	
	
	@Override
	public boolean updated() {
		// TODO Auto-generated method stub
		return setUpdate;
	}
	
	@Override
	public Container updateInformation(Container container) {
		// TODO Auto-generated method stub
		container.setCurrentPosition(lat, lon);
		container.save();
		history.updateHistoryDataBase(container);
		setUpdate = true;
		return container;
	}
	
}