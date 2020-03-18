package dataObjects;
import java.util.Scanner; 

public class LogisticCompany {
	public void addClient () {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Name: ");
		String name = s.nextLine();
		
		System.out.println("E-mail: ");
		String email = s.nextLine();
		
		System.out.println("Phone number: ");
		String phone = s.nextLine();
		
		System.out.println("Reference person: ");
		String person = s.nextLine();
		
		System.out.println("Address: ");
		String address = s.nextLine();
		
		//enter the generate ID
		
		accessClient.addData(name, email, phone, address, id);
		s.close();
	}
	
	public void getInfoClient() {
		
	}
	
	public void updateContainer() {
		
	}
	
	public void getInfoContainer() {
		
	}
}
