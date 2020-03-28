package userInterface;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import users.CurrentClient;
import users.LogisticCompany;

public class Interface {
	
	public static void get_ClientMenu(Scanner sc) {
		System.out.println("+--------------------------+");
		System.out.println("|Welcome to the Client Menu|");
		System.out.println("+--------------------------+");
		CurrentClient c = new CurrentClient(sc);
		c.getInfoClient();
		System.out.println("/n");
		System.out.println("+----------------------------+");
		System.out.println("+----------------------------+");

		System.out.println("/n");
		button();
		System.out.println("/n");
		System.out.println("+----------------------------+");
		c.updateInfoClient();
		System.out.println("+----------------------------+");		
	}
	
	public static void get_LogisticMenu() {
		System.out.println("+-------------------------------------+");
		System.out.println("|Welcome to the Logistics Company Menu| ");
		System.out.println("+-------------------------------------+");
		LogisticCompany l = new LogisticCompany();
		l.getInfoClient();
		l.getInfoContainer();
		System.out.println("If you want add new Client------press button------");
		System.out.println("/n");
		button();
		System.out.println("/n");
		l.addClient();
		System.out.println("Click for updating the container information");
		System.out.println("/n");
		button();
		System.out.println("/n");
		l.updateContainer();
				
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
	private static void button() { //this will be a button :D doesn't work yet 
		JFrame f=new JFrame("Button prototype");  
	    JButton b=new JButton("UpdateInfo");  
	    b.setBounds(50,100,95,30);  
	    f.add(b);  
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);   
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


