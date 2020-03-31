package dataAccess;

import objectsData.ObjectData;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.*;
import org.w3c.dom.*;

import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;

public class DataAccess<T extends ObjectData> {
	String filePath;
	File schemaFile;
	Document doc;
	Schema schema;
	
	
	DataAccess(String fileName) {
		filePath = fileName;
		
		try {
			
		//SchemaFactory schemaFactory = SchemaFactory.newDefaultInstance();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		
		File dataBase = new File(filePath);
		//schemaFile = new File("storage/activeData/dataStructure.xsd");
		
		//schema = schemaFactory.newSchema(schemaFile);
		//dbFactory.setSchema(schema);
		
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(dataBase);
		doc.getDocumentElement().normalize();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void newEntry(T data) throws AmbiguousElementSelectionException {
		Element root = doc.getDocumentElement();
		
		Element newEntry = elementFromData(data);
		
		NodeList elements = root.getChildNodes();
		
		
		if( NodeMethods.needsToBeInsertedAtEnd(elements, newEntry)) {
			root.appendChild(newEntry);
		}
		else {
			NodeMethods.insertElement(newEntry, root);
		}
		
		transform();
	}
	
	public void editEntry(T data) throws ElementNotFoundException {
		Element root = doc.getDocumentElement();
		Element oldEntry;
		Element newEntry = elementFromData(data);
		
		oldEntry = NodeMethods.getElementFromID(NodeMethods.getElementID(newEntry), root);
		root.replaceChild(newEntry, oldEntry);
		
		transform();
	}
	
	public void deleteEntry(long ID) throws DOMException, ElementNotFoundException {
		Element root = doc.getDocumentElement();
		
		root.removeChild(NodeMethods.getElementFromID(ID, root));
		
		transform();
	}
	
	public T getEntry(long ID) throws ElementNotFoundException, NumberFormatException, AmbiguousElementSelectionException {
		Element entry = NodeMethods.getElementFromID(ID, doc.getDocumentElement());
		
		T data = dataFromElement(entry);
		
		return data;
	}
	
	public Element getRoot() { //Mostly for testing
		return doc.getDocumentElement();
	}
	
	//---------HELPER METHODS(protected visibility)----------
	protected void newElementWithValue(Element parentElement, String elementName, String elementValue) {
		Element element = doc.createElement(elementName);
		Text valueNode = doc.createTextNode(String.valueOf(elementValue));
		
		element.appendChild(valueNode);
		parentElement.appendChild(element);
	}
	
	protected void transform() throws TransformerFactoryConfigurationError {
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
	
	protected Element elementFromData(T data) {
		return null;
	}
	
	protected T dataFromElement(Element element) throws NumberFormatException, AmbiguousElementSelectionException, ElementNotFoundException {
		return null;
	}
}
