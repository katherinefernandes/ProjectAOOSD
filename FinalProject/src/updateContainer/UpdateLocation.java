package updateContainer;

import businessObjects.Container;
import dataBase.DataBase;

public class UpdateLocation implements UpdateContainer{

	private boolean setUpdate;
	private float lon;
	private float lat;
	
	public UpdateLocation(float lon, float lat) {
		this.lon = lon;
		this.lat = lat;
		this.setUpdate = false;
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
		DataBase.saveToHistory(container);
		setUpdate = true;
		return container;
	}
	
}