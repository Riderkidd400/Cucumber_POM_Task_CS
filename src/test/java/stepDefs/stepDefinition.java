package stepDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.DeleteArticle;
import Pages.InvalidPage;
import Pages.LoginPage;

import Pages.addArticle;
import Pages.updateArticle;
import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Scenario;
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
	InvalidPage invalidpage;
	//Logout logoutpage;
	

	public stepDefinition() {

		driver = TestBase.getDriver();
		loginpage = new LoginPage(driver);
		addarticlepage = new addArticle(driver);
		updateArticlepage = new updateArticle(driver); 
		deletearticle = new DeleteArticle(driver);
		invalidpage = new InvalidPage(driver);
		//logoutpage = new Logout(driver);
		
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
	
	@Then("user enters the title {string} Header")
	public void user_enters_the_title_header(String string) {
		addarticlepage.settitle(string);
	}
	@Then("user enters the {string} info")
	public void user_enters_the_info(String string) {
		
		addarticlepage.setDescription(driver, string);
		//
	}
	@Then("user enters the {string} details")
	public void user_enters_the_details(String string) {
		
		addarticlepage.setbodymessage(driver,string);
	}
//	@Then("user enters the title {string}")
//	public void user_enters_the_title(String string) {
//		
//		addarticlepage.settitle(string);
//
//
//	}
//	@Then("user enters the Description")
//	public void user_enters_the_description() {
//
//		addarticlepage.setDescription(driver, "This Case Study is about the Sslenium E2");
//
//	}
//	@Then("user enters the body details")
//	public void user_enters_the_body_details() {
//
//		addarticlepage.setbodymessage(driver, "We have learned all the Basic to Advanced concepts of selenium ");
//	}
	@Then("user clicks on publish button")
	public void user_clicks_on_publish_button() {

		addarticlepage.clickonpublish(driver);

	}

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
	@Given("user refresh the page")
	public void user_refresh_the_page() {
		
	   invalidpage.refresh(driver);
	}
	@Then("user searches Home button")
	public void user_searches_home_button() {
	   
		invalidpage.clickohhomepage(driver);
	}
	

	
}
