package MyTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		features = "src//test//resources//features//Article.feature",
		glue = {"stepDefs"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty",
				
				"html:target/Reports/HTMLReport.html",
				"rerun:test-output/failedreports.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				
					
		}
		) 




public class MyTestRunner extends AbstractTestNGCucumberTests{
	
	
}
