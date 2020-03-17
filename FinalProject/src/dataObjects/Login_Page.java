package dataObjects;

import java.util.Scanner;

public class Login_Page {
	// the path takes the value of the file context where all the data is
	// I assume we will search for username and password are searched for in the file
    private static Scanner x;
	public void get_input(String username, String password, String path) {
		boolean searching = false;
		String templogin = "";
		String tempPass = "";
		
		try {
			x = new Scanner (new File(path));
			
			
		}
		
		catch(Exception e) {
			
		}
		
		
		}
}
