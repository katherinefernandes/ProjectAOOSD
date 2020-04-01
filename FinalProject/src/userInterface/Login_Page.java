package userInterface;

import java.io.File;
import java.util.Scanner;
class Login_Page {
	// the path takes the value of the file context where all the data is
	// I assume we will search for username and password are searched for in the file
	
	//mamuna -> I have changed all the attributes to private
	private boolean found = false;
	private String templogin = "";
	//private String tempPass = ""; //mamuna commented out as not being used.
	private String username;
	private String password;
	private String logistics_log = "admin";
	private boolean LCompany = false;

	public void get_input(Scanner s) {
//		boolean found = false;
//		String templogin = "";
//		String tempPass = "";
		
		System.out.println("Enter LogIn :");
		this.username = s.nextLine();
		//I aded the if statement to only ask for password if the user is the logistic company 
		if(this.username.contentEquals(this.logistics_log)) {   
			System.out.println("Enter Password : ");
			this.password = s.nextLine();
		}
		Login(s);
	}
	// mamuna ->I made login private 
	private void Login(Scanner s) {
		
		try {
			//this thing is going to read the file where we store the username/ids/any info from the customers
			Scanner x = new Scanner (new File("src/userInterface/passwords.txt"));
			x.useDelimiter(","); //inbuilt method to separate the info in the text file, reads till a comma or till a new line
			//time to loop through the txt file to check for the username and password
			//while(x.hasNext() && !found) {
			while(!found) {
				templogin = x.next();
				//System.out.println("temp="+templogin+" username="+this.username);
				//System.out.println(templogin.trim());
				//System.out.println(this.username.trim());
				if(templogin.trim().equals(this.username.trim()) && templogin.trim()!=this.logistics_log) {
					found=true; //we'll stop searching for the username					
				}
				else if(this.username.equals(this.logistics_log) && this.password.contentEquals(this.logistics_log)) {
					found=true;
					
				}	
			}
			x.close();
			//System.out.println(found);
		}
		
		
		catch(Exception e) {
			System.out.println("You enterent inconsistent information...try again ");
			get_input(s);
				
}	
	}
	
	public boolean found_information() {
		return found;
}
			
	public boolean status() {	
		if (this.username.contentEquals(this.logistics_log) && this.password.equals(this.logistics_log)){
			LCompany = true;
		}
		return LCompany;
}
		
}