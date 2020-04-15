package acceptanceTests.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectsData.ContainerData;
import supportingClasses.ValidInput;
import users.CurrentClientV2;

public class CurrentClientV2Steps {
	private CurrentClientV2 clientmanager;
	private int countryCode;
	private long phone;
	private ValidInput validate =new ValidInput();
	private String email;
	private ArrayList<String> firstName =new ArrayList<String>();
	private ArrayList<String> middleName =new ArrayList<String>();
	private ArrayList<String> lastName =new ArrayList<String>();
	
	@Given("that the client enters the ID {long} that exists in the memory")
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
	

	@When("the client decides to update its phone number")
	public void theClientDecidesToUpdateItsPhoneNumber() {
	    // Write code here that turns the phrase above into concrete actions
	    clientmanager.updatePhone();// this will set the updatedPhone to false
	    assertFalse("Updated phone should be set to false",clientmanager.getUpdatedPhone());

	}

	@When("provides the new country code {int} which is of the valid length")
	public void providesTheNewCountryCodeWhichIsOfTheValidLength(int countryCode) {
	    // Write code here that turns the phrase above into concrete actions
		this.countryCode=countryCode;
		assertTrue(validate.validateCountryCode(countryCode));
	}

	@When("provides the new phone number {long} which is also of the valid length")
	public void providesTheNewPhoneNumberWhichIsAlsoOfTheValidLength(long phone) {
	    // Write code here that turns the phrase above into concrete actions
		this.phone=phone;
		assertTrue(validate.validatePhone(phone));
	}

	@Then("the previous phone number and country code are replaced with the valid values")
	public void thePreviousPhoneNumberAndCountryCodeAreReplacedWithTheValidValues() {
	    // Write code here that turns the phrase above into concrete actions
	    clientmanager.updateClientInformation(this.countryCode,this.phone);
	    assertTrue("Should be true as the phonenumber has been updated",clientmanager.getUpdatedPhone());
	}
	
	@When("the client decides to update its email")
	public void theClientDecidesToUpdateItsEmail() {
	    // Write code here that turns the phrase above into concrete actions
	    clientmanager.updateEmail();//this sets the Updated email to true
	    assertFalse("This should be false as the email hasnt been updated yet",clientmanager.getUpdatedEmail());
	}

	@When("provides the new email {string} which is a valid email format")
	public void providesTheNewEmailWhichIsAValidEmailFormat(String email) {
	    // Write code here that turns the phrase above into concrete actions
		this.email=email;
		assertTrue(validate.validateEmail(email));
	}

	@Then("the previous email is replaced with the new valid email")
	public void thePreviousEmailIsReplacedWithTheNewValidEmail() {
	    // Write code here that turns the phrase above into concrete actions
	    clientmanager.updateClientInformation(this.email);
	    assertTrue("This should be true now as the email has been updated",clientmanager.getUpdatedEmail());
	    
	}

	@When("the client decides to update its reference person")
	public void theClientDecidesToUpdateItsReferencePerson() {
		// Write code here that turns the phrase above into concrete actions
		clientmanager.updateReferencePerson();// this sets the updatedReferenceperson to false
		assertFalse("Should be false as the information still needs to be updated",clientmanager.getUpdatedReferencePerson());
	}

	@When("provides the new firstname {string} which is valid")
	public void providesTheNewFirstnameWhichIsValid(String firstName) {
		// Write code here that turns the phrase above into concrete actions
		this.firstName.add(firstName);
		assertTrue(validate.validateName(firstName));
	}

	@When("provides the new middlename {string} which is also valid")
	public void providesTheNewMiddlenameWhichIsAlsoValid(String middleName) {
		// Write code here that turns the phrase above into concrete actions
		this.middleName.add(middleName);
		assertTrue(validate.validateName(middleName));
	}

	@When("provides the new lastname {string} which is also valid")
	public void providesTheNewLastnameWhichIsAlsoValid(String lastName) {
		// Write code here that turns the phrase above into concrete actions
		this.lastName.add(lastName);
		assertTrue(validate.validateName(lastName));
	}

	@Then("the previous reference person is replaced with the new information")
	public void thePreviousReferencePersonIsReplacedWithTheNewInformation() {
		// Write code here that turns the phrase above into concrete actions
		clientmanager.updateClientInformation(firstName,middleName,lastName);
		assertTrue("Should be true as the information has been changed",clientmanager.getUpdatedReferencePerson());
	}
	


}
