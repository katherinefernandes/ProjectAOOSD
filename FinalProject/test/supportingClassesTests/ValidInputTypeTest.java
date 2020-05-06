package supportingClassesTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import supportingClasses.ValidInputType;

class ValidInputTypeTest {

	//The reason why i am using the object and not the static method is for coverage, idk why but it doesnot cover the class otherwise
	//Mamuna
	@Test
	void testValidateInteger() {
		assertTrue(new ValidInputType().validateInteger("89"));
		assertFalse(ValidInputType.validateInteger("ma910"));
		
		
	}

	@Test
	void testValidateLong() {
		assertTrue(ValidInputType.validateLong("888888"));
		assertFalse(ValidInputType.validateLong("278md"));
	}

	@Test
	void testValidateFloat() {
		assertTrue(ValidInputType.validateFloat("89.9"));
		assertFalse(ValidInputType.validateFloat("918m"));
		
	}

}
