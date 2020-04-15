package acceptanceTests.steps;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;



import dataAccess.ClientAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectsData.ClientData;
import users.LogisticCompany;

public class LogisticCompanySteps {
	private ClientData client;
	private ClientAccess clientDatabase = new ClientAccess();
	private LogisticCompany logistic = new LogisticCompany();
		
	@Given("the logistic Company decides to view the Client information")
	public void the_logistic_Company_decides_to_view_the_Client_information(){
	    // Write code here that turns the phrase above into concrete actions
		assertTrue("Should be true", logistic.getDisplay());
	}
	
	@When("the logistic Company provides the client ID {long}")
	public void provides_the_client_ID(long ID) {
	    // Write code here that turns the phrase above into concrete actions
		try {
			client = clientDatabase.getEntry(ID);
		} catch (NumberFormatException | ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(ID,client.getID());
	}
	
	@Then("the Client information is shown that the company name is {string}, the email is {string}")
	public void the_Client_information_is_shown_that_the_company_name_is_the_email_is(String name, String email) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(client.getCompanyName(),name);
		assertEquals(client.getEmail(),email);
	}
	@When("the logistic Company provides a Client ID {long}")
	public void providesAClientID(long ID) {
	    // Write code here that turns the phrase above into concrete actions
		
		 assertThrows(ElementNotFoundException.class,()->{clientDatabase.getEntry(ID);});
		
	}

	@Then("the client information is not shown as the ID is not valid")
	public void theClientInformationIsNotShown() {
	    // Write code here that turns the phrase above into concrete actions
		assertThrows(NullPointerException.class,()->{client.getCompanyName();});
	}


	
}

