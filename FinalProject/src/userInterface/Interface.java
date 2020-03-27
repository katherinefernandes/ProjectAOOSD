package userInterface;
import javax.swing.JButton;
import javax.swing.JFrame;
import users.CurrentClient;
import users.LogisticCompany;

public class Interface {
	//test if my git is working
	
	public void get_ClientMenu() {
		System.out.println("+--------------------------+");
		System.out.println("|Welcome to the Client Menu|");
		System.out.println("+--------------------------+");
		CurrentClient c = new CurrentClient();
		c.getInfoClient();
		System.out.println("/n");
		System.out.println("+----------------------------+");
		System.out.println("/n");
		button();
		System.out.println("/n");
		System.out.println("+----------------------------+");
		c.updateInfoClient();
		System.out.println("+----------------------------+");		
	}
	
	public void get_LogisticMenu() {
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
	
	public void load_Menu() {
		Login_Page L = new Login_Page();
		L.get_input();
		try {
//		L.get_input();
		if (L.status() == true) {
			get_LogisticMenu();
		}
		else if(L.status()==false && L.found_information() == true){
			get_ClientMenu(); //I hope this line doesn't just load the menu without the password input 
		}
		PrintDisplay();
		}
		
		catch(Exception e){   // here we need to find a exception but didn't think of one yet
			System.out.println("Sorry something went wrong, try again in a couple of minutes");
			L.get_input();
		}		
	}
	
	private void button() { //this will be a button :D doesn't work yet 
		JFrame f=new JFrame("Button Example");  
	    JButton b=new JButton("UpdateInfo");  
	    b.setBounds(50,100,95,30);  
	    f.add(b);  
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);   
	}  
			
	private void PrintDisplay() {
		// the nice display that we will implement later on 		
	}
			
public static void main(String[] args) 
    {
	Interface I = new Interface();
	I.load_Menu();
	}

}


