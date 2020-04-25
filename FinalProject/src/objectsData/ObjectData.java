package objectsData;

import java.util.ArrayList;
import java.util.List;

import dataBase.DataBase;
import xmlParser.XMLField;

//TODO general problem with all subclasses: they don't follow open-close or single responsibility
//-open-close because adding more datafields to a class means changing code in multiple classes and methods
//-single responsibility because time updated is assigned automatically, which shouldn't be the job of these
//classes which should be seen as capsules of data as well as methods for parsing and converting that data.
public abstract class ObjectData implements ObjectDataInterface{
	protected List<XMLField> xmlFields;
	protected String tagName;
	
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
	
	public List<XMLField> getXML() {
		return xmlFields;
	}
	
	public String getTagname() {
		return tagName;
	}
	
	public boolean valuesContainSearchWord(String searchWord) {
		for(String value : dumpValues()) {
			if(value.contains(searchWord)) {
				return true;
			}
		}
		return false;
	}
	
	protected int indexOfTagname(List<XMLField> fields, String tagname) {
		int index = 0;
		while(!fields.get(index).getTagName().equals(tagname)) {
			index++;
		}
		return index;
	}
	
	//TODO remove switch and output argument
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
}
