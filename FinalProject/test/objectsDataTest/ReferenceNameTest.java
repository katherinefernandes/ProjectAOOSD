package objectsDataTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import objectsData.ReferenceName;

public class ReferenceNameTest {
	private ReferenceName name;
	private ArrayList<String> middlename = new ArrayList<String>();
	
	@Before
	public void testReferenceName() {
		middlename.add("J");
		name = new ReferenceName("Mamuna",middlename,"azam");
	}
	
	@Test
	public void testGetfirstname() {
		assertSame("Mamuna",name.getFirstName());
	}
	
	@Test
	public void testGetMiddleName() {
		assertFalse(name.getMiddleName().isEmpty());
	}
	
	@Test
	public void testGetlastname() {
		assertSame("azam",name.getLastName());
	}

}
