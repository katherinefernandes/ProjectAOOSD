package supportingClasses;

import java.util.ArrayList;

public class ValidInput {
	//changed all methods to just public
	public  boolean validateEmail (String email) {
		return email.matches("^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}");
	}
 
	public  boolean validateCountryCode (int cc) {
		
		if (cc < 1000 & cc > 0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public  boolean validatePhone (long phone) {
	
		if (String.valueOf(phone).length() > 4 & String.valueOf(phone).length() < 16) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public  boolean validateName (String name) {
		return name.matches("^[a-zA-Zàáâäãåą�?ćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñç�?šžÀ�?ÂÄÃÅĄĆČĖĘÈÉÊËÌ�?Î�?Į�?ŃÒÓÔÖÕØÙÚÛÜŲŪŸ�?ŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$");
	}
	
	
	
	public  boolean validatePostCode (String zip) {
		return zip.matches("^[a-zA-Z0-9-]+$");
	}
	
	public boolean validateLocation (float number) {
		if (number >= -180 & number <= 180) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * private boolean validateArrayOfNames(){}
	 * This method is checking the validity of the name and returns a boolean depending on the situation
	 * @param name the Name inputed by the user (could be either first name, middle name or last name)
	 * @return true if the name is valid and false if the name is invalid
	 */
	public boolean validateArrayOfNames(String name) {
		System.out.println(name);
		ArrayList<String> Name = InputParser.parsingNames(name); 
		for(int i=0;i<Name.size();i++) {
			if(!validateName(Name.get(i))) {
				return false;
			}
		}
		return true;
	}
}
