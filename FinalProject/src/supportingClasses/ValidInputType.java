package supportingClasses;

public class ValidInputType { // need to make a separate junit test class

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
