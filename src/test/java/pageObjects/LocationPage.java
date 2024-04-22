package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class LocationPage extends Gen{

	public LocationPage(WebDriver driver) {
		super(driver);
	}
	
	By Bangaloreclick = By.xpath("(//div[@class='col-xs-12 col-sm-6 col-md-4 col-lg-4'])[2]");
	
	public void clickBangalore() throws InterruptedException, IOException {

		WebElement Bangalore = driver.findElement(Bangaloreclick);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)","");
		explicitWait(Bangalore,10);
		highlightElement(Bangalore);
		Bangalore.click();
//		Thread.sleep(2000);
	}

}
