package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class updateArticle {

	public updateArticle(WebDriver driver) {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(driver, this);
	}

	WebDriver driver;

	@FindBy(name="title")WebElement title;
	@FindBy(name="tags")WebElement tags;

	public void EditTheArticle(WebDriver driver) {

		driver.findElement(By.linkText("Edit Article")).click();


	}

	public void update(WebDriver driver, String description) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
		    By.cssSelector("input[placeholder=\"What's this article about?\"]")
		));
		
		element.clear();
		
		element.sendKeys(description);
	}
	
	public void Entertags(String tagsentry) {
		
		tags.sendKeys(tagsentry);
		
	}

	public void clickonupdate(WebDriver driver) {

		WebElement publishButton = driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary[type='submit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", publishButton);
		publishButton.click();
	}

}
