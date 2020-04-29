package updateContainer;

import businessObjects.Container;
import dataBase.DataBase;

public class UpdateStatus implements UpdateContainer{

	private boolean setUpdate;
	private float temp;
	private float hum;
	private float press;
	
	public UpdateStatus(float temp, float hum, float press) {
		this.temp = temp;
		this.hum = hum;
		this.press = press;
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
		container.setInternalStatus(press, temp, hum);
		container.save();
		DataBase.saveToHistory(container);
		setUpdate = true;
		return container;
	}
	
}
