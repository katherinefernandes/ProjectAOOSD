package acceptanceTests.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.function.Executable;

import XMLParser.ClientAccess;
import XMLParser.ContainerAccess;
import XMLParser.PortAccess;
import containerFilters.FilterByCargoName;
import containerFilters.FilterByJourneyID;
import containerFilters.FilterByPortName;
import containerFilters.FilteringContainersForAClient;
import exceptions.ElementNotFoundException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectsData.ClientData;
import objectsData.ContainerData;
import objectsData.PortData;
import supportingClasses.ValidInput;
import supportingClasses.parseInput;
import updateClientInformation.UpdateEmail;
import updateClientInformation.UpdatePhoneNumber;
import updateClientInformation.UpdateReferencePerson;
import users.CurrentClientV2;
import users.User;

public class CurrentClientV2Steps {
	private CurrentClientV2 clientApplication = new CurrentClientV2(828300261636100l);
	private ClientData client;
	private long containerID;
	private long journeyID;
	private long startPortID;
	private ClientAccess databaseClient = new ClientAccess();
	private ContainerAccess databaseContainer = new ContainerAccess();
	private long destinationPortID;
	private float latitude;
	private float longitude;
	private String cargo;
	private String arriveBy;
	private long clientID;
	private float pressure;
	private float temperature;
	private float humidity;
	private ArrayList<ContainerData> Containers;
	private PortAccess databasePort = new PortAccess();
	private String startportname;
	/*private ClientData client;
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
	private long clientID;
	private User user;
	private String errorMessage;
	
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
	    try {
			clientmanager.getContainer(containerID);
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Error(e);
		}
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
	}*/
	@Given("that the client with the ID {long} is logged into the clientApplication")
	public void thatTheClientWithTheIDIsLoggedIntoTheClientApplication(long clientID) {
	    // Write code here that turns the phrase above into concrete actions
		clientApplication = new CurrentClientV2(clientID);
		assertTrue(clientApplication.getSetClient());
	}

	@When("the client decides to view its own information")
	public void theClientDecidesToViewItsOwnInformation() {
	    // Write code here that turns the phrase above into concrete actions
		client = clientApplication.viewClient();
	}

	@Then("the client sees that the company name is {string}")
	public void theClientSeesThatTheCompanyNameIs(String companyname) {
	    // Write code here that turns the phrase above into concrete actions
		 assertTrue(client.getCompanyName().equals(companyname));
		   
	}

	@Then("that the email is {string}")
	public void thatTheEmailIs(String email) {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(client.getEmail().equals(email));
	}

	@Then("that the phonenumber is countrycode {int} phone {long}")
	public void thatThePhonenumberIsCountrycodePhone(int cc, long phone) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(client.getPhoneNumber().getCountryCode(),cc);
	    assertEquals(client.getPhoneNumber().getPhone(),phone);
	}

	@Then("that the reference person is firstname {string} lastname {string}")
	public void thatTheReferencePersonIsFirstnameLastname(String firstname, String lastname) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(parseInput.parsingNames(firstname).size(),client.getPerson().getFirstName().size());
	    assertEquals(parseInput.parsingNames(lastname).size(),client.getPerson().getLastName().size());
	}
	@Given("that there exists a client with ID {long}")
	public void thatThereExistsAClientWithID(long clientID) {
	    // Write code here that turns the phrase above into concrete actions
		this.clientID =clientID;
		client = new ClientData(this.clientID,"company",92,23789,"email@eh.com",parseInput.parsingNames("muna"),parseInput.parsingNames(""),parseInput.parsingNames("azam"),"g11/2","Islamabad",59,"2620");
		databaseClient.newEntry(client);
	}

	@Given("the client has a container with the journey ID {long} registered for a journey")
	public void theClientHasAContainerWithTheJourneyIDRegisteredForAJourney(long journeyID) {
	    // Write code here that turns the phrase above into concrete actions
	    this.journeyID=journeyID;
	    client.addActiveShipment(this.journeyID);
	    databaseClient.editEntry(client);
	    databaseClient.flushActiveData();
	}

	@Given("the start port of the container was {string}")
	public void theStartPortOfTheContainerWas(String portname) {
	    // Write code here that turns the phrase above into concrete actions
		this.startPortID = clientApplication.getPortID(portname);
	}

	@Given("the destination port is {string}")
	public void theDestinationPortIs(String portname) {
	    // Write code here that turns the phrase above into concrete actions
		this.destinationPortID = clientApplication.getPortID(portname);
	}

	@Given("the current location of the container is {float} latitude and {float} longitude")
	public void theCurrentLocationOfTheContainerIsLatitudeAndLongitude(float latitude, float longitude) {
	    // Write code here that turns the phrase above into concrete actions
	    this.latitude = latitude;
	    this.longitude =longitude;
	}

	@Given("the container has cargo {string}")
	public void theContainerHasCargo(String cargo) {
	    // Write code here that turns the phrase above into concrete actions
	    this.cargo=cargo;
	}
	
	@Given("its optimal internal Status is {float} atm {float} celcius {float} % humidity")
	public void itsOptimalInternalStatusIsAtmCelciusHumidity(float pressure, float temperature, float humidity) {
	    // Write code here that turns the phrase above into concrete actions
	    this.pressure = pressure;
	    this.temperature = temperature;
	    this.humidity = humidity;
	}
	
	@Given("its arrival date is {string}")
	public void itsArrivalDateIs(String date) {
	    // Write code here that turns the phrase above into concrete actions
	    this.arriveBy =date;
	    ContainerData container = new ContainerData (10849147913500l,this.clientID,this.journeyID,this.startPortID,this.destinationPortID,this.latitude,this.longitude,this.cargo,this.temperature,this.pressure,this.humidity,parseInput.getDate(date));
	    databaseContainer.newEntry(container);
	    databaseContainer.flushActiveData();
	}
	

	@When("the client with the ID  {long} asks for the information of the container with the journey ID {long}")
	public void theClientWithTheIDAsksForTheInformationOfTheContainerWithTheJourneyID(long clientID, long journeyID) {
	    // Write code here that turns the phrase above into concrete actions
		clientApplication = new CurrentClientV2(clientID);
		this.journeyID=journeyID;
	    FilteringContainersForAClient filter = new FilterByJourneyID(client,journeyID);
	    Containers = clientApplication.getFilteredContainersOnAJourney(filter);
	    assertFalse(Containers.isEmpty());
	    System.out.println(Containers.get(0).getJourneyID()+"  "+Containers.get(0).getStartPortID());

	}

	@Then("the current location of the container shown is {float} latitude and {float} longitude")
	public void theCurrentLocationOfTheContainerShownIsLatitudeAndLongitude(float latitude, float longitude) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals((int)Containers.get(0).getCurrentPosition().getLatitude(),(int)latitude);
		assertEquals((int)Containers.get(0).getCurrentPosition().getlongitude(),(int)longitude);
		
	    
	}

	@Then("it contains the cargo:{string}")
	public void itContainsTheCargo(String cargo) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(Containers.get(0).getCargo(),cargo);
	}

	@Then("it will arrive by the date {string}")
	public void itWillArriveByTheDate(String date) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(Containers.get(0).getArriveBy(),date);
	}
	
	@When("the client with the ID {long} provides the port name {string}")
	public void theClientWithTheIDProvidesThePortName(long clientID, String portname) {
	    // Write code here that turns the phrase above into concrete actions
		clientApplication = new CurrentClientV2(clientID);
		startPortID = clientApplication.getPortID(portname);
		System.out.println("Startport ID: "+startPortID);
		assertNotEquals(startPortID,1l);
	}


	@Then("the client can view the information for his containers starting journey from the Port {string}")
	public void theClientCanViewTheInformationForHisContainersStartingJourneyFromThePort(String portname) {
	    // Write code here that turns the phrase above into concrete actions
		FilterByPortName filter = new FilterByPortName(clientApplication.viewClient(),startPortID);
		Containers = clientApplication.getFilteredContainersOnAJourney(filter);
		assertFalse(Containers.isEmpty());
	}

	@Then("those containers will include the container with the journey ID {long}")
	public void thoseContainersWillIncludeTheContainerWithTheJourneyID(long journeyID) {
	    // Write code here that turns the phrase above into concrete actions
		for (int i=0;i<Containers.size();i++) {
			assertEquals(Containers.get(i).getStartPortID(),startPortID);
		}
		boolean contains = false;
		for (int i=0;i<Containers.size();i++) {
			if(Containers.get(i).getJourneyID()==journeyID) {
				contains =true;
			}
		}
		assertTrue(contains);
	}

}

