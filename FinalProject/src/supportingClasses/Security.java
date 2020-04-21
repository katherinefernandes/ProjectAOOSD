package supportingClasses;
 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream; 
import java.util.ArrayList;

public class Security {	
	//try generating ID in chaotic order
	private long ID; 
	public long generateID()  {
		ID = System.nanoTime();  
		return ID;
	}   	
}