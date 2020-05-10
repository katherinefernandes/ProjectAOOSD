package supportingClasses;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Validates the different types of data input
 * @author Katherine
 *
 */
public class ValidInput {
	/**
	 * Validates the email format
	 * @param email
	 * @return boolean
	 */
	public  boolean validateEmail (String email) {
		return email.matches("^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}");
	}
 /**
  * Validates the country code length
  * @param countryCode
  * @return boolean
  */
	public  boolean validateCountryCode (int countryCode) {
		
		if (countryCode < 1000 & countryCode > 0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	/**
	 * Validates the phone number length
	 * @param phone
	 * @return boolean
	 */
	public  boolean validatePhone (long phone) {
	
		if (String.valueOf(phone).length() > 4 & String.valueOf(phone).length() < 16) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Validate a person's name or cargo name
	 * @param name
	 * @return boolean
	 */
	public  boolean validateName (String name) {
		return name.matches("^[a-zA-Zàáâäãåą�?ćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñç�?šžÀ�?ÂÄÃÅĄĆČĖĘÈÉÊËÌ�?Î�?Į�?ŃÒÓÔÖÕØÙÚÛÜŲŪŸ�?ŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$");
	}
	
	
	/**
	 * Validates the postcode 
	 * @param zip
	 * @return boolean
	 */
	public  boolean validatePostCode (String zip) {
		return zip.matches("^[a-zA-Z0-9-]+$");
	}
	/**
	 * Validates the location number
	 * @param number
	 * @return boolean
	 */
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
	
	/**
	 * This method validates the arrival date. It should be of the correct format 
	 * and comes after the current date.
	 * @param date
	 * @return true if the date is valid
	 * @author Mamuna
	 */
	public boolean validateDate(String date) {
		String[] datearray = date.split("-");
		if(datearray.length==3) {
			LocalDate object = LocalDate.of(Integer.valueOf(datearray[2]), Integer.valueOf(datearray[1]), Integer.valueOf(datearray[0]));
			return object.isAfter(LocalDate.now());
		}
		else return false;
	}
	
}
