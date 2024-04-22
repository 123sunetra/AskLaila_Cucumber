package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class TestBase {
	
public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {
		
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		chromeOptions.addArguments("--disable-notifications");
		EdgeOptions edgeOptions=new EdgeOptions();
		edgeOptions.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		edgeOptions.addArguments("--disable-notifications");
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		if(driver==null) {
			if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver(chromeOptions);
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				driver = new EdgeDriver(edgeOptions);
			}
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    driver.get(url);
	    driver.manage().window().maximize();
		}
		return driver;
	}

}
