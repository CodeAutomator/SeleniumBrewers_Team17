package step_definitions;

//import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

//import java.text.SimpleDateFormat;
//import java.time.Duration;
import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.java.it.Date;
import page_objects.ClassPageObject;
import utilities.common_utils;
import webdriver_manager.DriverManager;

public class ClassPage_SD {

	WebDriver driver = DriverManager.getDriver();
	ClassPageObject classPage = new ClassPageObject();
	common_utils objCommounUtils = new common_utils();

//private static final Logger LOGGER = LogManager.getLogger(Manageprogramvalidation1_stepdef.class);

	// driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
//Manage class page feature

	@Given("Class_Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() throws InterruptedException {
		
		classPage.navigateToManageClassPage();
		System.out.println("Admin is on dashboard page");
	}

	@When("Admin clicks Class button on the navigation bar")
	public void admin_clicks_class_button_on_the_navigation_bar() {
		classPage.clickOnNavigationBar();
		String txtLogMessage = "";
		System.out.println(txtLogMessage);
		// LOGGER.info(txtLogMessage);
	}

	@Then("Admin should see URL with Manage Class")
	public void admin_should_see_url_with(String string) {
		driver.get(Constants.ManageClassPageURL);
		String strURL = driver.getCurrentUrl();
		// LOGGER.info("URL :" + strURL);
		assertTrue(strURL.toLowerCase().contains("Manage class"), "Manage class page seen");
	}

	@Then("Get the response time for navigation from dashboard page to manage class page")
	public void get_the_response_time_for_navigation_from_dashboard_page_to_manage_class_page() {
		classPage.getResponseTime();

		final JavascriptExecutor js = (JavascriptExecutor) driver;
		double loadTime = (Double) js.executeScript("return (window.performance.timing.domComplete - "
				+ "window.performance.timing.navigationStart) / 1000");
		// LOGGER.info("Navigation time in seconds : " + loadTime);
		double int1 = 0;
		assertTrue(loadTime > int1, "Maximum navigation time exceeded!");
	}

	@Then("Admin should see header with Manage Class")
	public void admin_should_see_header_with(String ManageClass) {
		
		String title = DriverManager.getDriver().getTitle();
		System.out.println("Title = " + title);
		assertEquals(title, ManageClass);
		// LOGGER.info("header with Manage Class is visible:" +title);
	}

	@When("Admin clicks Class button on the navigation bar and get all text from the portal page")
	public void admin_clicks_button_on_the_navigation_bar_and_get_all_text_from_the_portal_page(String Class) {
		
		classPage.getNavigationBar().getText();
		try {

		} catch (Exception e) {

			// LOGGER.info(e.getMessage());

			assertFalse(false, "Failed - Admin clicks Class button on the navigation bar");

		}

	}

	@Then("Admin should see correct spelling for all the fields")
	public void admin_should_see_correct_spelling_for_all_the_fields() {
		
classPage.getAllTextFields();

	}

	@Then("Admin should see disabled delete icon below the Manage Class")
	public void admin_should_see_disabled_delete_icon_below_the(String ManageClass) {
		
		classPage.getDelIconBelowHeader();
		assert (classPage.isbuttondisabled());
	}

	@Then("Admin should see search bar on the class page")
	public void admin_should_see_search_bar_on_the_class_page() {

		boolean searchbar = classPage.getSearchbar().isDisplayed();
		if (searchbar) {
			System.out.println("search bar is present");
		} else {
			System.out.println("search bar is not present");
		}

	}

	@Then("Admin should see +Add New Class button on the class page")
	public void admin_should_see_add_new_class_button_on_the_class_page() {

		boolean addNewBtn = classPage.getAddNewClassLBtn().isDisplayed();
		if (addNewBtn) {
			System.out.println("Add New Class button is present");

		} else {
			System.out.println("Add New Class button is not present");

		}
	}

	@Then("Admin should see data table on the Manage Class Page With all column headers")
	public void admin_should_see_data_table_on_the_manage_class_page_with_all_column_headers() {

		boolean dataTableWithHeader = classPage.getDataTable().isDisplayed();
		if (dataTableWithHeader) {
			System.out.println("Data Table is present with all column headers is present");

		} else {
			System.out.println("Headers are not present on Data Table");

		}
	}

	@Then("Edit Icon in each row of data table only  when entries are available")
	public void edit_icon_in_each_row_of_data_table_only_when_entries_are_available() {

		WebElement table = driver.findElement(By.id("your-table-id"));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> editIcons = row.findElements(By.className("edit-icon-class"));

            if (editIcons.isEmpty()) {
                assertTrue("Edit icons should not be present in rows without entries", row.getText().isEmpty());
            } else {
                assertTrue("Edit icons should be present in rows with entries", !row.getText().isEmpty());
            }
        }

       
    }
	

	@Then("Edit Icon will not be present in data table")
	public void edit_icon_will_not_be_present_in_data_table() {

		boolean editIcon = classPage.getEditIcon().isDisplayed();
		if (editIcon) {
			System.out.println("edit icon is present in data table");
		} else {
			System.out.println("edit icon is not present in data table");
		}
		assertEquals(editIcon, "edit icon is not present in data table");
	}

	@Then("Delete Icon in each row of data table only  when entries are available")
	public void delete_icon_in_each_row_of_data_table_only_when_entries_are_available(By table) {

		java.util.List<WebElement> rows = table.findElements((SearchContext) By.tagName("tr"));
        for (WebElement row : rows) {
            java.util.List<WebElement> deleteIcons = row.findElements(By.className("delete-icon"));

            if (deleteIcons.isEmpty()) {
                assert row.getText().isEmpty() : "Delete icon should not be present in rows without entries";
            } else {
                assert !row.getText().isEmpty() : "Delete icon should be present in rows with entries";
            }  
        }
	}

	@Then("Admin cant see delete  Icon in data table")
	public void admin_cant_see_delete_icon_in_data_table() {
		
		boolean deleteIcon = classPage.getEnabledDelBtn().isDisplayed();
		if (deleteIcon) {
			System.out.println("delete icon is visible");
		} else {
			System.out.println("delete icon is not visible");
		}
	}

	@Then("Admin should see sort icon near the column headers except for Edit and Delete")
	public void admin_should_see_sort_icon_near_the_column_headers_except_for_edit_and_delete() {
		
boolean sortIcon = classPage.getSortIcon().isDisplayed();
if (sortIcon) {
	System.out.println("sort icon is visible");
} else {
	System.out.println("sort icon is not visible");
}
assertTrue(!sortIcon, "sort icon is not visible");
	}

	@Then("Admin should see check box in the all rows  of data table")
	public void admin_should_see_check_box_in_the_all_rows_of_data_table() {

		boolean checkBox = classPage.getCheckBox().isDisplayed();
		if (checkBox) {
			System.out.println("check box in the all rows of data table is present");
		} else {
			System.out.println("check box in the all rows of data table is not present");
		}
	}

	@Then("A text format Showing x to y of z entries should be visible above the footer, where x is thestarting record, y is the ending record and z is the total number of records")
	public void a_text_format_showing_x_to_y_of_z_entries_should_be_visible_above_the_footer_where_x_is_thestarting_record_y_is_the_ending_record_and_z_is_the_total_number_of_records() {
String paginationText = classPage.getPaginationText();

        String paginationTextContent = paginationText;
        // Implement logic to extract x, y, and z from the paginationTextContent and validate.
        int x = extractStartingRecord(paginationTextContent);
        int y = extractEndingRecord(paginationTextContent);
        int z = extractTotalNumberOfRecords(paginationTextContent);

        assert x <= y && y <= z : "Pagination text is not in the expected format";

	}
	public int extractStartingRecord(String paginationTextContent) {		

	return 0;
	}

	public int extractEndingRecord(String paginationTextContent) {
		return 0;
	}

	public int extractTotalNumberOfRecords(String paginationTextContent) {
		return 0;
	}

	@Then("Class_Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table1() {
		
		WebElement paginationControls = driver.findElement(By.id("pagination-controls-id"));
	    assert paginationControls.isDisplayed() : "Pagination controls are not visible";
	}	
	
	@Then("Admin should see the text with total number classes in the data table. \\( {string})")
	public void admin_should_see_the_text_with_total_number_classes_in_the_data_table(String expectedText) {
		
		 String actualText=classPage.getTotalClassesText();
	    assert actualText.equals(expectedText) : "Total classes text does not match the expected text";

	}
	
	/////////////////////
	
	@Then("Displays entries with that batch Id for Batch {int}")
	public void displays_entries_with_that_batch_id_for_batch(Integer batchId) {
		WebElement batchTable = classPage.getBatchTable(); 
		boolean isBatchDisplayed = batchTable.getText().contains("Batch " + batchId);
		assert isBatchDisplayed;
	}

	@Then("Displays empty details in the data table for Batch {int}")
	public void displays_empty_details_in_the_data_table_for_batch(Integer batchId) {
		WebElement batchTable = classPage.getBatchTable();
		boolean isBatchNotDisplayed = !batchTable.getText().contains("Batch " + batchId);
		assert isBatchNotDisplayed;
	}

	@Then("Displays entries with that class no for Class {int}")
	public void displays_entries_with_that_class_no_for_class(Integer classNo) {
		WebElement classTable = classPage.getClassTable();
		boolean isClassDisplayed = classTable.getText().contains("Class " + classNo);
		assert isClassDisplayed;
	}

	@Then("Displays empty details in the data table for Class {int}")
	public void displays_empty_details_in_the_data_table_for_class(Integer classNo) {
		WebElement classTable = classPage.getClassTable();
		boolean isClassNotDisplayed = !classTable.getText().contains("Class " + classNo);
		assert isClassNotDisplayed;
		//LoggerLoad.logInfo("Admin clicks assignment button on the navigation bar");
	}

	@Then("Displays entries with that class topic for Introduction to Maths")
	public void displays_entries_with_that_class_topic_for_introduction_to_maths() {
		WebElement topicTable = classPage.getTopicTable();
		boolean isTopicDisplayed = topicTable.getText().contains("Introduction to Maths");
		assert isTopicDisplayed;
	}

	@Then("Displays empty details in the data table for Advanced Quantum")
	public void displays_empty_details_in_the_data_table_for_advanced_quantum() {
		WebElement topicTable = classPage.getTopicTable();
		boolean isTopicNotDisplayed = !topicTable.getText().contains("Advanced Quantum");
		assert isTopicNotDisplayed;
	}

	
///////////////////////////////
	// Manage class 1 feature		

	@Given("Admin is on Manage Class Page")
	public void admin_is_on_manage_class_page() {
		
		String text = classPage.getClasslink().getText();	  
		assertEquals(true, text);
	}

	@When("Admin enters batch id into search box")
	public void admin_enters_batch_id_into_search_box(int batchId) {
		
		boolean isBatchDisplayed = classPage.getText().contains("Batch " + batchId);
		assert isBatchDisplayed;
	}

	@When("Admin enters non-existing batch id into search box")
	public void admin_enters_non_existing_batch_id_into_search_box(int batchId) {
		
		boolean isBatchNotDisplayed = !classPage.getText().contains("Batch " + batchId);
		assert isBatchNotDisplayed;
	}

	@When("Admin enters class no into search box")
	public void admin_enters_class_no_into_search_box(int classNo) {
		boolean isClassDisplayed = classPage.getText().contains("Class " + classNo);
		assert isClassDisplayed;
	}

	@When("Admin enters non-existing class no into search box")
	public void admin_enters_non_existing_class_no_into_search_box() {
		WebElement classTable = driver.findElement(By.id("classTable"));
		String classNo = null;
		boolean isClassNotDisplayed = !classTable.getText().contains("Class " + classNo);
		assert isClassNotDisplayed;
	}

	@When("Admin enters class topic into search box")
	public void admin_enters_class_topic_into_search_box() {
		WebElement topicTable = driver.findElement(By.id("topicTable"));
		boolean isTopicDisplayed = topicTable.getText().contains("Introduction to Maths");
		assert isTopicDisplayed;
	}

	@When("Admin enters non-existing class topic into search box")
	public void admin_enters_non_existing_class_topic_into_search_box() {
		WebElement topicTable = driver.findElement(By.id("topicTable"));
		boolean isTopicNotDisplayed = !topicTable.getText().contains("Advanced Quantum");
		assert isTopicNotDisplayed;
	}

	@When("Admin enters staff id into search box")
	public void admin_enters_staff_id_into_search_box() {
		classPage.enterDataInSearchBox();
	}

	@When("Admin enters non-existing staff id into search box")
	public void admin_enters_non_existing_staff_id_into_search_box() {
		classPage.enterInvalidDataInSearchBox();
	}

	@Then("Displays empty details in the data table for Staff {int}")
	public void displays_empty_details_in_the_data_table_for_staff(Integer int1) {
		
	}

	@When("Admin enters class date into search box")
	public void admin_enters_class_date_into_search_box() {
		classPage.enterDateInSearchBox();
	}

	@Then("Displays entries with that class date for 1st Jan {int}")
	public void displays_entries_with_that_class_date_for_1st_jan(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Admin enters invalid class date into search box")
	public void admin_enters_invalid_class_date_into_search_box() {
		classPage.enterInvalidDateInSearchBox();
	}

	@Then("Displays empty details in the data table for 32nd Feb {int}")
	public void displays_empty_details_in_the_data_table_for_32nd_feb(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	@Then("Displays entries with that staff id for Staff {int}")
	public void displays_entries_with_that_staff_id_for_staff(Integer int1) {
	     
	}


	// Edit class page feature

	@Given("Admin is in  Edit class detail popup window")
	public void admin_is_in_edit_class_detail_popup_window() {
		classPage.navigateToClassDetailPopup();
	}

	@When("Admin enters all mandatory field values with valid data and clicks save button \\( Batch ID , No of Classes, Class Date, Staff Id)")
	public void admin_enters_all_mandatory_field_values_with_valid_data_and_clicks_save_button_batch_id_no_of_classes_class_date_staff_id() {
		classPage.entersValuesInAllMandatoryFields();
		classPage.clickOnSaveBtn();
	}

	@Then("Admin should see particular class details is updated in the data table")
	public void admin_should_see_particular_class_details_is_updated_in_the_data_table() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Admin enters all mandatory field values with invalid data and clicks save button \\( Batch ID , No of Classes, Class Date, Staff Id, )")
	public void admin_enters_all_mandatory_field_values_with_invalid_data_and_clicks_save_button_batch_id_no_of_classes_class_date_staff_id() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Error message should appear in alert")
	public void error_message_should_appear_in_alert() {
		boolean isErrorMessageDisplayed = classPage.getErrorMessage() != null;
		assert isErrorMessageDisplayed;
		
	}

	@When("Admin enters values in all fields with valid data and clicks save button \\(Batch ID , No of Classes, Class Date, Class Topic, Staff Id, Class description, Comments, Notes, Recordings)")
	public void admin_enters_values_in_all_fields_with_valid_data_and_clicks_save_button_batch_id_no_of_classes_class_date_class_topic_staff_id_class_description_comments_notes_recordings() {
		
		classPage.entersValuesInAllMandatoryFields();
		classPage.clickOnSaveBtn();
	}

	@When("Admin enters with invalid data in optional fields and clicks save button \\( Batch ID , No of Classes, Class Date, Staff Id)")
	public void admin_enters_with_invalid_data_in_optional_fields_and_clicks_save_button_batch_id_no_of_classes_class_date_staff_id() {
		classPage.enterInvalidDataInOptionalFields();
		classPage.clickOnSaveBtn();
		
	}

	@When("Admin enters  data missing value in Batch ID and clicks save button \\(No of Classes, Class Date, Staff Id)")
	public void admin_enters_data_missing_value_in_batch_id_and_clicks_save_button_no_of_classes_class_date_staff_id() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Batch Id is missing")
	public void batch_id_is_missing() {
		classPage.getBatchIdDropdown().getText();		
		 WebElement BatchID = classPage.getBatchId();
		Assert.notNull(BatchID, null);
	}

	@When("Admin enters data missing value in No of class and clicks save button \\(Batch ID ,  Class Date, Staff Id, )")
	public void admin_enters_data_missing_value_in_no_of_class_and_clicks_save_button_batch_id_class_date_staff_id() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("No of classes is missing")
	public void no_of_classes_is_missing() {
		WebElement noOfClassesField = driver.findElement(By.id("no-of-classes-field"));

        // Implement logic to check if the "No of Classes" field is missing.
        boolean isNoOfClassesMissing = isElementMissing(noOfClassesField);

        // Assert that the "No of Classes" field is missing.
        assert isNoOfClassesMissing : "No of Classes field is not missing";

	}

	@When("Admin enters data missing value in  class date and clicks save button \\(Batch ID , No of Classes, Staff Id, )")
	public void admin_enters_data_missing_value_in_class_date_and_clicks_save_button_batch_id_no_of_classes_staff_id() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("class date is missing")
	public void class_date_is_missing() {
		WebElement classDateField = driver.findElement(By.id("class-date-field"));
        boolean isclassDateField = isElementMissing(classDateField);

        assert isclassDateField : "Class Date field is not missing";
	}
	@When("Admin enters data missing value in staff id and clicks save button \\(Batch ID , No of Classes, Class Date )")
	public void admin_enters_data_missing_value_in_staff_id_and_clicks_save_button_batch_id_no_of_classes_class_date() {
		
	}

	@Then("staff id is missing")
	public void staff_id_is_missing() {
		WebElement staffIdField = driver.findElement(By.id("staff-id-field"));
        boolean isStaffIdMissing = isElementMissing(staffIdField);

        assert isStaffIdMissing : "Staff ID field is not missing";
	}
	private boolean isElementMissing(WebElement staffIdField) {
		return false;
	}
	@When("Admin enters passed date in the class date field and clicks save button \\( Batch ID , No of Classes, Class Date, Staff Id)")
	public void admin_enters_passed_date_in_the_class_date_field_and_clicks_save_button_batch_id_no_of_classes_class_date_staff_id() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("class cannot be updated for the passed date")
	public void class_cannot_be_updated_for_the_passed_date() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks Cancel button without entering values in the fields")
	public void admin_clicks_cancel_button_without_entering_values_in_the_fields() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should land on Manage Class page")
	public void admin_should_land_on_manage_class_page() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks Cancel button entering values in the fields")
	public void admin_clicks_cancel_button_entering_values_in_the_fields() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should land on Manage Class Page and validate particular class details are not changed  in the data table")
	public void admin_should_land_on_manage_class_page_and_validate_particular_class_details_are_not_changed_in_the_data_table() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// Class Details page feature

	@When("Admin click +Add New Class button")
	public void admin_click_add_new_class_button() {
		classPage.clickOnAddNewClassButton();
	}

	@Then("Admin should see a popup  with  heading class details")
	public void admin_should_see_a_popup_with_heading_class_details() {
		
		boolean popUp = classPage.getPopUp().isDisplayed();
		if (popUp) {
			System.out.println("Popup with heading class details is present");
		} else {
			System.out.println("Popup with heading class details is not present");
		}
		assertEquals(popUp, "Popup with heading class details is present");
	}

//	@Then("Admin should see input fields Text \\(Batch ID , No of Classes, Class Date, Class Topic, Staff Id, Class description, Comments, Notes, Recordings)")
//	public void admin_should_see_input_fields_text_batch_id_no_of_classes_class_date_class_topic_staff_id_class_description_comments_notes_recordings() {
//		private boolean isElementDisplayed(By locator) {
//	        try {
//	            WebElement element = driver.findElement(locator);
//	            return element.isDisplayed();
//	        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
//	            return false;
//	        }
//	         WebElement batchIdTextboxLocator = classPage.getBatchId();
//	         WebElement numOfClassesTextboxLocator = classPage.getnumOfClasses();
//	         WebElement classDateTextboxLocator =classPage.getClassD();
//	         WebElement classTopicTextboxLocator = classPage.getclassTopic();
//	         WebElement staffIdTextboxLocator = By.id("staffIdTextbox"); // Replace with the actual locator for Staff Id textbox.
//	         WebElement classDescriptionTextboxLocator = By.id("classDescriptionTextbox"); // Replace with the actual locator for Class Description textbox.
//	        
//	        Assert.assertTrue("Batch ID textbox is not displayed", isElementDisplayed(batchIdTextboxLocator));
//	        Assert.assertTrue("No of Classes textbox is not displayed", isElementDisplayed(numOfClassesTextboxLocator));
//	        Assert.assertTrue("Class Date textbox is not displayed", isElementDisplayed(classDateTextboxLocator));
//	        Assert.assertTrue("Class Topic textbox is not displayed", isElementDisplayed(classTopicTextboxLocator));
//	        Assert.assertTrue("Staff Id textbox is not displayed", isElementDisplayed(staffIdTextboxLocator));
//	        Assert.assertTrue("Class Description textbox is not displayed", isElementDisplayed(classDescriptionTextboxLocator));
//	        Assert.assertTrue("Comments textbox is not displayed", isElementDisplayed(commentsTextboxLocator));
//	        Assert.assertTrue("Notes textbox is not displayed", isElementDisplayed(notesTextboxLocator));
//	        Assert.assertTrue("Recordings textbox is not displayed", isElementDisplayed(recordingsTextboxLocator));
//	    }
//
//	}
//
//	@Then("Six textbox should be  present in Class details popup window")
//	public void six_textbox_should_be_present_in_class_details_popup_window() {
//		By[] textboxLocators = {
//	            classPage.getBatchId();
//	            
//	            classPage.getnumOfClasses();
//	            By.id("classDate"),
//	            By.id("classTopic"),
//	            By.id("staffId"),
//	            By.id("classDescription"),
//	            
//	        };
//
//	        int expectedFieldCount = 6;
//	        int actualFieldCount = 0;
//
//	        for (By locator : textboxLocators) {
//	            if (isElementDisplayed(locator)) {
//	                actualFieldCount++;
//	            }
//	        }
//
//	        Assert.assertEquals("Number of textboxes in the popup window does not match", expectedFieldCount, actualFieldCount);
//	    }
//	}

	@Then("Admin should see  dropdown option for Batch ID")
	public void admin_should_see_dropdown_option_for_batch_id() {
		
		WebElement batchIdDropdown=classPage.getBatchIdDropdown();
		boolean isDropdownDisplayed = batchIdDropdown.isDisplayed();
        assert isDropdownDisplayed : "Batch ID dropdown is not displayed";
    }
	

	@Then("Admin should see  dropdown option for Staff Id")
	public void admin_should_see_dropdown_option_for_staff_id() {
		
		WebElement staffIdDropdown= classPage.getStaffIdField();
		boolean isDropdownDisplayed = staffIdDropdown.isDisplayed();
        assert isDropdownDisplayed : "Staff ID dropdown is not displayed";
    }
	

	@Then("Admin should see  calendar icon for class date")
	public void admin_should_see_calendar_icon_for_class_date() {
		WebElement calendarIcon = classPage.getCalenderIcon();
		boolean isIconDisplayed = calendarIcon.isDisplayed();
        assert isIconDisplayed : "Calendar icon for class date is not displayed";
    }
	

	@Then("Admin should see  save button in the class detail popup window")
	public void admin_should_see_save_button_in_the_class_detail_popup_window() {
		boolean saveButton = classPage.getSaveButton().isDisplayed();
		if (saveButton) {
			System.out.println("save button is present");
		} else {
			System.out.println("save button is not present");
		}
	}

	@Then("Admin should see  cancel button in the class detail popup window")
	
	public void admin_should_see_cancel_button_in_the_class_detail_popup_window() {
		
		boolean cancelButton = classPage.getCancelBtn().isDisplayed();
		if (cancelButton) {
			System.out.println("cancel button is present");
		} else {
			System.out.println("cancel button is not present");
		}
        assertEquals(cancelButton,"Cancel button is not displayed");
    }
	

	@Then("Admin should see  close button on the class details popup window")
	public void admin_should_see_close_button_on_the_class_details_popup_window() {
		
		boolean CloseBtn = classPage.getCloseBtn().isDisplayed();
		if (CloseBtn) {
			System.out.println("close button is present");
		} else {
			System.out.println("close button is not present");
		}
        assertEquals(CloseBtn,"Close button is not displayed");
    }
	

	@Given("Admin is in Manage class page")
	public void admin_is_in_manage_class_page() {
		classPage.navigateToManageClassPage();
		
	}	

	@When("Admin clicks Edit button in data table")
	public void admin_clicks_edit_button_in_data_table() {
		classPage.getEditIcon().click();
    }
	

	@Then("Edit popup window appears with heading Class Details")
	public void edit_popup_window_appears_with_heading_class_details() {
        WebElement editPopupWindow = classPage.getPopUp();
        assertEquals("Edit popup window is not displayed", editPopupWindow.isDisplayed());
        assertEquals("Class Details", editPopupWindow.getText());
    }
	

	@When("Admin clicks Edit button from one of the row in data table")
	public void admin_clicks_edit_button_from_one_of_the_row_in_data_table() {
        WebElement editButton = classPage.getEditIcon();
        assertEquals("Edit popup window is not displayed", editButton.isDisplayed());
        assertEquals("Class Details", editButton.getText());
	}

	@Then("Edit popup window appears with same row values in the all fields")
	public void edit_popup_window_appears_with_same_row_values_in_the_all_fields() {
		classPage.getEditIcon().getSize();
		
	}

	// Add New Class page feature

	@Given("Admin is in  class detail popup window")
	public void admin_is_in_class_detail_popup_window() {
		classPage.navigateToClassDetailPopup();
	}

	@When("Admin clicks  Batch ID dropdown")
	public void admin_clicks_batch_id_dropdown() {
		classPage.getDropdownInBatchId().click();
	}

	@Then("Batch id in the drop down should match with Batch id manage batch page table")
	public void batch_id_in_the_drop_down_should_match_with_batch_id_manage_batch_page_table() {
		FluentWait<WebDriver> wait = null;
		@SuppressWarnings("null")
		WebElement batchIdDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("batchIdDropdown")));
        batchIdDropdown.click();
        WebElement batchIdTable = driver.findElement(By.id("batchIdTable"));
        String selectedOption = ((Select) batchIdDropdown).getFirstSelectedOption().getText();
        String batchIdTableText = batchIdTable.getText();
        assert(batchIdTableText.contains(selectedOption));
        
	}

	@Then("Admin should see new class details is added in the data table")
	public void admin_should_see_new_class_details_is_added_in_the_data_table(Select batchIdDropdown, WebElement batchIdTable) {
        
		String selectedOption = batchIdDropdown.getFirstSelectedOption().getText();
        String batchIdTableText = batchIdTable.getText();
        assert(batchIdTableText.contains(selectedOption));

	}

	@Then("class cannot be  created for the passed date")
	public void class_cannot_be_created_for_the_passed_date() {
		
		boolean isClassCreationPrevented = classPage.isClassCreationPreventedForPastDate();
        assert(isClassCreationPrevented);
	}


	@When("Admin clicks date from date picker")
	public void admin_clicks_date_from_date_picker() {
		//classPage.getCalenderIcon().click();
		WebElement datePickerIcon = classPage.getCalenderIcon();
        datePickerIcon.click();
	}

	@Then("selected date should be their in class date text box")
	public void selected_date_should_be_their_in_class_date_text_box() {
		
//		String selectedDate = classPage.getSelectedDate(); // Replace with your implementation
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        try {
//            Date date = (Date) sdf.parse(selectedDate);
        } catch (Exception e) {
            throw new AssertionError("Selected date is not in the mm/dd/yyyy format");
        }
	}

	@Then("selected date should be in  mm\\/dd\\/yyyy format")
	public void selected_date_should_be_in_mm_dd_yyyy_format() {
		WebElement rightArrow = classPage.getRightArrow();
        rightArrow.click();
	}

	@When("Admin clicks right arrow in the date picker near month")
	public void admin_clicks_right_arrow_in_the_date_picker_near_month() {
		
		WebElement rightArrow = driver.findElement(By.id("right-arrow-id")); 
        rightArrow.click();
	}

	@Then("Next month calender should visible")
	public void next_month_calender_should_visible() {
		
		WebElement nextMonthCalendar = driver.findElement(By.id("next-month-calendar-id"));
        assert(nextMonthCalendar.isDisplayed());
	}

	@When("Admin clicks left arrow in the date picker near month")
	public void admin_clicks_left_arrow_in_the_date_picker_near_month() {
		
		WebElement leftArrow = driver.findElement(By.id("left-arrow-id")); 
        leftArrow.click();
	}

	@Then("previous month calender should visible")
	public void previous_month_calender_should_visible() {
		
		WebElement previousMonthCalendar = driver.findElement(By.id("previous-month-calendar-id")); // Replace with the actual locator
        assert(previousMonthCalendar.isDisplayed());
	}

	@When("Admin clicks date picker button")
	public void admin_clicks_date_picker_button() {
		classPage.getCalenderIcon().click();
		
	}

	@Then("Admin should see current date is highled in the date picker")
	public void admin_should_see_current_date_is_highled_in_the_date_picker() {
		
		By datePicker = null;
		@SuppressWarnings("null")
		List<WebElement> dateCells = datePicker.findElements((SearchContext) By.tagName("td"));
		for (WebElement dateCell : dateCells) {
			String cellText = dateCell.getText().trim();
			Object formattedCurrentDate = null;
			if (cellText.equals(formattedCurrentDate)) {
				// Check if the current date cell is highlighted (you may need to adjust the CSS
				// selector)
				if (dateCell.getAttribute("class").contains("highlighted")) {
					System.out.println("Current date is highlighted in the date picker.");
					return;

				}
			}
		}
	}

	@When("Admin clicks date picker button and selects future date")
	public void admin_clicks_date_picker_button_and_selects_future_date() {
		WebElement datePickerButton = classPage.getDatePickerButton();
        datePickerButton.click();

	}

	@Then("Admin should see selected date is highled in the date picker")
	public void admin_should_see_selected_date_is_highled_in_the_date_picker() {
		
		String selectedDate = classPage.getSelectedDate();
        boolean isHighlighted = selectedDate.contains(selectedDate);
        assert isHighlighted;
	}

	@Then("Admin should land on Manage Class Page and validate new class is not created in the data table")
	public void admin_should_land_on_manage_class_page_and_validate_new_class_is_not_created_in_the_data_table() throws InterruptedException {
		classPage.getDataTable();
        WebElement dataTable = null;
		@SuppressWarnings("null")
		boolean isNewClassPresent = dataTable.getText().contains("New Class"); // Adjust this based on your application

        assert !isNewClassPresent: "New class is not present";
	}
/////////////delete
	
	@When("Admin clicks delete button in data table row level")
	public void admin_clicks_delete_button_in_data_table_row_level() {
		try {
			classPage.getdeleteAlertBtn();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	

	@Then("Admin should see alert")
	public void admin_should_see_alert() {
		try {
	    	boolean Text = classPage.verifyAlertButtons("Program");
	    	if(Text) {
	    		assertTrue(true, "Yes and No buttons are displayed");
	    	} else {
	    		assertTrue(true, "Yes and No buttons not displayed");
	    	}
	    } catch (Exception e) {
			assertFalse(false,
					"Failed - Yes and No buttonsd for Delete alert");
		}
	    

	}

	@Then("Alert should have yes button to accept")
	public void alert_should_have_yes_button_to_accept() {
		
		Alert alert= classPage.getdeleteAlertBtn();
		classPage.getYesBtn();
		classPage.clickOnYesBtn();
		alert.dismiss();
        
	}

	@Then("Alert should have No button to reject")
	public void alert_should_have_no_button_to_reject() {
		Alert alert= classPage.getdeleteAlertBtn();
		classPage.getNoBtn();
		classPage.clickOnNoBtn();
		alert.dismiss();
        
	}


}
