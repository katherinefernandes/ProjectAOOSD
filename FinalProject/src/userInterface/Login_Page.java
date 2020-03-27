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
	public void get_input() {
//		boolean found = false;
//		String templogin = "";
//		String tempPass = "";
		
		Scanner s = new Scanner (System.in);
		System.out.println("Enter LogIn :");
		this.username = s.nextLine();
		//I aded the if statement to only ask for password if the user is the logistic company 
		if(this.username == this.logistics_log) {   
			System.out.println("Enter Password : ");
			this.password = s.nextLine();
		}
		Login();
		s.close();
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
				System.out.println("temp log = "+templogin.trim()+"!="+ this.logistics_log);
				if(templogin.trim()==this.username && templogin.trim()!=this.logistics_log) {
					found=true; //we'll stop searching for the username					
				}
				else if(templogin.trim()=="admin" && tempPass.trim()!="admin") {
					System.out.println("fix this");
					
				}	
			}
			x.close();
			System.out.println("basbjabaus"+found);
		}
		
		catch(Exception e) {
			System.out.println("You enterent inconsistent information...try again ");
			System.out.println(e);
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