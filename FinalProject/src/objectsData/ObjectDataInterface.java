package objectsData;

import java.util.ArrayList;
import java.util.List;

public interface ObjectDataInterface {
	public List<String> dumpValues(); //TODO change name
	public boolean valuesContainSearchWord(String searchWord);
	public List<XMLField> getXML();
	public String getTagname();
}
