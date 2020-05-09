package supportingClasses;

import java.security.SecureRandom;

public class Security {	
		

	public static long generateIDFromSecureRandom() { 
		SecureRandom random = new SecureRandom();
		return Math.abs(random.nextLong());
	}
	
}