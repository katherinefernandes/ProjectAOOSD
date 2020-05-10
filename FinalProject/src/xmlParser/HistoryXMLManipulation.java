package xmlParser;

import java.util.*;

import objects.Container;

/**
 * This class implements the database for the historical record of containers.
 * It implements the singleton pattern, and is supposed to be used through the
 * GeneralPersistency interface.
 * It is one of the four entry points to the xmlParser package.
 * @author simon
 *
 */
public class HistoryXMLManipulation extends ContainerXMLManipulation{	
	private static HistoryXMLManipulation selfInstance;
	
	public static HistoryXMLManipulation getInstance() {
		if(selfInstance == null) {
			selfInstance = new HistoryXMLManipulation();
		}
		return selfInstance;
	}
	
	private HistoryXMLManipulation() {
		super("storage/activeData/history.xml","Container","History");
		activeData = new ActiveData<>();
	}

	@Override
	public void newEntry(Container container) {
		activeData.storeNewData(container);
		if(activeData.size() > 700) {
			flushActiveData();
		}
	}

	@Override
	protected void flushActiveData() {
		io.initializeIO();
		io.transferNext();
		io.transferNext();
		saveAllActiveData();
		saveAllFileData();
		io.finishWriteIO();
	}
	
	@Override
	public List<Container> searchEntries(String searchWord){
		List<Container> matchingEntries = new ArrayList<>();
		flushActiveData();
		matchingEntries.addAll(findMatchingEntriesFromFile(searchWord));
		return matchingEntries;
	}
	
	private void saveAllActiveData() {
		int index = activeData.size() - 1;
		while(index >= 0) {
			io.insertDataPoint(dataPointFromObject(activeData.getDataAtIndex(index)));
			index--;
		}
		activeData.wipeAllData();
	}
	
	private void saveAllFileData() {
		while(io.hasNext()) {
			io.transferNext();
		}
	}
	
	@Override
	protected List<Container> findMatchingEntriesFromFile(String searchWord){
		List<Container> matchingEntries = new ArrayList<>();
		DataPointParser dataPoint = new DataPointParser(dataPointTagName, searchWord);
		io.initializeIO();
		io.readEvent();
		io.readEvent();
		while(io.hasNext()) {
			EventParser event = io.readEvent();
			dataPoint.handleMatchOnIDAndValue(event);
			if(dataPoint.isCompleteMatchingDataPoint()) {
				matchingEntries.add(objectFromDataPoint(dataPoint));
			}
		}	
		io.finishReadIO();
		return matchingEntries;
	}

	@Override
	protected void wipeActiveData() {
		activeData.wipeAllData();
		
	}
}
