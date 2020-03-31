package supportingClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Security {	
	//try generating ID in chaotic order
	public long generateID()  {
    	//we need to save the id in the txt file
//    	File file = new File("output.txt");
//    	FileOutputStream fos = new FileOutputStream(file);
//    	PrintStream ps = new PrintStream(fos);
//    	System.setOut(ps);
		long ID = System.nanoTime();
		//long journeyID = System.nanoTime();
		//long containerID = System.nanoTime();
		//System.out.println("userID "+ userID);
		//System.out.println("journeyID "+ journeyID);
		//System.out.println("ID: "+ ID);
		
		return ID;
		
		
		//GIVES ERRORS
//		try {
//			File file = new File("output.txt");
//	    	FileOutputStream fos = new FileOutputStream(file);
//	    	PrintStream ps = new PrintStream(fos);
//	    	System.setOut(ps);
//	    	return ID;
//		} catch(FileNotFoundException e) {
//			return ID;
//		}
	
}    


//public static void main(String[] args) throws FileNotFoundException {
//	Security s = new Security();
//	s.get_ID();
////
////	
////	
////	
//}



}