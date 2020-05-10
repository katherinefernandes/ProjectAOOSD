$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:userStories/dataNotFound.feature");
formatter.feature({
  "name": "Data Not found",
  "description": "  Description: The data is not found in the database",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Client can not be found in the database",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that the client ID 23456810892 is entered",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thatTheClientIDIsEntered(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the database is asked to return the client information",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.theDatabaseIsAskedToReturnTheClientInformation()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "error message \"ElementNotFoundException\" is given",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.errorMessageIsGiven(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Container can not be found in the database",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that the container ID 248047946 is entered",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thatTheContainerIDIsEntered(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the database is asked to return the container information",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.theDatabaseIsAskedToReturnTheContainerInformation()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "error message \"ElementNotFoundException\" is given",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.errorMessageIsGiven(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Port name is not valid",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that the port name \"random\" is entered",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thatThePortNameIsEntered(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the database is asked to return the portID",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.theDatabaseIsAskedToReturnThePortID()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the ID 1 is returned which means that port name is not valid",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.theIDIsReturnedWhichMeansThatPortNameIsNotValid(long)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Destination port doesnot exist",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that the portID 12789472 is entered",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thatThePortIDIsEntered(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the database is asked to return the port data",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.theDatabaseIsAskedToReturnThePortData()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "error message is returned",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.errorMessageIsReturned()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:userStories/findClient.feature");
formatter.feature({
  "name": "Get Client information",
  "description": "\tDescription: The users can view the client information",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Logistic Company can view the Client information",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that there exists a client with ID 897841664500",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thatThereExistsAClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client name is \"Endres\u0027s patients\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientNameIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the email is \"Bathsheba@gmail.co.uk\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theEmailIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the phonenumber is countrycode 45 phone 23879091",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thePhonenumberIsCountrycodePhone(int,long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the reference person is firstname \"Grazia\" middlename \"\" lastname \"Zee\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theReferencePersonIsFirstnameLastname(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the logistic Company enters the Client ID 897841664500",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.theLogisticCompanyEntersTheClientID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Client information is shown that the client name is \"Endres\u0027s patients\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.theClientInformationIsShownThatTheClientNameIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the email shown is \"Bathsheba@gmail.co.uk\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theEmailShownIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Client can view its own information",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that there exists a client with ID 897841664500",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thatThereExistsAClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client name is \"Endres\u0027s patients\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientNameIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the email is \"Bathsheba@gmail.co.uk\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theEmailIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the phonenumber is countrycode 45 phone 23879091",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thePhonenumberIsCountrycodePhone(int,long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the reference person is firstname \"Grazia\" middlename \"\" lastname \"Zee\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theReferencePersonIsFirstnameLastname(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the client with the ID 897841664500 is logged into the clientApplication",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thatTheClientWithTheIDIsLoggedIntoTheClientApplication(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client decides to view its own information",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.theClientDecidesToViewItsOwnInformation()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client sees that the company name is \"Endres\u0027s patients\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.theClientSeesThatTheCompanyNameIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the email is \"Bathsheba@gmail.co.uk\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thatTheEmailIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the phonenumber is countrycode 45 phone 23879091",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thatThePhonenumberIsCountrycodePhone(int,long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the reference person is firstname \"Grazia\" lastname \"Zee\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thatTheReferencePersonIsFirstnameLastname(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:userStories/findJourney.feature");
formatter.feature({
  "name": "Find a journey",
  "description": "  Description: The Client can track the journey of a container",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Client can track the journey of a container by Journey ID",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "there is a client with ID 36836570081685",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thereIsAClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client has a container with the journey ID 10849147913500 registered for a journey",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientHasAContainerWithTheJourneyIDRegisteredForAJourney(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the start port of the container was \"Gwadar\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theStartPortOfTheContainerWas(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the destination port is \"Copenhagen\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theDestinationPortIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the current location of the container is 26.11 latitude and 74.33 longitude",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theCurrentLocationOfTheContainerIsLatitudeAndLongitude(float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has cargo \"snacks\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasCargo(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its optimal internal Status is 1.0 atm 20.0 celsius 50.0 % humidity",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsOptimalInternalStatusIsAtmCelsiusHumidity(float,float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its arrival date is \"23-06-2020\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsArrivalDateIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the client with the ID 36836570081685 is logged into the clientApplication",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.thatTheClientWithTheIDIsLoggedIntoTheClientApplication(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client asks for the information of the container with the journey ID 10849147913500",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientAsksForTheInformationOfTheContainerWithTheJourneyID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the current location of the container shown is 26.11 latitude and 74.33 longitude",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.theCurrentLocationOfTheContainerShownIsLatitudeAndLongitude(float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "it contains the cargo:\"snacks\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itContainsTheCargo(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "it will arrive by the date \"23-06-2020\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itWillArriveByTheDate(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Client can track the containers starting journey from a Port",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "there is a client with ID 36836570081685",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thereIsAClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client has a container with the journey ID 10849147913500 registered for a journey",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientHasAContainerWithTheJourneyIDRegisteredForAJourney(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the start port of the container was \"Gwadar\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theStartPortOfTheContainerWas(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the destination port is \"Copenhagen\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theDestinationPortIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the current location of the container is 26.11 latitude and 74.33 longitude",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theCurrentLocationOfTheContainerIsLatitudeAndLongitude(float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has cargo \"snacks\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasCargo(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its optimal internal Status is 1.0 atm 20.0 celsius 50.0 % humidity",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsOptimalInternalStatusIsAtmCelsiusHumidity(float,float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its arrival date is \"23-06-2020\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsArrivalDateIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the client with the ID 36836570081685 is logged into the clientApplication",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.thatTheClientWithTheIDIsLoggedIntoTheClientApplication(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client provides the port name \"Gwadar\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientProvidesThePortName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client can view the information for his containers starting journey from the Port \"Gwadar\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.theClientCanViewTheInformationForHisContainersStartingJourneyFromThePort(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "those containers will include the container with the journey ID 10849147913500",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thoseContainersWillIncludeTheContainerWithTheJourneyID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Client can track the containers containing a particular cargo",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "there is a client with ID 36836570081685",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thereIsAClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client has a container with the journey ID 10849147913500 registered for a journey",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientHasAContainerWithTheJourneyIDRegisteredForAJourney(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the start port of the container was \"Gwadar\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theStartPortOfTheContainerWas(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the destination port is \"Copenhagen\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theDestinationPortIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the current location of the container is 26.11 latitude and 74.33 longitude",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theCurrentLocationOfTheContainerIsLatitudeAndLongitude(float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has cargo \"snacks\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasCargo(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its optimal internal Status is 1.0 atm 20.0 celsius 50.0 % humidity",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsOptimalInternalStatusIsAtmCelsiusHumidity(float,float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its arrival date is \"23-06-2020\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsArrivalDateIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the client with the ID 36836570081685 is logged into the clientApplication",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.thatTheClientWithTheIDIsLoggedIntoTheClientApplication(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client provides the cargo type \"snacks\"",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.theClientProvidesTheCargoType(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client can view all the information for all those containers",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.theClientCanViewAllTheInformationForAllThoseContainers()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:userStories/registerContainer.feature");
formatter.feature({
  "name": "Register Container",
  "description": " Description: The Client can register containers for journeys",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Client can register a container for a journey",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "there is a client with ID 36836570081685",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thereIsAClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the client with the ID 36836570081685 is logged into the clientApplication",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.thatTheClientWithTheIDIsLoggedIntoTheClientApplication(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client provides a port name \"Gwadar\" from where the journey will start",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientProvidesAPortNameFromWhereTheJourneyWillStart(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "provides a destination port name \"Copenhagen\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.providesADestinationPortName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "provides the name of the cargo \"Mangoes\" being transported",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.providesTheNameOfTheCargoBeingTransported(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "provides the optimal internal state for the cargo which is 10.0 temperature, 1.0 atm pressure and 90.0% humidity",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.providesTheOptimalInternalStateForTheCargoWhichIsTemperatureAtmPressureAndHumidity(float,float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "provides the expected arrival date which is \"30-04-2020\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.providesTheExpectedArrivalDateWhichIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a container is registered for the journey and the client is provided with a journey ID to track the container.",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.aContainerIsRegisteredForTheJourneyAndTheClientIsProvidedWithAJourneyIDToTrackTheContainer()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:userStories/registerNewClient.feature");
formatter.feature({
  "name": "Register a new Client",
  "description": "  Description: Only the logistic company can register a new client",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Logistic Company registers a new client",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the logistic Company decides to add a new client",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.theLogisticCompanyDecidesToAddANewClient()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client email is provided \"Whitney.Karlen@hotmail.com\"",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.theClientEmailIsProvided(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client name is provided\"Walther\u0027s fan A/S\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientNameIsProvided(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client phone number is provided  45 , 2345678",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientPhoneNumberIsProvided(int,long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the reference person is provided \"Yetty\" \"Patti\" \"Xylina\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theReferencePersonIsProvided(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the address is provided street: \"Kirkpatrick-main\" house number: 23 city: \"record city\" zipcode: \"2345\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theAddressIsProvidedStreetHouseNumberCityZipcode(String,int,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a unique client ID is generated",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.aUniqueClientIDIsGenerated()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:userStories/runSimulation.feature");
formatter.feature({
  "name": "Run simulation",
  "description": "  Description: Use the simulation package to generate and develop business objects",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "The simulation can create a new client",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that the logistics company is logged in to the logistics company application",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.initializeCompanySession()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the database is empty",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.emptyDataBase()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the simulation is activated",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.activateSimulator()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the simulation decides to create a new client",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.simulateClientCreation()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a new client is created",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.clientExists()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "The simulation can create a new journey",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that the logistics company is logged in to the logistics company application",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.initializeCompanySession()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the database is empty",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.emptyDataBase()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the simulation is activated",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.activateSimulator()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the simulation decides to create a new journey",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.simulateJourneyCreation()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a container is assigned to the journey",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.containerIsAssigned()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the journey is assigned to a client",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.clientIsAssigned()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "The simulation can develop a journey",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that the logistics company is logged in to the logistics company application",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.initializeCompanySession()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the database is empty",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.emptyDataBase()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the simulation is activated",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.activateSimulator()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the following ports are defined:",
  "rows": [
    {
      "cells": [
        "ID",
        "Country",
        "PortName",
        "Longitude",
        "Latitude"
      ]
    },
    {
      "cells": [
        "123456789",
        "Denmark",
        "Nyhavn",
        "55.",
        "12."
      ]
    },
    {
      "cells": [
        "987654321",
        "China",
        "Tianjin",
        "39.",
        "118."
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.definePorts(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the following containers are defined:",
  "rows": [
    {
      "cells": [
        "ID",
        "ClientID",
        "JourneyID",
        "StartPortID",
        "LastVisitedPortID",
        "DestinationPortID",
        "Longitude",
        "Latitude",
        "Cargo",
        "Temperature",
        "Humidity",
        "Atmosphere"
      ]
    },
    {
      "cells": [
        "10238493181",
        "12901394121",
        "128938929",
        "123456789",
        "123456789",
        "987654321",
        "40.",
        "80.",
        "Socks",
        "23.",
        "24.",
        "1."
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.defineContainers(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the simulation decides to update active journeys",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.simulateJourneyUpdate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container is moved towards its destination port with speed\u003d60km/hour",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.containerIsMoved()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the temperature of the container is changed by no more than 0.5 with max\u003d90. and min\u003d-10.",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.temperatureIsChanged()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the humidity of the container is changed by no more than 0.5 with max\u003d100. and min\u003d0.",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.humidityIsChanged()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the atmosphere of the container is changed by no more than 0.05 with max\u003d3. and min\u003d0.5",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.atmosphereIsChanged()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "The simulation can finish a journey",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that the database is empty",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.emptyDataBase()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the simulation is activated",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.activateSimulator()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the following ports are defined:",
  "rows": [
    {
      "cells": [
        "ID",
        "Country",
        "PortName",
        "Longitude",
        "Latitude"
      ]
    },
    {
      "cells": [
        "123456789",
        "Denmark",
        "Nyhavn",
        "55.",
        "12."
      ]
    },
    {
      "cells": [
        "987654321",
        "China",
        "Tianjin",
        "39.",
        "118."
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.definePorts(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the port with ID\u003d987654321 has the arriving container with ID\u003d10238493181",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.assignArrivingContainer(long,long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the following clients are defined:",
  "rows": [
    {
      "cells": [
        "ID",
        "CompanyName",
        "PhoneNumber",
        "Email",
        "RefrencePersonName",
        "StreetName",
        "HouseNumber",
        "City",
        "ZipCode"
      ]
    },
    {
      "cells": [
        "12901394121",
        "Sock co.",
        "45 989128318",
        "so@co.com",
        "John T. Smith",
        "Long street",
        "32",
        "Copenhagen",
        "2100"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.defineClients(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the client with ID\u003d12901394121 has the active journey with ID\u003d128938929",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.assignActiveJourney(long,long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the following containers are defined:",
  "rows": [
    {
      "cells": [
        "ID",
        "ClientID",
        "JourneyID",
        "StartPortID",
        "LastVisitedPortID",
        "DestinationPortID",
        "Longitude",
        "Latitude",
        "Cargo",
        "Temperature",
        "Humidity",
        "Atmosphere"
      ]
    },
    {
      "cells": [
        "10238493181",
        "12901394121",
        "128938929",
        "123456789",
        "123456789",
        "987654321",
        "39.005",
        "117.995",
        "Socks",
        "23.",
        "24.",
        "1."
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.defineContainers(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the simulation checks for finished journeys",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.simulateFinishJourney()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client with ID\u003d12901394121 has the the finished journey with ID\u003d128938929",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.checkForFinishedJourney(long,long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client with ID\u003d12901394121 does not have the active journey with ID\u003d128938929",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.checkForMissingActiveJourney(long,long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container with ID\u003d10238493181 has journeyID\u003d0, lastVisitedPortID\u003d987654321, startPortID\u003d987654321 and cargo\u003d\"none\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.checkThatContainerIsFinished(long,long,long,long,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the port with ID\u003d987654321 does not have the arrriving container 10238493181",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.checkForMissingArrivingContainer(long,long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the port with ID\u003d987654321 has the stationed container 10238493181",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.checkForStationedContainer(long,long)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:userStories/searchClients.feature");
formatter.feature({
  "name": "Search clients",
  "description": "Description: The Logistic Company should be able to search for clients.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Logistic Company can search by clients name",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that there exists a client with ID 555555555555",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thatThereExistsAClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client name is \"White notebook\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientNameIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the email is \"whitenotebook@wn.com\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theEmailIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the phonenumber is countrycode 45 phone 85665565",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thePhonenumberIsCountrycodePhone(int,long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the reference person is firstname \"Yetty\" middlename \"\" lastname \"Maguire\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theReferencePersonIsFirstnameLastname(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the logistic company enters the clients name \"White notebook\"",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.thatTheLogisticCompanyEntersTheClientsName(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the list of clients with this name should appear",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.theListOfClientsWithThisNameShouldAppear()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the list should include the client with ID 555555555555",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theListShouldIncludeTheClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Logistic Company can search by clients email",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that there exists a client with ID 555555555555",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thatThereExistsAClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client name is \"White notebook\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientNameIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the email is \"whitenotebook@wn.com\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theEmailIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the phonenumber is countrycode 45 phone 85665565",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thePhonenumberIsCountrycodePhone(int,long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the reference person is firstname \"Yetty\" middlename \"\" lastname \"Maguire\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theReferencePersonIsFirstnameLastname(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the logistic company enters the clients email \"whitenotebook@wn.com\"",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.thatTheLogisticCompanyEntersTheClientsEmail(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the list of clients with this email should appear",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.theListOfClientsWithThisEmailShouldAppear()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the list should include the client with ID 555555555555",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theListShouldIncludeTheClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Logistic Company can search by clients reference person",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that there exists a client with ID 555555555555",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thatThereExistsAClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client name is \"White notebook\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientNameIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the email is \"whitenotebook@wn.com\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theEmailIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the phonenumber is countrycode 45 phone 85665565",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thePhonenumberIsCountrycodePhone(int,long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the reference person is firstname \"Yetty\" middlename \"\" lastname \"Maguire\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theReferencePersonIsFirstnameLastname(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the logistic company enters the clients reference person \"Yetty\" \"\" \"Maguire\"",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.thatTheLogisticCompanyEntersTheClientsReferencePerson(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the list of clients with this reference person should appear",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.theListOfClientsWithThisReferencePersonShouldAppear()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the list should include the client with ID 555555555555",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theListShouldIncludeTheClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Logistic Company can search by clients phone",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that there exists a client with ID 555555555555",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thatThereExistsAClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client name is \"White notebook\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientNameIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the email is \"whitenotebook@wn.com\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theEmailIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the phonenumber is countrycode 45 phone 85665565",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thePhonenumberIsCountrycodePhone(int,long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the reference person is firstname \"Yetty\" middlename \"\" lastname \"Maguire\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theReferencePersonIsFirstnameLastname(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the logistic company enters the clients phone 85665565",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.thatTheLogisticCompanyEntersTheClientsPhone(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the list of clients with this phone should appear",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.theListOfClientsWithThisPhoneShouldAppear()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the list should include the client with ID 555555555555",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theListShouldIncludeTheClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:userStories/trackHistoryOfJourney.feature");
formatter.feature({
  "name": "Track the history of the Journey",
  "description": "\tDescription: The history of how the internal status of the container changed over time",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "name": "The logistic Company should be able to update the internal status of the container",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "there is a container with the ID 10849147913500",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thereIsAContainerWithTheID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has the journey ID 10849147913523",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasTheJourneyID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the start port is given \"Gwadar\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theStartPortIsGiven(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the destination port is given \"Copenhagen\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theDestinationPortIsGiven(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the current location of the container given is 26.11 latitude and 74.33 longitude",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theCurrentLocationOfTheContainerGivenIsLatitudeAndLongitude(float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has cargo given as  \"snacks\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasCargoGivenAs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its optimal internal Status is given  1.0 atm 20.0 celsius 50.0 % humidity",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsOptimalInternalStatusIsGivenAtmCelsiusHumidity(float,float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its arrival date is given \"23-06-2020\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsArrivalDateIsGiven(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the logistic company enters the container ID 10849147913500",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thatTheLogisticCompanyEntersTheContainerID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the temperature value 38.0 are given",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.theTemperatureValueAreGiven(float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the humidity level value 98.0% are given",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theHumidityLevelValueAreGiven(float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the pressure value 1.0atm are given",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thePressureValueAtmAreGiven(float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the internal status of the container is updated",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.theInternalStatusOfTheContainerIsUpdated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the new temperature value is 38.0",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theNewTemperatureValueIs(float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the new humidity level is 98.0%",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theNewHumidityLevelIs(float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the new pressure value is 1.0atm",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theNewPressureValueIsAtm(float)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "The client should be able to view the internal status of the container",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "there is a client with ID 14618447211200",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thereIsAClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client has a container with the journey ID 17027135462300 registered for a journey",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientHasAContainerWithTheJourneyIDRegisteredForAJourney(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the start port of the container was \"Gwadar\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theStartPortOfTheContainerWas(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the destination port is \"Copenhagen\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theDestinationPortIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the current location of the container is 26.11 latitude and 74.33 longitude",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theCurrentLocationOfTheContainerIsLatitudeAndLongitude(float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has cargo \"snacks\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasCargo(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its optimal internal Status is 1.0 atm 20.0 celsius 50.0 % humidity",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsOptimalInternalStatusIsAtmCelsiusHumidity(float,float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its arrival date is \"23-06-2020\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsArrivalDateIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the client with the ID 14618447211200 is logged into the clientApplication",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.thatTheClientWithTheIDIsLoggedIntoTheClientApplication(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client chooses to view the internal status of a container with the journeyID 17027135462300",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientChoosesToViewTheInternalStatusOfAContainerWithTheJourneyID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client can view the current internal status of the container which is temperature 20.0, pressure 1.0, humidity level 50.0",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.theClientCanViewTheCurrentInternalStatusOfTheContainerWhichIsTemperaturePressureHumidityLevel(float,float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:userStories/updateClientInformation.feature");
formatter.feature({
  "name": "Update the information of the client",
  "description": "  description: The client can update parts of its own information",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Client can update its phone number",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that there exists a client with ID 897841664500",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thatThereExistsAClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client name is \"Nederhoff\u0027s limitations Inc.\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientNameIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the email is \"Rici@outlook.jp\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theEmailIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the phonenumber is countrycode 45 phone 23879091",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thePhonenumberIsCountrycodePhone(int,long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the reference person is firstname \"Amandy\" middlename \"Mireille\" lastname \"Luna dela Rosa\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theReferencePersonIsFirstnameLastname(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the client with the ID 897841664500 is logged into the clientApplication",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thatTheClientWithTheIDIsLoggedIntoTheClientApplication(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the Client provides the new country code 45 which is of the valid length",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.providesTheNewCountryCodeWhichIsOfTheValidLength(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "provides the new phone number 45670912 which is also of the valid length",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.providesTheNewPhoneNumberWhichIsAlsoOfTheValidLength(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the previous phone number and country code are replaced with the valid values",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.thePreviousPhoneNumberAndCountryCodeAreReplacedWithTheValidValues()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Client can update its email number",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that there exists a client with ID 897841664500",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thatThereExistsAClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client name is \"Nederhoff\u0027s limitations Inc.\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientNameIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the email is \"Rici@outlook.jp\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theEmailIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the phonenumber is countrycode 45 phone 23879091",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thePhonenumberIsCountrycodePhone(int,long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the reference person is firstname \"Amandy\" middlename \"Mireille\" lastname \"Luna dela Rosa\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theReferencePersonIsFirstnameLastname(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the client with the ID 897841664500 is logged into the clientApplication",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thatTheClientWithTheIDIsLoggedIntoTheClientApplication(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client provides the new email \"Whitney.Karlen@hotmail.com\" which is a valid email format",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.providesTheNewEmailWhichIsAValidEmailFormat(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the previous email is replaced with the new valid email",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.thePreviousEmailIsReplacedWithTheNewValidEmail()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Client can update its reference Person",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "that there exists a client with ID 897841664500",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thatThereExistsAClientWithID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client name is \"Nederhoff\u0027s limitations Inc.\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theClientNameIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the email is \"Rici@outlook.jp\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theEmailIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the phonenumber is countrycode 45 phone 23879091",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thePhonenumberIsCountrycodePhone(int,long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the reference person is firstname \"Amandy\" middlename \"Mireille\" lastname \"Luna dela Rosa\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theReferencePersonIsFirstnameLastname(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the client with the ID 897841664500 is logged into the clientApplication",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thatTheClientWithTheIDIsLoggedIntoTheClientApplication(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the client provides the new firstname \"Yetty\" which is valid",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.providesTheNewFirstnameWhichIsValid(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "provides the new middlename \"Patti\" which is also valid",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.providesTheNewMiddlenameWhichIsAlsoValid(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "provides the new lastname \"Xylina\" which is also valid",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.providesTheNewLastnameWhichIsAlsoValid(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the previous reference person is replaced with the new information",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.thePreviousReferencePersonIsReplacedWithTheNewInformation()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:userStories/updateContainerLastPortVisited.feature");
formatter.feature({
  "name": "Update the last port visited by the container",
  "description": " description: The logistic Company can update the last port visited by the container",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Logistic Company can update the port visited for the container",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "there is a container with assigned ID 10849147913510",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thereIsAContainerWithAssignedID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has the assigned journey ID 108491479189",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasTheAssignedJourneyID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has the assigned client ID 897841664891",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasTheAssignedClientID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the start port is assigned \"Gwadar\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theStartPortIsAssigned(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the destination port is assigned \"Copenhagen\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theDestinationPortIsAssigned(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the current location of the container assigned is 26.11 latitude and 74.33 longitude",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theCurrentLocationOfTheContainerAssignedIsLatitudeAndLongitude(float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has cargo assigned as  \"snacks\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasCargoAssignedAs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its optimal internal Status assigned is 1.0 atm 20.0 celsius 50.0 % humidity",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsOptimalInternalStatusAssignedIsAtmCelsiusHumidity(float,float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its arrival date assigned is \"23-06-2020\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsArrivalDateAssignedIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the logistic company enters the container ID 10849147913510",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thatTheLogisticCompanyEntersTheContainerID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the port name is given \"Keppel\"",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.thePortNameIsGiven(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the port visited for the container is updated",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.thePortVisitedForTheContainerIsUpdated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the new port is \"Keppel\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theNewPortIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Logistic Company can update the port visited for the container",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "there is a container with assigned ID 10849147913510",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thereIsAContainerWithAssignedID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has the assigned journey ID 10849147913523",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasTheAssignedJourneyID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has the assigned client ID 897841664590",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasTheAssignedClientID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the start port is assigned \"Gwadar\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theStartPortIsAssigned(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the destination port is assigned \"Copenhagen\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theDestinationPortIsAssigned(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the current location of the container assigned is 26.11 latitude and 74.33 longitude",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theCurrentLocationOfTheContainerAssignedIsLatitudeAndLongitude(float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has cargo assigned as  \"snacks\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasCargoAssignedAs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its optimal internal Status assigned is 1.0 atm 20.0 celsius 50.0 % humidity",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsOptimalInternalStatusAssignedIsAtmCelsiusHumidity(float,float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its arrival date assigned is \"23-06-2020\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsArrivalDateAssignedIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the logistic company enters the container ID 10849147913510",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thatTheLogisticCompanyEntersTheContainerID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the port name is given \"Copenhagen\"",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.thePortNameIsGiven(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the port visited for the container is updated",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.thePortVisitedForTheContainerIsUpdated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the new port is \"Copenhagen\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theNewPortIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:userStories/updateContainerLocation.feature");
formatter.feature({
  "name": "Update Container Location",
  "description": " Description: The Logistic Company should be able to update the container location.",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Logistic Company can register a new location for the container",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "there is a container with the ID 10849147913500",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thereIsAContainerWithTheID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has the journey ID 10849147913523",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasTheJourneyID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the start port is given \"Gwadar\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theStartPortIsGiven(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the destination port is given \"Copenhagen\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theDestinationPortIsGiven(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the current location of the container given is 26.11 latitude and 74.33 longitude",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theCurrentLocationOfTheContainerGivenIsLatitudeAndLongitude(float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has cargo given as  \"snacks\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasCargoGivenAs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its optimal internal Status is given  1.0 atm 20.0 celsius 50.0 % humidity",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsOptimalInternalStatusIsGivenAtmCelsiusHumidity(float,float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its arrival date is given \"23-06-2020\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsArrivalDateIsGiven(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "that the logistic company enters the container ID 10849147913500",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.thatTheLogisticCompanyEntersTheContainerID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the latitude 65.4 is given",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.theLatitudeIsGiven(float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the longitude 45.85 is given",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theLongitudeIsGiven(float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the location for the container is updated",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.theLocationForTheContainerIsUpdated()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the new latitude is 65.4",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theNewLatitudeIs(float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the new longitude is 45.85",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theNewLongitudeIs(float)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:userStories/viewAllJourneys.feature");
formatter.feature({
  "name": "View All Active Journeys",
  "description": " description: The logistic Company can view all the active Journeys",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Logistic Company can view all the active Journeys",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "there is a container with assigned ID 1084914791892",
  "keyword": "Given "
});
formatter.match({
  "location": "ApplicationSteps.thereIsAContainerWithAssignedID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has the assigned journey ID 108492279189",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasTheAssignedJourneyID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has the assigned client ID 112334891",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasTheAssignedClientID(long)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the start port is assigned \"Gwadar\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theStartPortIsAssigned(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the destination port is assigned \"Copenhagen\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theDestinationPortIsAssigned(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the current location of the container assigned is 26.11 latitude and 74.33 longitude",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theCurrentLocationOfTheContainerAssignedIsLatitudeAndLongitude(float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the container has cargo assigned as  \"snacks\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.theContainerHasCargoAssignedAs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its optimal internal Status assigned is 1.0 atm 20.0 celsius 50.0 % humidity",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsOptimalInternalStatusAssignedIsAtmCelsiusHumidity(float,float,float)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "its arrival date assigned is \"23-06-2020\"",
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.itsArrivalDateAssignedIs(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the logistic company decides to view all the active Journeys",
  "keyword": "When "
});
formatter.match({
  "location": "ApplicationSteps.theLogisticCompanyDecidesToViewAllTheActiveJourneys()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "all the active journey IDs are returned which also contains the Journey ID 108492279189",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.allTheActiveJourneyIDsAreReturnedWhichAlsoContainsTheJourneyID(long)"
});
formatter.result({
  "status": "passed"
});
});