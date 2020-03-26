package dataAccess;

import objectsData.ClientData;
import objectsData.ReferenceName;
import objectsData.Address;

import java.io.*;
import java.util.*;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;


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
		
		if( (clientsLength == 0) || (clientIDValue >= nodeMethods.getElementID((Element) clients.item(clientsLength - 1)))) {
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
		
		oldClient = getElementFromID(nodeMethods.getElementID(newClient));
		root.replaceChild(newClient, oldClient);
		
		transform();
	}

	public ClientData getEntry(long ID) throws ElementNotFoundException, NumberFormatException, AmbiguousElementSelectionException {
		Element client = getElementFromID(ID);
		ClientData clientData = dataFromElement(client);
		return clientData;
	}

	
	
	
	protected Element elementFromData(ClientData data) {
		Element newClient = doc.createElement("Client");
		newElementWithValue(newClient, "ClientID", String.valueOf(data.getClientID()));
		newElementWithValue(newClient, "CompanyName", data.getCompanyName());
		
		Element phoneNumber = doc.createElement("PhoneNumber");
		newElementWithValue(phoneNumber, "CountryCode", String.valueOf(data.getPhoneNumber().getCountryCode()));
		newElementWithValue(phoneNumber, "PhoneNumberBase", String.valueOf(data.getPhoneNumber().getPhone()));
		newClient.appendChild(phoneNumber);
		
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
	
	protected ClientData dataFromElement(Element client) throws NumberFormatException, AmbiguousElementSelectionException, ElementNotFoundException {
		long clientID = Integer.valueOf(nodeMethods.valueFromTagName(client, "ClientID"));
		String companyName = nodeMethods.valueFromTagName(client, "CompanyName");
		int countryCode = Integer.valueOf(nodeMethods.valueFromTagName(nodeMethods.singleElementFromTagName(client,"PhoneNumber"), "CountryCode"));
		int phoneNumber = Integer.valueOf(nodeMethods.valueFromTagName(nodeMethods.singleElementFromTagName(client,"PhoneNumber"), "PhoneBaseNumber"));
		String email = nodeMethods.valueFromTagName(client, "Email");
		List<List<String>> names = getNames(client);
		
		Element addressElement = nodeMethods.singleElementFromTagName(client, "Address");
		String streetName = nodeMethods.valueFromTagName(addressElement, "StreetName");
		int houseNumber = Integer.valueOf(nodeMethods.valueFromTagName(addressElement, "HouseNumber"));
		String city = nodeMethods.valueFromTagName(addressElement, "City");
		String zipCode = nodeMethods.valueFromTagName(addressElement, "ZipCode");
		
		NodeList activeShipmentsElements = nodeMethods.singleElementFromTagName(client, "ActiveShipments").getChildNodes();
		List<String> journeyIDStrings = getValuesFromChildNodes(activeShipmentsElements);
		List<Long> journeyIDs = new ArrayList<>();
		for (int i = 0; i < journeyIDStrings.size(); i++) {
			journeyIDs.add(Long.valueOf(journeyIDStrings.get(i)));
		}
		
		
		ClientData clientData = new ClientData(clientID, companyName, countryCode, phoneNumber, email, (ArrayList<String>) names.get(0), (ArrayList<String>) names.get(1), (ArrayList<String>) names.get(2), streetName, city, houseNumber, zipCode);
		
		
		return clientData;
	}

	public List<List<String>> getNames(Element client) throws AmbiguousElementSelectionException, ElementNotFoundException {
		List<List<String>> names = new ArrayList<List<String>>();
		
		Element namesElement = nodeMethods.singleElementFromTagName(client, "RefrencePersonName");
		
		NodeList firstNamesElements = namesElement.getElementsByTagName("FirstName");
		NodeList middleNamesElements = namesElement.getElementsByTagName("MiddleName");
		NodeList lastNamesElements = namesElement.getElementsByTagName("LastName");
		List<NodeList> namesElementsList = new ArrayList<NodeList>(3);
		namesElementsList.set(0, firstNamesElements);
		namesElementsList.set(1, middleNamesElements);
		namesElementsList.set(2, lastNamesElements);
		
		for(int i = 0; i < 3; i++) {
			NodeList namesElements = namesElementsList.get(i);
			names.add(getValuesFromChildNodes(namesElements));
		}
		return names;
	}
	
	public List<String> getValuesFromChildNodes(NodeList childNodes){
		List<String> values = new ArrayList<String>();
		int childNodesLen = childNodes.getLength();
		for(int i = 0; i < childNodesLen; i++) {
			values.add(childNodes.item(i).getTextContent());
		}
		return values;
	}
}

