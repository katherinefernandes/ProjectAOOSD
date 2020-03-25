package dataAccess;

import objectsData.ClientData;
import objectsData.ReferenceName;
import objectsData.Address;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;


public class ClientAccess extends DataAccess<ClientData> {
	
	
	public ClientAccess() {
		super("storage/activeData/clients.xml");
	}
	
	public void newEntry(ClientData data) {
		Element root = doc.getDocumentElement();
		
		Element newClient = elementFromData(data);
		
		NodeList clients = root.getChildNodes();
		int clientsLength = clients.getLength();
		long clientIDValue = data.getClientID();
		
		if( (clientsLength == 0) || (clientIDValue >= getElementID((Element) clients.item(clientsLength - 1)))) {
			root.appendChild(newClient);
		}
		else {
			insertElement(newClient);
		}
		
		
		transform();
	}


	public void editEntry(ClientData data) throws ElementNotFoundException{
		Element root = doc.getDocumentElement();
		Element oldClient;
		Element newClient = elementFromData(data);
		
		oldClient = getElementFromID(getElementID(newClient));
		root.replaceChild(newClient, oldClient);
		
		transform();
	}

	public ClientData getEntry(long ID) throws ElementNotFoundException {
		Element client = getElementFromID(ID);
		ClientData clientData = dataFromElement(client);
		return clientData;
	}

	
	
	
	protected Element elementFromData(ClientData data) {
		Element newClient = doc.createElement("Client");
		newElementWithValue(newClient, "ClientID", String.valueOf(data.getClientID()));
		newElementWithValue(newClient, "CompanyName", data.getCompanyName());
		newElementWithValue(newClient, "PhoneNumber", String.valueOf(data.getPhoneNumber()));
		newElementWithValue(newClient, "Email", data.getEmail());
		
		ReferenceName name = data.getPerson();
		Element nameElement = doc.createElement("RefrencePersonName");
		for(String firstname : name.getFirstName()) {
			newElementWithValue(nameElement,"FirstName",firstname);
		}
		
		for(String middleName : name.getMiddleName()) {
			newElementWithValue(nameElement,"MiddleName",middleName);
		}
		for (String lastName: name.getLastName()) {
			newElementWithValue(nameElement,"LastName",lastName);
		}
		newClient.appendChild(nameElement);
		
		Address address = data.getAddress();
		Element addressElement = doc.createElement("Address");
		newElementWithValue(addressElement,"StreetName",address.getStreetName());
		newElementWithValue(addressElement,"HouseNumber",String.valueOf(address.getHouseNumber()));
		newElementWithValue(addressElement,"City",address.getCity());
		newElementWithValue(addressElement,"ZipCode",String.valueOf(address.getZipCode()));
		newClient.appendChild(addressElement);
		
		Element activeShipments = doc.createElement("ActiveShipments");
		for(long journeyID : data.getActiveShipment()) {
			newElementWithValue(activeShipments,"JourneyID",String.valueOf(journeyID));
		}
		newClient.appendChild(activeShipments);
		return newClient;
	}
}
