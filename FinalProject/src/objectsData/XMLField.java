package objectsData;

import java.util.*;

public class XMLField {
	private int valueType;
	private String tagName;
	private String value;
	private String valuesName;
	private List<String> values;
	private List<XMLField> compound;
	
	public XMLField(int valueType, String tagName) {
		this.valueType = valueType;
		this.tagName = tagName;
	}
	public XMLField(String tagName, String value) {
		this(0,tagName);
		try {
			setValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public XMLField(String tagName, String valuesName, List<String> values) {
		this(1,tagName);
		try {
			setValues(values,valuesName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public XMLField(String tagName, List<XMLField> fields) {
		this(2,tagName);
		try {
			setCompound(fields);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setValue(String string) throws Exception {
		if(valueType == 0) {
			value = string;
		}
		else {
			throw new Exception("Wrong valuetype");
		}
	}
	public void setValues(List<String> strings, String valuesName) throws Exception {
		if(valueType == 1) {
			this.valuesName = valuesName;
			values = strings;
		}
		else {
			throw new Exception("Wrong valuetype");
		}
	}
	public void addValue(String value) throws Exception {
		if(valueType == 1) {
			values.add(value);
		}
		else {
			throw new Exception("Wrong valuetype");
		}
	}
	public void setCompound(List<XMLField> fields) throws Exception {
		if(valueType == 2) {
			compound = fields;
		}
		else {
			throw new Exception("Wrong valuetype");
		}
	}
	public String getTagName() {
		return tagName;
	}
	public int getValueType() {
		return valueType;
	}
	public String getValue() throws Exception {
		if(valueType == 0) {
			return value;
		}
		else {
			throw new Exception("Wrong valuetype");
		}
	}
	public String getValuesName() throws Exception {
		if(valueType == 1) {
			return valuesName;
		}
		else {
			throw new Exception("Wrong valuetype");
		}
	}
	public List<String> getValues() throws Exception {
		if(valueType == 1) {
			return values;
		}
		else {
			throw new Exception("Wrong valuetype");
		}
	}
	public List<XMLField> getCompound() throws Exception {
		if(valueType == 2) {
			return compound;
		}
		else {
			throw new Exception("Wrong valuetype");
		}
	}
}
