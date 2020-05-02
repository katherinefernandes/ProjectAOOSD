package containerFilterTests;


import org.junit.jupiter.api.Test;

import businessObjects.Client;
import businessObjects.Container;
import businessObjects.Port;
import containerFilters.FilterByPortName;
import supportingClasses.InputParser;
import supportingClasses.Security;

class FilterByPortNameTest {
	
	
	@Test
	void test() {
		Security generateID = new Security();
		Container c1 = new Container( 232383l,31l, 780l,36l ,  234l,  10.0f,  19.0f,  "cargo",  10.0f,  1.0f,  60.0f, "10-09-2021");
		Container c2 = new Container( 6283l,31l, 781l, 38l,  102l,  10.0f,  19.0f,  "cargo",  10.0f, 1.0f,  78.0f, "10-09-2021");
		Container c3 = new Container( 8973l,31l, 782l, 89l, generateID.generateIDFromSecureRandom(),  10.0f,  19.0f,  "cargo", 10.0f,  1.0f,  90.0f, "10-09-2021");
		Port p1 = new Port(36l,"Pakistan","gawadar",36.0f,87.0f);
		Client cl1 = new Client(31l,"company",92,23789,"email@eh.com",InputParser.parsingNames("firstname"),InputParser.parsingNames("middlename"),InputParser.parsingNames("lastname"),"g11/2","Islamabad",59,"2620");
		cl1.addActiveShipment(232383l);
		cl1.addActiveShipment(6283l);
		cl1.addActiveShipment(8973l);
		p1.save();
		cl1.save();
		c1.save();c2.save();c3.save();
		FilterByPortName filter = new FilterByPortName(cl1,36l);
		filter.filterContainers();
		
		
	}

}
