package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import wdMethods.ProjMethods;

public class HomePage_StepDefinitions extends ProjMethods{
		
	private HomePage homePage;
	
	public HomePage_StepDefinitions() {
		homePage = new HomePage();
	}
	

	@Given("I landing to the home page")
	public void iLandingToTheHomePage() {
		try {
		homePage.verifyHomePage();
		}catch (Exception e) {
			reportStep("Failed in landing to the home page "+ e, "FAIL",true);
		}
		
	}
	
	@When("I enter the productname and verify appropriate search result is displayed")
	public void iEnterTheProductnameAndVerifyAppropriateSearchResultIsDisplayed() {
		try {
			homePage.searchByProductName();
		} catch (Exception e) {
			e.printStackTrace();
			reportStep("Failed in enter the productname and verify appropriate search result is displayed " + e, "FAIL", true);
		}
	}

	
	
}
