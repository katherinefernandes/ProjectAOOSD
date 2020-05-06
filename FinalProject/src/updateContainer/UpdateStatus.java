package updateContainer;

import businessObjects.Container;
import dataBase.DataBase;

public class UpdateStatus implements UpdateContainer{

	private boolean update;
	private float temp;
	private float hum;
	private float press;
	
	public UpdateStatus(float temp, float hum, float press) {
		this.temp = temp;
		this.hum = hum;
		this.press = press;
		this.update = false;
	}
	
	
	@Override
	public boolean getUpdated() {
		return update;
	}
	
	@Override
	public Container updateInformation(Container container) {
		container.setInternalStatus(press, temp, hum);
		container.save();
		DataBase.saveToHistory(container);
		update = true;
		return container;
	}
	
}
