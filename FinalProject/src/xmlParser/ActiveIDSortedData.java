package xmlParser;

import objects.BusinessObject;

class ActiveIDSortedData<T extends BusinessObject> extends ActiveData<T> {
	
	@Override
	public void storeNewData(T newData) {
		long newDataID = newData.getID();
		if (isEmpty() || newDataID > getIDOfLastStored()) {
			storeDataAtEnd(newData);
		}else {
			storeDataAtSupremum(newData);
		}
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
			removeDataAtIndex(index + 1);
		}
	}
	
	private long getIDOfLastStored() {
		return getDataAtIndex(dataList.size() - 1).getID();
	}

	private boolean insertionCreatedDuplicate(int index) {
		return getDataAtIndex(index).getID() == getDataAtIndex(index + 1).getID();
	}

}
