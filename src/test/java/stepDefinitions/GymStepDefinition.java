package stepDefinitions;
import java.io.IOException;

import io.cucumber.java.en.*;
import pageObjects.GymPage;
import utils.TestContextSetup;

public class GymStepDefinition {
	
	public TestContextSetup test;
	
	public GymStepDefinition(TestContextSetup testcontent) {
		this.test = testcontent;
	}

	@Then("chooses all the gym sub-categories available")
	public void chooses_all_the_gym_sub_categories_available() throws IOException, InterruptedException {
	    GymPage gp = test.pg.getGymPage();
	    gp.clickSubCategory();
	    gp.subCategories();
	    Thread.sleep(2000);
	}
}
