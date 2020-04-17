package objectsData;

import java.util.ArrayList;
import java.util.List;

public interface ObjectDataInterface {
	public List<String> dumpValues();
	public boolean valuesContainSearchWord(String searchWord);
	public List<XMLField> getXML();
	public String getTagname();
}
