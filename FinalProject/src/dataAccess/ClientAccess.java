package dataAccess;

import objectsData.ClientData;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.validation.*;
import org.w3c.dom.*;


public class ClientAccess extends DataAccess<ClientData> {

	ClientAccess() {
		super("storage/clients.xml");
	}
	
	public void newEntry(ClientData data) {
		Element root = doc.getDocumentElement();
		NodeList clients = root.getChildNodes();
		
		Element newClient = doc.createElement("Client");
		
	}

	public void editEntry(ClientData data) {
		
	}

	public ClientData getEntry(int ID) {
		return null;
	}

}
