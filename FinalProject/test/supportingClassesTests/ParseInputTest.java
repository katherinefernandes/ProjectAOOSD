package supportingClassesTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import supportingClasses.parseInput;

class ParseInputTest {
	private parseInput parser;
	
	@Before
	public void parseInputTest() {
		parser = new parseInput();
	}
	
	@Test
	public void testParsingNames() {
		assertSame(new ArrayList<String>(Arrays.asList("muna")).size(),parseInput.parsingNames("muna").size());
	}

}
