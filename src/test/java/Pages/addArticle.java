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

public class addArticle {

	public addArticle(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);

	}

	WebDriver driver;

	@FindBy(name = "title")WebElement title;

	//@FindBy(name="description")WebElement descript;

	@FindBy(name = "body")WebElement body;

	public void clickonaddafrticle(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement newArticleLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("New Article")));

		newArticleLink.click();

	}

	public void settitle(String titlename) {

		title.sendKeys(titlename);


	}
	public void setDescription(WebDriver driver, String Description) {

		//driver.findElement(By.cssSelector("div.nav-link.dropdown-toggle.cursor-pointer")).click();

		System.out.println("Waiting for Description field to be visible");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("input[placeholder=\"What's this article about?\"]")
				));


		System.out.println("Description field is ready");

		element.sendKeys(Description);

	}

	public void setbodymessage(WebDriver driver,String BodyMessage) {

		body.sendKeys(BodyMessage);



	}
	public void clickonpublish(WebDriver driver) {

		WebElement publishButton = driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary[type='submit']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", publishButton);
		publishButton.click();
	}
}
