package acceptanceTests.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateClientInformation {
	@When("the client decides to update its phone number")
	public void theClientDecidesToUpdateItsPhoneNumber() {
	    // Write code here that turns the phrase above into concrete actions
		
	}
	
	@When("provides the new country code {int} which is of the valid length")
	public void providesTheNewCountryCodeWhichIsOfTheValidLength(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	@When("provides the new phone number {int} which is also of the valid length")
	public void providesTheNewPhoneNumberWhichIsAlsoOfTheValidLength(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
	
	@Then("the previous phone number and country code are replaced with the valid values")
	public void thePreviousPhoneNumberAndCountryCodeAreReplacedWithTheValidValues() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
}

