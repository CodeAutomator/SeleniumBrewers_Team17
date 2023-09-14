package step_definitions;


import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.DashboardPage;
import page_objects.HomePage;
import page_objects.LoginPage;

import utilities.common_utils;
import webdriver_manager.DriverManager;

public class Dashboard_SD {
	
DashboardPage objdashboard= DashboardPage.getInstance();
	LoginPage objlogin = LoginPage.getInstance();
	WebDriver driver = DriverManager.getDriver();
	common_utils objCommounUtils = new common_utils();
	String txtLogMessage = "";
	private static final Logger LOGGER = LogManager.getLogger(HomePage.class);
	
	
//	@Given("Admin is on dashboard page after Login")
//	public void admin_is_on_dashboard_page_after_login() {
//		driver.get(Constants.LOGIN_URL);
//		driver.manage().window().maximize();
//		
//		LOGGER.info("Admin is on dashboard page : ");
//		
//		System.out.println("Admin is on dashboard page after login ");
//	}
//	
	@Then("Admin should see manage program as header")
	public void admin_should_see_manage_program_as_header() {
		
        assertTrue("Manage Program header is not displayed", objdashboard.getManageProgramHeader().isDisplayed());
	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) {
		 final JavascriptExecutor js = (JavascriptExecutor) driver;
		    double loadTime = (Double) js.executeScript(
		            "return (window.performance.timing.domComplete - "
		            + "window.performance.timing.navigationStart) / 1000");
			LOGGER.info("Navigation time in seconds : " + loadTime);
	    	assertTrue(loadTime>int1, "Maximum navigation time exceeded!");
		
	}

	@Then("Dashboard_HTTP response should be >= {int} for broken link")
	public void http_response_should_be_for_broken_link (Integer int1)throws IOException {
	   objdashboard.verifyBrokenLink();
	}

	@Then("Admin should see LMS -Learning management system  as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
	
	    assertTrue("LMS title is not displayed", objdashboard.getLMSPageTitle().isDisplayed());
        String titleText = objdashboard.getLMSPageTitle().getText();
        assertTrue("LMS title text is incorrect", titleText.contains("LMS - Learning management system"));
    }
	

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		String lmsTitle = objdashboard.getLMSPageTitle().getText();
		boolean isLeftAligned = false;
		isLeftAligned = objdashboard.getLMSPageTitle().getAttribute("style").contains("left");
		LOGGER.info("LMS title : " + lmsTitle);
		assertEquals(isLeftAligned, true, 
				"LMS title is not in the left corner");
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() {
		String placeText = objdashboard.getNavigationBar()
				.getAttribute("placeholder");
LOGGER.info("Displayed text : " + placeText);
assertEquals(placeText, "Select Navigation bar text",
			"Wrong spelling of 'Select Navigation bar text'");
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
		String placeText = objdashboard.getLMSPageTitle()
				.getAttribute("placeholder");
LOGGER.info("Displayed text : " + placeText);
assertEquals(placeText, "Wrong spelling of 'LMS Title'");;
	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		String navText = objdashboard.getNavigationBar().getText();
		boolean isRightAligned = false;
		isRightAligned = objdashboard.getNavigationBar().getAttribute("style").contains("right");
		LOGGER.info("Navigation bar Text  : " + navText);
		assertEquals(isRightAligned, true, 
				"Navigation bar Text is not in the right corner");
	}
	

	@Then("Admin should see student in the 1st place")
	public void admin_should_see_student_in_the_1st_place() {
		String firstNavItemText = objdashboard.getStudentNavLink().getText().trim();
        assertEquals("Student is not in the 1st place", "Student", firstNavItemText);
	}

	@Then("Admin should see program in the 2nd place")
	public void admin_should_see_program_in_the_2nd_place() {
		String secondNavItemText = objdashboard.getProgramNavLink().getText().trim();
        assertEquals("Program is not in the 2nd place", "Program", secondNavItemText);
	}

	@Then("Admin should see batch in the 3rd place")
	public void admin_should_see_batch_in_the_3rd_place() {
		String thirdNavItemText = objdashboard.getBatchNavLink().getText().trim();
        assertEquals("Batch is not in the 3rd place", "Batch", thirdNavItemText);
	}

	@Then("Admin should see class in the 4th place")
	public void admin_should_see_class_in_the_4th_place() {
        String fourthNavItemText = objdashboard.getClassNavLink().getText().trim();
        assertEquals("Class is not in the 4th place", "Class", fourthNavItemText);
	}

	@Then("Admin should see student in the 5th user")
	public void admin_should_see_student_in_the_5th_user() {
		 String fifthNavItemText = objdashboard.getUserNavLink().getText().trim();
	        assertEquals("User is not in the 5th place", "User", fifthNavItemText);
	}

	@Then("Admin should see student in the 6th assignment")
	public void admin_should_see_student_in_the_6th_assignment() {
		 String sixthNavItemText = objdashboard.getAssignmentNavLink().getText().trim();
	        assertEquals("Assignment is not in the 6th place", "Assignment", sixthNavItemText);
	}

	@Then("Admin should see student in the 7th attendance")
	public void admin_should_see_student_in_the_7th_attendance() {
		String seventhNavItemText = objdashboard.getAttendanceNavLink().getText().trim();
        assertEquals("Attendance is not in the 7th place", "Attendance", seventhNavItemText);
	}

	@Then("Admin should see student in the 8th logout")
	public void admin_should_see_student_in_the_8th_logout() {
		String eighthNavItemText = objdashboard.getLogoutNavLink().getText().trim();
		assertEquals("Logout is not in the 8th place", "Logout", eighthNavItemText);
	}

	
	
	@Given("Admin is in dashboard page")
	public void admin_is_in_dashboard_page() {
		LOGGER.info("Admin is on dashboard page : ");
		System.out.println("Admin is on dashboard page after login ");
	}

	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() {
		objdashboard.getLogoutNavLink().click();
	}

	@Then("Admin should land on login in page")
	public void admin_should_land_on_login_in_page() {
		objlogin.verifyLoginPageTitle();
	}


}
