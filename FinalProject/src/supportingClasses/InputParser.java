package supportingClasses;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class InputParser { //TODO Class names should be upper case
	public static ArrayList<String> parsingNames(String name) {
		ArrayList<String> aList= new ArrayList<String>(Arrays.asList(name.split(" ")));
		return aList;
	}
	/*public static void main(String[] args) {
		System.out.println(parsingNames("munaazam"));
	}*/ //mamuna-> I added this to test it out in console...
	
	
	public static String getDate(String myDateObj) { //
		String [] date=myDateObj.split("-");
		LocalDate myDateObj2 = LocalDate.of(Integer.valueOf(date[2]),Integer.valueOf(date[1]),Integer.valueOf(date[0]));
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
	    String formattedDate = myDateObj2.format(myFormatObj);  
	    return formattedDate;
	}// this needs to be deleted.. instead have a validation for the date, need to make sure that the date>=localdate.now()
	public static String getDate(LocalDate myDateObj) { //using this for generating last updated...
		
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
	    String formattedDate = myDateObj.format(myFormatObj);  
	    return formattedDate;
	}

}
