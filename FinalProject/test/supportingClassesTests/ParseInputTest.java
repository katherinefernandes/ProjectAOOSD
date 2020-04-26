package supportingClassesTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import supportingClasses.InputParser;

class ParseInputTest {
	private static InputParser parser;
	
	@BeforeEach
	public void parseInputTest() {
		parser = new InputParser();
	}
	
	@Test
	public void testParsingNames() {
		assertSame(new ArrayList<String>(Arrays.asList("muna")).size(),parser.parsingNames("muna").size());
	}

}
