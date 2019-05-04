package steps;




import cucumber.api.java.Before;
import utilities.SeleniumDriver;

public class BeforeActions  {

	@Before
    public static void setUp() {
		//ExtentCucumberFormatter.initiateExtentCucumberFormatter();
       SeleniumDriver.setupDriver();
    }
}
