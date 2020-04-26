package updateContainer;

import businessObjects.Container;
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
	public Container updateInformation(Container container) {
		// TODO Auto-generated method stub
		container.setInternalStatus(press, temp, hum);
		container.save();
		history.updateHistoryDataBase(container);
		setUpdate = true;
		return container;
	}
	
}
