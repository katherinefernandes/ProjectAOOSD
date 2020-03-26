package dataAccess;

import java.io.File;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;

public class NodeMethods {
	public NodeMethods() {
	}

	public int getElementID(Element element) {
		return Integer.parseInt(element.getChildNodes().item(0).getTextContent());
	}

	public String valueFromTagName(Element root, String tagName) throws AmbiguousElementSelectionException, ElementNotFoundException {
		Element element = singleElementFromTagName(root, tagName);
		return element.getTextContent();
	}

	public Element singleElementFromTagName(Element root, String tagName)
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
}