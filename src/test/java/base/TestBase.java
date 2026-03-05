	package base;

import java.security.PublicKey;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {

	private static TestBase testbase;

	private static WebDriver driver;

	private TestBase() {

		String Browser = "chrome";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		if(Browser.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver(options);
		}

		else if (Browser.equalsIgnoreCase("edge")) {

			driver =new EdgeDriver();
		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().deleteAllCookies();

	}

	public static void intidriver() {
		

		if(testbase == null) {

			testbase = new TestBase();
		}

	}

	public static WebDriver getDriver() {

		return driver;
	}

	public static void OpenUrl(String Url) {

		driver.get(Url);
	}

	public static void teardown() {

		if(driver != null) {
			
			driver.close();
		}
		
		testbase = null;
	}



}
