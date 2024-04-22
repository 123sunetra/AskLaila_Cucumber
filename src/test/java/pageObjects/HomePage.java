package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class HomePage extends Gen {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	By locationButton = By.xpath("(//button[@type='button' and text()='Nevermind! I am in a roaming mode.'])[1]");
	By IndiaTile = By.xpath("(//div[@class='col-xs-12 col-sm-6 col-md-4 col-lg-4'])[1]");
	
	
	public void roamingclick() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement loc = driver.findElement(locationButton);
		highlightElement(loc);
		explicitWait(loc,10);
		js.executeScript("arguments[0].click();", loc);
	}
	
	public String IndiaClick() throws InterruptedException, IOException {
        
        String title_act=driver.getTitle();
        WebElement India = driver.findElement(IndiaTile);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)","");
		explicitWait(India,10);
		Thread.sleep(2000);
		highlightElement(India);
		India.click();
		return title_act;
	}

	
}
