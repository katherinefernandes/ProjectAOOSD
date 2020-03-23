package dataAccess;

import objectsData.ClientData;


import java.io.*;
import javax.xml.parsers.*;
import javax.xml.validation.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;


public class ClientAccess extends DataAccess<ClientData> {
	
	
	ClientAccess() {
		super("storage/clients.xml");
	}
	
	public void newEntry(ClientData data) {
		Element root = doc.getDocumentElement();
		
		Element newClient = createNewClientElement(data);
		
		NodeList clients = root.getChildNodes();
		int clientsLength = clients.getLength();
		int clientIDValue = data.getClientId();
		
		if( (clientsLength == 0) || (clientIDValue >= getElementID(clients.item(clientsLength - 1)))) {
			root.appendChild(newClient);
		}
		else {
			insertElementSorted(root, newClient);
		}
		
		try {
			
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(filePath));
		transformer.transform(source, result);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void editEntry(ClientData data) {
		
	}

	public ClientData getEntry(int ID) {
		return null;
	}

	
	public Element createNewClientElement(ClientData data) {
		Element newClient = doc.createElement("Client");
		newElementWithValue(newClient, "ClientID", String.valueOf(data.getClientId()));
		newElementWithValue(newClient, "CompanyName", data.getCompanyName());
		newElementWithValue(newClient, "PhoneNumber", String.valueOf(data.getPhoneNumber()));
		newElementWithValue(newClient, "Email", data.getEmail());
		
		Name name = data.getName();
		Element nameElement = doc.createElement("Name");
		newElementWithValue(nameElement,"FirstName",name.getFirstName());
		for(String middleName : name.getMiddleName()) {
			newElementWithValue(nameElement,"MiddleName",middleName);
		}
		newElementWithValue(nameElement,"LastName",name.getLastName());
		newClient.appendChild(nameElement);
		
		Address address = data.getAddress();
		Element addressElement = doc.createElement("Address");
		newElementWithValue(addressElement,"StreetName",address.getStreetName());
		newElementWithValue(addressElement,"HouseNumber",String.valueOf(address.getHouseNumber()));
		newElementWithValue(addressElement,"City",address.getCity());
		newElementWithValue(addressElement,"ZipCode",String.valueOf(address.getZipCode));
		newClient.appendChild(addressElement);
		
		Element activeShipments = doc.createElement("ActiveShipments");
		for(long journeyID : data.getActiveShipments()) {
			newElementWithValue(activeShipments,"JourneyID",String.valueOf(journeyID));
		}
		newClient.appendChild(activeShipments);
		return newClient;
	}
}
