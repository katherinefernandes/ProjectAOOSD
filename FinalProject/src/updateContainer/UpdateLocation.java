package updateContainer;

import java.time.LocalDateTime;

import dataBase.DataBase;
import objects.Container;
/**
 * Updates the current location for the container
 * @author Katherine
 *
 */
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