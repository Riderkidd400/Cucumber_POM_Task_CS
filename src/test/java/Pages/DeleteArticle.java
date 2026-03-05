package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DeleteArticle {
	
	static Alert alert;

	public DeleteArticle(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		
	}
	
	
public void Articledelete(WebDriver driver) {
		
		System.out.println("Article Delete Initiated");
		
		driver.findElement(By.xpath("(//*[@class=\"btn btn-sm\"])[1]")).click();
		
	}

public void switchtoalert(WebDriver driver) {
	
	 alert = driver.switchTo().alert();
}


public void acceptalert(WebDriver driver) {
	
	alert.accept();
	
	System.out.println("Article Deleted ");
	
}
}
