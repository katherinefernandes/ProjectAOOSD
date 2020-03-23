package dataObjects;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

class Security {	
	public long get_ID() throws FileNotFoundException {
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
		File file = new File("output.txt");
    	FileOutputStream fos = new FileOutputStream(file);
    	PrintStream ps = new PrintStream(fos);
    	System.setOut(ps);
		return ID;
	
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