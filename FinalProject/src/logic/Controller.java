package logic;
 
import java.util.*;

import dataAccess.*;
import exceptions.ElementNotFoundException;
import objectsData.ClientData;
import supportingClasses.Security;
import users.CurrentClientV2;

public class Controller {
	private String companyUsername = "admin";
	private String companyPassword = "admin";
	private ArrayList<String> clientIDs;
	private CurrentClientV2 currentClient;

	public Controller() {
		Security s = new Security();
		clientIDs = s.getClientIDs();
		
	}

	public boolean Login(boolean isClient,boolean isCompany,String clientID,String companyUserNameIN,char[] companyPasswordIN) { 
		if (isClient) {
			if (clientIDs.contains(clientID)) {
				System.out.println("textfield in window: " +  clientID);
				initializeCurrentClient(Long.valueOf(clientID));
				
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

	public void saveReferencePerson(String firstName, String middleName, String lastName) {
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
		currentClient.updateClientInformation(firstNameList, middleNameList, lastNameList);
		
		
		
	}
	
	public void initializeCurrentClient(long ID) {
		currentClient = new CurrentClientV2(ID);
		
		
		
	}
	
	public void savePhoneNumber(String countryCode,String phone) {
		currentClient.updateClientInformation(Integer.valueOf(countryCode),Long.valueOf(phone));
		
	}
	
	public void saveEmail(String email) {
		currentClient.updateClientInformation(email);
		
	}
	
	
}
