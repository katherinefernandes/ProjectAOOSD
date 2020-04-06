package acceptanceTests.steps;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import cucumber.api.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import userInterface.Login_Page;

public class ViewClientSteps {
	private Login_Page loginPage = new Login_Page();
	private Scanner s = new Scanner(System.in);
	@Given("that the logistic Company is logged in")
	public void that_the_logistic_Company_is_logged_in() {
		loginPage.set_username("admin");
		loginPage.set_password("admin");
		loginPage.Login(s);
		assertTrue(loginPage.status());
	}
	
	@When("the logistic Company decides to view the Client information")
	public void the_logistic_Company_decides_to_view_the_Client_information() {
	    // Write code here that turns the phrase above into concrete actions
	    throw  new PendingException();
	}
	
	@When("provides the client ID {string}")
	public void provides_the_client_ID(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("the Client information is shown that the company name is {string}, the email is {string}")
	public void the_Client_information_is_shown_that_the_company_name_is_the_email_is(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}

