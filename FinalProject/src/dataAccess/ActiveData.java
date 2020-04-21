package dataAccess;

import java.util.*;
import objectsData.ObjectDataInterface;

class ActiveData<T extends ObjectDataInterface> {
	List<T> dataList;
	
	public ActiveData() {
		dataList = new ArrayList<>();
	}
	
	public void storeNewData(T newData) {
		dataList.add(newData);
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
	
	private List<T> addDataIfMatch(List<T> matchingEntries, T data, String searchWord) {
		if(data.valuesContainSearchWord(searchWord)) {
			matchingEntries.add(data);
		}
		return matchingEntries;
	}
	
	protected void storeDataAtEnd(T data) {
		dataList.add(data);
	}
	
	protected void storeDataAtIndex(int index, T data) {
		dataList.add(index,data);
	}

	
	protected void removeDataAtIndex(int index) {
		dataList.remove(index);
	}
	
}
