package dataObjects;




public class validInput {
	
	public static boolean validateEmail (String email) {
		return email.matches("^[-0-9a-zA-Z.+_]+@[-0-9a-zA-Z.+_]+\\.[a-zA-Z]{2,4}");
	}
	
	public static boolean validatePhone (String phone) {
		return phone.matches("^[+]{0,1}[0-9]{8,15}");
	}

}
