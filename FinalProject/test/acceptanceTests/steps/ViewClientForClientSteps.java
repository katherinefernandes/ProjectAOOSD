package acceptanceTests.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import userInterface.Login_Page;
import users.CurrentClientV2;

public class ViewClientForClientSteps {
	private Login_Page login = new Login_Page();
	private Scanner scan = new Scanner(System.in);
	private CurrentClientV2 clientmanager;
	
	
	@Given("that the client is logged in")
	public void thatTheClientIsLoggedIn() {
	    login.set_username("36836570081685");
	    login.Login(scan);
	    assertTrue(login.found_information());
	    assertFalse(login.status());
	}
	
	@Given("the ID {long} it entered exists in the memory")
	public void theIDItEnteredExistsInTheMemory(long ID) {
	    // Write code here that turns the phrase above into concrete actions
		clientmanager = new CurrentClientV2(ID);
		assertTrue(clientmanager.getClientIsSet());
	}
	
	@When("the client decides to view the client information")
	public void theClientDecidesToViewTheClientInformation() {
	    // Write code here that turns the phrase above into concrete actions
		assertFalse("Should be false",clientmanager.getViewClient());
	    clientmanager.setViewClient(true);
	    assertTrue("Should be true as client has chosen to view its info",clientmanager.getViewClient());
	    
	}
	
	@Then("the client information is shown that the company name is {string}, the email is {string}")
	public void theClientInformationIsShownThatTheCompanyNameIsTheEmailIs(String name, String email) {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(clientmanager.viewClient());
		assertEquals(name,clientmanager.getClient().getCompanyName());
		assertEquals(email,clientmanager.getClient().getEmail());
		
	}
	

	@Then("the phonenumber is countrycode {int} phone {long}")
	public void thePhonenumberIsCountrycodePhone(int countrycode, long phone) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(phone,clientmanager.getClient().getPhoneNumber().getPhone());
		assertSame(countrycode,clientmanager.getClient().getPhoneNumber().getCountryCode());
	}
	
	@Then("the reference person is firstname {string} lastname {string}")
	public void theReferencePersonIsFirstnameLastname(String firstname, String lastname) {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(clientmanager.getClient().getPerson().getFirstName().contains(firstname));
		assertTrue(clientmanager.getClient().getPerson().getLastName().contains(lastname));
	}
}

