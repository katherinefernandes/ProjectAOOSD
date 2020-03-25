package objectsDataTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import objectsData.PhoneNumber;

public class PhoneNumberTest {


	private PhoneNumber objectTest;
	
	
	@Before
	public void test() {
		objectTest = new PhoneNumber(36,8978789);
	}
	
	@Test
	public void testCountrycode() {
		assertEquals(36,objectTest.getCountryCode());
	}
	
	@Test
	public void testPhoneNumber() {
		assertEquals(8978789,objectTest.getPhone());
	}

}
