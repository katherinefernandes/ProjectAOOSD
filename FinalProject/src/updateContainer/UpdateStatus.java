package updateContainer;

import dataBase.DataBase;
import objects.Container;

public class UpdateStatus implements UpdateContainer{

	private boolean update;
	private float temperature;
	private float humidity;
	private float atmosphere;
	
	public UpdateStatus(float temperature, float humidity, float atmosphere) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.atmosphere = atmosphere;
		this.update = false;
	}
	
	
	@Override
	public boolean getUpdated() {
		return update;
	}
	
	@Override
	public Container updateInformation(Container container) {
		container.setInternalStatus(atmosphere, temperature, humidity);
		container.save();
		DataBase.saveToHistory(container);
		update = true;
		return container;
	}
	
}
