package supportingClasses;

import objectsData.ContainerData;
import objectsData.HistoryData;

public class UpdateHistory {
	private HistoryData history;
	
	public void updateHistoryDataBase(ContainerData container) {
		history= new HistoryData(container.getID(),container.getJourneyID(),container.getClientID(),container.getDestinationPortID(),container.getStartPortID(),container.getCargo(),container.getInternalStatus().getTemperature(),container.getInternalStatus().getAtmosphere(),container.getInternalStatus().getHumidity(),container.getCurrentPosition().getLatitude(),container.getCurrentPosition().getlongitude());
		history.save();
	}
}
