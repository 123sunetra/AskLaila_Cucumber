package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FreeListingPage extends Gen{

	public FreeListingPage(WebDriver driver) {
		super(driver);
	}
	
	By fllogin = By.xpath("//div[@id='flowEntry']//button");
	
	
	By mail = By.xpath("//input[@id='loginEmail']");
	
	
	By pass = By.xpath("//input[@id='loginPassword']");
	
	
	By lgnbtn = By.xpath("//button[@id='loginRes']");
	
	
	By errormsg = By.xpath("//div[@id='errdiv']");
	
	
	By cross = By.xpath("//div[@class='modal-header loginTitle']//button[@type='button']");
	
	
	public void clickFreeListingLogin() {
		WebElement freeListingLogin = driver.findElement(fllogin);
		freeListingLogin.click();
	}
	
	public void enterEmail() {
		WebElement email = driver.findElement(mail);
		email.sendKeys("abcxyz");
	}
	
	public void enterPassword() {
		WebElement password = driver.findElement(pass);
		password.sendKeys("12345");
	}
	
	public void clickLoginButton() throws InterruptedException {
		WebElement loginButton = driver.findElement(lgnbtn);
		loginButton.click();
		
	}
	
	public String freeListingErrorMsg() {
		WebElement freeListingErrormsg = driver.findElement(errormsg);
		explicitWait(freeListingErrormsg,10);
		String msg = freeListingErrormsg.getText();
		return msg;
	}
	
	public void cross() throws InterruptedException {
		WebElement crossButton = driver.findElement(cross);
		crossButton.click();
		Thread.sleep(1000);
		
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	

}
