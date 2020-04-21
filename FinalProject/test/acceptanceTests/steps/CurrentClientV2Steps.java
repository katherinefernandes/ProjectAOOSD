package acceptanceTests.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
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
	private String arriveBy;
	private ContainerData container;
	private ArrayList<ContainerData> containersInJourney;
	
	@Given("that the client enters the ID {long} that exists in the memory")
	public void theIDItEnteredExistsInTheMemory(long ID) {
		clientmanager = new CurrentClientV2(ID);
		assertTrue(clientmanager.getSetClient());
	}
	
	@When("the client decides to view the client information")
	public void theClientDecidesToViewTheClientInformation() {
	    assertTrue(clientmanager.getSetClient());
	}

	@Then("the client information is shown that the company name is {string}, the email is {string}")
	public void theClientInformationIsShownThatTheCompanyNameIsTheEmailIs(String name, String email) {
	    client = clientmanager.viewClient();
	    assertTrue(client.getCompanyName().equals(name));
	    assertTrue(client.getEmail().equals(email));
	}

	@Then("the phonenumber is countrycode {int} phone {long}")
	public void thePhonenumberIsCountrycodePhone(int cc, long phone) {
	    assertEquals(client.getPhoneNumber().getCountryCode(),cc);
	    assertEquals(client.getPhoneNumber().getPhone(),phone);
	}

	@Then("the reference person is firstname {string} lastname {string}")
	public void theReferencePersonIsFirstnameLastname(String firstname, String lastname) {
	    assertEquals(parseInput.parsingNames(firstname).size(),client.getPerson().getFirstName().size());
	    assertEquals(parseInput.parsingNames(lastname).size(),client.getPerson().getLastName().size());
	}
	


	@When("the Client provides the new country code {int} which is of the valid length")
	public void providesTheNewCountryCodeWhichIsOfTheValidLength(int countryCode) {
		this.countryCode=countryCode;
		assertTrue(validate.validateCountryCode(countryCode));
	}

	@When("provides the new phone number {long} which is also of the valid length")
	public void providesTheNewPhoneNumberWhichIsAlsoOfTheValidLength(long phone) {
		this.phone=phone;
		assertTrue(validate.validatePhone(phone));
	}

	@Then("the previous phone number and country code are replaced with the valid values")
	public void thePreviousPhoneNumberAndCountryCodeAreReplacedWithTheValidValues() {
		UpdatePhoneNumber update = new UpdatePhoneNumber(this.countryCode,this.phone);
	    assertTrue("Should be true as the phonenumber has been updated",clientmanager.updateClientInformation(update));
	}
	

	@When("the client provides the new email {string} which is a valid email format")
	public void providesTheNewEmailWhichIsAValidEmailFormat(String email) {
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
		this.firstName = parseInput.parsingNames(firstName);
		assertTrue(validate.validateName(firstName));
	}

	@When("provides the new middlename {string} which is also valid")
	public void providesTheNewMiddlenameWhichIsAlsoValid(String middleName) {
		this.middleName = parseInput.parsingNames(middleName);
		assertTrue(validate.validateName(middleName));
	}

	@When("provides the new lastname {string} which is also valid")
	public void providesTheNewLastnameWhichIsAlsoValid(String lastName) {
		this.lastName = parseInput.parsingNames(lastName);
		assertTrue(validate.validateName(lastName));
	}

	@Then("the previous reference person is replaced with the new information")
	public void thePreviousReferencePersonIsReplacedWithTheNewInformation() {
		UpdateReferencePerson update = new UpdateReferencePerson(firstName,middleName,lastName);
		assertTrue("Should be true as the information has been changed",clientmanager.updateClientInformation(update));
	}
	
	@When("the client provides a port name {string} from where the journey will start")
	public void theClientProvidesAPortNameFromWhereTheJourneyWillStart(String portname) {
	    startPortID = clientmanager.getPortID(portname);
	    assertNotEquals(startPortID,1l);// the startPortID would be 1 if the portname is not valid
	    clientmanager.getAContainer(startPortID);
	    assertTrue(clientmanager.getFoundContainer());
	}

	@When("provides a destination port name {string}")
	public void providesADestinationPortName(String portname) {
		destinationPortID = clientmanager.getPortID(portname);
		assertNotEquals(destinationPortID,1l);// the startPortID would be 1 if the portname is not valid
		clientmanager.updateDestinationPort(destinationPortID);
	}

	@When("provides the name of the cargo {string} being transported")
	public void providesTheNameOfTheCargoBeingTransported(String cargo) {
	    this.cargo = cargo;
	    assertTrue(validate.validateName(cargo));
	}

	@When("provides the optimal internal state for the cargo which is {float} temperature, {float} atm pressure and {float}% humidity")
	public void providesTheOptimalInternalStateForTheCargoWhichIsTemperatureAtmPressureAndHumidity(float temperature, float pressure, float humidity) {
	    this.temperature= temperature;
	    this.pressure= pressure;
	    this.humidity = humidity;
	}

	@When("provides the expected arrival date which is {string}")
	public void providesTheExpectedArrivalDateWhichIs(String date) {
		//need a method to get a proper date..
	    arriveBy = date;
	}

	@Then("a container is registered for the journey and the client is provided with a container ID to track the journey.")
	public void aContainerIsRegisteredForTheJourneyAndTheClientIsProvidedWithAContainerIDToTrackTheJourney() {
	    clientmanager.registerContainer(startPortID,destinationPortID,cargo,temperature,pressure,humidity,arriveBy);
	    assertTrue(clientmanager.getContainerRegistered());
	    
	}
	
	@When("the client enters the container the ID {long} that exists in the database")
	public void theClientEntersTheContainerTheIDThatExistsInTheDatabase(long containerID) {
	    clientmanager.getContainer(containerID);
	    assertTrue(clientmanager.getSetContainer());
	}

	@Then("the current location of the container is {float} latitude and {float} longitude, it contains the cargo:{string}")
	public void theCurrentLocationOfTheContainerIsLatitudeAndLongitudeItContainsTheCargo(float latitude, float longitude, String cargo) {
		container = clientmanager.viewContainer();
		assertEquals((int)container.getCurrentPosition().getLatitude(),(int)latitude);
		assertEquals((int)container.getCurrentPosition().getlongitude(),(int)longitude);
		assertTrue(container.getCargo().equals(cargo));
	}

	@Then("it will arrive by the date {string}")
	public void itWillArriveByTheYearMonthDayHourMinute(String date) {
	    System.out.println(container.getArriveBy());
	    System.out.println(parseInput.getDate(date));
		assertTrue(container.getArriveBy().equals(parseInput.getDate(date)));
	
	}

	@When("the client provides the port name {string}")
	public void theClientProvidesThePortName(String portname) {
	    startPortID = clientmanager.getPortID(portname);
	    assertNotEquals(startPortID,1l);
	}

	@Then("the client can view all the information for all his containers starting journey from that Port")
	public void theClientCanViewAllTheInformationForAllHisContainersStartingJourneyFromThatPort() {
		FilterByPortName filter = new FilterByPortName(clientmanager.viewClient(),startPortID);
		containersInJourney = clientmanager.getFilteredContainersOnAJourney(filter);
		for (int i=0;i<containersInJourney.size();i++) {
			assertEquals(containersInJourney.get(i).getStartPortID(),startPortID);
		}
	}
	
	@When("the client provides the cargo type {string}")
	public void theClientProvidesTheCargoType(String cargo) {

		this.cargo=cargo;
		FilterByCargoName filter = new FilterByCargoName(clientmanager.viewClient(),cargo);
		containersInJourney = clientmanager.getFilteredContainersOnAJourney(filter);
	}

	@Then("the client can view all the information for all those containers")
	public void theClientCanViewAllTheInformationForAllThoseContainers() {
		
		for (int i=0;i<containersInJourney.size();i++) {
			assertEquals(containersInJourney.get(i).getCargo(),cargo);
		}
	}
	
	@When("the client chooses to view the internal status of a container with the journeyID {long}")
	public void theClientChoosesToViewTheInternalStatusOfAContainerWithTheJourneyID(long journeyID) {
	    FilterByJourneyID filter = new FilterByJourneyID(clientmanager.viewClient(),journeyID);
	    container= clientmanager.getFilteredContainersOnAJourney(filter).get(0);
	}

	@Then("the client can view the current internal status of the container which is temperature {float}, pressure {float}, humidity level {float}")
	public void theClientCanViewTheCurrentInternalStatusOfTheContainerWhichIsTemperaturePressureHumidityLevel(float temperature, float pressure, float humidity) {
	    assertEquals((int)container.getInternalStatus().getTemperature(),(int)temperature);
	    assertEquals((int)container.getInternalStatus().getAtmosphere(),(int)pressure);
	    assertSame((int)container.getInternalStatus().getHumidity(),(int)humidity);
	}

}

