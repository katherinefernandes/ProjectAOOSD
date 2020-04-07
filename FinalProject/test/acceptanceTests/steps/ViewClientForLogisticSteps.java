package acceptanceTests.steps;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Scanner;


import dataAccess.ClientAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectsData.ClientData;
import userInterface.Login_Page;
import users.LogisticCompany;

public class ViewClientForLogisticSteps {
	private Login_Page loginPage = new Login_Page();
	private Scanner s = new Scanner(System.in);
	private ClientData client;
	private ClientAccess clientDatabase = new ClientAccess();
	private LogisticCompany logistic = new LogisticCompany();
	
	@Given("that the logistic Company is logged in")
	public void that_the_logistic_Company_is_logged_in() {
		loginPage.set_username("admin");
		loginPage.set_password("admin");
		loginPage.Login(s);
		assertTrue(loginPage.status());
	}
	
	@When("the logistic Company decides to view the Client information")
	public void the_logistic_Company_decides_to_view_the_Client_information(){
	    // Write code here that turns the phrase above into concrete actions
		assertTrue("Should be true", logistic.getDisplay());
	}
	
	@When("provides the client ID {long}")
	public void provides_the_client_ID(long ID) {
	    // Write code here that turns the phrase above into concrete actions
		try {
			client = clientDatabase.getEntry(ID);
		} catch (NumberFormatException | ElementNotFoundException| AmbiguousElementSelectionException e) {
			// TODO Auto-generated catch block
			System.out.println("ID not found in the database");
		}
		assertEquals(ID,client.getClientID());
	}
	
	@Then("the Client information is shown that the company name is {string}, the email is {string}")
	public void the_Client_information_is_shown_that_the_company_name_is_the_email_is(String name, String email) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(client.getCompanyName(),name);
		assertEquals(client.getEmail(),email);
	}
	@When("provides a Client ID {long}")
	public void providesAClientID(long ID) {
	    // Write code here that turns the phrase above into concrete actions
		
		 assertThrows(ElementNotFoundException.class,()->{clientDatabase.getEntry(ID);});
		
	}

	@Then("the client information is not shown")
	public void theClientInformationIsNotShown() {
	    // Write code here that turns the phrase above into concrete actions
		assertThrows(NullPointerException.class,()->{client.getCompanyName();});
	}


	
}

