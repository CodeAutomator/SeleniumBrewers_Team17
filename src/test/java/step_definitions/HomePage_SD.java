package step_definitions;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.HomePage;
import utilities.common_utils;
import webdriver_manager.DriverManager;


public class HomePage_SD extends Constants{
	
	HomePage objhomepage = HomePage.getInstance();
	WebDriver driver = DriverManager.getDriver();
	common_utils objCommounUtils = new common_utils();
	String txtLogMessage = "";
	private static final Logger LOGGER = LogManager.getLogger(HomePage_SD.class);
	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
			
			
			driver.get(Constants.BROWSER);			
		
		LOGGER.info("Admin launch browser");
		
		
	}
	
	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_LMS_portal_URL() {
		
		
		
		objhomepage.getHomepage();
		LOGGER.info("Admin gives the correct LMS");

	}
	@Then("Admin should land on the home page")
	public void admin_should_land_on_the_home_page() {
	objhomepage.getTitleOfHomepage();
		
		LOGGER.info("Admin should land on home page");
		
	}

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
	
		objhomepage.InvalidHomeURL();
		LOGGER.info("Admin gives the Wrong LMS URL ");

	
	}

	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer expectRespCode) {
		int actualRespCode = objhomepage.getHTTPResponseCode();
        Assert.assertEquals(actualRespCode, (int) expectRespCode, "Response code do not match");
    
	}
	 @Then("HTTP response code should be greater than or equal to {int} indicating broken links")
	    public void http_response_code_should_be_greater_than_or_equal_to_indicating_broken_links(Integer int1) {
		 
		 objhomepage.checkForBrokenLinks();
	 }
	
	 @Then("Admin should see correct spellings in all fields")
		public void admin_should_see_correct_spellings_in_all_fields() {
		 boolean CorrectSpellings = objhomepage.verifyCorrectSpellings();
	    	Assert.assertTrue(CorrectSpellings, "Correct spellings are not found in one or more fields.");
	    
		}

	@Then("Admin should see correct logo of the LMS")
	public void admin_should_see_correct_logo_of_the_lms() {
		
		
		 boolean isLogoDisplayed = objhomepage.isLogoPresent(); 
		Assert.assertTrue(isLogoDisplayed, "LMS logo is not displayed.");
		LOGGER.info("Check Logo is present");
	}

	@Then("Admin should see logo is properly aligned")
	public void admin_should_see_logo_is_properly_aligned() {
		
		 boolean isLogoProperlyAligned = objhomepage.verifyLogoAllignment();
		 Assert.assertTrue(isLogoProperlyAligned, "The logo is not properly aligned.");
		LOGGER.info("Check Logo is properly aligned");
	}
		

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
		objhomepage.isLoginButtonPresent();
		LOGGER.info("Check visiblity of login button in main page");
	}

	@Then("Admin should able to click the Login button")
	public void admin_should_able_to_click_the_login_button() {
		objhomepage.ClickOnLoginBtn();
	    LOGGER.info("Checking Login Button is clicakable or not");
	}
	}


