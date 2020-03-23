package dataAccess;

import objectsData.ObjectData;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.validation.*;
import org.w3c.dom.*;

public class DataAccess<T extends ObjectData> {
	String filePath;
	File dataBase;
	File schemaFile;
	Document doc;
	Schema schema;
	
	
	DataAccess(String fileName) {
		filePath = fileName;
		
		try {
			
		SchemaFactory schemaFactory = SchemaFactory.newDefaultInstance();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		
		dataBase = new File(filePath);
		schemaFile = new File("storage/activeData/dataStructure.xsd");
		
		schema = schemaFactory.newSchema(schemaFile);
		dbFactory.setSchema(schema);
		
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(dataBase);
		doc.getDocumentElement().normalize();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void newEntry(T data) {
		
	}
	
	public void editEntry(T data) {
		
	}
	
	public T getEntry(int ID) {
		return null;
	}
	
	
	//---------HELPER METHODS(protected visibility)----------
	protected void newElementWithValue(Element parentElement, String elementName, String elementValue) {
		Element element = doc.createElement(elementName);
		Text valueNode = doc.createTextNode(String.valueOf(elementValue));
		
		element.appendChild(valueNode);
		parentElement.appendChild(element);
	}
	
	protected int getElementID(Node node) {
		return Integer.parseInt(node.getChildNodes().item(0).getTextContent());
	}
	
	protected void insertElementSorted(Element root, Element newClient) {
		int newClientIDValue = getElementID(newClient);
		NodeList clients = root.getChildNodes();
		int lower = 0;
		int upper = clients.getLength() - 1;
		int index;
		int curID;
		
		do {
			index = (lower + upper)/2;
			
			curID = getElementID(clients.item(index));
			if(curID > newClientIDValue) {
				lower = index;
			}
			else if(curID < newClientIDValue) {
				upper = index;
			}
			else {
				upper = index;
				lower = index;
			}
		} while (Math.abs(lower - upper) >= 1);
		
		root.insertBefore(newClient, clients.item(upper));
	}
}
