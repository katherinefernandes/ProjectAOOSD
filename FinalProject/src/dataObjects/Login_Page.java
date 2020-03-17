package dataObjects;

import java.io.File;
import java.util.Scanner;

public class Login_Page {
	// the path takes the value of the file context where all the data is
	// I assume we will search for username and password are searched for in the file
    private static Scanner x;
	private String username;
	private String password;
    public Login_Page(){
    	Scanner s = new Scanner(System.in);
    	System.out.println("Enter your username: ");
    	String username = s.nextLine();
    	System.out.println("Enter your password: ");
    	String password = s.nextLine();
    	
    	
    	
    	
    	
    }
    
	public void get_input(String username, String password, String path) {
		this.username=username;
		this.password= password;
		boolean searching = true;
		String templogin = "";
		String tempPass = "";
		
		try {
			//this thing is going to read the file where we store the username/ids/any info from the customers
			x = new Scanner (new File(path));
			x.useDelimiter("[,\n]"); //inbuilt method to separate the info in the text file, reads till a comma or till a new line
			//time to loop through the txt file to check for the username and password
			while(x.hasNext() && searching) {
				templogin = x.next();
				tempPass = x.next();
				if(templogin.trim()==username.trim() && tempPass.trim()==password.trim()) {
					searching=false; //we'll stop searching for the username
					
					
				}
				
				
			}
			
			
			
		}
		
		catch(Exception e) {
			
		}
		
		
		}
}
