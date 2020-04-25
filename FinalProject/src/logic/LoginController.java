package logic;
 
import java.awt.EventQueue;
import java.util.*;

import applications.ClientApplication;
import exceptions.ElementNotFoundException;
import graphicalInterface.LoginWindow;
import graphicalInterface.LogisticsMenu;
import graphicalInterface.newClientMenu;
import objectsData.ClientData;
import supportingClasses.Security;
import xmlParser.ClientXMLManipulation;

public class LoginController {
	private String companyUsername = "admin";
	private String companyPassword = "admin";
	private ArrayList<String> clientIDs;
	private LoginWindow window;
	private ClientXMLManipulation clientXMLManipulation;

	public LoginController() {
		System.out.println("Inside login controller");
		clientXMLManipulation = new ClientXMLManipulation();
		window = new LoginWindow(this);
		window.errorMessage.setVisible(false);
		window.openFrame();
		
		
	}
	
	public boolean validClientInfo(String clientID) {
			if (clientXMLManipulation.IDExists(clientID)) {
				System.out.println("textfield in window: " +  clientID);
				
				return true;
			} else {
				
				System.out.println("Invalid client id");
				return false;
		}}
			


	private boolean validCompanyInfo(String companyUserNameIN, char[] companyPasswordIN) {
		if (companyUserNameIN.equals(companyUsername)
				&& Arrays.equals(companyPasswordIN, companyPassword.toCharArray())) {
			return true;
		} else
			return false;
	}
	
	public void loginButtonPressed(boolean clientChecked) {
		login();
		
	}
	
	public void login() { 
		System.out.println("Inside the login thing");
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
			LoginController thisController = this;
			if(isClient) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ClientController clientController = new ClientController((window.getClientInput()));
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
							LogisticsMenu logistics = new LogisticsMenu(logisticController);
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
