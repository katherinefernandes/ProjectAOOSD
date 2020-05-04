package acceptanceTests.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import applications.ClientApplication;
import applications.CompanyApplication;
import businessObjects.Client;
import businessObjects.Container;
import businessObjects.Port;
import applications.Application;
import containerFilters.FilterByCargoName;
import containerFilters.FilterByJourneyID;
import containerFilters.FilterByPortName;
import containerFilters.FilteringContainersForAClient;
import dataWrappers.Location;
import dataWrappers.ReferenceName;
import dataBase.DataBase;
import exceptions.ElementSelectionException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import searchClients.SearchByEmail;
import searchClients.SearchByName;
import searchClients.SearchByPhone;
import searchClients.SearchByReferencePerson;
import searchClients.SearchByString;
import simulation.Simulator;
import supportingClasses.DataForViewAllJourneys;
import supportingClasses.ExtractingPortID;
import supportingClasses.UpdateDestinationPort;
import supportingClasses.ValidInput;
import supportingClasses.InputParser;
import updateClientInformation.UpdateEmail;
import updateClientInformation.UpdatePhoneNumber;
import updateClientInformation.UpdateReferencePerson;
import updateContainer.UpdateLocation;
import updateContainer.UpdatePort;
import updateContainer.UpdateStatus;

public class ApplicationSteps {

	private ValidInput validate =new ValidInput();
	private long clientID;
	private String companyname;
	private String email;
	private int countryCode;
	private long phone;
	private ArrayList<String> firstname;
	private ArrayList<String> lastname;
	private ArrayList<String> middlename;
	private CompanyApplication logistic = new CompanyApplication();
	private Client client;
	private ClientApplication clientApplication;
	private long journeyID;
	private long startPortID;
	private long destinationPortID;
	private float latitude;
	private float longitude;
	private float pressure;
	private float temperature;
	private float humidity;
	private String cargo;
	private String arriveBy;
	private ArrayList<Container> Containers;
	private String name;
	private ArrayList<String> firstName;
	private ArrayList<String> middleName;
	private ArrayList<String> lastName;
	private String street;
	private int houseNumber;
	private String city;
	private String postCode;
	private SearchByName optionName;
	private List<Client> clients;
	private SearchByEmail optionEmail;
	private ReferenceName searchRefPerson;
	private SearchByReferencePerson optionRefPerson;
	private SearchByPhone optionPhone;
	private long containerID;
	private Container container;
	private Application user;
	private String errorMessage;
	private String portName;
	private long portID;
	private boolean result;
	private long visitedPortID;
	private DataForViewAllJourneys viewJourneys;

	@Before
	public void IntialisePorts() {
		Port port1 = new Port(357983327889100l,"Pakistan","Gwadar",25.11f,62.33f);
		Port port2 = new Port(357983327946100l,"Denmark","Copenhagen",55.70f,12.59f);
		Port port3 = new Port(357983327979100l,"Singapore","Keppel",1.26f,103.83f);
		port2.save();
		port1.save();
		port3.save();
	}

	
	
	@Given("that there exists a client with ID {long}")
	public void thatThereExistsAClientWithID(long clientID) {
		this.clientID=clientID;
	}

	@Given("the client name is {string}")
	public void theClientNameIs(String name) {
		 this.companyname =name;
	}

	@Given("the email is {string}")
	public void theEmailIs(String email) {
		this.email =email;
	}

	@Given("the phonenumber is countrycode {int} phone {long}")
	public void thePhonenumberIsCountrycodePhone(int countryCode, long phone) {
		this.countryCode =countryCode;
	    this.phone =phone;
	}

	@Given("the reference person is firstname {string} middlename {string} lastname {string}")
	public void theReferencePersonIsFirstnameLastname(String firstname, String middlename,String lastname) {
		this.firstname = InputParser.parsingNames(firstname);
	    this.lastname = InputParser.parsingNames(lastname);
	    this.middlename = InputParser.parsingNames(middlename);
	    Client client = new Client(this.clientID,this.companyname,this.countryCode,this.phone,this.email,this.firstname,this.middlename,this.lastname,"g-11/2","islamabad",58,"1400");
	    client.save();
	}
	

	@When("the logistic Company enters the Client ID {long}")
	public void theLogisticCompanyEntersTheClientID(long clientID) {
		try {
			 logistic.getClient(clientID);
			 client = logistic.viewClient();
		} catch (ElementSelectionException e) {

			throw new Error(e); ///need to figure out how to test this.
		}
	}

	@Then("the Client information is shown that the client name is {string}")
	public void theClientInformationIsShownThatTheClientNameIs(String clientname) {
		assertTrue(client.getCompanyName().equals(clientname));
	}

	@Then("the email shown is {string}")
	public void theEmailShownIs(String email) {
		assertTrue(client.getEmail().equals(email));
	}
	@Given("that the client with the ID {long} is logged into the clientApplication")
	public void thatTheClientWithTheIDIsLoggedIntoTheClientApplication(long clientID) {
		clientApplication = new ClientApplication(clientID);
		assertTrue(clientApplication.getSetClient());
	}

	@When("the client decides to view its own information")
	public void theClientDecidesToViewItsOwnInformation() {
	    client = clientApplication.viewClient();
	}

	@Then("the client sees that the company name is {string}")
	public void theClientSeesThatTheCompanyNameIs(String name) {
		 assertTrue(client.getCompanyName().equals(name));
	}

	@Then("that the email is {string}")
	public void thatTheEmailIs(String email) {
		assertTrue(client.getEmail().equals(email));
	}

	@Then("that the phonenumber is countrycode {int} phone {long}")
	public void thatThePhonenumberIsCountrycodePhone(int cc, long phone) {
		assertEquals(client.getPhoneNumber().getCountryCode(),cc);
	    assertEquals(client.getPhoneNumber().getPhone(),phone);
	}

	@Then("that the reference person is firstname {string} lastname {string}")
	public void thatTheReferencePersonIsFirstnameLastname(String firstname, String lastname) {
		assertEquals(InputParser.parsingNames(firstname).size(),client.getPerson().getFirstName().size());
	    assertEquals(InputParser.parsingNames(lastname).size(),client.getPerson().getLastName().size());
	}
	
	
	@Given("there is a client with ID {long}")
	public void thereIsAClientWithID(long clientID) {
		this.clientID =clientID;
		client = new Client(this.clientID,"company",92,23789,"email@eh.com",InputParser.parsingNames("muna"),InputParser.parsingNames(""),InputParser.parsingNames("azam"),"g11/2","Islamabad",59,"2620");
		client.save();
		clientApplication =  new ClientApplication(clientID);
	}

	@Given("the client has a container with the journey ID {long} registered for a journey")
	public void theClientHasAContainerWithTheJourneyIDRegisteredForAJourney(long journeyID) {
		this.journeyID=journeyID;
	    client.addActiveShipment(this.journeyID);
	    client.save();
	}

	@Given("the start port of the container was {string}")
	public void theStartPortOfTheContainerWas(String portname) {
		this.startPortID = ExtractingPortID.getPortID(portname);
	}

	@Given("the destination port is {string}")
	public void theDestinationPortIs(String portname) {
		this.destinationPortID = ExtractingPortID.getPortID(portname);
	}

	@Given("the current location of the container is {float} latitude and {float} longitude")
	public void theCurrentLocationOfTheContainerIsLatitudeAndLongitude(float latitude, float longitude) {
		this.latitude = latitude;
	    this.longitude =longitude;
	}

	@Given("the container has cargo {string}")
	public void theContainerHasCargo(String cargo) {
		this.cargo=cargo;
	}

	@Given("its arrival date is {string}")
	public void itsArrivalDateIs(String date) {
		 this.arriveBy =date;
		 Container container = new Container (10849147913500l,this.clientID,this.journeyID,this.startPortID,this.destinationPortID,this.latitude,this.longitude,this.cargo,this.temperature,this.pressure,this.humidity,(this.arriveBy));
		 container.save();
	}

	@Given("its optimal internal Status is {float} atm {float} celsius {float} % humidity")
	public void itsOptimalInternalStatusIsAtmCelsiusHumidity(float atm, float temp, float humid) {
		 this.pressure = atm;
		 this.temperature = temp;
		 this.humidity = humid;
	}

	@When("the client asks for the information of the container with the journey ID {long}")
	public void theClientAsksForTheInformationOfTheContainerWithTheJourneyID(long journeyID) {
		clientApplication = new ClientApplication(clientID);
		this.journeyID=journeyID;
	    FilteringContainersForAClient filter = new FilterByJourneyID(client,journeyID);
	    Containers = clientApplication.filterContainersOnAJourney(filter);
	    assertFalse(Containers.isEmpty());
	    System.out.println(Containers.get(0).getJourneyID()+"  "+Containers.get(0).getStartPortID());
	}

	@Then("the current location of the container shown is {float} latitude and {float} longitude")
	public void theCurrentLocationOfTheContainerShownIsLatitudeAndLongitude(float latitude, float longitude) {
		assertEquals((int)Containers.get(0).getCurrentPosition().getLatitude(),(int)latitude);
		assertEquals((int)Containers.get(0).getCurrentPosition().getLongitude(),(int)longitude);
		
	}

	@Then("it contains the cargo:{string}")
	public void itContainsTheCargo(String cargo) {
		assertEquals(Containers.get(0).getCargo(),cargo);
	}

	@Then("it will arrive by the date {string}")
	public void itWillArriveByTheDate(String date) {
		assertEquals(Containers.get(0).getArriveBy(),date);
	}
	
	@When("the client provides the port name {string}")
	public void theClientProvidesThePortName(String portname) {
		startPortID = ExtractingPortID.getPortID(portname);
		System.out.println("Startport ID: "+startPortID);
		assertNotEquals(startPortID,1l);
	}

	@Then("the client can view the information for his containers starting journey from the Port {string}")
	public void theClientCanViewTheInformationForHisContainersStartingJourneyFromThePort(String portname) {
		FilterByPortName filter = new FilterByPortName(clientApplication.viewClient(),startPortID);
		Containers = clientApplication.filterContainersOnAJourney(filter);
		assertFalse(Containers.isEmpty());
	}

	@Then("those containers will include the container with the journey ID {long}")
	public void thoseContainersWillIncludeTheContainerWithTheJourneyID(long journeyID) {
		boolean contains = false;
		for (int i=0;i<Containers.size();i++) {
			if(Containers.get(i).getJourneyID()==journeyID) {
				contains =true;
				break;
			}
		}
		assertTrue(contains);
	}
	
	@When("the client provides a port name {string} from where the journey will start")
	public void theClientProvidesAPortNameFromWhereTheJourneyWillStart(String portname) {
		 startPortID = ExtractingPortID.getPortID(portname);
		 assertNotEquals(startPortID,1l);
	}

	@When("provides a destination port name {string}")
	public void providesADestinationPortName(String portname) {
		destinationPortID =ExtractingPortID.getPortID(portname);
		assertNotEquals(destinationPortID,1l);
	}

	@When("provides the name of the cargo {string} being transported")
	public void providesTheNameOfTheCargoBeingTransported(String cargo) {
		this.cargo = cargo;
	    assertTrue(validate.validateName(cargo));
	}

	@When("provides the optimal internal state for the cargo which is {float} temperature, {float} atm pressure and {float}% humidity")
	public void providesTheOptimalInternalStateForTheCargoWhichIsTemperatureAtmPressureAndHumidity(float temp, float atm, float humid) {
		this.temperature= temp;
		this.pressure= atm;
		this.humidity = humid;
	}

	@When("provides the expected arrival date which is {string}")
	public void providesTheExpectedArrivalDateWhichIs(String date) {
		arriveBy = date;
	}

	@Then("a container is registered for the journey and the client is provided with a journey ID to track the container.")
	public void aContainerIsRegisteredForTheJourneyAndTheClientIsProvidedWithAJourneyIDToTrackTheContainer() {
		clientApplication.registerContainerForAJourney(startPortID,destinationPortID,cargo,temperature,pressure,humidity,arriveBy);
		assertTrue(DataBase.searchContainers(cargo).size()>0);
		
	}
	@Given("the logistic Company decides to add a new client")
	public void theLogisticCompanyDecidesToAddANewClient() {
		   //remove this given or check in a different way Muna
	}


	@Then("a unique client ID is generated")
	public void aUniqueClientIDIsGenerated() {
		long ID = logistic.addClient(email, name, countryCode, phone, firstName, middleName, lastName, street, city, postCode, houseNumber);
		assertTrue(DataBase.searchClients(Long.toString(ID)).size()>0);
	}
	
	@When("the client email is provided {string}")
	public void theClientEmailIsProvided(String email) {
		assertTrue(validate.validateEmail(email));
		this.email = email;	
	}

	@When("the client name is provided{string}")
	public void theClientNameIsProvided(String companyname) {
		this.companyname = companyname;
	}

	@When("the client phone number is provided  {int} , {long}")
	public void theClientPhoneNumberIsProvided(int cc, long phone) {
		assertTrue("the country code should be valid",validate.validateCountryCode(cc));
		assertTrue(validate.validatePhone(phone));
		this.countryCode = cc;
		this.phone = phone;
	}

	@When("the reference person is provided {string} {string} {string}")
	public void theReferencePersonIsProvided(String name1, String name2, String name3) {
		assertTrue(validate.validateName(name1));
		assertTrue(validate.validateName(name2));
	    assertTrue(validate.validateName(name3));
	   this.firstName = InputParser.parsingNames(name1);
	   this.middleName = InputParser.parsingNames(name2);
	   this.lastName = InputParser.parsingNames(name3);
	}

	@When("the address is provided street: {string} house number: {int} city: {string} zipcode: {string}")
	public void theAddressIsProvidedStreetHouseNumberCityZipcode(String street, int hNumber, String city, String zipcode) {
		assertTrue(validate.validateName(city));
		assertTrue(validate.validatePostCode(zipcode));
		this.street = street;
		this.houseNumber = hNumber;
		this.city = city;
		this.postCode = zipcode;
	}
	
	

	@When("that the logistic company enters the clients name {string}")
	public void thatTheLogisticCompanyEntersTheClientsName(String searchName) {
		optionName = new SearchByName(searchName);
	}

	@Then("the list of clients with this name should appear")
	public void theListOfClientsWithThisNameShouldAppear() {
		  assertNotEquals(logistic.search(optionName).size(),0);
		  this.clients =logistic.search(optionName);
	}

	@Then("the list should include the client with ID {long}")
	public void theListShouldIncludeTheClientWithID(long clientID) {
		boolean contains = false;
		for (int i=0;i<clients.size();i++) {
			if(clients.get(i).getID()==clientID) {
				contains =true;
				break;
			}
		}
		assertTrue(contains);
	}
	@When("that the logistic company enters the clients email {string}")
	public void thatTheLogisticCompanyEntersTheClientsEmail(String searchEmail) {
		optionEmail = new SearchByEmail(searchEmail);
	}

	@Then("the list of clients with this email should appear")
	public void theListOfClientsWithThisEmailShouldAppear() {
		assertNotEquals(logistic.search(optionEmail).size(), 0);
		this.clients =logistic.search(optionEmail);
	}

	@When("that the logistic company enters the clients reference person {string} {string} {string}")
	public void thatTheLogisticCompanyEntersTheClientsReferencePerson(String string, String string2, String string3) {
		this.firstname = InputParser.parsingNames(string);
		this.middlename = InputParser.parsingNames(string2);
		this.lastName = InputParser.parsingNames(string3);
		searchRefPerson = new ReferenceName(firstname, middlename, lastName);
		optionRefPerson = new SearchByReferencePerson(searchRefPerson);
	}

	@Then("the list of clients with this reference person should appear")
	public void theListOfClientsWithThisReferencePersonShouldAppear() {
		assertNotEquals(logistic.search(optionRefPerson).size(), 0);
		this.clients =logistic.search(optionRefPerson);
	}

	@When("that the logistic company enters the clients phone {long}")
	public void thatTheLogisticCompanyEntersTheClientsPhone(long searchPhone) {
		optionPhone = new SearchByPhone(searchPhone);
	}

	@Then("the list of clients with this phone should appear")
	public void theListOfClientsWithThisPhoneShouldAppear() {
		assertNotEquals(logistic.search(optionPhone).size(), 0);
		this.clients =logistic.search(optionPhone);
	}
	
	@Given("there is a container with the ID {long}")
	public void thereIsAContainerWithTheID(long containerID) {
		this.containerID = containerID;
	}

	@Given("the container has the journey ID {long}")
	public void theContainerHasTheJourneyID(long journeyID) {
		this.journeyID=journeyID;
	}

	@Given("the start port is given {string}")
	public void theStartPortIsGiven(String portname) {
		startPortID = ExtractingPortID.getPortID(portname);
		System.out.println("Startport ID: "+startPortID);
		assertNotEquals(startPortID,1l);
	}

	@Given("the destination port is given {string}")
	public void theDestinationPortIsGiven(String portname) {
		this.destinationPortID = ExtractingPortID.getPortID(portname);
	}

	@Given("the current location of the container given is {float} latitude and {float} longitude")
	public void theCurrentLocationOfTheContainerGivenIsLatitudeAndLongitude(float latitude, float longitude) {
		this.latitude = latitude;
	    this.longitude =longitude;
	}

	@Given("the container has cargo given as  {string}")
	public void theContainerHasCargoGivenAs(String cargo) {
		this.cargo=cargo;
	}

	@Given("its optimal internal Status is given  {float} atm {float} celsius {float} % humidity")
	public void itsOptimalInternalStatusIsGivenAtmCelsiusHumidity(float atm, float temp, float humid) {
		this.pressure = atm;
		this.temperature = temp;
		this.humidity = humid;
	}

	@Given("its arrival date is given {string}")
	public void itsArrivalDateIsGiven(String date) {
		this.arriveBy =date;
		System.out.println(containerID);
		Container container = new Container (this.containerID,897841664590l,this.journeyID,this.startPortID,this.destinationPortID,this.latitude,this.longitude,this.cargo,this.temperature,this.pressure,this.humidity,(this.arriveBy));
		container.save();
	}

	@Given("that the logistic company enters the container ID {long}")
	public void thatTheLogisticCompanyEntersTheContainerID(long id) {
		  this.containerID = id;
		    try {
				logistic.getContainer(this.containerID);
				System.out.println(this.containerID);
			} catch (ElementSelectionException e) {
				e.printStackTrace();
				throw new Error(e); //need to test this out in a better way
			}
		    assertTrue(logistic.getSetContainer());
		
	}

	@When("the temperature value {float} are given")
	public void theTemperatureValueAreGiven(float double1) {
		this.temperature = double1;
	}

	@When("the humidity level value {float}% are given")
	public void theHumidityLevelValueAreGiven(float double1) {
		this.humidity=double1;
	}

	@When("the pressure value {float}atm are given")
	public void thePressureValueAtmAreGiven(float double1) {
		this.pressure=double1;
	}

	@Then("the internal status of the container is updated")
	public void theInternalStatusOfTheContainerIsUpdated() {
		UpdateStatus update = new UpdateStatus( temperature, humidity,pressure);
		assertTrue("This should be true now as the status has been updated",logistic.updateContainerInformation(update));
	}

	@Then("the new temperature value is {float}")
	public void theNewTemperatureValueIs(float temp) {
		try {
			logistic.getContainer(this.containerID);
		} catch (ElementSelectionException e) {
			e.printStackTrace();
			throw new Error(e); //need to test this out in a better way
		}
	    this.container = logistic.viewContainer();
	    assertEquals((int)container.getInternalStatus().getTemperature(),(int)temp);
	    
	}

	@Then("the new humidity level is {float}%")
	public void theNewHumidityLevelIs(float humid) {
		 assertEquals((int)container.getInternalStatus().getHumidity(),(int)humid);		
	}

	@Then("the new pressure value is {float}atm")
	public void theNewPressureValueIsAtm(float atm) {
		 assertEquals((int)container.getInternalStatus().getAtmosphere(),(int)atm);
	}
	
	@When("the latitude {float} is given")
	public void theLatitudeIsGiven(float double1) {
		 this.latitude = double1;
		 assertTrue(validate.validateLocation(double1));
	}

	@When("the longitude {float} is given")
	public void theLongitudeIsGiven(float double1) {
		this.longitude = double1;
		assertTrue(validate.validateLocation(double1));
	}

	@Then("the location for the container is updated")
	public void theLocationForTheContainerIsUpdated() {
		UpdateLocation update = new UpdateLocation(longitude, latitude);
		assertTrue("This should be true now as the location has been updated",logistic.updateContainerInformation(update));
	}

	@Then("the new latitude is {float}")
	public void theNewLatitudeIs(float double1) {
		try {
			logistic.getContainer(this.containerID);
		} catch (ElementSelectionException e) {
			e.printStackTrace();
			throw new Error(e); //need to test this out in a better way
		}
	    this.container = logistic.viewContainer();
	    assertEquals((int)container.getCurrentPosition().getLatitude(),(int)double1);
	}

	@Then("the new longitude is {float}")
	public void theNewLongitudeIs(float double1) {
		assertEquals((int)container.getCurrentPosition().getLongitude(),(int)double1);
	}
	
	
	@When("the client chooses to view the internal status of a container with the journeyID {long}")
	public void theClientChoosesToViewTheInternalStatusOfAContainerWithTheJourneyID(long journeyID) {
	    	this.journeyID=journeyID;
	    	FilterByJourneyID filter = new FilterByJourneyID(clientApplication.viewClient(),this.journeyID);
			Containers = clientApplication.filterContainersOnAJourney(filter);
			for (int i=0;i<Containers.size();i++) {
				assertEquals(Containers.get(i).getJourneyID(),journeyID);
			}
	}

	@Then("the client can view the current internal status of the container which is temperature {float}, pressure {float}, humidity level {float}")
	public void theClientCanViewTheCurrentInternalStatusOfTheContainerWhichIsTemperaturePressureHumidityLevel(float temp, float press, float humid) {
		assertEquals((int)Containers.get(0).getInternalStatus().getTemperature(),(int)temp);
		assertEquals((int)Containers.get(0).getInternalStatus().getAtmosphere(),(int)press);
		assertEquals((int)Containers.get(0).getInternalStatus().getHumidity(),(int)humid);
	}
	
	@When("the client provides the cargo type {string}")
	public void theClientProvidesTheCargoType(String cargo) {
		this.cargo=cargo;
		FilterByCargoName filter = new FilterByCargoName(clientApplication.viewClient(),cargo);
		Containers = clientApplication.filterContainersOnAJourney(filter);
	}

	@Then("the client can view all the information for all those containers")
	public void theClientCanViewAllTheInformationForAllThoseContainers() {
		for (int i=0;i<Containers.size();i++) {
			assertEquals(Containers.get(i).getCargo(),cargo);
		}
	}
	
	@Given("that the client ID {long} is entered")
	public void thatTheClientIDIsEntered(long clientID) {
		this.clientID = clientID;
		user = new Application();
	}

	@When("the database is asked to return the client information")
	public void theDatabaseIsAskedToReturnTheClientInformation() {
	    try {
			user.getClient(clientID);
			errorMessage = "none";
		} catch (ElementSelectionException e) { //need to test this out in a better way
			errorMessage = "ElementNotFoundException";
		}
	}

	
	@Then("error message {string} is given")
	public void errorMessageIsGiven(String error) {
		assertTrue(errorMessage.equals(error));
	}
	
	@Given("that the container ID {long} is entered")
	public void thatTheContainerIDIsEntered(long containerID) {
		this.containerID = containerID;
		user = new Application();
	}

	@When("the database is asked to return the container information")
	public void theDatabaseIsAskedToReturnTheContainerInformation() {
		   try {
				user.getContainer(containerID);
				errorMessage = "none";
			} catch (ElementSelectionException e) {

				errorMessage = "ElementNotFoundException";
			}
	}
	
	@Given("that the port name {string} is entered")
	public void thatThePortNameIsEntered(String portName) {
	    this.portName=portName;
	}

	@When("the database is asked to return the portID")
	public void theDatabaseIsAskedToReturnThePortID() {
		this.portID = ExtractingPortID.getPortID(portName);
	}

	@Then("the ID {long} is returned which means that port name is not valid")
	public void theIDIsReturnedWhichMeansThatPortNameIsNotValid(long portID) {
	    assertEquals(portID,this.portID);
	}
	
	@Given("that the portID {long} is entered")
	public void thatThePortIDIsEntered(long portID) {
		this.portID=portID;
	}

	@When("the database is asked to return the port data")
	public void theDatabaseIsAskedToReturnThePortData() {
		 assertThrows(java.lang.Error.class,()-> new UpdateDestinationPort().updatePort(portID, 34569l));
		 result = false;
	}

	@Then("error message is returned")
	public void errorMessageIsReturned() {
		assertFalse(result);
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
	    assertTrue("Should be true as the phonenumber has been updated",clientApplication.updateClientInformation(update));
	    
	}
	@When("the client provides the new email {string} which is a valid email format")
	public void providesTheNewEmailWhichIsAValidEmailFormat(String email) {
		this.email=email;
		assertTrue(validate.validateEmail(email));
	}

	@Then("the previous email is replaced with the new valid email")
	public void thePreviousEmailIsReplacedWithTheNewValidEmail() {
		UpdateEmail update = new UpdateEmail(email);
	   assertTrue("This should be true now as the email has been updated",clientApplication.updateClientInformation(update));
	    
	}


	@When("the client provides the new firstname {string} which is valid")
	public void providesTheNewFirstnameWhichIsValid(String firstName) {
		this.firstName = InputParser.parsingNames(firstName);
		assertTrue(validate.validateName(firstName));
	}

	@When("provides the new middlename {string} which is also valid")
	public void providesTheNewMiddlenameWhichIsAlsoValid(String middleName) {
		this.middleName = InputParser.parsingNames(middleName);
		assertTrue(validate.validateName(middleName));
	}

	@When("provides the new lastname {string} which is also valid")
	public void providesTheNewLastnameWhichIsAlsoValid(String lastName) {
		this.lastName = InputParser.parsingNames(lastName);
		assertTrue(validate.validateName(lastName));
	}

	@Then("the previous reference person is replaced with the new information")
	public void thePreviousReferencePersonIsReplacedWithTheNewInformation() {
		UpdateReferencePerson update = new UpdateReferencePerson(firstName,middleName,lastName);
		assertTrue("Should be true as the information has been changed",clientApplication.updateClientInformation(update));
	}
	
	@When("the port name is given {string}")
	public void thePortNameIsGiven(String portname) {
		this.visitedPortID = ExtractingPortID.getPortID(portname);
		assertNotEquals(visitedPortID,1l);
	}

	@Then("the port visited for the container is updated")
	public void thePortVisitedForTheContainerIsUpdated() {
		UpdatePort update = new UpdatePort(this.visitedPortID);
		assertTrue("This should be true now as the port has been updated",logistic.updateContainerInformation(update));
	}

	@Then("the new port is {string}")
	public void theNewPortIs(String portname) {
		List<Port> ports = DataBase.searchPorts(Long.toString(logistic.viewContainer().getLastVisitedPortID()));
		boolean contains =false;
		for (Port port: ports) {
			if(port.getPortName().contains(portname)) {
				contains = true;
			}
		}
		assertTrue(contains);
	}
	
	@Given("there is a container with assigned ID {long}")
	public void thereIsAContainerWithAssignedID(long containerID) {
		this.containerID=containerID;
	}

	@Given("the container has the assigned journey ID {long}")
	public void theContainerHasTheAssignedJourneyID(long ID) {
		this.journeyID=ID;
	}

	@Given("the container has the assigned client ID {long}")
	public void theContainerHasTheAssignedClientID(long ID) {
		this.clientID =ID;
		Client client = new Client(ID, "company",92,23789,"email@eh.com",InputParser.parsingNames("firstname"),InputParser.parsingNames("middlename"),InputParser.parsingNames("lastname"),"g11/2","Islamabad",59,"2620");
		client.addActiveShipment(journeyID);
		client.save();
	}

	@Given("the start port is assigned {string}")
	public void theStartPortIsAssigned(String portname) {
		this.startPortID = ExtractingPortID.getPortID(portname);
	}

	@Given("the destination port is assigned {string}")
	public void theDestinationPortIsAssigned(String portname) {
		this.destinationPortID=ExtractingPortID.getPortID(portname);
	}

	@Given("the current location of the container assigned is {float} latitude and {float} longitude")
	public void theCurrentLocationOfTheContainerAssignedIsLatitudeAndLongitude(float lat, float longitude) {
	    this.longitude=longitude;
	    this.latitude=lat;
	}

	@Given("the container has cargo assigned as  {string}")
	public void theContainerHasCargoAssignedAs(String string) {
		this.cargo=string;
	}

	@Given("its optimal internal Status assigned is {float} atm {float} celsius {float} % humidity")
	public void itsOptimalInternalStatusAssignedIsAtmCelsiusHumidity(float atm, float temp, float humid) {
		this.temperature=temp;
		this.pressure=atm;
		this.humidity=humid;
	}

	@Given("its arrival date assigned is {string}")
	public void itsArrivalDateAssignedIs(String string) {
		this.arriveBy=string;
		Container container = new Container (this.containerID,this.clientID,this.journeyID,this.startPortID,this.destinationPortID,this.latitude,this.longitude,this.cargo,this.temperature,this.pressure,this.humidity,(this.arriveBy));
		container.save();
	}
	
	@When("the logistic company decides to view all the active Journeys")
	public void theLogisticCompanyDecidesToViewAllTheActiveJourneys() {
		viewJourneys = new DataForViewAllJourneys();
	}

	@Then("all the active journey IDs are returned which also contains the Journey ID {long}")
	public void allTheActiveJourneyIDsAreReturnedWhichAlsoContainsTheJourneyID(long journeyID) {
		System.out.println(viewJourneys.getResult());
		assertTrue(viewJourneys.getResult().contains(Long.toString(journeyID)));
	}
	
	////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////
	//SIMULATION STEPS
	//Would have made this a separate class, if not for build problems 
	////////////////////////////////////////////////////////////////////////////////////
	Port currentPort;
	Container currentContainer;
	Container updatedContainer;
	Client currentClient;
	long currentJourney;
	ClientApplication clientSession;
	CompanyApplication companySession;
	List<Client> viewedClients;
	Simulator simulator = new Simulator();
	
	
	//--------------------------------------------------------
	@Given("that the logistics company is logged in to the logistics company application")
	public void initializeCompanySession(){
		companySession = new CompanyApplication();
	}
	
	
    @When("the simulation decides to create a new client")
    public void simulateClientCreation(){
    	currentClient = simulator.simulateClientCreation(0.0);
    }
    
    @Then("a new client is created")
    public void clientExists(){
    	assertTrue(currentClient != null);
    }
    
    @Then("the new client is displayed")
    public void clientIsSaved(){
    	SearchByEmail search = new SearchByEmail("");
    	viewedClients = companySession.search(search);
    	assertTrue(viewedClients.contains(currentClient));
    }
    //--------------------------------------------------------
    @When("the simulation decides to create a new journey")
    public void simulateJourneyCreation() {
    	currentJourney = simulator.simulateJourneyCreation(0.0);
    	currentClient = DataBase.searchClients(String.valueOf(currentJourney)).get(0);
    	currentContainer = DataBase.searchContainers(String.valueOf(currentJourney)).get(0);
    }
    
	@Then("a container is assigned to the journey")
	public void containerIsAssigned() {
		assertTrue(currentContainer.getJourneyID() == currentJourney);
	}
	
	@Then("the journey is assigned to a client")
	public void clientIsAssigned(){
		assertTrue(currentClient.getActiveShipments().contains(currentJourney));
	}
	//--------------------------------------------------------
	@Given("that the following ports are defined:$")
	public void definePorts(DataTable table) {
		List<Map<String,String>> ports = table.asMaps();
		for(Map<String,String> portValues : ports) {
			Port port = new Port(Long.valueOf(portValues.get("ID")),portValues.get("Country"),
					    		 portValues.get("PortName"),Float.valueOf(portValues.get("Latitude")),
					    		 Float.valueOf(portValues.get("Longitude")));
			port.save();
		}
	}
	
	@Given("that the following containers are defined:$")
	public void defineContainers(DataTable table) {
		List<Map<String,String>> containers = table.asMaps();
		for(Map<String,String> containerValues : containers) {
			Container container = new Container(Long.valueOf(containerValues.get("ID")),Long.valueOf(containerValues.get("ClientID")),
												Long.valueOf(containerValues.get("JourneyID")),Long.valueOf(containerValues.get("StartPortID")),
												Long.valueOf(containerValues.get("LastVisitedPortID")),Long.valueOf(containerValues.get("DestinationPortID")),
												Float.valueOf(containerValues.get("Latitude")),Float.valueOf(containerValues.get("Longitude")),
												containerValues.get("Cargo"),Float.valueOf(containerValues.get("Temperature")),
												Float.valueOf(containerValues.get("Atmosphere")),Float.valueOf(containerValues.get("Humidity")),
												LocalDateTime.now().toString(),LocalDate.now().plusMonths(3).toString());
			container.save();
			currentContainer = container;
		}
	}
	
	@Given("that the following clients are defined:$")
	public void defineClients(DataTable table) {
		List<Map<String,String>> clients = table.asMaps();
		for(Map<String,String> clientValues : clients) {
			String[] phone = clientValues.get("PhoneNumber").split(" ");
			int countryCode = Integer.valueOf(phone[0]);
			long phoneNumber = Long.valueOf(phone[1]);
			
			String[] name = clientValues.get("RefrencePersonName").split(" ");
			List<String> firstName = new ArrayList<>();
			firstName.add(name[0]);
			List<String> lastName = new ArrayList<>();
			lastName.add(name[name.length - 1]);
			List<String> middleName = new ArrayList<>();
			for(int i = 1; i < name.length - 1; i++) {
				middleName.add(name[i]);
			}
			
			Client client = new Client(Long.valueOf(clientValues.get("ID")),clientValues.get("CompanyName"),
									   countryCode,phoneNumber,clientValues.get("Email"),firstName,middleName,lastName,
									   clientValues.get("StreetName"),clientValues.get("City"),
									   Integer.valueOf(clientValues.get("HouseNumber")),clientValues.get("ZipCode"));
			client.save();
			currentClient = client;
		}
	}
	
	@When("the simulation decides to update active journeys")
	public void simulateJourneyUpdate() {
		simulator.simulateJourneyDevelopment();
		try {
			updatedContainer = DataBase.getContainer(currentContainer.getID());
		} catch (ElementSelectionException e) {
			throw new Error(e);
		}
	}
	
	@Then("the container is moved towards its destination port with speed=60km\\/hour")
	public void containerIsMoved() {
		Location oldPosition = currentContainer.getCurrentPosition();
		Location newPosition = updatedContainer.getCurrentPosition();
		float distance = oldPosition.distanceTo(newPosition);
		assertTrue(distance >= 30F && distance <= 150F);
	}
	
	@Then("the temperature of the container is changed by no more than 0.5 with max=90. and min=-10.")
	public void temperatureIsChanged() {
		float oldTemperature = currentContainer.getInternalStatus().getTemperature();
		float newTemperature = updatedContainer.getInternalStatus().getTemperature();
		assertTrue(oldTemperature != newTemperature); //This could possible return return a failure with working code, 
													  //but the chance is very small
		assertTrue(Math.abs(oldTemperature - newTemperature) <= 0.5F);
		assertTrue(newTemperature <= 90.F && newTemperature >= -10.F);
	}
	
	@Then("the humidity of the container is changed by no more than 0.5 with max=100. and min=0.")
	public void humidityIsChanged() {
		float oldHumidity = currentContainer.getInternalStatus().getHumidity();
		float newHumidity = updatedContainer.getInternalStatus().getHumidity();
		assertTrue(oldHumidity != newHumidity); //This could possible return return a failure with working code, 
													  //but the chance is very small
		assertTrue(Math.abs(oldHumidity - newHumidity) <= 0.5F);
		assertTrue(newHumidity <= 100.F && newHumidity >= 0.F);
	}
	
	@Then("the atmosphere of the container is changed by no more than 0.05 with max=3. and min=0.5")
	public void atmosphereIsChanged() {
		float oldAtmosphere = currentContainer.getInternalStatus().getAtmosphere();
		float newAtmosphere = updatedContainer.getInternalStatus().getAtmosphere();
		assertTrue(oldAtmosphere != newAtmosphere); //This could possible return return a failure with working code, 
													//but the chance is very small
		assertTrue(Math.abs(oldAtmosphere - newAtmosphere) <= 0.05F);
		assertTrue(newAtmosphere <= 3.F && newAtmosphere >= 0.5F);
	}
	//---------------------------------------------------------------
	@Given("the port with ID={long} has the arriving container with ID={long}")
	public void assignArrivingContainer(long portID, long containerID) {
		try {
			Port port = DataBase.getPort(portID);
			port.addArrivingContainer(containerID);
			port.save();
		} catch (ElementSelectionException e) {
			throw new Error(e);
		}
	}
	@Given("that the client with ID={long} has the active journey with ID={long}")
	public void assignActiveJourney(long clientID, long journeyID) {
		try {
			Client client = DataBase.getClient(clientID);
			client.addActiveShipment(journeyID);
			client.save();
		} catch (ElementSelectionException e) {
			throw new Error(e);
		}
	}
	@When("the simulation checks for finished journeys")
	public void simulateFinishJourney() {
		simulator.checkForFinshedJourneys();
	}
	@Then("the client with ID={long} has the the finished journey with ID={long}")
	public void checkForFinishedJourney(long clientID, long journeyID) {
		try {
			Client client = DataBase.getClient(clientID);
			assertTrue(client.getFinishedShipments().contains(journeyID));
		} catch (ElementSelectionException e) {
			throw new Error(e);
		}
	}
	@Then("the client with ID={long} does not have the active journey with ID={long}")
	public void checkForMissingActiveJourney(long clientID, long journeyID) {
		try {
			Client client = DataBase.getClient(clientID);
			assertFalse(client.getActiveShipments().contains(journeyID));
		} catch (ElementSelectionException e) {
			throw new Error(e);
		}
	}
	@Then("the container with ID={long} has journeyID={long}, lastVisitedPortID={long}, startPortID={long} and cargo={string}")
	public void checkThatContainerIsFinished(long containerID, long journeyID, long lastVisitedPortID, long startPortID, String cargo) {
		try {
			Container container = DataBase.getContainer(containerID);
			assertTrue(container.getJourneyID() == journeyID);
			assertTrue(container.getLastVisitedPortID() == lastVisitedPortID);
			assertTrue(container.getStartPortID() == startPortID);
			assertTrue(container.getCargo().equals(cargo));
		} catch (ElementSelectionException e) {
			throw new Error(e);
		}
	
	}
	@Then("the port with ID={long} does not have the arrriving container {long}")
	public void checkForMissingArrivingContainer(long portID, long containerID) {
		try {
			Port port = DataBase.getPort(portID);
			assertFalse(port.getArrivingContainers().contains(containerID));
		} catch (ElementSelectionException e) {
			throw new Error(e);
		}
	}
	@Then("the port with ID={long} has the stationed container {long}")
	public void checkForStationedContainer(long portID, long containerID) {
		try {
			Port port = DataBase.getPort(portID);
			assertTrue(port.getStationedContainers().contains(containerID));
		} catch (ElementSelectionException e) {
			throw new Error(e);
		}
	}
}
