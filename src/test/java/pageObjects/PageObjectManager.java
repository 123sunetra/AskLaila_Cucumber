package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public HomePage hp;
	public LocationPage lp;
	public GymandSearchPage gsp;
	public CarWashPage cp;
	public FreeListingPage fp;
	public GymPage gp;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public HomePage getHomePage() {
		hp = new HomePage(driver);
		return hp;
	}
	
	public LocationPage getLocationPage() {
		lp = new LocationPage(driver);
		return lp;
	}
	
	public GymandSearchPage getGymandSearchPage() {
		gsp = new GymandSearchPage(driver);
		return gsp;
	}
	
	public CarWashPage getCarWashPage() {
		cp = new CarWashPage(driver);
		return cp;
	}
	
	public FreeListingPage getFreeListingPage() {
		fp = new FreeListingPage(driver);
		return fp;
	}
	
	public GymPage getGymPage() {
		gp = new GymPage(driver);
		return gp;
	}

}
