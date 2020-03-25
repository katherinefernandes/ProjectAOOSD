package dataAccess;



import objectsData.HistoryData;

public class HistoryAccess extends DataAccess<HistoryData> {
	HistoryAccess() {
		super("storage/activeData/history.xml");
	}
	
	public void newEntry(HistoryData data) {
	
	}


	public void editEntry(HistoryData data) {
		
	}

	public HistoryData getEntry(long ID) {
		return null;
	}
}
