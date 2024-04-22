package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gen {

public WebDriver driver;
	
	public Gen(WebDriver driver) {
		this.driver = driver;
	}

	public void highlightElement(WebElement element) {
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
		}catch(Exception e) {}
	}
	
	public void explicitWait(WebElement element,int time) {
		WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(time));
		mywait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
