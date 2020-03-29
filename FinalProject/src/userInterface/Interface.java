package userInterface;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import users.CurrentClient;
import users.LogisticCompany;

public class Interface {
	
	public static void get_ClientMenu(Scanner sc) {
		Boolean quit = false;
		int Option;
		System.out.println("+--------------------------+");
		System.out.println("|Welcome to the Client Menu|");
		System.out.println("+--------------------------+");
		CurrentClient c = new CurrentClient(sc);
		//interactive menu to give the user the choice
		Scanner menu = new Scanner(System.in);
		for(int i = 1 ; i <= 3 ; i++) {
			System.out.println(i+". Option "+i);
		}
		System.out.println("0. Quit");
		do {
			System.out.println("Choose an option: ");
			Option = menu.nextInt();
			switch(Option) {
			case 1:
				System.out.println("Get the client Information");
			    c.getInfoClient();
			    break;
			    
			    
			case 2:
				System.out.println("Update the current client Information");
				c.updateInfoClient();
				break;
				
				
			case 3:
				System.out.println("Add a new journey");
				c.addJourney();
				break;
				
			case 4:
				System.out.println("View Internal Status of a Journey");
				c.viewInternalStatusOfAJourney();
				break;
				
			case 0:
				quit = true;
				break;
				
			default:
				System.out.println("Invalid choice.");	
			
			}
			
		} while(!quit);
		System.out.println("Exiting menu");
		System.out.println("/n");
		System.out.println("+----------------------------+");
		System.out.println("+----------------------------+");
		menu.close();
	}
	
	public static void get_LogisticMenu() {
		Boolean quit = false;
		int Option;
		System.out.println("+-------------------------------------+");
		System.out.println("|Welcome to the Logistics Company Menu| ");
		System.out.println("+-------------------------------------+");
		LogisticCompany l = new LogisticCompany();
		Scanner m = new Scanner(System.in);
		for(int i = 1 ; i <= 3 ; i++) {
			System.out.println(i+". Option "+i);
		}
		System.out.println("0. Quit");
		do {
			System.out.println("Choose an option: ");
			Option = m.nextInt();
			switch(Option) {
			case 1:
				System.out.println("Option 1");
			    //call Muna's method

			    break;
			    
			    
			case 2:
				System.out.println("Option 2");
				//call Muna's method

				break;
				
				
			case 3:
				System.out.println("Option 3");
				//Call muna's method
				break;
			case 0:
				quit = true;
				break;
				
			default:
				System.out.println("Invalid choice.");	
			
			}
			
		} while(!quit);
		System.out.println("Exiting menu");
		m.close();
				
	}
	
	
	public static void load_Menu() {
		Scanner sc = new Scanner(System.in);
		Login_Page L = new Login_Page(sc);
		
		L.get_input();
		try {
//		L.get_input();
		if (L.status() == true) {
			get_LogisticMenu();
		}
		else if(L.status()==false && L.found_information() == true){
			get_ClientMenu(sc); //I hope this line doesn't just load the menu without the password input 
		}
		PrintDisplay();
		
		sc.close();
		}
		catch(Exception e){   // here we need to find a exception but didn't think of one yet
			System.out.println("Sorry something went wrong, try again in a couple of minutes");
			sc.close();
			System.out.println(e.getMessage());
	}
	}
			
	private static void PrintDisplay() {
		// the nice display that we will implement later on 		
	}
			
public static void main(String[] args) 
    {
	
	//Interface I = new Interface();
	load_Menu();
	}

}


