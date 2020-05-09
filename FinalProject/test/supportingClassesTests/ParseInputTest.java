package supportingClassesTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import supportingClasses.InputParser;

class ParseInputTest {
	
	@Test
	public void testParsingNames() {
		assertSame(new ArrayList<String>(Arrays.asList("muna")).size(),new InputParser().parsingNames("muna").size());
		assertSame(new ArrayList<String>(Arrays.asList("muna")).size(),new InputParser().parsingNames("muna").size());
	}

}
