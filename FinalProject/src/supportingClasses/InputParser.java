package supportingClasses;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class InputParser {// need to test this class as well
	public static ArrayList<String> parsingNames(String name) {
		ArrayList<String> aList= new ArrayList<String>(Arrays.asList(name.split(" ")));
		return aList;
	}
	
	public static String getDate(LocalDateTime localDateTime) { //using this for generating last updated...
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
	    String formattedDate = localDateTime.format(myFormatObj);  
	    return formattedDate;
	}
	
	public static String getDate(LocalDate localDate) { //using this for generating last updated...
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
	    String formattedDate = localDate.format(myFormatObj);  
	    return formattedDate;
	}
}
