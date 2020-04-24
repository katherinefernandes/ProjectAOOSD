package supportingClasses;

import XMLParser.HistoryAccess;
import objectsData.ContainerData;
import objectsData.HistoryData;

public class UpdateHistory {
	private HistoryAccess databaseHistory;
	private HistoryData history;
	
	public UpdateHistory() {
		databaseHistory = new HistoryAccess();
	}
	public void updateHistoryDataBase(ContainerData container) {
		history= new HistoryData(container.getID(),container.getJourneyID(),container.getClientID(),container.getDestinationPortID(),container.getStartPortID(),container.getCargo(),container.getInternalStatus().getTemperature(),container.getInternalStatus().getAtmosphere(),container.getInternalStatus().getHumidity(),container.getCurrentPosition().getLatitude(),container.getCurrentPosition().getlongitude());
		databaseHistory.newEntry(history);
		databaseHistory.flushActiveData();
	}
}
