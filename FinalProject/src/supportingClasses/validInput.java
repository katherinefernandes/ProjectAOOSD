package supportingClasses;




public class validInput {
	
	public static boolean validateEmail (String email) {
		return email.matches("^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}");
	}
	
	public static boolean validateCountryCode (int cc) {
		
		if (cc < 1000 & cc > 0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static boolean validatePhone (long phone) {
	
		if (String.valueOf(phone).length() > 4 & String.valueOf(phone).length() < 16) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean validateName (String name) {
		return name.matches("^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$");
	}
	
	public static boolean validateStreet (String street) {
		return street.matches("^[0-9a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+$");
	}
	
	public static boolean validatePostCode (String zip) {
		return zip.matches("^[a-zA-Z0-9-]+$");
	}
}
