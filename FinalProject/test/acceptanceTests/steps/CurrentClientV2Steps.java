package acceptanceTests.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;

import containerFilters.FilterByCargoName;
import containerFilters.FilterByJourneyID;
import containerFilters.FilterByPortName;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectsData.ClientData;
import objectsData.ContainerData;
import supportingClasses.ValidInput;
import supportingClasses.parseInput;
import updateClientInformation.UpdateEmail;
import updateClientInformation.UpdatePhoneNumber;
import updateClientInformation.UpdateReferencePerson;
import users.CurrentClientV2;

public class CurrentClientV2Steps {
	private CurrentClientV2 clientmanager;
	private ClientData client;
	private int countryCode;
	private long phone;
	private ValidInput validate =new ValidInput();
	private String email;
	private ArrayList<String> firstName =new ArrayList<String>();
	private ArrayList<String> middleName =new ArrayList<String>();
	private ArrayList<String> lastName =new ArrayList<String>();
	private long startPortID;
	private long destinationPortID;
	private String cargo;
	private float temperature;
	private float pressure;
	private float humidity;
	private LocalDateTime arriveBy;
	private ContainerData container;
	private ArrayList<ContainerData> containersInJourney;
	
	@Given("that the client enters the ID {long} that exists in the memory")
	public void theIDItEnteredExistsInTheMemory(long ID) {
	    // Write code here that turns the phrase above into concrete actions
		clientmanager = new CurrentClientV2(ID);
		assertTrue(clientmanager.getSetClient());
	}
	
	@When("the client decides to view the client information")
	public void theClientDecidesToViewTheClientInformation() {
	    // Write code here that turns the phrase above into concrete actions
	//    clientmanager.getClient();
	    assertTrue(clientmanager.getSetClient());
	}

	@Then("the client information is shown that the company name is {string}, the email is {string}")
	public void theClientInformationIsShownThatTheCompanyNameIsTheEmailIs(String name, String email) {
	    // Write code here that turns the phrase above into concrete actions
	    client = clientmanager.viewClient();
	    assertTrue(client.getCompanyName().equals(name));
	    assertTrue(client.getEmail().equals(email));
	}

	@Then("the phonenumber is countrycode {int} phone {long}")
	public void thePhonenumberIsCountrycodePhone(int cc, long phone) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(client.getPhoneNumber().getCountryCode(),cc);
	    assertEquals(client.getPhoneNumber().getPhone(),phone);
	}

	@Then("the reference person is firstname {string} lastname {string}")
	public void theReferencePersonIsFirstnameLastname(String firstname, String lastname) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(parseInput.parsingNames(firstname).size(),client.getPerson().getFirstName().size());
	    assertEquals(parseInput.parsingNames(lastname).size(),client.getPerson().getLastName().size());
	}
	


	@When("the Client provides the new country code {int} which is of the valid length")
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
		UpdatePhoneNumber update = new UpdatePhoneNumber(this.countryCode,this.phone);
	    assertTrue("Should be true as the phonenumber has been updated",clientmanager.updateClientInformation(update));
	}
	

	@When("the client provides the new email {string} which is a valid email format")
	public void providesTheNewEmailWhichIsAValidEmailFormat(String email) {
	    // Write code here that turns the phrase above into concrete actions
		this.email=email;
		assertTrue(validate.validateEmail(email));
	}

	@Then("the previous email is replaced with the new valid email")
	public void thePreviousEmailIsReplacedWithTheNewValidEmail() {
		UpdateEmail update = new UpdateEmail(email);
	   assertTrue("This should be true now as the email has been updated",clientmanager.updateClientInformation(update));
	    
	}


	@When("the client provides the new firstname {string} which is valid")
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
		UpdateReferencePerson update = new UpdateReferencePerson(firstName,middleName,lastName);
		assertTrue("Should be true as the information has been changed",clientmanager.updateClientInformation(update));
	}
	
	@When("the client provides a port name {string} from where the journey will start")
	public void theClientProvidesAPortNameFromWhereTheJourneyWillStart(String portname) {
	    // Write code here that turns the phrase above into concrete actions
	    startPortID = clientmanager.getPortID(portname);
	    assertNotEquals(startPortID,1l);// the startPortID would be 1 if the portname is not valid
	    clientmanager.getAContainer(startPortID);
	    assertTrue(clientmanager.getFoundContainer());
	}

	@When("provides a destination port name {string}")
	public void providesADestinationPortName(String portname) {
	    // Write code here that turns the phrase above into concrete actions
		destinationPortID = clientmanager.getPortID(portname);
		assertNotEquals(destinationPortID,1l);// the startPortID would be 1 if the portname is not valid
		clientmanager.updateDestinationPort(destinationPortID);
	}

	@When("provides the name of the cargo {string} being transported")
	public void providesTheNameOfTheCargoBeingTransported(String cargo) {
	    // Write code here that turns the phrase above into concrete actions
	    this.cargo = cargo;
	    assertTrue(validate.validateName(cargo));
	}

	@When("provides the optimal internal state for the cargo which is {float} temperature, {float} atm pressure and {float}% humidity")
	public void providesTheOptimalInternalStateForTheCargoWhichIsTemperatureAtmPressureAndHumidity(float temperature, float pressure, float humidity) {
	    // Write code here that turns the phrase above into concrete actions
	    this.temperature= temperature;
	    this.pressure= pressure;
	    this.humidity = humidity;
	    //idk how to test them
	}

	@When("provides the expected arrival date which is {string}")
	public void providesTheExpectedArrivalDateWhichIs(String date) {
	    // Write code here that turns the phrase above into concrete actions
		//need a method to get a proper date..
	    arriveBy = LocalDateTime.now();
	}

	@Then("a container is registered for the journey and the client is provided with a container ID to track the journey.")
	public void aContainerIsRegisteredForTheJourneyAndTheClientIsProvidedWithAContainerIDToTrackTheJourney() {
	    // Write code here that turns the phrase above into concrete actions
	    clientmanager.registerContainer(startPortID,destinationPortID,cargo,temperature,pressure,humidity,arriveBy);
	    assertTrue(clientmanager.getContainerRegistered());
	    
	}
	
	@When("the client enters the container the ID {long} that exists in the database")
	public void theClientEntersTheContainerTheIDThatExistsInTheDatabase(long containerID) {
	    // Write code here that turns the phrase above into concrete actions
	    clientmanager.getContainer(containerID);
	    assertTrue(clientmanager.getSetContainer());
	}

	@Then("the current location of the container is {float} latitude and {float} longitude, it contains the cargo:{string}")
	public void theCurrentLocationOfTheContainerIsLatitudeAndLongitudeItContainsTheCargo(float latitude, float longitude, String cargo) {
	    // Write code here that turns the phrase above into concrete actions
		container = clientmanager.viewContainer();
		assertEquals((int)container.getCurrentPosition().getLatitude(),(int)latitude);
		assertEquals((int)container.getCurrentPosition().getlongitude(),(int)longitude);
		assertTrue(container.getCargo().equals(cargo));
	}

	@Then("it will arrive by the year {int} month {int} day {int} hour {int} minute {int}")
	public void itWillArriveByTheYearMonthDayHourMinute(int year, int month, int day, int hour, int minute) {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(container.getArriveBy().equals(LocalDateTime.of(year, month, day, hour, minute)));
	}

	@When("the client provides the port name {string}")
	public void theClientProvidesThePortName(String portname) {
	    // Write code here that turns the phrase above into concrete actions
	    startPortID = clientmanager.getPortID(portname);
	    assertNotEquals(startPortID,1l);
	}

	@Then("the client can view all the information for all his containers starting journey from that Port")
	public void theClientCanViewAllTheInformationForAllHisContainersStartingJourneyFromThatPort() {
	    // Write code here that turns the phrase above into concrete actions
		FilterByPortName filter = new FilterByPortName(clientmanager.viewClient(),startPortID);
		containersInJourney = clientmanager.getFilteredContainersOnAJourney(filter);
		for (int i=0;i<containersInJourney.size();i++) {
			assertEquals(containersInJourney.get(i).getStartPortID(),startPortID);
		}
	}
	@When("the client provides the cargo type {string}")
	public void theClientProvidesTheCargoType(String cargo) {
	    // Write code here that turns the phrase above into concrete actions
		this.cargo=cargo;
		FilterByCargoName filter = new FilterByCargoName(clientmanager.viewClient(),cargo);
		containersInJourney = clientmanager.getFilteredContainersOnAJourney(filter);
	}

	@Then("the client can view all the information for all those containers")
	public void theClientCanViewAllTheInformationForAllThoseContainers() {
	    // Write code here that turns the phrase above into concrete actions
		
		for (int i=0;i<containersInJourney.size();i++) {
			
			assertEquals(containersInJourney.get(i).getCargo(),cargo);
		}
	}
	@When("the client chooses to view the internal status of a container with the journeyID {long}")
	public void theClientChoosesToViewTheInternalStatusOfAContainerWithTheJourneyID(long journeyID) {
	    // Write code here that turns the phrase above into concrete actions
	    FilterByJourneyID filter = new FilterByJourneyID(clientmanager.viewClient(),journeyID);
	    container= clientmanager.getFilteredContainersOnAJourney(filter).get(0);
	}

	@Then("the client can view the current internal status of the container which is temperature {float}, pressure {float}, humidity level {float}")
	public void theClientCanViewTheCurrentInternalStatusOfTheContainerWhichIsTemperaturePressureHumidityLevel(float temperature, float pressure, float humidity) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals((int)container.getInternalStatus().getTemperature(),(int)temperature);
	    assertEquals((int)container.getInternalStatus().getAtmosphere(),(int)pressure);
	    assertSame((int)container.getInternalStatus().getHumidity(),(int)humidity);
	}

}

