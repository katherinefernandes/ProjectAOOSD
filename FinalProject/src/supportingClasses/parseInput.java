package supportingClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class parseInput {
	public static ArrayList<String> parsingNames(String name) {
		ArrayList<String> aList= new ArrayList<String>(Arrays.asList(name.split(" ")));
		return aList;
	}
	/*public static void main(String[] args) {
		System.out.println(parsingNames("munaazam"));
	}*/ //mamuna-> I added this to test it out in console...
}
