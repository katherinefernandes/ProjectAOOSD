package userInterface;

import java.io.File;
import java.util.Scanner;
class Login_Page {
	// the path takes the value of the file context where all the data is
	// I assume we will search for username and password are searched for in the file
	boolean found = false;
	String templogin = "";
	String tempPass = "";
	String username;
	String password;
	String logistics_log = "admin";
	public boolean LCompany = false;
	public Scanner s;
	public Login_Page(Scanner s) {
		this.s=s;
	}
	public void get_input() {
//		boolean found = false;
//		String templogin = "";
//		String tempPass = "";
		
	//	Scanner s = new Scanner (System.in);
		
		System.out.println("Enter LogIn :");
		this.username = s.nextLine();
		//I aded the if statement to only ask for password if the user is the logistic company 
		if(this.username.contentEquals(this.logistics_log)) {   
			System.out.println("Enter Password : ");
			this.password = s.nextLine();
			LCompany = true;
		}
		//s.close();
		Login();
	}
	
	public void Login() {
		
		try {
			//this thing is going to read the file where we store the username/ids/any info from the customers
			Scanner x = new Scanner (new File("/Users/daniela/Documents/GitHub/ProjectAOOSD/FinalProject/src/userInterface/passwords.txt"));
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
			System.out.println("You entered inconsistent information...try again ");
			get_input();
				
}	
	}
	
	public boolean found_information() {
		return found;
}
			
	public boolean status() {	
//		if (this.password.equals(this.logistics_log) && this.username.contentEquals(this.logistics_log)){
//			LCompany = true;
//		}
		return LCompany;
}
		
}