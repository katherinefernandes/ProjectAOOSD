package logic;
 
import java.awt.EventQueue;
import java.util.*;
import dataBase.DataBase;
import graphicalInterface.LoginWindow;
import graphicalInterface.LogisticMenu;
/**
 * This class connects the logic behind the login system to the graphical user interface
 * @author daniela
 *
 */
public class LoginController {
	private String companyUsername = "admin";
	private String companyPassword = "admin";
	private LoginWindow window;
    
	/**
	 * This controller initialises the login system
	 */
	public LoginController() {
		System.out.println("Inside login controller");
		window = new LoginWindow(this);
		window.errorMessage.setVisible(false);
		window.openFrame();
	}
	/**
	 * public boolean validClientInfo(){}
	 * This method checks whether the ID inputed by the user exists into the data base
	 * @param clientID String holding the clientID
	 * @return boolean value depending whether the ID exists in the data base or not
	 */
	public boolean validClientInfo(String clientID) {
		return DataBase.isSavedID(Long.valueOf(clientID));
	}
    
	/**
	 * private boolean validCompanyInfo(String companyUserNameIN, char[] companyPasswordIN) (){}
	 * This method checks if the value entered matches the preset value of the username and password
	 * @param companyUserNameIN holds the value of the inputed username
	 * @param companyPasswordIN holds the value of the inputed password
	 * @return a boolean statement depending on the outcome
	 */
	private boolean validCompanyInfo(String companyUserNameIN, char[] companyPasswordIN) {
		return companyUserNameIN.equals(companyUsername) && Arrays.equals(companyPasswordIN, companyPassword.toCharArray());
	}
	
	/**
	 * public void loginButtonPressed(){}
	 * This method check which menu is selected when the enter button is pressed and invoked the next frame 
	 */
	public void loginButtonPressed() { 
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
			invokeNextFrame(isClient);} 
	}
	
	
    /**
     * private void invokeNextFrame(){}
     * This method invokes the next frame
     * @param isClient checks if the user is a client or a company
     */
	private void invokeNextFrame(boolean isClient) {
		if(isClient) {
			nextClientFrame();
		} else {
			nextComapanyFrame();
		}
	}
	
	/**
	 * private void nextComapanyFrame() {}
	 * This method invokes the next frame for the company menu
	 */
	private void nextComapanyFrame() {
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
	}
	
	/**
	 * This method invokes the next frame for the client menu
	 */
	private void nextClientFrame() {
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
	}
}
