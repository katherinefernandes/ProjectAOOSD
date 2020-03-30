package dataAccess;

import objectsData.*;

import java.io.*;
import java.util.*;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;

public class ContainerAccess extends DataAccess<ContainerData> {
	
	 ContainerAccess() {
		super("storage/activeData/containers.xml");
	}
	
	public Element elementFromData(ContainerData data) {
		
		
		return null;
	}
	
	public ContainerData dataFromElement(Element element) {
		
		
		
		return null;
	}
}
