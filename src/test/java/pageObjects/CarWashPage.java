package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;









public class CarWashPage extends Gen{

	public CarWashPage(WebDriver driver) {
		super(driver);
	}
	
	By ccards = By.xpath("//span[@class='ratevalue']//ancestor::div[@class='col-xs-12 card']");
	By cwashname = By.xpath("//h2[@class='resultTitle']");
	By cwashratings = By.xpath("//span[@class='ratevalue']");
	By cwashphone = By.xpath("//label[@class='phonedisplay']");
	By reviewtext = By.xpath("//textarea[@class='commentBox']");
	By reporttext = By.xpath("//div[@id='modalFixListing']//div[@class='modal-content']//textarea");
	By reportclose = By.xpath("//div[@id='modalFixListing']//div[@class='modal-content']//button[@class='close']");
	By fmail = By.xpath("//input[@id='email']");
	By fpass = By.xpath("//input[@id='pass']");
	By flogin = By.xpath("//label[@id='loginbutton']");
	
	
	
	
	
	
	String before_review = "(//button[@class='hidden-xs btn btn-default cardFooterButtonBlue'])[";
    String after_review = "]";
    String before_share = "(//button[@title='Share'])[";
    String after_share = "]";
    String before_fb = "(//ul[@role='menu']//li//a[@data-original-title='Share on Facebook'])[";
    String after_fb = "]";
    String before_tw = "(//ul[@role='menu']//li//a[@data-original-title='Share on Twitter'])[";
    String after_tw = "]";
    String before_report = "(//div[@class='btn-group btn-input clearfix']//button[@title='Report'])[";
    String after_report = "]";
    
    Map<String, String> nameRating = new HashMap<String, String>();
    Map<String, String> nameNumber = new HashMap<String, String>();

    List<String> numReal = new ArrayList<String>();
	List<String> rateReal = new ArrayList<String>();
	
	
	public static int randomNumber(int num) {
	    Random random = new Random();
		int randomNo = (random.nextInt(num))+1;
		return randomNo;

	 }
	
	public static List<String>  getMaps(Map<String, String> m )	{
	    Map<String, String> map=m;	
	    
	    List<String> val1 = new ArrayList<String>();
		for(String k : map.keySet())
	    {
//	    	System.out.println(k+","+number.get(k));
	    	val1.add(map.get(k));
	    	
	    }
	    	return val1;
	    }
	
	public void clickBack() {
		driver.navigate().back();
	}
	
	List<WebElement> carWashRatings = driver.findElements(cwashratings);
	int size = carWashRatings.size();
    int randNum = (randomNumber(size))+1;
    
    public void displayDetails() throws InterruptedException, IOException {
    	
    	List<WebElement> carCards = driver.findElements(ccards);
    	List<WebElement> carWashName = driver.findElements(cwashname);
    	List<WebElement> carWashPhone = driver.findElements(cwashphone);
    	
    	for(int i=0; i<carCards.size(); i++) 
    	{
    		String name = carWashName.get(i).getText();
    		String rating = carWashRatings.get(i).getText();
    		String number1 = carWashPhone.get(i).getText();
    		nameRating.put(name,rating);
    		nameNumber.put(name,number1);
    	}
    	
		 numReal = getMaps(nameNumber);
		 rateReal = getMaps(nameRating);
	int i =0;
	
	for(String k : nameNumber.keySet())
	{
		String rate1 = rateReal.get(i);
        if(Double.parseDouble(rate1)>4){
        	String Name= "Name:" +k+","+"Rating: "+rate1+" Phone Number: "+ numReal.get(i);
        	System.out.println(Name);
        	System.out.println("<===========================================================================>");
        	
        	
        }
		
		i++;
	}
    }
    
    public void writeReview() throws InterruptedException {
	 
	    
    	
    	WebElement reviewButton= driver.findElement(By.xpath(before_review +randNum +after_review));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	highlightElement(reviewButton);
    	js.executeScript("arguments[0].click();", reviewButton);
    	WebElement reviewTextBox = driver.findElement(reviewtext);
    	explicitWait(reviewTextBox,10);
    	reviewTextBox.sendKeys("Very nice!!!");
    }
    
    public void shareFB() throws IOException, InterruptedException {
    	
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement shareButton = driver.findElement(By.xpath(before_share +randNum +after_share));
    	highlightElement(shareButton);
    	js.executeScript("arguments[0].click();", shareButton);
    	Thread.sleep(3000);
    	
    	WebElement fbShareButton = driver.findElement(By.xpath(before_fb + randNum + after_fb));
    	highlightElement(fbShareButton);
    	js.executeScript("arguments[0].click();", fbShareButton);

    	
    	

    	
    	Set<String> wid = driver.getWindowHandles();
    	List<String> winid = new ArrayList<String>(wid);
    	String parent = winid.get(0);
    	String child = winid.get(1);
    	String title = driver.switchTo().window(child).getTitle();
    	Thread.sleep(3000);

    		if(title.equals("Facebook")) {
    			driver.switchTo().window(child);
    			
    			Thread.sleep(2000);
    			WebElement FBEmail = driver.findElement(fmail);
    			FBEmail.sendKeys("abc@xyz");
    			WebElement FBPass = driver.findElement(fpass);
    			FBPass.sendKeys("acbsdh1234");
    			WebElement FBLogin = driver.findElement(flogin);
    			FBLogin.click();
    			
    			String err_msg = driver.findElement(By.xpath("//div[@class='_li']//div[contains(@class,'pam login_error_box')]")).getText();
    			System.out.println("Facebook Error msg : " + err_msg);
    			System.out.println("<==============================================================>");
    			driver.close();
    		}
    		driver.switchTo().window(parent);
    }
    
    public void shareTwitter() throws InterruptedException, IOException {
    	
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement shareButton = driver.findElement(By.xpath(before_share +randNum +after_share));
    	highlightElement(shareButton);
    	js.executeScript("arguments[0].click();", shareButton);
    	shareButton.click();
    	Thread.sleep(2000);
    	WebElement twShareButton = driver.findElement(By.xpath(before_tw + randNum + after_tw));
    	highlightElement(twShareButton);
    	js.executeScript("arguments[0].click();", twShareButton);

    	
    	Set<String> wid = driver.getWindowHandles();
    	List<String> winid = new ArrayList<String>(wid);
    	String parent = winid.get(0);
    	String child = winid.get(1);
    	Thread.sleep(3000);
    	driver.switchTo().window(child);
    	
    	Thread.sleep(2000);
    	driver.close();
    	driver.switchTo().window(parent);
    	
    }
    
    public void reportButton() throws InterruptedException, IOException {

    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	driver.findElement(By.xpath(before_report + randNum + after_report)).click();
    	Thread.sleep(2000);
    	WebElement reportTextArea = driver.findElement(reporttext);
    	reportTextArea.sendKeys("Service not satisfactory!");
    	
    	Thread.sleep(2000);
    	WebElement reportCloseButton = driver.findElement(reportclose);
    	highlightElement(reportCloseButton);
    	js.executeScript("arguments[0].click();", reportCloseButton);
//    	reportCloseButton.click();
    }
    

}
