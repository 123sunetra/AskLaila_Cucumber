package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.FreeListingPage;
import utils.TestContextSetup;

public class FreelistingStepDefinition {
	
	public TestContextSetup test;
	
	public FreelistingStepDefinition(TestContextSetup testcontent) {
		this.test = testcontent;
	}

	

	@Then("captures the error message after providing credentials")
	public void captures_the_error_message_after_providing_credentials() throws InterruptedException {
		FreeListingPage fp = test.pg.getFreeListingPage();
		fp.clickFreeListingLogin();
		fp.enterEmail();
		fp.enterPassword();
		fp.clickLoginButton();
		String error_msg = fp.freeListingErrorMsg();
		System.out.println("FreeListing Error Message : " + error_msg);
		System.out.println("<=========================================================>");
		fp.cross();
		fp.navigateBack();
	}
}
