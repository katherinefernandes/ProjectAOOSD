package supportingClassesTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import supportingClasses.InputParser;

class ParseInputTest {
	
	@Test
	public void testParsingNames() {
		assertSame(new ArrayList<String>(Arrays.asList("muna")).size(),InputParser.parsingNames("muna").size());
		InputParser parser = new InputParser();
		assertSame(new ArrayList<String>(Arrays.asList("muna")).size(),parser.parsingNames("muna").size());
	}

}
