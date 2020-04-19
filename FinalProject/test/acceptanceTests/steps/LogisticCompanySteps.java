package acceptanceTests.steps;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectsData.ClientData;
import supportingClasses.ValidInput;
import supportingClasses.parseInput;
import users.LogisticCompanyV2;

public class LogisticCompanySteps {
	private ClientData client;
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
	private float temp;
	private float hum;
	private float press;
	
	@Given("the logistic Company enters the Client ID {long}")
	public void theLogisticCompanyEntersTheClientID(long clientID)  {
	    // Write code here that turns the phrase above into concrete actions
	    logistic.getClient(clientID);
	}

	/*@When("the Client ID is not present in the database")
	public void theClientIDIsNotPresentInTheDatabase() {
	    // Write code here that turns the phrase above into concrete actions
	    assertFalse(logistic.getSetClient());
	}*/

	/*@Then("the client information is not shown as that client doesnot exist")
	public void theClientInformationIsNotShownAsThatClientDoesnotExist() {
	    // Write code here that turns the phrase above into concrete actions
	    assertFalse(logistic.getSetClient());
	}*/
	@When("the Client ID is present in the database")
	public void theClientIDIsPresentInTheDatabase() {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(logistic.getSetClient());
	}

	@Then("the Client information is shown that the company name is {string}, the email is {string}")
	public void theClientInformationIsShownThatTheCompanyNameIsTheEmailIs(String name, String email) {
	    // Write code here that turns the phrase above into concrete actions
	  //  assertTrue(logistic.getDisplay());
	    client = logistic.viewClient();
	    assertTrue(logistic.getSetClient());
	    assertTrue(client.getCompanyName().equals(name));
	    assertTrue(client.getEmail().equals(email));
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
	    logistic.getContainer(this.containerid);
	    assertTrue(logistic.getSetContainer());
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

	@Given("the logistic Company decides to update the internal status of the container")
	public void theLogisticCompanyDecidesToUpdateTheInternalStatusOfTheContainer() {
	    // Write code here that turns the phrase above into concrete actions
		logistic.setUpdatedStatus();
	    assertFalse("Updated status should be set to false",logistic.getUpdatedStatus());
	}

	@When("the logistic Company enters the container ID {long}")
	public void theLogisticCompanyEntersTheContainerID(long id) {
	    // Write code here that turns the phrase above into concrete actions
		this.containerid = id;
		logistic.getContainer(id);
	    assertTrue(logistic.getSetContainer());
	}

	@When("the temperature value {float}")
	public void theTemperatureValue(float double1) {
	    // Write code here that turns the phrase above into concrete actions
		this.temp = double1;
	}

	@When("the humidity level value {float}%")
	public void theHumidityLevelValue(float double1) {
	    // Write code here that turns the phrase above into concrete actions
		this.hum = double1;
	}

	@When("the pressure value {float}atm")
	public void thePressureValueAtm(float double1) {
	    // Write code here that turns the phrase above into concrete actions
		this.press = double1;
	}

	@Then("the internal status of the container is updated")
	public void theInternalStatusOfTheContainerIsUpdated() {
	    // Write code here that turns the phrase above into concrete actions
	    logistic.updateStatus(temp, hum, press);
	    assertTrue("Updated status should be true now",logistic.getUpdatedStatus());
	}
	
}

