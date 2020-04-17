package logic;

import java.util.ArrayList;

import users.CurrentClientV2;

public class ClientController {
	private long clientID;
	private CurrentClientV2 currentClient;
	public ClientController(String clientID){
		this.clientID = Long.valueOf(clientID);
		currentClient = new CurrentClientV2(this.clientID);
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
