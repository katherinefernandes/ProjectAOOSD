package acceptanceTests.steps;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectsData.ClientData;
import searchClients.SearchByName;
import supportingClasses.ValidInput;
import supportingClasses.parseInput;
import updateClientInformation.UpdateEmail;
import updateContainer.UpdateLocation;
import updateContainer.UpdateStatus;
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
	private SearchByName optionName;
	
	@Given("the logistic Company enters the Client ID {long}")
	public void theLogisticCompanyEntersTheClientID(long clientID)  {
	    logistic.getClient(clientID);
	}
	
	@When("the Client ID is present in the database")
	public void theClientIDIsPresentInTheDatabase() {
	    assertTrue(logistic.getSetClient());
	}

	@Then("the Client information is shown that the company name is {string}, the email is {string}")
	public void theClientInformationIsShownThatTheCompanyNameIsTheEmailIs(String name, String email) {
	    client = logistic.viewClient();
	    assertTrue(client.getCompanyName().equals(name));
	    assertTrue(client.getEmail().equals(email));
	}
	
	@Given("the logistic Company decides to add a new client")
	public void theLogisticCompanyDecidesToAddANewClient() {
		assertFalse(logistic.getAddNewClient());
	    logistic.setAddNewClient();   
	}

	@When("the client email is {string}")
	public void theClientEmailIs(String email) {
		assertTrue(validate.validateEmail(email));
		this.email = email;	
	}

	@When("the client name is {string}")
	public void theClientNameIs(String name) {
		this.name = name;
	}

	@When("the client phone number is {int} , {long}")
	public void theClientPhoneNumberIs(int cc, long phone) {
		assertTrue("the country code should be valid",validate.validateCountryCode(cc));
		assertTrue(validate.validatePhone(phone));
		
		this.countryCode = cc;
		this.phone = phone;
	}

	@When("the reference person is {string} {string} {string}")
	public void theReferencePersonIs(String name1, String name2, String name3) {
	   assertTrue(validate.validateName(name1));
	   assertTrue(validate.validateName(name2));
	   assertTrue(validate.validateName(name3));
	   
	   this.firstName = parseInput.parsingNames(name1);
	   this.middleName = parseInput.parsingNames(name2);
	   this.lastName = parseInput.parsingNames(name3);
	}

	@When("the address is street: {string} house number: {int} city: {string} zipcode: {string}")
	public void theAddressIsStreetHouseNumberCityZipcode(String street, int hNumber, String city, String zipcode) {
		assertTrue(validate.validateName(city));
		assertTrue(validate.validatePostCode(zipcode));
		
		this.street = street;
		this.houseNumber = hNumber;
		this.city = city;
		this.postCode = zipcode;
	   
	}

	@Then("a unique client ID is generated")
	public void aUniqueClientIDIsGenerated() {
		logistic.addClient(email, name, countryCode, phone, firstName, middleName, lastName, street, city, postCode, houseNumber);
		assertTrue(logistic.getAddNewClient());
	}
	

	@Given("that the logistic company enters the container ID {long}")
	public void thatTheLogisticCompanyEntersTheContainerID(long id) {
	    this.containerid = id;
	    logistic.getContainer(this.containerid);
	    assertTrue(logistic.getSetContainer());
	}

	@When("the latitude {float}")
	public void theLatitude(float double1) {
	    this.latitude = double1;
	    assertTrue(validate.validateLocation(double1));
	}

	@When("the longitude {float}")
	public void theLongitude(float double1) {
		this.longitude = double1;
		assertTrue(validate.validateLocation(double1));
	}

	@Then("the location for the container is updated")
	public void theLocationForTheContainerIsUpdated() {
		UpdateLocation update = new UpdateLocation(latitude, longitude);
		assertTrue("This should be true now as the location has been updated",logistic.updateContainerInformation(update));
	}

	@When("the temperature value {float}")
	public void theTemperatureValue(float double1) {
		this.temp = double1;
	}

	@When("the humidity level value {float}%")
	public void theHumidityLevelValue(float double1) {
		this.hum = double1;
	}

	@When("the pressure value {float}atm")
	public void thePressureValueAtm(float double1) {
		this.press = double1;
	}

	@Then("the internal status of the container is updated")
	public void theInternalStatusOfTheContainerIsUpdated() {
		UpdateStatus update = new UpdateStatus(press, temp, hum);
		assertTrue("This should be true now as the status has been updated",logistic.updateContainerInformation(update));
	}
	
	@Given("that the logistic company enters the client's name {string}")
	public void thatTheLogisticCompanyEntersTheClientSName(String searchName) {
	    // Write code here that turns the phrase above into concrete actions
	    optionName = new SearchByName(searchName);
	}

	@Then("the list of clients with this name should appear")
	public void theListOfClientsWithThisNameShouldAppear() {
	    assertNotEquals(logistic.search(optionName).size(), 0);
	}

}

