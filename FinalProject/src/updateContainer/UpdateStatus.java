package updateContainer;

import dataAccess.ContainerAccess;
import objectsData.ContainerData;

public class UpdateStatus implements UpdateContainer{

	private boolean setUpdate;
	private ContainerAccess databaseContainer;
	private float temp;
	private float hum;
	private float press;
	
	public UpdateStatus(float temp, float hum, float press) {
		this.temp = temp;
		this.hum = hum;
		this.press = press;
		this.setUpdate = false;
		databaseContainer = new ContainerAccess();
	}
	
	
	@Override
	public boolean updated() {
		// TODO Auto-generated method stub
		return setUpdate;
	}
	
	@Override
	public ContainerData updateInformation(ContainerData container) {
		// TODO Auto-generated method stub
		container.setStatus(press, temp, hum);
		databaseContainer.editEntry(container);
		databaseContainer.flushActiveData();
		setUpdate = true;
		return container;
	}
}
