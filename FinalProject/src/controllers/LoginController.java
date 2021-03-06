package controllers;
 
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import dataBase.DataBase;
import exceptions.ElementSelectionException;
import graphicalInterface.LoginWindow;
import graphicalInterface.LogisticMenu;

import simulation.Simulator;
import supportingClasses.ValidInputType;
import worldMap.MapPane;
/**
 * This class connects the logic behind the login system to the graphical user interface
 * @author daniela
 *
 */
public class LoginController {
	private String companyUsername = "admin";
	private String companyPassword = "admin";
	private LoginWindow window;
	private String clientText;
	private String companyName;
	private char[] companyPasswordIN;
	private boolean simulationOn;
	private double simulationHoursPerSecond;
	private Simulator simulator;
    
	/**
	 * This controller initialises the login system
	 */
	public LoginController() {
		System.out.println("Inside login controller");
		simulationOn = false;
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
		return ValidInputType.validateLong(clientID)&&DataBase.isSavedID(Long.valueOf(clientID));
	}
    
	/**
	 * private boolean validCompanyInfo(String companyUserNameIN, char[] companyPasswordIN) (){}
	 * This method checks if the value entered matches the preset value of the username and password
	 * @param companyUserNameIN holds the value of the inputed username
	 * @param companyPasswordIN holds the value of the inputed password
	 * @return a boolean statement depending on the outcome
	 */
	//same here -mamuna
	public boolean validCompanyInfo(String companyUserNameIN, char[] companyPasswordIN) {
		return companyUserNameIN.equals(companyUsername) && Arrays.equals(companyPasswordIN, companyPassword.toCharArray());
	}
	
	
	
	
	
	
	/**
	 * public void loginButtonPressed(){}
	 * This method check which menu is selected when the enter button is pressed and invoked the next frame 
	 */
	public void loginButtonPressed(boolean isClient) { 
		boolean validLogin;
		if(isClient) {
			validLogin = validClientInfo(clientText);
		}
		else {
			
			validLogin =validCompanyInfo(companyName,companyPasswordIN);
		}
		if(!validLogin) {
			window.invalidInput();
		} else { 
			startSimulation();
			invokeNextFrame(isClient);
		} 
	}
	

	public void setClientText(String text) {
		this.clientText = text;
	}
	
	
	public void setCompnyName(String companyName) {
		this.companyName = companyName;
	}
	
	public void setCompanyPassword(char[] companyPassword) {
		this.companyPasswordIN = companyPassword;
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
					System.out.println("Setting up the client application for client:"+clientText);
					new ClientController(clientText);
					window.closeFrame();
					
				
				} catch (Exception e) {
					throw new Error("Exception given, the validation did not work",e);
				}
			}
		});
	}
	
	public void setSimulation(boolean simulationOn, double simulationHoursPerSecond) {
		this.simulationOn = simulationOn;
		this.simulationHoursPerSecond = simulationHoursPerSecond;
	}
	private void startSimulation() {
		if(simulationOn) {
			int delayMS = (int) (1000./simulationHoursPerSecond);
			simulator = new Simulator();
			Timer simulation = new Timer(delayMS, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					simulator.simulateOneHour();
		         }
			});
			simulation.start();
		}
	}
}
