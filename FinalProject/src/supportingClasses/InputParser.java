package supportingClasses;

import java.util.ArrayList;
import java.util.Arrays;

public class InputParser {
	
	
	public static ArrayList<String> parsingNames(String name) {
		ArrayList<String> aList= new ArrayList<String>(Arrays.asList(name.split(" ")));
		return aList;
	}
}
