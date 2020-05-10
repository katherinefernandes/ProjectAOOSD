package applications;

import java.util.ArrayList;
import java.util.List;

import objects.Client;
import searchClients.SearchClients;
import supportingClasses.Security;
import updateContainer.UpdateContainer;

/**
 * This class contains all the features available to the logistic company
 * @author Katherine 
 *
 */
public class CompanyApplication extends Application {
	
	public CompanyApplication() {
		super();
	}
	/**This method is used to add a new client to the system
	 * 
	 * @param email
	 * @param name
	 * @param countryCode
	 * @param phone
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param street
	 * @param city
	 * @param postCode
	 * @param houseNumber
	 * @return client ID
	 */
	public long addClient(String email, String name, int countryCode, long phone, ArrayList<String> firstName,
			ArrayList<String> middleName, ArrayList<String> lastName, String street, String city, String postCode,
			int houseNumber) {
		long id = Security.generateIDFromSecureRandom();
		Client newClient = new Client(id, name, countryCode, phone, email, firstName, middleName, lastName, street, city, houseNumber, postCode);
		newClient.save();
		return id;
	}

	/**
	 * This method is used to update the container information
	 * @param Update
	 * @return true if the update goes smoothly
	 */
	public boolean updateContainerInformation(UpdateContainer Update) {
		Update.updateInformation(container);
		return Update.getUpdated();
	}
	/**
	 * This method searchs the clients database according to the search option 
	 * 
	 * @param option
	 * @return a list of clients
	 */
	public List<Client> search(SearchClients option){
		return option.getClients();
	}

}
