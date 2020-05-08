package updateContainer;

import java.time.LocalDateTime;

import businessObjects.Container;
import dataBase.DataBase;

public class UpdateLocation implements UpdateContainer{

	private boolean update;
	private float longitude;
	private float latitude;
	private String currentTime;
	
	public UpdateLocation(float longitude, float latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.update = false;
		currentTime = LocalDateTime.now().toString();
	}
	
	
	//Where is this constructor being used?-mamuna
	/*public UpdateLocation(float lon, float lat, String currentTime) {
		this(lon, lat);
		this.currentTime = currentTime;
	}*/
	
	
	@Override
	public boolean getUpdated() {
		return update;
	}
	
	@Override
	public Container updateInformation(Container container) {
		container.setCurrentPosition(latitude, longitude);
		container.setUpdated(currentTime);
		container.save();
		DataBase.saveToHistory(container);
		update = true;
		return container;
	}
	
}