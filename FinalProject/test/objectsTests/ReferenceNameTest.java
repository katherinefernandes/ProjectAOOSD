package objectsTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

import dataWrappers.ReferenceName;

public class ReferenceNameTest {
	private ReferenceName name;
	private ArrayList<String> middlename = new ArrayList<String>();
	private ArrayList<String> firstname = new ArrayList<String>();
	private ArrayList<String> lastname = new ArrayList<String>();
	@BeforeEach
	public void testReferenceName() {
		middlename.add("J");
		firstname.add("Mamuna");
		lastname.add("azam");
		name = new ReferenceName(firstname,middlename,lastname);
	}

	@Test
	public void testGetfirstname() {
		assertSame("Mamuna",name.getFirstName().get(0));
	}
	
	@Test
	public void testGetMiddleName() {
		assertFalse(name.getMiddleName().isEmpty());
	}
	
	@Test
	public void testGetlastname() {
		assertSame("azam",name.getLastName().get(0));
	}

}
