package userInterface;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.BaseMatcher.*;
import java.util.ArrayList;
import java.util.List;
 
import org.junit.Before;
import org.junit.Test;
 
public class Login_PageTest {
     
	boolean found = false;
	String templogin = "";
	String tempPass = "";;
     
    @Before
    public void setData(){
        this.templogin = "client1";
        this.tempPass = "admin";
        ArrayList<String> listOfValidStrings = new ArrayList<String>();
        listOfValidStrings.add("uchvbsh");
        listOfValidStrings.add("vbsu");
    }
     
    @Test
    public void testget_Input() {
        assertThat("admin",is("client1"));
    }
    
//how to properly make it because it's badddddddd
}
