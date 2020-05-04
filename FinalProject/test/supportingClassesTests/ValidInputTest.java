package supportingClassesTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import supportingClasses.ValidInput;

public class ValidInputTest {
	private ValidInput validate;
	
	@Before
	public void Initialize() {
		validate = new ValidInput();
	}
	
	@Test
	public void validateCountryCode() {
		assertTrue(validate.validateCountryCode(32));
		assertFalse(validate.validateCountryCode(2000));
		assertFalse(validate.validateCountryCode(-2));
	}
	
	@Test
	public void validatePhone() {
		assertTrue(validate.validatePhone(999999l));
		assertFalse(validate.validatePhone(32l));
		assertFalse(validate.validatePhone(35362792937747373l));
		
	}
	
	@Test
	public void validateLocation() {
		assertFalse(validate.validateLocation(-181));
		assertFalse(validate.validateLocation(190));
		assertTrue(validate.validateLocation(180));
		assertTrue(validate.validateLocation(-180));
		assertTrue(validate.validateLocation(100));
		
	}
	
	@Test
	public void validateDate() {
		assertTrue(validate.validateDate("09-10-2020"));
		assertFalse(validate.validateDate("9019"));
		assertFalse(validate.validateDate("02-05-2020"));
	}
	
	@Test
	public void validateEmail() {
		assertTrue(validate.validateEmail("email@email.com"));
		assertFalse(validate.validateEmail("someemail"));
	}
	
	
	
	
	
}
