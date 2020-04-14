package objectsData;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.XMLEvent;

public abstract class ObjectData{
	protected List<XMLField> xmlFields;
	protected String tagName;
	
	public abstract long getID();
	
	public List<String> dumpValues(){
		List<String> values = new ArrayList<>();
		try {
			for(XMLField field : xmlFields) {
				XMLvalues(values,field);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return values;
	}
	
	protected int indexOfTagname(List<XMLField> fields, String tagname) {
		int index = 0;
		while(!fields.get(index).getTagName().equals(tagname)) {
			index++;
		}
		return index;
	}
	
	private void XMLvalues(List<String> values,XMLField field) throws Exception {
		switch (field.getValueType()){
		case 0:
			values.add(field.getValue());
			return;
		
		case 1:
			for(String value : field.getValues()) {
				values.add(value);
			}
			return;
		case 2:
			for(XMLField xml : field.getCompound()) {
				XMLvalues(values,xml);
			}
			return;
		}
	}
	
	public List<XMLField> getXML() {
		return xmlFields;
	}
	
	public String getTagname() {
		return tagName;
	}
}
