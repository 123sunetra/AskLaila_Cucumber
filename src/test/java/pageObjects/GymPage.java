package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class GymPage extends Gen{

	public GymPage(WebDriver driver) {
		super(driver);
	}
	
	By category = By.xpath("//div[@id='searchSubCategory']//button");
	
	
	By gymcards = By.xpath("//div[@id='searchSubCategory']//ul[@class='dropdown-menu pad0']//li");
	
	
	public void clickSubCategory() {
		WebElement gymSubCategory = driver.findElement(category);
		highlightElement(gymSubCategory);
		gymSubCategory.click();
	}
	
	public void subCategories() throws IOException{
		
		System.out.println("Gym Categories : ");
		List<WebElement> categories = driver.findElements(gymcards);
    	for(WebElement g:categories) {
    		String Category = g.getText();
    		System.out.println(Category);
    	}
    	System.out.println("<===========================>");
	}
		
	

}
