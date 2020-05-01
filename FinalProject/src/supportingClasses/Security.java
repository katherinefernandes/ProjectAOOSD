package supportingClasses;

import java.security.SecureRandom;

public class Security {	
	//try generating ID in chaotic order
	private static long ID; 
	public static long generateID()  {
		ID = System.nanoTime();  
		return ID;
	}   	
	
	public static long generateIDFromSecureRandom() {
		SecureRandom random = new SecureRandom();
		return random.nextLong();
	}
}