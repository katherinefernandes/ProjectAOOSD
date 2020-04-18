package logic;

import java.util.ArrayList;

import graphicalInterface.newClientStuff;
import supportingClasses.ValidInput;
import supportingClasses.parseInput;
import users.CurrentClientV2;

public class ClientController {
	private long clientID;
	private CurrentClientV2 currentClient;
	private ValidInput validate;
	private newClientStuff clientmenu;
	private ArrayList<String> firstNameList;
	private ArrayList<String> middleNameList;
	private ArrayList<String> lastNameList;
	
	
	public ClientController(String clientID){
		this.clientID = Long.valueOf(clientID);
		currentClient = new CurrentClientV2(this.clientID);
	}
	public boolean saveReferencePerson(String firstName, String middleName, String lastName) {
		System.out.println("inside the method savereferencePerson");
		if(checkNameValidity(firstName) && checkNameValidity(middleName) && checkNameValidity(lastName)){
			firstNameList = parseInput.parsingNames(firstName);
			middleNameList = parseInput.parsingNames(middleName);
			lastNameList = parseInput.parsingNames(lastName);
			currentClient.updateReferencePerson();
			System.out.println("Going to try to update information");
			currentClient.updateClientInformation(firstNameList, middleNameList, lastNameList);
			System.out.println("Tried to update Client information");
			//clientmenu.displaySuccess();
			if (currentClient.getUpdatedReferencePerson()) {
				System.out.println("Update success, trying to display message");
				return true;
			} else {
				System.out.println("Some thing went wrong in saving to the databaseClient");
				return false;
			}
		}
		
		else {
			System.out.println("The names are not valid");
			return false;	
		}
		
		
		
	}
	
	public void initializeCurrentClient(long ID) {
		currentClient = new CurrentClientV2(ID);
		
		
		
	}
	
	public boolean checkNameValidity(String name) {
		validate = new ValidInput();
		System.out.println(name);
		ArrayList<String> Name = parseInput.parsingNames(name); 
		for(int i=0;i<Name.size();i++) {
			if(!validate.validateName(Name.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkPhoneValidity(String phone) {
		return validate.validatePhone(Long.valueOf(phone));
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
		return validate.validateEmail(email);
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
