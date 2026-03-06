package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {

	public Logout(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "img.user-pic") WebElement picselection;
	
	public void clickonimage() {
		
		picselection.click();
	}
	
	public void logout(WebDriver driver) {
		
		List<WebElement> element = driver.findElements(By.cssSelector("img.user-pic"));
		
		for(WebElement ele : element) {
			
			System.err.println(ele.getText());
		}
		
	}
	
}
