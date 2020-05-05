package xmlParser;

import java.util.*;

import businessObjects.BusinessObject;

class ActiveData<T extends BusinessObject> {
	List<T> dataList;
	
	public ActiveData() {
		dataList = new ArrayList<>();
	}
	
	public int size() {
		return dataList.size();
	}
	
	public void storeNewData(T newData1) {
		dataList.add(newData1);
	}
	
	public void storeAllData(List<T> dataList) {
		this.dataList.addAll(dataList);
	}
	
	public T getDataAtIndex(int index) {
		return dataList.get(index);
	}
	
	public List<T> findMatchingEntriesFromActiveData(String searchWord){
		List<T> matchingData = new ArrayList<>();
		for(T data : dataList) {
			matchingData = addDataIfMatch(matchingData, data, searchWord);
		}
		return matchingData;
	}
	
	public boolean isEmpty() {
		return dataList.isEmpty();
	}
	
	public void wipeAllData() {
		dataList = new ArrayList<>();
	}

	public void storeDataAtEnd(T data) {
		dataList.add(data);
	}
	
	public void removeDataWithID(long ID) {
		for(int i = 0; i < dataList.size(); i++) {
			long currentID = getDataAtIndex(i).getID();
			if(currentID == ID) {
				removeDataAtIndex(i);
				break;
			}else if(currentID > ID) {
				break;
			}
		}
	}
	
	public boolean activeDataContainsID(long ID) {
		String IDAsString = String.valueOf(ID);
		for(T data : dataList) {
			if (String.valueOf(data.getID()).equals(IDAsString)){
				return true;
			}
		}
		return false;
	}
	
	protected void storeDataAtIndex(int index, T data) {
		dataList.add(index,data);
	}

	
	protected void removeDataAtIndex(int index) {
		dataList.remove(index);
	}
	
	private List<T> addDataIfMatch(List<T> matchingEntries, T data, String searchWord) {
		if(valuesContainSearchWord(data,searchWord)) {
			matchingEntries.add(data);
		}
		return matchingEntries;
	}
	
	private boolean valuesContainSearchWord(T data, String searchWord){
		for(String value : data.getAllValues()) {
			if(value.contains(searchWord)) {
				return true;
			}
		}
		return false;
	}
	
}
