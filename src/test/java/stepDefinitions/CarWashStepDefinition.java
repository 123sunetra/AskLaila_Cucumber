package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.*;
import pageObjects.CarWashPage;
import utils.TestContextSetup;

public class CarWashStepDefinition {
	
	public CarWashPage cp;
	public TestContextSetup test;
	
	public CarWashStepDefinition(TestContextSetup testcontent) {
		this.test = testcontent;
		cp = test.pg.getCarWashPage();
	}
	
	@When("lists all the top five car wash services whose ratings are greater than four")
	public void lists_all_the_top_five_car_wash_services_whose_ratings_are_greater_than_four() throws InterruptedException, IOException {
		
		cp.displayDetails();
		
		
	}
	

	@When("writes a review, shares on fb and twitter, and reports the service")
	public void writes_a_review_shares_on_fb_and_twitter_and_reports_the_service() throws IOException, InterruptedException {
		
		cp.writeReview();
		cp.clickBack();
		Thread.sleep(2000);
		cp.shareFB();
		cp.shareTwitter();
		cp.reportButton();
		cp.clickBack();
		Thread.sleep(3000);
	}

}
