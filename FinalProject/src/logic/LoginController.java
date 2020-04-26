package logic;
 
import java.awt.EventQueue;
import java.util.*;
import dataBase.DataBase;
import graphicalInterface.LoginWindow;
import graphicalInterface.LogisticMenu;

//TODO unify the way we get information for the interface. Either send it as parameters when calling controller methods in the interface, 
//or pull it from the interface by calling interface methods from the controller. Right now we're doing both.
public class LoginController {
	private String companyUsername = "admin";
	private String companyPassword = "admin";
	private LoginWindow window;

	public LoginController() {
		System.out.println("Inside login controller");
		window = new LoginWindow(this);
		window.errorMessage.setVisible(false);
		window.openFrame();
	}
	
	public boolean validClientInfo(String clientID) {
		return DataBase.isSavedID(Long.valueOf(clientID));
	}

	private boolean validCompanyInfo(String companyUserNameIN, char[] companyPasswordIN) {
		return companyUserNameIN.equals(companyUsername) && Arrays.equals(companyPasswordIN, companyPassword.toCharArray());
	}
	
	//TODO there should only be level of "if", "while" and "for" statements in each method.
	public void loginButtonPressed() { //TODO this should be reduced to one level of abstraction
		boolean validLogin;
		boolean isClient = window.isClientButtonChecked();
		if(isClient) {
			String clientText=window.getClientInput();
			validLogin = validClientInfo(clientText);
		}
		else {
			String companyName = window.getCompanyUsername();
			char[] companyPassword = window.getComapnyPassword();
			validLogin =validCompanyInfo(companyName,companyPassword);
		}
		if(!validLogin) {
			window.invalidInput();
		} else {
			if(isClient) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new ClientController((window.getClientInput()));
							window.closeFrame();
							
						
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			} else {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LogisticController logisticController = new LogisticController();
							LogisticMenu logistics = new LogisticMenu(logisticController);
							logistics.frame.setVisible(true);
							window.closeFrame();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}} 
	}
}
