package stepDefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {

	
	@BeforeAll
	public static void setupDriver() {
		
		TestBase.intidriver();
		
	}
	
	@After
	public void teardown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			
			TakesScreenshot src = (TakesScreenshot)TestBase.getDriver();
			byte[] img = src.getScreenshotAs(OutputType.BYTES);
			scenario.attach(img, "image/png", "FailedScenarioImage");
			
		}
		
	}
	
	
}
