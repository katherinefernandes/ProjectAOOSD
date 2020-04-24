package updateContainer;

import objectsData.ContainerData;
import objectsData.HistoryData;
import supportingClasses.UpdateHistory;
import xmlParser.ContainerXMLManipulation;
import xmlParser.HistoryXMLManipulation;

public class UpdateStatus implements UpdateContainer{

	private boolean setUpdate;
	private ContainerXMLManipulation databaseContainer;
	private UpdateHistory history;
	private float temp;
	private float hum;
	private float press;
	
	public UpdateStatus(float temp, float hum, float press) {
		this.temp = temp;
		this.hum = hum;
		this.press = press;
		this.setUpdate = false;
		databaseContainer = new ContainerXMLManipulation();
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
		databaseContainer.editEntry(container);
		databaseContainer.flushActiveData();
		history.updateHistoryDataBase(container);
		setUpdate = true;
		return container;
	}
	
}
