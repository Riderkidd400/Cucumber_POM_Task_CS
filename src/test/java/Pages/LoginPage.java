package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		
	}

	
	//@FindBy(className =  "nav-link")WebElement loginpage;
		@FindBy(name = "email")WebElement username;
		@FindBy(name  = "password")WebElement password;
		@FindBy(css = "button")WebElement loginbutton;
		
		
		public void logintothewebsite( String user_name, String pass_word){
			
			
//			loginpage.click();
			username.sendKeys(user_name);
			password.sendKeys(pass_word);
			
			
			
		}
		public void loginclick( ){
			
			loginbutton.click();
				
			}
	
		public boolean isheaderdisplayed(WebDriver driver) {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			WebElement newArticleLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New Article")));
			
			
			if(newArticleLink.isDisplayed()) {
				
				System.out.println("NewArticle is Enabled");
			}else {
				
				System.out.println("oops");
			}
			return true;
				
		}
		
}
