package supportingClasses;

public class activeContainers {
	private Security ID = new Security();
	
	public long assignContainer() {
		return ID.generateID();
	}
}

