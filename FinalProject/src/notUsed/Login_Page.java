package notUsed;

import java.io.File;
import java.util.Scanner;
public class Login_Page {
	private boolean found = false;
	private String templogin = "";
	private String username;
	private String password;
	private String logistics_log = "admin";
	private boolean LCompany = false;
	public void set_username(String username) {
		this.username = username;
	}
	public void set_password(String password) {
		this.password = password;
	}
	
	
	public long get_username() {
		return Long.parseLong(username);	
	}

	public void get_input(Scanner s) {
		
		System.out.println("Enter LogIn :");
		this.username = s.nextLine();
		if(this.username.contentEquals(this.logistics_log)) {   
			System.out.println("Enter Password : ");
			this.password = s.nextLine();
		}
		Login(s);
	}
	public void Login(Scanner s) {
		
		try {
			Scanner x = new Scanner (new File("output.txt"));
			x.useDelimiter(",");
			while(!found) {
				templogin = x.next();
				if(templogin.trim().equals(this.username.trim()) && templogin.trim()!=this.logistics_log) {
					found=true;				
				}
				else if(this.username.equals(this.logistics_log) && this.password.contentEquals(this.logistics_log)) {
					found=true;
					
				}	
			}
			x.close();
		}
		catch(Exception e) {
			System.out.println("You entered inconsistent information...try again ");
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