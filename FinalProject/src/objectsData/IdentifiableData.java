package objectsData;

public abstract class IdentifiableData extends ObjectData{
	protected long ID;
	
	public long getID() {
		return ID;
	}
	
	@Override
	public boolean valuesContainSearchWord(String searchWord) {
		if(!super.valuesContainSearchWord(searchWord)) {
			return String.valueOf(ID).contains(searchWord);
		}
		return true;
	}
}
