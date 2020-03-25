package userInterface;

import javax.swing.JButton;
import javax.swing.JFrame;

import dataAccess.DataAccess;
import objectsData.ClientData;
import users.CurrentClient;

public class Interface {
	
	public void get_ClientMenu() {
		System.out.println("Welcome to the Client Menu");
		CurrentClient c = new CurrentClient();
		c.getInfoClient();
		System.out.println("/n");
		button();
		c.updateInfoClient();
		
		
		
		
	}
	
	public void get_LogisticMenu() {
		// ask info from katherine
		System.out.println("Welcome to the Logistics Company Menu ");
		
		
		
		
		
	}
	
	public void load_Menu() {
		Login_Page L = new Login_Page();
		L.get_input();
		if (L.status() == true) {
			get_LogisticMenu();
		}
		else {
			get_ClientMenu(); //I hope this line doesn't just load the menu without the password input 
		}
		
		
		
	}
	
	private void button() {
		JFrame f=new JFrame("Button Example");  
	    JButton b=new JButton("UpdateInfo");  
	    b.setBounds(50,100,95,30);  
	    f.add(b);  
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	}  
		
		
	
	
	
public static void main(String[] args) 
    {
	Interface I = new Interface();
	I.load_Menu();
	}

}


