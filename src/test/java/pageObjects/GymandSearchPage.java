package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GymandSearchPage extends Gen{

	public GymandSearchPage(WebDriver driver) {
		super(driver);
	}
	
	By search = By.xpath("//input[@id='what']");
	By find = By.xpath("//button[@class='btn btn-default']");
	By freelist = By.xpath("//div[@class='btn-group']//a[@class='btn cardFooterButtonBlue']");
	By gym = By.xpath("//div[@class='col-xs-6 col-sm-6 col-md-3 col-lg-3 pad0'][34]");
	
	
	public void searchText() throws InterruptedException, IOException {

		WebElement searchbox = driver.findElement(search);
		WebElement findButton = driver.findElement(find);
		explicitWait(searchbox,10);
		searchbox.sendKeys("Car Washing Services");
		highlightElement(findButton);
		findButton.click();
	}
	
	public void clickFreeListing() {
		WebElement freeListingButton = driver.findElement(freelist);
		highlightElement(freeListingButton);
		freeListingButton.click();
	}
	
	public void selectGym() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1800)","");
		WebElement gymGrid = driver.findElement(gym);
		highlightElement(gymGrid);
		gymGrid.click();
	}
	
	public String getSearchPageTitle() {
		return driver.getTitle();
	}

}
