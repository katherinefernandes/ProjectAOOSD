package logic;

import java.util.ArrayList;

import graphicalInterface.newClientStuff;
import objectsData.ClientData;
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
	private ClientData client;
	
	public ClientController(String clientID){
		this.clientID = Long.valueOf(clientID);
		validate = new ValidInput();
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
	
	//public void initializeCurrentClient(long ID) {
	//	currentClient = new CurrentClientV2(ID);
		
		
		
	//}
	
	private boolean checkNameValidity(String name) {
		System.out.println(name);
		ArrayList<String> Name = parseInput.parsingNames(name); 
		for(int i=0;i<Name.size();i++) {
			if(!validate.validateName(Name.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkPhoneValidity(String phone) {
		try {
			return validate.validatePhone(Long.valueOf(phone));
		}catch(NumberFormatException e) {
			return false;
		}
	}
	private boolean checkCountryCodeValidity(String CountryCode) {
		return validate.validateCountryCode(Integer.valueOf(CountryCode));
	}
	
	
	public boolean savePhoneNumber(String countryCode,String phone) {
		if(checkPhoneValidity(phone)&&checkCountryCodeValidity(countryCode)) {
			System.out.println("The phone number and country code were valid, now going to update information");
			currentClient.updatePhone();
			currentClient.updateClientInformation(Integer.valueOf(countryCode),Long.valueOf(phone));
			System.out.println("Tried updating information");
			if (currentClient.getUpdatedPhone()) {
				System.out.println("Everything went alright");
				return true;
			}else {
				System.out.println("Something went wrong with the database update");
				return false;
			}
			
		}
		else {
			 System.out.println("The phone number or the countrycode type is not valid");
			 return false;
		}
		
	}
	
	private boolean checkEmailValidity(String email) {
		return validate.validateEmail(email);
	}
	
	public boolean saveEmail(String email) {
		if(checkEmailValidity(email)) {
			System.out.println("The email type is valid, now going to try setting it");
			currentClient.updateEmail();
			currentClient.updateClientInformation(email);
			if (currentClient.getUpdatedEmail()) {
				System.out.println("The email has been successfully updated");
				return true;
			} else {
				System.out.println("Something went wrong with the database");
				return false;
			}
			
		}
		else {
			System.out.println("The email type is not valid");
			return false;
		}
		
	}
	public String getCurrentPhoneNumber() {
		// TODO Auto-generated method stub
		String phone = "";
		if(currentClient.getClientIsSet()) {
			client = currentClient.viewClient();
			phone = Integer.toString(client.getPhoneNumber().getCountryCode())+Long.toString(client.getPhoneNumber().getPhone());
		}
		return phone;
	}
	public String getCurrentEmail() {
		// TODO Auto-generated method stub
		String email ="";
		if (currentClient.getClientIsSet()) {
			client = currentClient.viewClient();
			email = client.getEmail();
		}
		return email;
	}

}
