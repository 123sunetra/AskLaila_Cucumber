package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public PageObjectManager pg;
	public TestBase test;
	
	public TestContextSetup() throws IOException {
		test = new TestBase();
		pg = new PageObjectManager(test.WebDriverManager());
	}

}
