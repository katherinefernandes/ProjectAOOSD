package supportingClasses;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class parseInput {
	public static ArrayList<String> parsingNames(String name) {
		ArrayList<String> aList= new ArrayList<String>(Arrays.asList(name.split(" ")));
		return aList;
	}
	/*public static void main(String[] args) {
		System.out.println(parsingNames("munaazam"));
	}*/ //mamuna-> I added this to test it out in console...
	
	
	public static String getDate(LocalDate myDateObj) {
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
	    
	    String formattedDate = myDateObj.format(myFormatObj);  
	    
	    return formattedDate;
	}
}
