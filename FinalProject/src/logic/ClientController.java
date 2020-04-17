package logic;

import java.util.ArrayList;

import graphicalInterface.newClientStuff;
import supportingClasses.ValidInput;
import users.CurrentClientV2;

public class ClientController {
	private long clientID;
	private CurrentClientV2 currentClient;
	private ValidInput valid;
	private newClientStuff clientmenu;
	public ClientController(String clientID){
		this.clientID = Long.valueOf(clientID);
		currentClient = new CurrentClientV2(this.clientID);
	}
	public void saveReferencePerson(String firstName, String middleName, String lastName) {
		if(checkNameValidity(firstName) && checkNameValidity(middleName) && checkNameValidity(lastName)){
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
		else {
			clientmenu = new newClientStuff(this);
			clientmenu.displayNameError();
		
			
			
		}
		
		
		
	}
	
	public void initializeCurrentClient(long ID) {
		currentClient = new CurrentClientV2(ID);
		
		
		
	}
	
	public boolean checkNameValidity(String name) {
		valid = new ValidInput();
		return valid.validateName(name);
		
		
	}
	
	public boolean checkPhoneValidity(String phone) {
		return valid.validatePhone(Long.valueOf(phone));
	}
	
	
	public void savePhoneNumber(String countryCode,String phone) {
		if(checkPhoneValidity(phone)) {
		currentClient.updateClientInformation(Integer.valueOf(countryCode),Long.valueOf(phone));
		}
		else {
			clientmenu.displyPhoneError();
		}
		
	}
	
	public boolean checkEmailValidity(String email) {
		return valid.validateEmail(email);
	}
	
	public void saveEmail(String email) {
		if(checkEmailValidity(email)) {
		currentClient.updateClientInformation(email);
		}
		else {
			clientmenu.displayEmailError();
		}
		
	}

}
