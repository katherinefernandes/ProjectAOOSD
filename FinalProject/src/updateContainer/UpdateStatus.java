package updateContainer;

import objectsData.ContainerData;
import supportingClasses.UpdateHistory;

public class UpdateStatus implements UpdateContainer{

	private boolean setUpdate;
	private UpdateHistory history;
	private float temp;
	private float hum;
	private float press;
	
	public UpdateStatus(float temp, float hum, float press) {
		this.temp = temp;
		this.hum = hum;
		this.press = press;
		this.setUpdate = false;
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
		container.setStatus(press, temp, hum);
		container.save();
		history.updateHistoryDataBase(container);
		setUpdate = true;
		return container;
	}
	
}
