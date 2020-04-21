package dataAccess;

import objectsData.IdentifiableData;

class ActiveIdentifiableData<T extends IdentifiableData> extends ActiveData<T> {
	
	@Override
	public void storeNewData(T newData) {
		long newDataID = newData.getID();
		if (isEmpty() || newDataID > getIDOfLastStored()) {
			storeDataAtEnd(newData);
		}else {
			storeDataAtSupremum(newData);
		}
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
	
	public boolean IDIsInActiveData(String ID) {
		for(T data : dataList) {
			if (String.valueOf(data.getID()).equals(ID)){
				return true;
			}
		}
		return false;
	}
	
	private void storeDataAtSupremum(T newData) {
		long newDataID = newData.getID();
		int index = findSupremumIndexInActiveData(newDataID);
		storeDataAtIndex(index, newData);
		removePossibleDuplicate(index);
	}
	
	private int findSupremumIndexInActiveData(long ID) {
		int index = 0;
		while(!isIDStoredAtIndexSupremumOfID(index,ID)) {
			index++;
		}
		return index;
	}
	
	private boolean isIDStoredAtIndexSupremumOfID(int index, long ID) {
		return getDataAtIndex(index).getID() >= ID;
	}
	
	private void removePossibleDuplicate(int index) {
		if(insertionCreatedDuplicate(index)) {
			removeDataAtIndex(index);
		}
	}
	
	private long getIDOfLastStored() {
		return getDataAtIndex(dataList.size() - 1).getID();
	}

	private boolean insertionCreatedDuplicate(int index) {
		return getDataAtIndex(index).getID() == getDataAtIndex(index + 1).getID();
	}

}
