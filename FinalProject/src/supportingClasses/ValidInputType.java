package supportingClasses;

/**
 * This class validates the types of the inputs from a user
 * @author Mamuna
 *
 */
public class ValidInputType {

	public static boolean validateInteger(String text) {
		try {
			Integer.valueOf(text);
			return true;
		}catch(NumberFormatException e) {
			System.out.println("the countrycode is not valid");
			return false;
		}
	}
	public static boolean validateLong(String text) {
		try {
			Long.valueOf(text);
			return true;
		}catch(NumberFormatException e) {
			System.out.println("the countrycode is not valid");
			return false;
		}
	}
	public static boolean validateFloat(String text) {
		try {
			Float.valueOf(text);
			return true;
			}catch(NumberFormatException e) {
				return false;
			}
	}
	
}

