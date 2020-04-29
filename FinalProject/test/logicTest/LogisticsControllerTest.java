package logicTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import businessObjects.Container;
import businessObjects.Port;
import logic.LogisticController;
import supportingClasses.InputParser;

public class LogisticsControllerTest {


	private String firstname;
	private String middlename;
	private String lastname;

	@Before
	public void initialize() {
		LogisticController logistics = new LogisticController();
		
	}
//	
//	@Test
//	public void updateStatusTest() {
//		// the try catch blocks 	
//		
//	}
//	
//	
//	@Test
//	public void getCountainerDataTest() {
//		
//
//		
//	}
//	
//	@Test
//	public void findClientByEmailTest() {
//		
//	}
//	
//	
//	@Test
//	public void findClientByPhoneTest() {
//		
//	}
//	
//	
//	@Test
//	public void findClientByReferencePerson() {
//		
//		
//		
//	}
	
	@Test
	public void findClientByReferencePersonTest() {
	    InputParser.parsingNames(firstname);
	    InputParser.parsingNames(middlename);
	    InputParser.parsingNames(lastname);
		
		
	}
	
	
	
	
	
	
	
	
	
	
}