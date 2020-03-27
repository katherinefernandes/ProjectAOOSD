package dataAccess;

import objectsData.ObjectData;

import java.io.*;
import java.util.List;

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
	NodeMethods nodeMethods;
	File schemaFile;
	Document doc;
	Schema schema;
	
	
	DataAccess(String fileName) {
		filePath = fileName;
		nodeMethods = new NodeMethods();
		
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
	
	public void newEntry(T data) {
		
	}
	
	public void editEntry(T data) throws ElementNotFoundException {
		
	}
	
	public void deleteEntry(long ID) throws DOMException, ElementNotFoundException {
		
	}
	
	public T getEntry(long ID) throws ElementNotFoundException, NumberFormatException, AmbiguousElementSelectionException {
		return null;
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
	
	protected void insertElement(Element newElement, Element root) {
		long newElementID = nodeMethods.getElementID(newElement);
		NodeList elements = root.getChildNodes();
		int elementsLen = elements.getLength();
		int insertionIndex;
		
		if(elementsLen > 0) {
			insertionIndex = searchSupremum(elements,newElementID);
		}
		else {
			insertionIndex = 1;
		}
		
		if (insertionIndex < elementsLen) {
			root.insertBefore(newElement, elements.item(insertionIndex));
		}
		else {
			root.appendChild(newElement);
		}
	}
	
	protected Element getElementFromID(long ID, Element root) throws ElementNotFoundException {
		NodeList nodes = root.getChildNodes();
		int nodesLen = nodes.getLength();
		Node closestNode;
		
		if (nodesLen == 0 || nodeMethods.getElementID((Element) (closestNode = nodes.item(searchSupremum(nodes, ID)))) != ID) {
			throw new ElementNotFoundException("Element with given ID not found");
		}

		return (Element) closestNode;
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
	//--------HELPER HELPER METHODS(private visibility)---------
	public int searchSupremum(NodeList nodes, long ID) {
		int lower = 0;
		int upper = nodes.getLength() - 1;
		int index = (lower + upper)/2;
		long curID;
		
		while (lower < upper) {
			
			curID = nodeMethods.getElementID((Element) nodes.item(index));
			if(curID < ID) {
				lower = index + 1;
			}
			else if(curID > ID) {
				upper = index - 1;
			}
			else {
				upper = index;
				lower = index;
			}
			index = (lower + upper)/2;
		}
		curID = nodeMethods.getElementID((Element) nodes.item(index));
		if (index == -1) {
			return 0;
		}if (ID > curID) {
			return index + 1;
		}
		return index;
	}
}
