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
	public boolean LCompany = false;
	public void get_input() {
//		boolean found = false;
//		String templogin = "";
//		String tempPass = "";
		
		Scanner s = new Scanner (System.in);
		System.out.println("Enter LogIn :");
		this.username = s.nextLine();
		System.out.println("Enter Password : ");
		this.password = s.nextLine();
		Login();
	}
	public void Login() {
		try {
			//this thing is going to read the file where we store the username/ids/any info from the customers
			Scanner x = new Scanner (new File("/Users/daniela/Documents/GitHub/ProjectAOOSD/FinalProject/storage/clients.xml "));
			x.useDelimiter("[,\n]"); //inbuilt method to separate the info in the text file, reads till a comma or till a new line
			//time to loop through the txt file to check for the username and password
			while(x.hasNext() && !found) {
				templogin = x.next();
				tempPass = x.next();
				if(templogin.trim()==username.trim() && tempPass.trim()==password.trim()) {
					found=true; //we'll stop searching for the username
					System.out.println("print");
				}
				
			System.out.println(found);	
			}
			x.close();
			System.out.println(found);
			
			
			
		}

		
		catch(Exception e) {
			System.out.println("Username and Password don't match");
			get_input();
			
			
		
}
	
	}
	
public boolean found_information() {
	return found;
}
	
		
public boolean status() {	
	if (tempPass.trim()=="admin" && templogin.trim()=="admin" ){
		LCompany = true;
	}
	return LCompany;


	

}
		
 


//
//public static void main (String[] args) {
//	Login_Page l = new Login_Page();
//	l.get_input();
//	
//}	
}