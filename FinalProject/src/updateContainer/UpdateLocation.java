package updateContainer;

import java.time.LocalDateTime;

import businessObjects.Container;
import dataBase.DataBase;

public class UpdateLocation implements UpdateContainer{

	private boolean setUpdate;
	private float lon;
	private float lat;
	private String currentTime;
	
	public UpdateLocation(float lon, float lat) {
		this.lon = lon;
		this.lat = lat;
		this.setUpdate = false;
		currentTime = LocalDateTime.now().toString();
	}
	
	public UpdateLocation(float lon, float lat, String currentTime) {
		this(lon, lat);
		this.currentTime = currentTime;
	}
	
	
	@Override
	public boolean updated() {
		return setUpdate;
	}
	
	@Override
	public Container updateInformation(Container container) {
		container.setCurrentPosition(lat, lon);
		container.setUpdated(currentTime);
		container.save();
		DataBase.saveToHistory(container);
		setUpdate = true;
		return container;
	}
	
}