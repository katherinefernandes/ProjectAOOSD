package logic;
 
import java.util.ArrayList;
import java.util.Arrays;

import graphicalInterface.Login_Window;
import supportingClasses.Security;

public class Controller {
	private String companyUsername = "admin";
	private String companyPassword = "admin";
	private ArrayList<String> clientIDs;

	public Controller() {
		Security s = new Security();
		clientIDs = s.getClientIDs();
	}

	public boolean Login(Login_Window window) { 
		if (window.clientMenuRdb.isSelected()) {
			if (clientIDs.contains(window.IDtextField.getText())) {
				System.out.println("textfield in window: " +  window.IDtextField.getText());
				
				return true;
			} else
				return false;
		} else if (window.companyMenuRdb.isSelected()) {
			if (window.usernameTextField.getText().equals(companyUsername)
					&& Arrays.equals(window.passwordField.getPassword(), companyPassword.toCharArray())) {
				return true;
			} else
				return false;
		} else
			return false;
	}
}
