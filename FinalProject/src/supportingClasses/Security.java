package supportingClasses;

public class Security {	
	//try generating ID in chaotic order
	private long ID; 
	public long generateID()  {
		ID = System.nanoTime();  
		return ID;
	}   	
}