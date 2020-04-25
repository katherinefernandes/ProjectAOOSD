package objectsData;

import java.util.ArrayList;
import java.util.List;

import xmlParser.XMLField;

public interface ObjectDataInterface {
	public List<String> dumpValues(); //TODO change name
	public boolean valuesContainSearchWord(String searchWord);
	public List<XMLField> getXML();
	public String getTagname();
	public void save();
}
