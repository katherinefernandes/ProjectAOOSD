package logic;
 
import java.awt.EventQueue;
import java.util.*;

import dataAccess.*;
import exceptions.ElementNotFoundException;
import graphicalInterface.Login_Window;
import graphicalInterface.LogisticsMenu;
import graphicalInterface.newClientStuff;
import objectsData.ClientData;
import supportingClasses.Security;
import users.CurrentClientV2;

public class LoginController {
	private String companyUsername = "admin";
	private String companyPassword = "admin";
	private ArrayList<String> clientIDs;
	private Login_Window window;

	public LoginController() {
		Security s = new Security();
		clientIDs = s.getClientIDs();
		window = new Login_Window(this);
		window.openFrame();
		
	}
	
	public boolean validClientInfo(String clientID) {
		if (clientIDs.contains(clientID)) {
			System.out.println("textfield in window: " +  clientID);
			
			return true;
		} else
			return false;
	}


	private boolean validCompanyInfo(String companyUserNameIN, char[] companyPasswordIN) {
		if (companyUserNameIN.equals(companyUsername)
				&& Arrays.equals(companyPasswordIN, companyPassword.toCharArray())) {
			return true;
		} else
			return false;
	}
	
	public void loginButtonPressed(boolean clientChecked) {
		if(clientChecked) {
			login();
         }
		else {
			
		}
		
	}
	
	public void login() { 
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
							newClientStuff clientmenu = new newClientStuff(clientController);
							clientmenu.frame.setVisible(true);
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
