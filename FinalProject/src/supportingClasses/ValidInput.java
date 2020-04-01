package supportingClasses;




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
	
	public  boolean validateStreet (String street) {
		return street.matches("^[0-9a-zA-Zàáâäãåą�?ćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñç�?šžÀ�?ÂÄÃÅĄĆČĖĘÈÉÊËÌ�?Î�?Į�?ŃÒÓÔÖÕØÙÚÛÜŲŪŸ�?ŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$");
	}
	
	public  boolean validatePostCode (String zip) {
		return zip.matches("^[a-zA-Z0-9-]+$");
	}
}
