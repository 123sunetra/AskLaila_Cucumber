package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.GymandSearchPage;
import pageObjects.HomePage;
import pageObjects.LocationPage;
import utils.TestContextSetup;


public class HomePageStepDefinition {
	
	public GymandSearchPage gs;
	public TestContextSetup test;
	
	public HomePageStepDefinition(TestContextSetup testcontent) {
		this.test = testcontent;
		gs = test.pg.getGymandSearchPage();
	}
	
	@Given("user clicks on required location and lands on homepage")
	public void user_clicks_on_required_location_and_lands_on_homepage() throws InterruptedException, IOException {
	   HomePage hp = test.pg.getHomePage();
	   LocationPage lp = test.pg.getLocationPage();
	   hp.roamingclick();
	   String title_act=hp.IndiaClick();
	   Assert.assertEquals(title_act, "AskLaila - Local information service.");
	   lp.clickBangalore();
	}

	@When("user searches for carwash services")
	public void user_searches_for_carwash_services() throws InterruptedException, IOException {
		gs.searchText();
	}

	@Then("navigates back to homepage and clicks on freelisting")
	public void navigates_back_to_homepage_and_clicks_on_freelisting() throws InterruptedException {

//		if(!gs.getSearchPageTitle().equals("AskLaila Bangalore - India's local information service.")) {
//			test.driver.navigate().back();
//			Thread.sleep(3000);
//		}
		gs.clickFreeListing();
	}

	@Then("navigates back and clicks on gym")
	public void navigates_back_and_clicks_on_gym() {
	    gs.selectGym();
	}






}
