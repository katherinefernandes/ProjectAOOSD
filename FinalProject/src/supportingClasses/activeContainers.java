package supportingClasses;

public class activeContainers {
	private Security ID ;
	private boolean setID ;
	
	public activeContainers() {
		ID = new Security();
		setID = false;
	}
	
	public long assignContainer() {
		setID=true;
		return ID.generateID();
	}
	public boolean getSetID() {
		return setID;
	}
}

