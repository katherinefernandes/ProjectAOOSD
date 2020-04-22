package acceptanceTests.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import exceptions.ElementNotFoundException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import users.CurrentClientV2;
import users.User;

public class UserSteps {
	private String errorMessage;
	private long clientID;
	private User user;
	private long containerID;
	private String portName;
	private CurrentClientV2 clientManager;
	private long portID;
	private boolean result;


	@Given("that the client ID {long} is entered")
	public void thatTheClientIDIsEntered(long clientID) {
	    // Write code here that turns the phrase above into concrete actions
		this.clientID = clientID;
		user = new User();
	}

	@When("the database is asked to return the client information")
	public void theDatabaseIsAskedToReturnTheClientInformation() {
	    try {
			user.getClient(clientID);
			errorMessage = "none";
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			errorMessage = "ElementNotFoundException";
		}
	}

	
	@Then("error message {string} is given")
	public void errorMessageIsGiven(String error) {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(errorMessage.equals(error));
	}
	
	@Given("that the container ID {long} is entered")
	public void thatTheContainerIDIsEntered(long containerID) {
	    // Write code here that turns the phrase above into concrete actions
		this.containerID = containerID;
		user = new User();
	}

	@When("the database is asked to return the container information")
	public void theDatabaseIsAskedToReturnTheContainerInformation() {
	    // Write code here that turns the phrase above into concrete actions
		   try {
				user.getContainer(containerID);
				errorMessage = "none";
			} catch (ElementNotFoundException e) {
				// TODO Auto-generated catch block
				errorMessage = "ElementNotFoundException";
			}
	}
	@Given("that the port name {string} is entered")
	public void thatThePortNameIsEntered(String portName) {
	    // Write code here that turns the phrase above into concrete actions
	    this.portName=portName;
	    clientManager = new CurrentClientV2(555555555555l);
	}

	@When("the database is asked to return the portID")
	public void theDatabaseIsAskedToReturnThePortID() {
	    // Write code here that turns the phrase above into concrete actions
		this.portID = clientManager.getPortID(portName);
	}

	@Then("the ID {long} is returned which means that port name is not valid")
	public void theIDIsReturnedWhichMeansThatPortNameIsNotValid(long portID) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(portID,this.portID);
	}
	@Given("that the portID {long} is entered")
	public void thatThePortIDIsEntered(long portID) {
	    // Write code here that turns the phrase above into concrete actions
		this.portID=portID;
		clientManager = new CurrentClientV2(555555555555l);
	}

	@When("the database is asked to return the port data")
	public void theDatabaseIsAskedToReturnThePortData() {
	    // Write code here that turns the phrase above into concrete actions
	    result = clientManager.updateDestinationPort(portID);
	}

	@Then("error message is returned")
	public void errorMessageIsReturned() {
	    // Write code here that turns the phrase above into concrete actions
	    assertFalse(result);
	}
}
