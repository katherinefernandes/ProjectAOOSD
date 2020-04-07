package supportingClasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class Security {	
	//try generating ID in chaotic order
	private long ID; 
	public long generateID()  {
    	//we need to save the id in the txt file
//    	File file = new File("output.txt");
//    	FileOutputStream fos = new FileOutputStream(file);
//    	PrintStream ps = new PrintStream(fos);
//    	System.setOut(ps);
		ID = System.nanoTime();
		//long journeyID = System.nanoTime();
		//long containerID = System.nanoTime();
		//System.out.println("userID "+ userID);
		//System.out.println("journeyID "+ journeyID);
		//System.out.println("ID: "+ ID);
		
		return ID;
		
		
		
	
	
}    
	public void saveClientID(long ID) {
		BufferedWriter writer = null;
		try
		{
		    writer = new BufferedWriter( new FileWriter("output.txt"));
		    String output = Long.toString(ID);
		    writer.write(output);

		}
		catch ( IOException e)
		{
		}
		finally
		{
		    try
		    {
		        if ( writer != null)
		        writer.close( );
		    }
		    catch ( IOException e)
		    {
		    }
		}
	}
}