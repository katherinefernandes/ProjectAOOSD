package dataAccess;

import objectsData.ObjectData;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.validation.*;
import org.w3c.dom.*;

public class DataAccess<T extends ObjectData> {
	File dataBase;
	File schemaFile;
	Document doc;
	Schema schema;
	
	DataAccess(String fileName) {
		try {
			SchemaFactory schemaFactory = SchemaFactory.newDefaultInstance();
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			
			dataBase = new File(fileName);
			schemaFile = new File("storage/dataStructure.xsd");
			
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
	
	public T getEntry(long ID) {
		return null;
	}
}
