package logic;
 
import java.awt.EventQueue;
import java.util.*;

import dataBase.DataBase;
import graphicalInterface.Login_Window;
import graphicalInterface.LogisticsMenu;

public class LoginController {
	private String companyUsername = "admin";
	private String companyPassword = "admin";
	private Login_Window window;

	public LoginController() {
		window = new Login_Window(this);
		window.openFrame();
	}
	
	public boolean validClientInfo(String clientID) {
		if (DataBase.isSavedID(Long.valueOf(clientID))) {
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
