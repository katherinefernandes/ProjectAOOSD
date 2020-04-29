package logicTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import org.junit.Before;
import org.junit.Test;

import businessObjects.Container;
import businessObjects.Port;
import logic.LogisticController;
import supportingClasses.InputParser;
import supportingClasses.ValidInput;

public class LogisticsControllerTest {

	private ValidInput validate;
	private String firstname;
	private String middlename;
	private String lastname;
	private LogisticController logistics;

	@Before
	public void initialize() {
		logistics = new LogisticController();
		validate = new ValidInput();
		
	}
	
	@Test
	public void updateStatusTest() {
		// the try catch blocks 	
		
	}
	
	
	@Test
	public void getCountainerDataTest() {
		

		
	}
	
	@Test
	public void findClientByEmailTest() {
		
	}
	
	
	@Test
	public void findClientByPhoneTest() {
		
	}
	
	
	@Test
	public void findClientByReferencePerson() {
		
		
		
	}
	
	@Test
	public void findClientByReferencePersonTest() {
	   
		
		
	}
	
	@Test
	public void viewClientTest() {
		
		
		
	}
	
	@Test	
	public void addNewClientTest() {
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}