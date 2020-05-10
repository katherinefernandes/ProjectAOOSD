package supportingClasses;

import java.security.SecureRandom;
/**
 * Generates a unique ID
 * @author Daniela 
 *
 */
public class Security {	
		

	public static long generateIDFromSecureRandom() { 
		SecureRandom random = new SecureRandom();
		return Math.abs(random.nextLong());
	}
	
}