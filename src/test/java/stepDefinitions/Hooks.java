package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup testcon;
	
	public Hooks(TestContextSetup testcontext) {
		this.testcon=testcontext;
	}
	
	@After
	public void AfterScenario() throws IOException {
		testcon.test.WebDriverManager().quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario sc) throws IOException {
		WebDriver d = testcon.test.WebDriverManager();
//		if(sc.isFailed()) {
		try {
			File sourcepath = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
			byte[] filecontent = FileUtils.readFileToByteArray(sourcepath);
			sc.attach(filecontent, "image/png", "image");
		}
		catch(Exception e) {
			
		}
//		}
	}

}
