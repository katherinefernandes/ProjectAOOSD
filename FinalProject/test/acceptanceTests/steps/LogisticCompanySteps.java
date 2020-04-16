package acceptanceTests.steps;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import dataAccess.ClientAccess;
import exceptions.AmbiguousElementSelectionException;
import exceptions.ElementNotFoundException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectsData.ClientData;
import supportingClasses.ValidInput;
import supportingClasses.parseInput;
import users.LogisticCompanyV2;

public class LogisticCompanySteps {
	private ClientData client;
	private ClientAccess clientDatabase = new ClientAccess();
	private LogisticCompanyV2 logistic = new LogisticCompanyV2();
	private ValidInput validate = new ValidInput();
	private String email;
	private String name;
	private int countryCode;
	private long phone;
	private ArrayList<String> firstName;
	private ArrayList<String> middleName;
	private ArrayList<String> lastName;
	private String street;
	private int houseNumber;
	private String city;
	private String postCode;
	private long containerid;
	private float latitude;
	private float longitude;
	
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

	@Given("the logistic Company decides to add a new client")
	public void theLogisticCompanyDecidesToAddANewClient() {
	    // Write code here that turns the phrase above into concrete actions
		assertFalse(logistic.getAddNewClient());
		
	    logistic.setAddNewClient();
	    
	    
	}

	@When("the client email is {string}")
	public void theClientEmailIs(String email) {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(validate.validateEmail(email));
		
		this.email = email;
		
		
	}

	@When("the client name is {string}")
	public void theClientNameIs(String name) {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(validate.validateName(name));
		
		this.name = name;
		
	}

	@When("the client phone number is {int} , {long}")
	public void theClientPhoneNumberIs(int cc, long phone) {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue("the country code should be valid",validate.validateCountryCode(cc));
		assertTrue(validate.validatePhone(phone));
		
		this.countryCode = cc;
		this.phone = phone;
		
	}

	@When("the reference person is {string} {string} {string}")
	public void theReferencePersonIs(String name1, String name2, String name3) {
	    // Write code here that turns the phrase above into concrete actions
	   assertTrue(validate.validateName(name1));
	   assertTrue(validate.validateName(name2));
	   assertTrue(validate.validateName(name3));
	   
	   this.firstName = parseInput.parsingNames(name1);
	   this.middleName = parseInput.parsingNames(name2);
	   this.lastName = parseInput.parsingNames(name3);
	}

	@When("the address is street: {string} house number: {int} city: {string} zipcode: {string}")
	public void theAddressIsStreetHouseNumberCityZipcode(String street, int hNumber, String city, String zipcode) {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(validate.validateStreet(street));
		assertTrue(validate.validateName(city));
		assertTrue(validate.validatePostCode(zipcode));
		
		this.street = street;
		this.houseNumber = hNumber;
		this.city = city;
		this.postCode = zipcode;
	   
	}

	@Then("a unique client ID is generated")
	public void aUniqueClientIDIsGenerated() {
	    // Write code here that turns the phrase above into concrete actions
		logistic.addClient(email, name, countryCode, phone, firstName, middleName, lastName, street, city, postCode, houseNumber);
		assertTrue(logistic.getAddNewClient());
	}
	
	@Given("that the logistic company chooses to update the location")
	public void thatTheLogisticCompanyChoosesToUpdateTheLocation() {
	    // Write code here that turns the phrase above into concrete actions
		logistic.setUpdatedLocation();
	    assertFalse("Updated location should be set to false",logistic.getUpdatedLocation());
	    
	}

	@When("the logistic company enters the container id {long}")
	public void theLogisticCompanyEntersTheContainerId(long id) {
	    // Write code here that turns the phrase above into concrete actions
	    this.containerid = id;
	    assertTrue(logistic.getContainerIsSet(id));
	}

	@When("the latitude {float}")
	public void theLatitude(float double1) {
	    // Write code here that turns the phrase above into concrete actions
	    this.latitude = double1;
	    assertTrue(validate.validateLocation(double1));
	}

	@When("the longitude {float}")
	public void theLongitude(float double1) {
	    // Write code here that turns the phrase above into concrete actions
		this.longitude = double1;
		assertTrue(validate.validateLocation(double1));
	}

	@Then("the location for the container is updated")
	public void theLocationForTheContainerIsUpdated() {
	    // Write code here that turns the phrase above into concrete actions
	    logistic.updateLocation(longitude, latitude);
	    assertTrue("Updated location should be true now",logistic.getUpdatedLocation());
	}
}

