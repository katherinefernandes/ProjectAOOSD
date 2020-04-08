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
	
	private ArrayList<String> readFromFile() {
		    FileInputStream fis;
			try {
				fis = new FileInputStream("output.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);
				ArrayList<String> clientUsernames = (ArrayList<String>) ois.readObject();
				ois.close();
				return clientUsernames;
			} catch (Exception e) { 
				e.printStackTrace();
				return new ArrayList<String>();
			}
	}
	
	private void writeToFile(ArrayList<String> clientUsernames) { 
				FileOutputStream fos;
				try {
					fos = new FileOutputStream("output.txt");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(clientUsernames);
					oos.close();
				} catch (Exception e) { 
					e.printStackTrace();
				}  
	}
	
	public ArrayList<String> getClientIDs() {
		return readFromFile();
	}
	
	public void saveClientID(long ID) {
		ArrayList<String> clientUsernames = readFromFile();
		clientUsernames.add(Long.toString(ID));
		writeToFile(clientUsernames);
	}
}