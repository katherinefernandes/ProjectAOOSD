package userInterface;
import java.util.Scanner;

import users.CurrentClient;
import users.LogisticCompany;

public class Interface {
	
	public static void get_ClientMenu(Scanner sc) {
		Boolean quit = false;
		int Option;
		System.out.println("+--------------------------+");
		System.out.println("|Welcome to the Client Menu|");
		System.out.println("+--------------------------+");
		
		do {
			CurrentClient c = new CurrentClient();
			//interactive menu to give the user the choice
			System.out.println("1. Get the client Information");
			System.out.println("2. Update the current client Information");
			System.out.println("3. Add a new journey");
			System.out.println("4. View Internal Status of a Journey");
			
			System.out.println("0. Quit");
			
			System.out.println("Choose an option: ");
			Option = sc.nextInt();
			switch(Option) {
			case 1:
				System.out.println("Get the client Information");
			    c.getInfoClient(sc);
			    break;
			    
			    
			case 2:
				System.out.println("Update the current client Information");
				c.updateInfoClient(sc);
				break;
				
				
			case 3:
				System.out.println("Add a new journey");
				c.addJourney(sc);
				break;
				
			case 4:
				System.out.println("View Internal Status of a Journey");
				c.viewInternalStatusOfAJourney(sc);
				break;
				
			case 0:
				quit = true;
				break;
				
			default:
				System.out.println("Invalid choice.");	
			
			}
			
		} while(!quit);
		System.out.println("Exiting menu");
		System.out.println("\n");
		System.out.println("+----------------------------+");
		System.out.println("+----------------------------+");
	}
	
	public static void get_LogisticMenu(Scanner sc) {
		Boolean quit = false;
		int Option;
		System.out.println("+-------------------------------------+");
		System.out.println("|Welcome to the Logistics Company Menu| ");
		System.out.println("+-------------------------------------+");
		LogisticCompany l = new LogisticCompany();
		
		do {
			System.out.println("1. Add a new Client");
			System.out.println("2. Get client Information");
			System.out.println("3. Update container Information");
			System.out.println("4. Get Containter Information");
			System.out.println("0. Quit");
			System.out.println("Choose an option: ");
			
			Option = sc.nextInt();
			switch(Option) {
			case 1:
				System.out.println("Add a new Client");
			    l.addClient(sc);
			    break;
			    
			    
			case 2:
				CurrentClient c = new CurrentClient();
				System.out.println("Get client Information");
				c.getInfoClient(sc);
				break;
				
				
			case 3:
				System.out.println("Update container Information");
				l.updateContainer(sc);
				break;
			case 4:
				System.out.println("Get Containter Information");
				l.getInfoContainer(sc);
				break;
			case 0:
				quit = true;
				break;
				
			default:
				System.out.println("Invalid choice.");	
			
			}
			
		} while(!quit);
		System.out.println("Exiting menu");
	}
	
	
	public static void load_Menu() {
		Scanner sc = new Scanner(System.in);
		Login_Page L = new Login_Page();
		
		L.get_input(sc);
		try {
//		L.get_input();
		if (L.status() == true) {
			get_LogisticMenu(sc);
		}
		else if(L.status()==false && L.found_information() == true){
			get_ClientMenu(sc); //I hope this line doesn't just load the menu without the password input 
		}
		PrintDisplay();
		
		sc.close();
		}
		catch(Exception e){   // here we need to find a exception but didn't think of one yet
			System.out.println("Sorry something went wrong, try again in a couple of minutes");
			System.out.println(e.getMessage());
			e.printStackTrace();
			sc.close();
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


