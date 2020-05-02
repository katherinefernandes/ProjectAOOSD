package supportingClassesTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import supportingClasses.ValidInputType;

class ValidInputTypeTest {

	@Test
	void testValidateInteger() {
		ValidInputType validate = new ValidInputType();
		assertTrue(validate.validateInteger("89"));
		assertFalse(validate.validateInteger("ma910"));
		
		
	}

	@Test
	void testValidateLong() {
		ValidInputType validate = new ValidInputType();
		assertTrue(validate.validateLong("888888"));
		assertFalse(validate.validateLong("278md"));
	}

	@Test
	void testValidateFloat() {
		ValidInputType validate = new ValidInputType();
		assertTrue(validate.validateFloat("89.9"));
		assertFalse(validate.validateFloat("918m"));
		
	}

}
