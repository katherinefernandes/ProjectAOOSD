package logic;
 
import java.util.*;

import dataAccess.*;
import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import supportingClasses.Security;

public class Controller {
	private String companyUsername = "admin";
	private String companyPassword = "admin";
	private ArrayList<String> clientIDs;
	private ClientAccess clientAccess;

	public Controller() {
		Security s = new Security();
		clientIDs = s.getClientIDs();
		clientAccess = new ClientAccess();
	}

	public boolean Login(boolean isClient,boolean isCompany,String clientID,String companyUserNameIN,char[] companyPasswordIN) { 
		if (isClient) {
			if (clientIDs.contains(clientID)) {
				System.out.println("textfield in window: " +  clientID);
				
				return true;
			} else
				return false;
		} else if (isCompany) {
			if (companyUserNameIN.equals(companyUsername)
					&& Arrays.equals(companyPasswordIN, companyPassword.toCharArray())) {
				return true;
			} else
				return false;
		} else
			return false;
	}

	public void saveReferencePerson(String firstName, String middleName, String lastName, long clientID) {
		ArrayList<String> firstNameList = new ArrayList<>();
		ArrayList<String> middleNameList = new ArrayList<>();
		ArrayList<String> lastNameList = new ArrayList<>();
		for(String name : firstName.split(" ")) {
			firstNameList.add(name);
		}
		for(String name : middleName.split(" ")) {
			middleNameList.add(name);
		}
		for(String name : lastName.split(" ")) {
			lastNameList.add(name);
		}
		ClientData oldClient = null;
		try {
			oldClient = clientAccess.getEntry(clientID);
		} catch (ElementNotFoundException e) {
			e.printStackTrace(); //TODO display that 
		}
		oldClient.setPerson(firstNameList,middleNameList,lastNameList);
		clientAccess.editEntry(oldClient);
		clientAccess.flushActiveData();
	}
}
