package dataAccess;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;

public class NodeMethods {

	public static long getElementID(Element element) {
		return Long.parseLong(element.getChildNodes().item(0).getTextContent());
	}

	public static String valueFromTagName(Element root, String tagName) throws AmbiguousElementSelectionException, ElementNotFoundException {
		Element element = singleElementFromTagName(root, tagName);
		return element.getTextContent();
	}

	public static Element singleElementFromTagName(Element root, String tagName)
			throws AmbiguousElementSelectionException, ElementNotFoundException {
		NodeList element = root.getElementsByTagName(tagName);
		if(element.getLength() > 1) {
			throw new AmbiguousElementSelectionException("Multiple elements with same tag name");
		}
		if(element.getLength() < 1) {
			throw new ElementNotFoundException("No element with that tag name");
		}
		return (Element) element.item(0);
	}
	
	public static List<String> getValuesFromChildNodes(NodeList childNodes){
		List<String> values = new ArrayList<String>();
		int childNodesLen = childNodes.getLength();
		for(int i = 0; i < childNodesLen; i++) {
			values.add(childNodes.item(i).getTextContent());
		}
		return values;
	}
	
	public static boolean needsToBeInsertedAtEnd(NodeList nodes, Element element) {
		long newNodeID = getElementID(element);
		int nodesLength = nodes.getLength();
		return (nodesLength == 0) || (newNodeID > getElementID((Element) nodes.item(nodesLength - 1)));
	}

	public static void insertElement(Element newElement, Element root) throws AmbiguousElementSelectionException {
		long newElementID = getElementID(newElement);
		NodeList elements = root.getChildNodes();
		int insertionIndex = searchSupremum(elements,newElementID);
		if(getElementID((Element) elements.item(insertionIndex)) == newElementID) {
			throw new AmbiguousElementSelectionException("Cannot insert existing element");
		}
		root.insertBefore(newElement, elements.item(insertionIndex));
	}

	public static int searchSupremum(NodeList nodes, long ID) {
		int lower = 0;
		int upper = nodes.getLength() - 1;
		int index = (lower + upper)/2;
		long curID;
		
		while (lower < upper) {
			
			curID = getElementID((Element) nodes.item(index));
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
		curID = getElementID((Element) nodes.item(index));
		
		if (ID > curID) {
			return index + 1;
		}
		return index;
	}
	
	

	public static Element getElementFromID(long ID, Element root) throws ElementNotFoundException {
		NodeList nodes = root.getChildNodes();
		int nodesLen = nodes.getLength();
		Node closestNode;
		
		if (nodesLen == 0 ||getElementID((Element) (closestNode = nodes.item(searchSupremum(nodes, ID)))) != ID) {
			throw new ElementNotFoundException("Element with given ID not found");
		}
	
		return (Element) closestNode;
	}
}