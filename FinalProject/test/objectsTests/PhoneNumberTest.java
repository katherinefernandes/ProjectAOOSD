package objectsTests;

import static org.junit.Assert.*;

import org.junit.jupiter.api.*;

import dataWrappers.PhoneNumber;

public class PhoneNumberTest {


	private PhoneNumber objectTest;
	
	
	@BeforeEach
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
