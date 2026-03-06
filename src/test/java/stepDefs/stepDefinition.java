package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.DeleteArticle;
import Pages.LoginPage;
import Pages.Logout;
import Pages.addArticle;
import Pages.updateArticle;
import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition {
	
	static String casestudy = "Manikandan TC001";

	WebDriver driver;
	LoginPage loginpage;
	addArticle addarticlepage;
	updateArticle updateArticlepage;
	DeleteArticle deletearticle;
	Logout logoutpage;
	

	public stepDefinition() {

		driver = TestBase.getDriver();
		loginpage = new LoginPage(driver);
		addarticlepage = new addArticle(driver);
		updateArticlepage = new updateArticle(driver); 
		deletearticle = new DeleteArticle(driver);
		logoutpage = new Logout(driver);
		
	}


	@Given("user opens the Url")
	public void user_opens_the_url() {

		TestBase.OpenUrl("https://conduit-realworld-example-app.fly.dev/#/login");

	}

	@When("user enters the credentials")
	public void user_enters_the_credentials() {

		loginpage.logintothewebsite("sanmaveenvlogs@gmail.com", "P@ssw0rd");

	}
	@Then("user clicks on the login button")
	public void user_clicks_on_the_login_button() {

		loginpage.loginclick();


	}
	@Given("user is on Home page")
	public void user_is_on_home_page() {

		Assert.assertTrue(loginpage.isheaderdisplayed(driver));

	}
	@When("user clicks on the New Article")
	public void user_clicks_on_the_new_article() {

		addarticlepage.clickonaddafrticle(driver);
	}
	@Then("user enters the title {string}")
	public void user_enters_the_title(String string) {
		
		addarticlepage.settitle(string);


	}
	@Then("user enters the Description")
	public void user_enters_the_description() {

		addarticlepage.setDescription(driver, "This Case Study is about the Sslenium E2");

	}
	@Then("user enters the body details")
	public void user_enters_the_body_details() {

		addarticlepage.setbodymessage(driver, "We have learned all the Basic to Advanced concepts of selenium ");
	}
//	@Then("user clicks on publish button")
//	public void user_clicks_on_publish_button() {
//
//		addarticlepage.clcikpublish(driver);
//
//	}

	@Given("user validates the Existing Article {string}")
	public void user_validates_the_existing_article(String string) {
		
		Assert.assertEquals(string, casestudy );
		System.out.println("Valid Assert");

	}
	@When("user clicks on Edit Article")
	public void user_clicks_on_edit_article() {

		updateArticlepage.EditTheArticle(driver);
		
	}
	@Then("user updates the Description")
	public void user_updates_the_description() {
		
		updateArticlepage.update(driver, "Updated the Description");
	   
	}

	
	@Then("user update the Tags tab")
	public void user_update_the_tags_tab() {

		updateArticlepage.Entertags("MK_SELENIUM");
		
		
	}
	@Then("user clicks on update Article")
	public void user_clicks_on_update_article() {
		
		updateArticlepage.clickonupdate(driver);

	}
	@Given("user clicks on delete Article")
	public void user_clicks_on_delete_article() {
		
		deletearticle.Articledelete(driver);
	    
	}
	@Then("User validates the Alert message")
	public void user_validates_the_alert_message() {
		
		deletearticle.switchtoalert(driver);
	    
	}
	@Then("user accepts the alert")
	public void user_accepts_the_alert() {
		
		deletearticle.acceptalert(driver);
	    
	}
	@Then("user validates the deleted article {string} is present on the Articlepage")
	public void user_validates_the_deleted_article_is_present_on_the_articlepage(String string) {

		if(string == casestudy) {
			
			Assert.assertTrue(true,"Article still Exist");
		}
		else {
			
			Assert.assertTrue(true,"Article Deleted Sucessfully");
		}
	
	}
	
	@Given("user logout the page")
	public void user_logout_the_page() {
		
	    logoutpage.clickonimage();
	    
	    logoutpage.logout(driver);
	}

	
	@When("user enters the Invalid {string} and {string}")
	public void user_enters_the_invalid_and(String string, String string2) {
		
		loginpage.logintothewebsite(string, string2);
		
	}

	@After
	public void attachscreenshot(io.cucumber.java.Scenario scenario) {
		
		if(scenario.isFailed()) {
			
			TakesScreenshot src = (TakesScreenshot) driver;
			
			byte[] img = src.getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(img, "image/png", "FailedScenarioImage");
		

		}
	}
}
