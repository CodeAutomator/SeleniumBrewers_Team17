package step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.util.List;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import webdriver_manager.DriverManager;
import page_objects.StudentModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.common_utils;

public class Student {
	//Dashboard objDashboard = Dashboard.getInstance();
	
	StudentModule objStudentModule = StudentModule.getInstance();
	WebDriver driver = DriverManager.getDriver();
	common_utils objCommounUtils = new common_utils();
	static long startTime;
	String txtLogMessage = "";
//	private static final Logger LOGGER = 
//			LogManager.getLogger(StudentModule.class);
	private static final Logger LOGGER = 
			LogManager.getLogger();
	public Student() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}
	
	//student1.feature
	@Given("Logged on the LMS portal as Admin")
	public void logged_on_the_lms_portal_as_admin() {
		//call login object and method
	    System.out.println("Logged on to LMS portl as Admin");
	    LOGGER.info("Logged on to LMS portl as Admin");
	}

	@Given("Admin is logged in and on the student Details page")
	public void admin_is_logged_in_and_on_the_student_details_page() {
		 System.out.println("Admin loggen in and on student details page");
		 LOGGER.info("Admin loggen in and on student details page");	
	}

	@Given("Student_Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		driver.get(Constants.SIGNIN_URL);
		//driver.manage().window().maximize();
		//SignPage.Signin(Constants.USERNAME, Constants.PASSWORD);
		LOGGER.info("Admin is on dashboard page : ");
		System.out.println("Admin is on dashboard page after login ");}

	@When("Admin clicks Student on the navigation bar")
	public void admin_clicks_on_the_navigation_bar() {
		objStudentModule.getLnkStudentNavigationBar().click();
		//startTime = System.currentTimeMillis();
		txtLogMessage = "Admin Clicks on Student on the navigation bar";
		System.out.println(txtLogMessage);
		LOGGER.info(txtLogMessage);
	}

	@Then("Admin should see the Student details Page Title")
	public void admin_should_see_the_student_details_page_title() {
	    String strTitle = driver.getTitle();
		LOGGER.info("Title of page :" + strTitle);
	    assertEquals(strTitle,"Student Details Page", "Student details page not seen");
	}

	@Then("Student_Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) {
		//long elapsedTime = System.currentTimeMillis() - startTime;
	    final JavascriptExecutor js = (JavascriptExecutor) driver;
	    double loadTime = (Double) js.executeScript(
	            "return (window.performance.timing.domComplete - "
	            + "window.performance.timing.navigationStart) / 1000");
		LOGGER.info("Navigation time in seconds : " + loadTime);
    	assertTrue(loadTime>int1, "Maximum navigation time exceeded!");
	}

	@Then("Student_HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) 
				throws MalformedURLException, IOException {
      HttpURLConnection cn = 
    		  (HttpURLConnection)new 
    		  URL(constants.Constants.APP_URL)
    		  .openConnection();
      cn.setRequestMethod("HEAD");
      cn.connect();
      int respCode = cn.getResponseCode();
      LOGGER.info("HTTP Resonse code : " + respCode );
	      assertTrue(respCode>=400, "Link os broken with Response code :" + respCode );
	}

	@Then("Admin should see LMS -Learning management system as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
		String strTitle = driver.getTitle();
		LOGGER.info("Title of current page is :" + strTitle);
		assertEquals(strTitle, "LMS -Learning management system", 
				"Title not matched");
	}

	@Then("Student Detail title should be in centre of the page")
	public void student_detail_title_should_be_in_centre_of_the_page() {		
//		
//		WebElement canvas = new WebDriverWait(driver, 
//							Duration.ofSeconds(10)).
//				until(ExpectedConditions.elementToBeClickable
//						(objStudentModule.getTxtPageTitle()));
//		//clicking on the centre
//		new Actions(driver).
//				moveToElement(canvas).click().build().perform();
		
//		int X = driver.manage().window().getSize().width;
//		int x = objStudentModule.getTxtPageTitle().getLocation().getX();
//		int y = objStudentModule.getTxtPageTitle().getLocation().getY();
//		int width = objStudentModule.getTxtPageTitle().getSize().width;
		String strTitle = objStudentModule.getTxtPageTitle().getText();
		boolean isCentreAligned = false;
		isCentreAligned = objStudentModule.getTxtPageTitle().
				getAttribute("style").contains("center");
		LOGGER.info("Student detail title : " + strTitle);
		assertEquals(isCentreAligned, true, 
				"Student detail title is not in the centre");
	}

	@Then("{int} dropdowns should be present in the page")
	public void dropdowns_should_be_present_in_the_page(Integer int1) {
		int noOfDropdowns = objStudentModule.getAllDropdownElements().size();
		LOGGER.info("No. of dropdown controls on the page : " + noOfDropdowns);
		assertEquals(noOfDropdowns, 2, 
					noOfDropdowns+"dropdowns present in the page");
	}

	@Then("Admin should see search box inside the drop down")
	public void admin_should_see_search_box_inside_the_drop_down() {
		objStudentModule.getSelStudentName().click();
		boolean searchDisplayed = false;
		searchDisplayed = objStudentModule.getTxtSearchName().isDisplayed();
		LOGGER.info("Searchbox control inside a Student Name dropdown seen : " + searchDisplayed);
		assertEquals(searchDisplayed, true, "No searchbox inside student name dropdown");
	}

	@Then("Admin should see search box inside batch id drop down")
	public void admin_should_see_search_box_inside_batch_id_drop_down() {
		objStudentModule.getSelBatchId().click();
		boolean searchDisplayed = false;
		searchDisplayed = objStudentModule.getTxtSearchid().isDisplayed();
		LOGGER.info("Searchbox control inside a batch dropdown seen : " + searchDisplayed);
		assertEquals(searchDisplayed, true, "No searchbox inside batch id dropdown");
	}

	@Then("Admin should see correct spelling select student name")
	public void admin_should_see_correct_spelling_select_student_name() {
        String placeText = objStudentModule.getTxtSearchName()
        				.getAttribute("placeholder");
        LOGGER.info("Displayed text : " + placeText);
		assertEquals(placeText, "Select Student Name",
					"Wrong spelling of 'Select Student Name'");
	}

	@Then("Admin should see correct spelling select batch id text")
	public void admin_should_see_correct_spelling_select_batch_id_text() {
		String placeText = objStudentModule.getTxtSearchid()
				.getAttribute("placeholder");
		LOGGER.info("Displayed text : " + placeText);
		assertEquals(placeText,"Select batch id", 
					"Wrong spelling of 'Select batch id'");
	}

	@Then("Admin should see only numbers inside batch id drop down")
	public void admin_should_see_only_numbers_inside_batch_id_drop_down() {
		WebElement selectElement = objStudentModule.getTxtSearchid();
		Select select = new Select(selectElement);
		List<WebElement> el = select.getOptions();
		int i, l = el.size();
		boolean b=false;
		for(i=0;i<l;i++) {
			b = NumberUtils.isParsable(el.get(i).getText());
			if(!b){
				break;
			}
		}
		LOGGER.info(" Only numbers seen in batch id dropdown : " + b);
		assertEquals(b,true, "Only numbers not seen in batch id dropdown");
	}

	@Then("Admin should see select student name in gray color")
	public void admin_should_see_select_student_name_in_gray_color() {
		 String color = objStudentModule.getTxtSearchName()
 				.getCssValue("color");
		LOGGER.info("Student Name in " + color + " color");
		assertEquals(color, "gray", "Student Name not in gray color");
	}

	@Then("Admin should see select batch ID in gray color")
	public void admin_should_see_select_batch_id_in_gray_color() {
		String color = objStudentModule.getTxtSearchid()
 				.getCssValue("color");
		LOGGER.info("Batch Id in " + color + " color");
		assertEquals(color, "gray", "Batch Id not in gray color");
	}

	@Then("Admin should see select student name in first")
	public void admin_should_see_select_student_name_in_first() {
	   List<WebElement> lst = objStudentModule.getAllDropdownElements();
	   String name = lst.get(0).getText();
	   LOGGER.info(name + " seen in first dropdown");
	   assertEquals(name.toLowerCase(), "select student name", 
			   name + " not seen in first drdopdown");
	}

	@Then("Admin should see select batch id in second")
	public void admin_should_see_select_batch_id_in_second() {
		List<WebElement> lst = objStudentModule.getAllDropdownElements();
		String name = lst.get(1).getText();
		LOGGER.info(name + " seen in second dropdown");
		   assertEquals(name.toLowerCase(), "select batch id", 
				   name + " not seen in second drdopdown");
	}

	@Then("Admin should able to scroll down to select the name")
	public void admin_should_able_to_scroll_down_to_select_the_name() {
		WebElement selName = objStudentModule.getSelStudentName();  
	    boolean scroll = selName.getCssValue("overflow-y").
	    	toLowerCase().contains("scroll");
	    assertTrue(scroll, "admin not able to scroll down to select a name");
	}

	@Then("Admin should able to scroll down to select the batch id")
	public void admin_should_able_to_scroll_down_to_select_the_batch_id() {
		WebElement selBatchId = objStudentModule.getSelBatchId();  
	    boolean scroll = selBatchId.getCssValue("overflow-y").
	    	toLowerCase().contains("scroll");
	    assertTrue(scroll, "admin not able to scroll down to select a batch id");
	}
	
	//student2.feature
	
	@Given("Admin is on student details page")
	public void admin_is_on_student_details_page() {
	    System.out.println("Admin is on student details page");
	    LOGGER.info("Admin is on student details page");
	}

	@When("Admin select student name from the drop down")
	public void admin_select_student_name_from_the_drop_down() {
	    System.out.println("Admin selects a student name from the dropdown");
	    LOGGER.info("Admin selects the student name from the dropdown");
	}

	@Then("Admin should not see select student name text")
	public void admin_should_not_see_select_student_name_text() {
	    String strName = objStudentModule.getSelStudentName().getText();
	    assertTrue(!strName.equals("Select Student Name"), 
	    		"'Select Student Name' seen instead of the selected name");
	    LOGGER.info("Student Name not selected");
	}

	@When("Admin select batch id from the drop down")
	public void admin_select_batch_id_from_the_drop_down() {
	    System.out.println("Admin selects a batch id from the dropdown");
	    LOGGER.info("Admin selects a batch id from the dropdown");
	}

	@Then("Admin should not see select batch id text")
	public void admin_should_not_see_select_batch_id_text() {
		String strBatchId = objStudentModule.getSelBatchId().getText();
		    assertTrue(!strBatchId.equals("Select batch id"), 
		    		"'Select batch id' seen instead of the selected batch id");
		LOGGER.info("Batch Id not selected");
	}

	@When("Admin clicks select student name and enters x alphabet in the search box")
	public void admin_clicks_select_student_name_and_enters_x_alphabet_in_the_search_box() {
		objStudentModule.getTxtSearchName().sendKeys("x");
		System.out.println("Admin clicks select student name and types x "
	    		+ "alphabet in the search box");
	    LOGGER.info("Admin clicks select student name and types x "
	    		+ "alphabet in the search box");
	}

	@Then("Admin should see student name start with x is listed below")
	public void admin_should_see_student_name_start_with_x_is_listed_below() {
		WebElement ddName = objStudentModule.getSelStudentName();
		Select selectName = new Select(ddName);
		List<WebElement> el = selectName.getOptions();
		boolean flag= false;
		int i, len = el.size();
		for(i=0;i<len;i++) {
			if(el.get(i).getText().
					substring(0).toLowerCase().equals("x")==false) {
				flag = true;
				break;
			}
		}
		assertEquals(flag, false, "Can't see student name starting with 'x'");
	    if(flag) {
	    	LOGGER.info("Can't see student name starting with 'x'");
	    } else {
	    	LOGGER.info("Can see student name starting with 'x'");

	    }
	}

	@When("Admin  clicks select batch id and enter 1 number in the search box")
	public void admin_clicks_select_batch_id_and_enter_x_number_in_the_search_box() {
		objStudentModule.getTxtSearchid().sendKeys("1");
		System.out.println("Admin clicks select batchid and types 1 "
	    		+ "number in the search box");
		LOGGER.info("Admin clicks select batchid and types 1 "
	    		+ "number in the search box");}

	@Then("Admin should see batch id start with 1 is listed below")
	public void admin_should_see_batch_id_start_with_x_is_listed_below() {
		WebElement ddBatchId = objStudentModule.getSelBatchId();
		Select selectBatchId = new Select(ddBatchId);
		List<WebElement> el = selectBatchId.getOptions();
		boolean flag= false;
		int i, len = el.size();
		for(i=0;i<len;i++) {
			if(el.get(i).getText().
					substring(0).toLowerCase().equals("x")==false) {
				flag = true;
				break;
			}
		}
		assertEquals(flag, false, "Can't see batch id starting with '1'");
	    if(flag) {
	    	LOGGER.info("Can't see batch id starting with '1'");
	    } else {
	    	LOGGER.info("Can see batch id starting with '1'");

	    }
	}

	@When("Admin selects only student name")
	public void admin_selects_only_student_name() {
		WebElement ddName = objStudentModule.getSelStudentName();
		Select selectName = new Select(ddName);
		selectName.selectByIndex(0);
		WebElement ddBatchId = objStudentModule.getSelBatchId();
		Select BatchId = new Select(ddBatchId);
		BatchId.deselectAll();
		System.out.println("Admin selects only student name");
		LOGGER.info("Admin selects only student name");
	}

	@Then("Student details should not be displayed")
	public void student_details_should_not_be_displayed() {
	   String strError = objStudentModule.getTxtError().getText();
	   assertFalse(strError.equals("student details can not be displayed"),
			   "Student details should not be displayed");
	   LOGGER.info("Student details should not be displayed");
	}

	@When("Admin selects only  batch id")
	public void admin_selects_only_batch_id() {
		WebElement ddName = objStudentModule.getSelStudentName();
		Select selectName = new Select(ddName);
		selectName.deselectAll();
		WebElement ddBatchId = objStudentModule.getSelBatchId();
		Select BatchId = new Select(ddBatchId);
		BatchId.selectByIndex(0);
		System.out.println("Admin selects only batch id");
		LOGGER.info("Admin selects only batch id");
	}

	@When("Admin selects  student name and batch id")
	public void admin_selects_student_name_and_batch_id() {
		WebElement ddName = objStudentModule.getSelStudentName();
		Select selectName = new Select(ddName);
		selectName.selectByIndex(0);
		WebElement ddBatchId = objStudentModule.getSelBatchId();
		Select BatchId = new Select(ddBatchId);
		BatchId.selectByIndex(0);
		System.out.println("Admin selects only student name and batch id");
		LOGGER.info("Admin selects only student name and batch id");
	}

	@Then("Particular student information should be displayed")
	public void particular_student_information_should_be_display() {
	    boolean isDisplayed = objStudentModule.getTxtStudentDetails().isDisplayed();
	    if(!isDisplayed) {
	    	txtLogMessage = "Particular student information not displayed";
	    }else {
	    	txtLogMessage = "Particular student information displayed";
	    }
	    LOGGER.info(txtLogMessage);
	    assertTrue(isDisplayed,"Particular student information not displayed");
	}

	//student3.feature
	
	@When("Admin clicks on program link on student page")
	public void admin_clicks_on_program_link_on_student_page() {
		objStudentModule.getLnkProgramNavigationBar().click();
		System.out.println("Admin clicks Program link on student page");
		LOGGER.info("Admin clicks Program link on student page");
	}
	
	@Then("Admin is redirected to Program page")
	public void admin_is_redirected_to_program_page() {
	    String strTitle = driver.getTitle();
	    assertEquals(strTitle, "Program", "Admin not redirected to Program page"); 
	}
	
	@When("Admin clicks on Batch link on student page")
	public void admin_clicks_on_batch_link_on_student_page() {
		objStudentModule.getLnkBatchNavigationBar().click();
		System.out.println("Admin clicks Batch link on student page");
		LOGGER.info("Admin clicks Batch link on student page");
}
	
	@Then("Admin is redirected to Batch page")
	public void admin_is_redirected_to_batch_page() {
		 String strTitle = driver.getTitle();
		 assertEquals(strTitle, "Batch", "Admin not redirected to Batch page");  
	}
	
	@When("Admin clicks on Class link on student page")
	public void admin_clicks_on_class_link_on_student_page() {
		objStudentModule.getLnkClassNavigationBar().click();
		System.out.println("Admin clicks Class link on student page");
		LOGGER.info("Admin clicks Class link on student page");
	}
	
	@Then("Admin is redirected to Class page")
	public void admin_is_redirected_to_class_page() {
		 String strTitle = driver.getTitle();
		 assertEquals(strTitle, "Class", "Admin not redirected to Class page"); 
	}
	
	@When("Admin clicks on User link on student page")
	public void admin_clicks_on_user_link_on_student_page() {
		objStudentModule.getLnkUserNavigationBar().click();
		System.out.println("Admin clicks User link on student page");
		LOGGER.info("Admin clicks User link on student page");
	}
	
	@Then("Admin is redirected to User page")
	public void admin_is_redirected_to_user_page() {
		 String strTitle = driver.getTitle();
		 assertEquals(strTitle, "User", "Admin not redirected to User page"); 
	}
	
	@When("Admin clicks on Assignment link on student page")
	public void admin_clicks_on_assignment_link_on_student_page() {
		objStudentModule.getLnkAssignmentNavigationBar().click();
		System.out.println("Admin clicks Assignment link on student page");
		LOGGER.info("Admin clicks Assignment link on student page");
	}
	
	@Then("Admin is redirected to Assignment page")
	public void admin_is_redirected_to_assignment_page() {
		 String strTitle = driver.getTitle();
		 assertEquals(strTitle, "Assignment", "Admin not redirected to Assignment page"); 
	}
	
	@When("Admin clicks on Attendance link on student page")
	public void admin_clicks_on_attendance_link_on_student_page() {
		objStudentModule.getLnkAttendanceNavigationBar().click();
		System.out.println("Admin clicks Attendance link on student page");
		LOGGER.info("Admin clicks Attendance link on student page");
	}
	
	@Then("Admin is redirected to Attendance page")
	public void admin_is_redirected_to_attendance_page() {
		 String strTitle = driver.getTitle();
		 assertEquals(strTitle, "Attendance", "Admin not redirected to Attendance page"); 	    
	}
	
	@When("Admin clicks on Logout link on student page")
	public void admin_clicks_on_logout_link_on_student_page() {
		objStudentModule.getLnkLogoutNavigationBar().click();
		System.out.println("Admin clicks Logout link on student page");
		LOGGER.info("Admin clicks Logout link on student page");
	}
	
	@Then("Admin is redirected to Login page")
	public void admin_is_redirected_to_login_page() {
		 String strTitle = driver.getTitle();
		 assertEquals(strTitle, "Login", "Admin not redirected to Login page"); 	    
	}
}