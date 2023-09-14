package step_definitions;

import static org.testng.Assert.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.ManageProgramPageObj;
import utilities.ExcelReader;
import utilities.common_utils;
import webdriver_manager.DriverManager;

public class ManageProgramModule {
	WebDriver driver = DriverManager.getDriver();
	ManageProgramPageObj objManageProgramModule = ManageProgramPageObj.getInstance();
	common_utils objCommounUtils = new common_utils();
	String invalidText="@///test";
	String txtLogMessage = "";
	public List<WebElement> columnHeaders;

	private static final Logger LOGGER = LogManager.getLogger(ManageProgramModule.class);

	public ManageProgramModule() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	// BackGround - Manage Program Validation 1
	@Given("Program_Logged on the LMS portal")
	public void logged_on_the_lms_portal() {
		//call login object and method
		System.out.println("Logged on to LMS portl as Admin");
		LOGGER.info("Logged on to LMS portl as Admin");
	}
	// BackGround - Manage Program Validation 2
	@Then("Admin clicks Program from navigation bar")
	public void admin_clicks_program_from_navigation_bar() {
		objManageProgramModule.getLnkProgramNavigationBar().click();
		txtLogMessage = "Admin Clicks on Student on the navigation bar";
		System.out.println(txtLogMessage);
		LOGGER.info(txtLogMessage);
	}
	// Feature: Manage program validation -- Manageprogramvalidation1.feature
	@Given("Program_Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		driver.get(Constants.SIGNIN_URL);
		//driver.manage().window().maximize();
		System.out.println("Admin is on dashboard page"); 
	}

	//Add Program - Background
	@When("Admin is on Manage Program page after Login")
	public void admin_is_on_manage_program_page_after_login() {
		driver.get(Constants.ManageprogrampageURL);
		//driver.manage().window().maximize();
		System.out.println("Admin is on dashboard page");
	}
	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) throws InterruptedException {
		try {
			objManageProgramModule.Programnavigationbarbutton();
			System.out.println("Admin Clicks on program on the navigation bar");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String string) {
		String url = objManageProgramModule.getManageprogrampageURL();
		LOGGER.info("URL of current page is :" + url);
		assertEquals(url, "https://manageprogram.herokuapp.com/");
	}

	@Then("Admin should see a heading with text {string} on the page")
	public void admin_should_see_a_heading_with_text_on_the_page(String string) {
		String Title = objManageProgramModule.getManageprogramPageTitle();
		LOGGER.info("Title of current page is :" + Title);
		assertEquals(Title, "Manage Program", "Title not matched");
	}

	@Then("Admin should see the text as {string} along with Pagination icon")
	public void admin_should_see_the_text_as_along_with_pagination_icon(String string) {
		// Verify that the table is displayed
		Assert.assertTrue("Table is not displayed.", objManageProgramModule.isTableDisplayed());

		// Verify the "Showing x to y of z entries" text
		String entriesInfoText = objManageProgramModule.getEntriesInfoText();
		Assert.assertTrue("Entries info text format is incorrect.", entriesInfoText.matches("Showing \\d+ to \\d+ of \\d+ entries"));

		// Verify the presence of the pagination icon
		Assert.assertTrue("Pagination icon is not displayed.", objManageProgramModule.isPaginationDisplayed());


	}

	@Then("Admin should see the footer as {string}")
	public void admin_should_see_the_footer_as(String string) {
		String footertext = objManageProgramModule.getfootertext();
		LOGGER.info("Title of footer pagination text is :" + footertext);
		assertEquals(footertext, "In total there are z programs", "Text not matched");
	}

	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() throws InterruptedException {
		objManageProgramModule.Deletetopbutton();
		assert(objManageProgramModule.isbuttondisabled());
	}

	@Then("Admin should see a {string} button on the program page above the data table")
	public void admin_should_see_a_button_on_the_program_page_above_the_data_table(String string) {

		String anewprogram = objManageProgramModule.getaddprogramtext();
		LOGGER.info("add new program button text is :" + anewprogram);
		assertEquals(anewprogram, "+A New Program", "Text not matched");
	}

	@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int}")
	public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer int1) {

		// Get the number of records displayed in the table
		int rowCount = objManageProgramModule.getRowCount();

		// Verify that the number of records is 5
		assertEquals(rowCount, 5, "Number of records is not as expected (5).");
	}


	@Then("Admin should see data table on the Manage Program Page with column headers like Program Name, Program Description, Program Status, Edit,Delete")
	public void admin_should_see_data_table_on_the_manage_program_page_with_column_headers_like_program_name_program_description_program_status_edit_delete() {

		String programnamedatatable = objManageProgramModule.getprogramnametextondatatable();
		LOGGER.info("program name on data table text is :" + programnamedatatable);
		assertEquals(programnamedatatable, "Program Name", "Text not matched");

		String programdescdatatable = objManageProgramModule.getprogramdesctextondatatable();
		LOGGER.info("program description on data table text is :" + programdescdatatable);
		assertEquals(programdescdatatable, "Program Description", "Text not matched");

		String programstatusdatatable = objManageProgramModule.getprogramstatustextondatatable();
		LOGGER.info("program description on data table text is :" + programstatusdatatable);
		assertEquals(programstatusdatatable, "Program Status", "Text not matched");

		String editdatatable = objManageProgramModule.getedittextondatatable();
		LOGGER.info("Edit on data table text is :" + editdatatable);
		assertEquals(editdatatable, "Edit", "Text not matched");

		String deletedatatable = objManageProgramModule.getdeletetextondatatable();
		LOGGER.info("Delete on data table text is :" + deletedatatable);
		assertEquals(deletedatatable, "Delete", "Text not matched");

	}


	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {

		columnHeaders = objManageProgramModule.getColumnHeaders();
		for (WebElement columnHeader : columnHeaders) {
			if (!objManageProgramModule.isExcludedColumn(columnHeader)) {
				Assert.assertTrue("Sort arrow icon not displayed for a column header",
						objManageProgramModule.hasSortArrowIcon(columnHeader));
			}
		}

	}

	@Then("Admin should see check box on the left side in all rows of the data table")
	public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {

		List<WebElement> rows = objManageProgramModule.getAllRows();
		for (WebElement row : rows) {
			Assert.assertTrue("Checkbox not displayed in a row", objManageProgramModule.isCheckboxPresentInRow(row));
		}
	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		List<WebElement> rows = objManageProgramModule.getRowsWithEditDeleteButtons();
		for (WebElement row : rows) {
			Assert.assertTrue("Edit and Delete buttons not displayed in a row", row.isDisplayed());
		}


	}

	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String expectedText) {

		WebElement searchBar = objManageProgramModule.getSearchBar();
		String actualText = searchBar.getAttribute("placeholder");
		Assert.assertEquals("Search bar text does not match", expectedText, actualText);

	}

	// Feature: Manage program validation - Manageprogramvalidation2.feature

	@Given("Admin is on Manage Program Page")
	public void admin_is_on_manage_program_page() {
		driver.get(Constants.ManageprogrampageURL);
		System.out.println("Admin is on Manage program page");
	}

	@When("Admin enters <Program name> into search box.")
	public void admin_enters_program_name_into_search_box() throws InterruptedException {
		objManageProgramModule.enterSearchPhrase("Jan23-Seleniumbrewer-SDET-201-1001"); 
		Thread.sleep(2000);
		objManageProgramModule.clickSearchMagnifyButton();

	}

	@Then("Admin should see the Programs displayed based on the Program Name")
	public void admin_should_see_the_programs_displayed_based_on_the_program_name() {

		Assert.assertTrue("Search results are not visible", objManageProgramModule.areSearchResultsVisible());

		// Get the text from the search results
		String searchResultsText = objManageProgramModule.getSearchResultsText();

		// Implement verification logic for the search results

		Assert.assertTrue("Search results do not contain the expected phrase", searchResultsText.contains("Jan23-Seleniumbrewer-SDET-201-1001"));
	}

	@When("Admin enters <Program description phrase> into search box")
	public void admin_enters_program_description_phrase_into_search_box() throws InterruptedException {
		objManageProgramModule.enterSearchPhrase("Jan23-Seleniumbrewer-SDET-Desc"); 
		Thread.sleep(2000);
		objManageProgramModule.clickSearchMagnifyButton();

	}

	@Then("Admin should see the Programs displayed based on the Program Description")
	public void admin_should_see_the_programs_displayed_based_on_the_program_description() {

		Assert.assertTrue("Search results are not visible", objManageProgramModule.areSearchResultsVisible());

		// Get the text from the search results
		String searchResultsText = objManageProgramModule.getSearchResultsText();

		// Implement verification logic for the search results

		Assert.assertTrue("Search results do not contain the expected phrase", searchResultsText.contains("Jan23-Seleniumbrewer-SDET-Desc"));

	}

	@When("Admin enters <Program status phrase> into search box.")
	public void admin_enters_program_status_phrase_into_search_box() throws InterruptedException {

		objManageProgramModule.enterSearchPhrase("Active"); 
		Thread.sleep(2000);
		objManageProgramModule.clickSearchMagnifyButton();
	}

	@Then("Admin should see the Programs displayed based on the Program Status")
	public void admin_should_see_the_programs_displayed_based_on_the_program_status() {
		Assert.assertTrue("Search results are not visible", objManageProgramModule.areSearchResultsVisible());

		// Get the text from the search results
		String searchResultsText = objManageProgramModule.getSearchResultsText();

		// Implement verification logic for the search results

		Assert.assertTrue("Search results do not contain the expected phrase", searchResultsText.contains("Active"));

	}

	@When("Admin enters the {string} not present in the data table on the Search box")
	public void admin_enters_the_not_present_in_the_data_table_on_the_search_box(String invalidText) throws InterruptedException {
		objManageProgramModule.enterSearchPhrase(invalidText); 
		Thread.sleep(2000);
		objManageProgramModule.clickSearchMagnifyButton();
	}

	@Then("Admin should see zero entries on the data table")
	public void admin_should_see_zero_entries_on_the_data_table() {

		// Verify that the data table is empty
		Assert.assertTrue("Data table is not empty", objManageProgramModule.isDataTableEmpty());

	}

	// Feature: Add New Program   @ADD 1


	@When("Admin clicks <A New Program>button")
	public void admin_clicks_a_new_program_button() throws InterruptedException {
		objManageProgramModule.Addnewprogrambutton();
		System.out.println("Admin Clicks on add new program button");
		LOGGER.info("Admin Clicks on add new program button");

	}

	@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {

		Assert.assertTrue("Program details form is not empty", objManageProgramModule.isProgramDetailsFormEmpty());
		Assert.assertTrue("Save button is not visible", objManageProgramModule.isSaveButtonVisible());
		Assert.assertTrue("Cancel button is not visible", objManageProgramModule.isCancelButtonVisible());
		Assert.assertTrue("Close icon is not visible", objManageProgramModule.isCloseIconVisible());
	}

	@Then("Admin should see two input fields and their respective text boxes in the program details window")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {

		Assert.assertTrue("Program name field textbox is not empty", objManageProgramModule.isProgramDetailsFieldEmpty());
		Assert.assertTrue("Program description field textbox is not empty", objManageProgramModule.isProgramDetailsFieldEmpty());

	}

	@Then("Admin should see two radio button for Program Status")
	public void admin_should_see_two_radio_button_for_program_status() {
		Assert.assertTrue("'Active' radio button is not visible", objManageProgramModule.isRadioActiveVisible());
		Assert.assertTrue("'Inactive' radio button is not visible", objManageProgramModule.isRadioInactiveVisible());

	}

	// Feature: Add New Program   @ADD 2

	@Given("Admin is on {string} Popup window")
	public void admin_is_on_popup_window(String string) {

		boolean isPopupVisible = objManageProgramModule.getprogramDetailsPopup().isDisplayed();
		Assert.assertFalse("Program Details popup should disappear", isPopupVisible);
		System.out.println("Admin is on pop window page"); 
		LOGGER.info("Admin is on pop window page");
	}

	@When("Admin clicks <Save> button without entering any data")
	public void admin_clicks_save_button_without_entering_any_data() throws InterruptedException {

		objManageProgramModule.savebuttonpopup();
		System.out.println("Admin Clicks on save button on popup window");
		LOGGER.info("Admin Clicks on save button on popup window");
	}


	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() {

		String expectedErrorMessage = "Please fill the form";
		String actualErrorMessage = objManageProgramModule.getErrorMessage().getText();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}

	@When("Admin enters only {string} in text box and clicks Save button")
	public void admin_enters_only_in_text_box_and_clicks_save_button(String programName) {
		objManageProgramModule.enterProgramName(programName);
		objManageProgramModule.clickSaveButton();
	}

	@Then("Admin gets a message alert {string}")
	public void admin_gets_a_message_alert(String string) {
		String expectedErrorMessage = "Description is required"; // Replace with the expected error message
		String actualErrorMessage = objManageProgramModule.getErrorMessage().getText();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
		LOGGER.info("Admin gets a message alert");

	}

	@When("Admin enters only the Program Description {string} in text box and clicks Save button")
	public void admin_enters_only_the_program_description_in_text_box_and_clicks_save_button(String programDescription) {
		objManageProgramModule.enterProgramDescription(programDescription);
		objManageProgramModule.clickSaveButton();
	}

	@Then("Admin gets a message alert for Descrption {string}")
	public void admin_gets_a_message_alert_for_descrption(String string) {
		String expectedErrorMessage = "Description is required"; // Replace with the expected error message
		String actualErrorMessage = objManageProgramModule.getErrorMessage().getText();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
		LOGGER.info("Admin gets a message alert for Descrption");
	}


	@When("Admin selects only Status and clicks Save button")
	public void admin_selects_only_status_and_clicks_save_button() {
		objManageProgramModule.clickStatusRadio();
		objManageProgramModule.clickSaveButton();
		LOGGER.info("Admin selects only Status and clicks Save button");
	}

	@Then("Admin gets a message alert for Name and Description {string}")
	public void admin_gets_a_message_alert_for_name_and_description(String string) {
		String expectedErrorMessage = "Name and Description required"; // Replace with the expected error message
		String actualErrorMessage = objManageProgramModule.getErrorMessage().getText();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}

	@When("Admin enters only {string} char in name and desc column")
	public void admin_enters_only_char_in_name_and_desc_column(String specialCharacter) {
		objManageProgramModule.enterProgramName(specialCharacter);
		objManageProgramModule.clickSaveButton();

		objManageProgramModule.enterProgramDescription(specialCharacter);
		objManageProgramModule.clickSaveButton();
	}

	@Then("Admin gets a Error message alert for special character")
	public void admin_gets_a_error_message_alert_for_special_character() {
		String expectedErrorMessage = "Invalid Data"; // Replace with the expected error message
		String actualErrorMessage = objManageProgramModule.getErrorMessage().getText();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
		LOGGER.info("Admin gets a Error message alert for special character");
	}

	@When("Admin clicks Cancel-Close\\(X) Icon on Program Details form")
	public void admin_clicks_cancel_close_x_icon_on_program_details_form() {
		objManageProgramModule.clickCloseIcon();
		LOGGER.info("Admin clicks Cancel-Close\\\\(X) Icon on Program Details form");
	}

	@Then("Program Details popup window should be closed without saving")
	public void program_details_popup_window_should_be_closed_without_saving() {
		// Implement a verification step to ensure the popup is closed
		boolean isPopupClosed = !objManageProgramModule.getprogramDetailsPopup().isDisplayed();
		Assert.assertTrue("Program Details popup should be closed", isPopupClosed);

	}

	@When("Enter all the required fields with valid values and click Save button")
	public void enter_all_the_required_fields_with_valid_values_and_click_save_button() {
		objManageProgramModule.enterProgramName("Jan23-Seleniumbrewer-SDET-501-1001");
		objManageProgramModule.enterProgramDescription("Phase II testing");
		objManageProgramModule.clickStatusRadio();
		objManageProgramModule.clickSaveButton();

	}

	@Then("Admin gets a message {string} alert and able to see the new program added in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table(String expectedMessage) {

		String actualMessage = objManageProgramModule.getSuccessMessage().getText();
		Assert.assertEquals(expectedMessage, actualMessage);

	}

	@When("Admin clicks <Cancel>button")
	public void admin_clicks_cancel_button() {

		objManageProgramModule.clickcancelButton();
		LOGGER.info("Admin clicks <Cancel>button");

	}

	@Then("Admin can see the Program details popup disappears without creating any program")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() {

		boolean isPopupVisible = objManageProgramModule.getprogramDetailsPopup().isDisplayed();
		Assert.assertFalse("Program Details popup should disappear", isPopupVisible);
		LOGGER.info("Admin can see the Program details popup disappears without creating any program");
	}

	// Feature :- Edit Program Module -- Single Scenario


	@When("Admin clicks <Edit> button on the data table for any row")
	public void admin_clicks_edit_button_on_the_data_table_for_any_row() {

		List<WebElement> editButtons = objManageProgramModule.getEditButtons();
		if (!editButtons.isEmpty()) {
			editButtons.get(0).click(); // Click the  Edit button
		} 
		LOGGER.info("Admin clicks <Edit> button on the data table for any row");

	}

	@Then("Admin should see a popup open for Program details to edit")
	public void admin_should_see_a_popup_open_for_program_details_to_edit() {

		// Verify that the Program Details popup is displayed
		boolean isPopupVisible = objManageProgramModule.editgetProgramDetailsPopup().isDisplayed();
		Assert.assertTrue("Admin should see the Program Details popup for editing", isPopupVisible);
		LOGGER.info("Admin should see a popup open for Program details to edit");
	}

	// Feature :- Edit Program Detail Module -- Mutiple Single Scenario	
	@Given("Admin is on Program Details Popup window to Edit")
	public void admin_is_on_program_details_popup_window_to_edit() {

		boolean isPopupVisible = objManageProgramModule.editgetProgramDetailsPopup().isDisplayed();
		Assert.assertFalse("Program Details popup should disappear", isPopupVisible);
		System.out.println("Admin is on pop window page to edit"); 
		LOGGER.info("Admin is on Program Details Popup window to Edit");
	}

	@When("Admin edits the Name column and clicks save button")
	public void admin_edits_the_name_column_and_clicks_save_button() {

		objManageProgramModule.editProgramName("Jan23-Seleniumbrewer-SDET-301-1001");
		objManageProgramModule.editclickSaveButton();
		LOGGER.info("Admin edits the Name column and clicks save button");

	}

	@Then("Admin gets a message {string} alert and able to see the updated name in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program(String expectedMessage) {

		String actualMessage = objManageProgramModule.editgetSuccessMessage();
		Assert.assertEquals(expectedMessage, actualMessage);

	}

	@When("Admin edits the Description column and clicks save button")
	public void admin_edits_the_description_column_and_clicks_save_button() {

		objManageProgramModule.editprogramDescription("Phase III Test");
		objManageProgramModule.editclickSaveButton();
		LOGGER.info("Admin edits the Description column and clicks save button");

	}

	@Then("Admin gets a message {string} alert and able to see the updated description in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program(String expectedMessage) {

		String actualMessage = objManageProgramModule.editgetSuccessMessage();
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("Admin changes the Status and clicks save button")
	public void admin_changes_the_status_and_clicks_save_button() {

		objManageProgramModule.editselectInactiveStatus();

		// Click the Save button
		objManageProgramModule.editclickSaveButton();
		LOGGER.info("Admin changes the Status and clicks save button");
	}

	@Then("Admin gets a message {string} alert and able to see the updated status in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program(String expectedMessage) {

		String actualMessage = objManageProgramModule.editgetSuccessMessage();
		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("Admin enters only numbers or special {string} char in name and desc column")
	public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column(String specialCharacter) {

		objManageProgramModule.enterProgramName(specialCharacter);
		objManageProgramModule.editclickSaveButton();

		objManageProgramModule.editenterProgramDescription(specialCharacter);
		objManageProgramModule.editclickSaveButton();
	}

	@Then("Admin gets a Error message alert {string}")
	public void admin_gets_a_error_message_alert(String string) {
		String expectedErrorMessage = "Invalid Data"; // Replace with the expected error message
		String actualErrorMessage = objManageProgramModule.editgetErrorMessage().getText();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
		LOGGER.info("Admin gets a Error message alert");
	}


	@When("Admin clicks <Cancel>button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {

		objManageProgramModule.editclickcancelButton();
		LOGGER.info("Admin clicks <Cancel>button on edit popup");
	}

	@Then("Admin can see the Program details popup disappears and can see nothing changed for particular program")
	public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program() {
		/** REvisit*/
		boolean isPopupVisible = objManageProgramModule.getprogramDetailsPopup().isDisplayed();
		Assert.assertFalse("Program Details popup should disappear", isPopupVisible);
	}

	@When("Admin clicks <Save>button on edit popup")
	public void admin_clicks_save_button_on_edit_popup() {

		objManageProgramModule.editenterProgramName("Jan23-Seleniumbrewer-SDET-1001-1001");
		objManageProgramModule.editenterProgramDescription("Phase III testing");
		objManageProgramModule.editclickStatusRadio();
		objManageProgramModule.editclickSaveButton();
	}

	@Then("Admin gets a message {string} alert and able to see the updated details in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program(String expectedMessage) {

		String actualMessage = objManageProgramModule.editgetSuccessMessage();
		Assert.assertEquals(expectedMessage, actualMessage);

	}

	// Feature - Delete Program Module

	@When("Admin clicks <Delete> button on the data table for any row {int}")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row(Integer rowIndex) {

		objManageProgramModule.clickDeleteButtonForRow(rowIndex);
		LOGGER.info("Admin clicks <Delete> button on the data table for any row {int}");
	}

	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String expectedHeading) {

		String actualAlertHeading = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedHeading, actualAlertHeading);
		LOGGER.info("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion");

	}

	@Then("Admin should see a message for Program Name {string}")
	public void admin_should_see_a_message_for_program_name(String expectedMessage) {

		String actualAlertmessage = driver.switchTo().alert().getText();
		Assert.assertEquals(expectedMessage, actualAlertmessage);
		LOGGER.info("Admin should see a message for Program Name {string}");
	}

	// Feature: Multiple Delete Program 1
	@When("Admin clicks any checkbox in the data table")
	public void admin_clicks_any_checkbox_in_the_data_table() {
		List<WebElement> el = objManageProgramModule.getProgramDetailRows();
		if(!el.get(0).findElement(By.xpath("")).isSelected()) {
			el.get(0).findElement(By.xpath("")).click();
		}
		LOGGER.info("One of the checkbox in a row is selected");
	}

	@Then("Admin should see common delete option enabled under header Manage Program")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {
		boolean btnEnabled = objManageProgramModule.getBtnDelAll().isEnabled();
		LOGGER.info("Delete icon is disabled :" + btnEnabled);
		assertTrue(!btnEnabled, "Delete icon should be disabled");
	}

	@Then("Delete Button on the header Section")
	public void delete_button_on_the_header_section() {
		objManageProgramModule.getBtnDelAll().click();
		LOGGER.info("Delete All icom is been selected");
	}

	@Then("Admin should land on Manage Program page and can see the selected program is deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table() throws IOException {
		try {
			String strTitle = driver.getTitle();
			assertEquals(strTitle, "Manage Program Page"); 


			driver.switchTo().alert();
			LOGGER.info("User deleted alert appears");

			//check if user got deleted
			List<WebElement> el = objManageProgramModule.getProgramDetailRows();
			int i, cnt = el.size();
			boolean displayedFlag = false;
			String data;
			String strFilePath  = System.getProperty("user.dir") + 
					"/src/test/resources/excelFiles/TestCaseData.xlsx";
			ExcelReader.setFilePath(strFilePath);
			ExcelReader.setSheetNo(2);
			ExcelReader.setRowNo(1);
			Row row = ExcelReader.GetRowData();
			String strProgramName = row.getCell(1).toString();

			for(i=0;i<cnt;i++) {
				data = el.get(i).findElement
						(By.xpath("//ProgramName")).getText();
				if(data.equals(strProgramName)) {
					displayedFlag = true;
					LOGGER.info("The deleted data is present in the data table");
					break;
				}
			}  

			if(!displayedFlag) {
				LOGGER.info("The deleted data not present in the data table");
			}
			assertTrue(!displayedFlag, "The deleted data present in the data table");        
		}catch(NoAlertPresentException e){
			System.out.println("Alert doesn't appear for deleted user");
			LOGGER.info("Alert doesn't appear for deleted user");
		} 

	}

	@Then("Admin should land on Manage Program page and can see the selected program is not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table() throws IOException {
		List<WebElement> el = objManageProgramModule.getProgramDetailRows();
		int i, cnt = el.size();
		boolean displayedFlag = false;
		String data;
		String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(2);
		ExcelReader.setRowNo(1);
		Row row = ExcelReader.GetRowData();
		String strProgramName = row.getCell(1).toString();

		for(i=0;i<cnt;i++) {
			data = el.get(i).findElement
					(By.xpath("//ProgramName")).getText();
			if(data.equals(strProgramName)) {
				displayedFlag = true;
				LOGGER.info("The Batch is still listed in the data table");
				break;
			}
		}
		if(!displayedFlag) {
			LOGGER.info("The Batch deleted from the data table");
		}
		assertTrue(displayedFlag, "The Batch deleted from the data table");
	}
	// Mutiple Delete Program - 3

	@When("Admin clicks Multiple checkbox in the data table")
	public void admin_clicks_multiple_checkbox_in_the_data_table() {
		List<WebElement> el = objManageProgramModule.getProgramDetailRows();
		if(el.size()>=1) {
			el.get(0).findElement(By.xpath("checkbox_id")).click();
		}
		if(el.size()>=2) {
			el.get(1).findElement(By.xpath("checkbox_id")).click();			
		}	
		LOGGER.info("Two or more checkboxes in rows are selected");   
	}

	@Then("Admin should land on Manage Program page and can see the selected programs are deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_deleted_from_the_data_table() {
		String strTitle = driver.getTitle();
		assertEquals(strTitle, "Manage Program Page");
		WebElement dataTable = objManageProgramModule.getDataTable();
		boolean isProgramPresent = dataTable.findElement(By.xpath("//td[text()='Selected Program Name']")).isDisplayed();
		Assert.assertTrue("The selected program are not deleted from the data table.", !isProgramPresent);
		LOGGER.info("Admin should land on Manage Program page and can see the selected programs are deleted from the data table");

	}

	@Then("Admin should land on Manage Program page and can see the selected programs are not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_not_deleted_from_the_data_table() {
		String strTitle = driver.getTitle();
		assertEquals(strTitle, "Manage Program Page"); 
		WebElement dataTable = objManageProgramModule.getDataTable();
		boolean isProgramPresent = dataTable.findElement(By.xpath("//td[text()='Selected Program Name']")).isDisplayed();
		Assert.assertTrue("The selected program is not deleted from the data table.", isProgramPresent);
		LOGGER.info("Admin should land on Manage Program page and can see the selected programs are not deleted from the data table");
	}
	// Sorting Module

	@When("Admin clicks the sort icon of program name column")
	public void admin_clicks_the_sort_icon_of_program_name_column() {

		// Click the program name column header to sort in ascending order
		objManageProgramModule.clickProgramNameHeader();
		LOGGER.info("Admin clicks the sort icon of program name column");

	}

	@Then("The data get sorted on the table based on the program name column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order() {

		// Verify that the program names are sorted in ascending order
		Assert.assertTrue("Program names are not sorted in ascending order.", objManageProgramModule.isProgramNameColumnSortedAscending());
		LOGGER.info("The data get sorted on the table based on the program name column values in ascending order");
	}

	@Given("The data is in the ascending order on the table based on Program Name column")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_name_column() {
		// Click the program name header to sort in ascending order
		objManageProgramModule.clickProgramNameHeader();
		// Verify that the program names are sorted in ascending order
		Assert.assertTrue("Program names are not sorted in ascending order.", objManageProgramModule.isProgramNameColumnSortedAscending());
		LOGGER.info("The data is in the ascending order on the table based on Program Name column");


	}

	@Then("The data get sorted on the table based on the program name column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order() {

		// Click the program name header again to sort in descending order
		objManageProgramModule.clickProgramNameHeader();
		// Verify that the program names are sorted in descending order
		Assert.assertTrue("Program names are not sorted in descending order.", objManageProgramModule.isProgramNameColumnSortedDescending());
		LOGGER.info("The data get sorted on the table based on the program name column values in descending order");
	}

	@When("Admin clicks the sort icon of program Desc column")
	public void admin_clicks_the_sort_icon_of_program_desc_column() {
		// Click the program desc column header to sort in ascending order
		objManageProgramModule.clickProgramDescHeader();
		LOGGER.info("Admin clicks the sort icon of program Desc column");

	}

	@Then("The data get sorted on the table based on the program description column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_ascending_order() {

		// Click the program name header again to sort in asending order
		objManageProgramModule.clickProgramDescHeader();
		// Verify that the program names are sorted in descending order
		Assert.assertTrue("Program desc are not sorted in descending order.", objManageProgramModule.isProgramDescColumnSortedAscending());
	}

	@Given("The data is in the ascending order on the table based on Program Description column")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_description_column() {

		// Verify that the program Description are sorted in ascending order
		Assert.assertTrue("Program Description are not sorted in descending order.", objManageProgramModule.isProgramDescColumnSortedAscending());
		LOGGER.info("The data is in the ascending order on the table based on Program Description column");
	}

	@Then("The data get sorted on the table based on the program description column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_descending_order() {

		// Click the program name header again to sort in descending order
		objManageProgramModule.clickProgramDescHeader();
		// Verify that the program names are sorted in descending order
		Assert.assertTrue("Program desc are not sorted in descending order.", objManageProgramModule.isProgramDescColumnSortedDescending());
		LOGGER.info("The data get sorted on the table based on the program description column values in descending order");
	}

	@When("Admin clicks the sort icon of program Status column")
	public void admin_clicks_the_sort_icon_of_program_status_column() {
		// Click the program status column header to sort in ascending order
		objManageProgramModule.clickProgramStatusHeader();
		LOGGER.info("Admin clicks the sort icon of program Status column");

	}

	@Then("The data get sorted on the table based on the program status column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_ascending_order() {

		// Verify that the program status are sorted in ascending order
		Assert.assertTrue("Program status are not sorted in ascending order.", objManageProgramModule.isProgramStatusColumnSortedAscending());
		LOGGER.info("The data get sorted on the table based on the program status column values in ascending order");
	}

	@Given("The data is in the ascending order on the table based on Program Status column")
	public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_status_column() {
		// Click the program status header to sort in ascending order
		objManageProgramModule.clickProgramStatusHeader();
		// Verify that the program status are sorted in ascending order
		Assert.assertTrue("Program status are not sorted in ascending order.", objManageProgramModule.isProgramStatusColumnSortedAscending());
		LOGGER.info("The data is in the ascending order on the table based on Program Status column");


	}

	@Then("The data get sorted on the table based on the program status column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_descending_order() {
		// Click the program status header again to sort in descending order
		objManageProgramModule.clickProgramStatusHeader();
		// Verify that the program status are sorted in descending order
		Assert.assertTrue("Program status are not sorted in descending order.", objManageProgramModule.isProgramStatusColumnSortedDescending());
		LOGGER.info("The data get sorted on the table based on the program status column values in descending order");
	} 

// Pagination Feature

	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() {
		// Click the "Next" page link in pagination
		objManageProgramModule.clickNextPageLink();
		LOGGER.info("Admin clicks Next page link on the program table");
	    
	}

	@Then("Admin should see the Pagination has {string} link")
	public void admin_should_see_the_pagination_has_link(String string) {
		// Verify that the "Next" link is present in the pagination
        boolean isNextLinkPresent = objManageProgramModule.isNextPageLinkPresent();

        if (isNextLinkPresent) {
            System.out.println("Pagination has 'Next' link.");
        } else {
            System.out.println("Pagination does not have 'Next' link.");
            LOGGER.info("Pagination does not have 'Next' link.");
        }
	    
	}

	@When("Admin clicks Last page link")
	public void admin_clicks_last_page_link() {
		objManageProgramModule.clickLastPageLink();
		 LOGGER.info("Admin clicks Last page link");
	    
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
		
		boolean areLastPageRecordsDisplayed = objManageProgramModule.areLastPageRecordsDisplayed();
		boolean isNextLinkDisabled = objManageProgramModule.isNextPageLinkDisabled();
		assert areLastPageRecordsDisplayed : "Last page's record is not displayed.";
	    assert isNextLinkDisabled : "Next page link is not disabled.";
	    LOGGER.info("Admin should see the last page record on the table with Next page link are disabled");
	    
	}

	@Given("Admin is on last page of Program table")
	public void admin_is_on_last_page_of_program_table() {
		boolean areLastPageRecordsDisplayed = objManageProgramModule.areLastPageRecordsDisplayed();
		boolean isNextLinkDisabled = !objManageProgramModule.isNextPageLinkDisabled();
		assert areLastPageRecordsDisplayed : "Last page's record are displayed.";
	    assert isNextLinkDisabled : "Next page link is disabled.";
	    
	}

	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() {
		objManageProgramModule.clickFirstPageLink();
		 LOGGER.info("Admin clicks First page link");
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
		 @SuppressWarnings("unused")
		boolean isPreviousPageLinkPresent = objManageProgramModule.isPreviousPageLinkPresent();
		 @SuppressWarnings("unused")
		String firstRecordData = objManageProgramModule.getFirstRecordData();
	    
	}

	@Given("Admin is on Previous Program page")
	public void admin_is_on_previous_program_page() {
		boolean areLastPageRecordsDisplayed = objManageProgramModule.areLastPageRecordsDisplayed();
		boolean isNextLinkDisabled = !objManageProgramModule.isNextPageLinkDisabled();
		assert areLastPageRecordsDisplayed : "Last page's record are displayed.";
	    assert isNextLinkDisabled : "Next page link is disabled."; 
	    
	}

	@When("Admin clicks Start page link")
	public void admin_clicks_start_page_link() {
		  // Click the "Start page" link
		objManageProgramModule.clickStartPageLink();
		 LOGGER.info("Admin clicks Start page link");
	    
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
	    
		// Verify that the table is still displayed
        Assert.assertTrue("Program table is not displayed on the Start page.", objManageProgramModule.isProgramTableDisplayed());

        // Verify that the Previous page link is disabled
        Assert.assertTrue("Previous page link is not disabled on the Start page.", objManageProgramModule.isPreviousPageLinkDisabled());
        LOGGER.info("Admin should see the very first page record on the table with Previous page link are disabled");
	    
	}


	// Feature- Navigation validation program

	@When("Admin clicks on Student link on Manage Program page")
	public void admin_clicks_on_student_link_on_manage_program_page() {

		objManageProgramModule.getLnkStudentNavigationBar().click();
		System.out.println("Admin clicks Program link on Program page");
		LOGGER.info("Admin clicks Program link on Program page");


	}

	@Then("Admin is re-directed to Student page")
	public void admin_is_re_directed_to_student_page() {
		String strTitle = driver.getTitle();
		assertEquals(strTitle, "Student", "Admin not redirected to Program page"); 
	}

	@Then("Admin is re-directed to Batch page")
	public void admin_is_re_directed_to_batch_page() {
		objManageProgramModule.getLnkBatchNavigationBar().click();
		System.out.println("Admin clicks Class link on Program page");
		LOGGER.info("Admin clicks Class link on Program page");
	}

	@When("Admin clicks on Class link on Manage Program page")
	public void admin_clicks_on_class_link_on_manage_program_page() {
		objManageProgramModule.getLnkClassNavigationBar().click();
		System.out.println("Admin clicks Class link on Program page");
		LOGGER.info("Admin clicks Class link on Program page");
	}

	@Then("Admin is re-directed to Class page")
	public void admin_is_re_directed_to_class_page() {
		String strTitle = driver.getTitle();
		assertEquals(strTitle, "Class", "Admin not redirected to Class page"); 
		LOGGER.info("Admin is re-directed to Class page");

	}

	@When("Admin clicks on User link on Manage Program page")
	public void admin_clicks_on_user_link_on_manage_program_page() {
		objManageProgramModule.getLnkUserNavigationBar().click();
		System.out.println("Admin clicks User link on Program page");
		LOGGER.info("Admin clicks User link on Program page");
	}

	@Then("Admin is re-directed to User page")
	public void admin_is_re_directed_to_user_page() {
		String strTitle = driver.getTitle();
		assertEquals(strTitle, "User", "Admin not redirected to User page");
		LOGGER.info("Admin is re-directed to User page");
	}

	@When("Admin clicks on Assignment link on Manage Program page")
	public void admin_clicks_on_assignment_link_on_manage_program_page() {
		objManageProgramModule.getLnkAssignmentNavigationBar().click();
		System.out.println("Admin clicks Assignment link on Program page");
		LOGGER.info("Admin clicks Assignment link on Program page");
	}

	@Then("Admin is re-directed to Assignment page")
	public void admin_is_re_directed_to_assignment_page() {
		String strTitle = driver.getTitle();
		assertEquals(strTitle, "Assignment", "Admin not redirected to Assignment page"); 
	}

	@When("Admin clicks on Attendance link on Manage Program page")
	public void admin_clicks_on_attendance_link_on_manage_program_page() {
		objManageProgramModule.getLnkAttendanceNavigationBar().click();
		System.out.println("Admin clicks Attendance link on Program page");
		LOGGER.info("Admin clicks Attendance link on Program page");
	}

	@Then("Admin is re-directed to Attendance page")
	public void admin_is_re_directed_to_attendance_page() {
		String strTitle = driver.getTitle();
		assertEquals(strTitle, "Attendance", "Admin not redirected to Attendance page"); 
		LOGGER.info("Admin is re-directed to Attendance page");
	}

	@When("Admin clicks on Logout link on Manage Program page")
	public void admin_clicks_on_logout_link_on_manage_program_page() {
		objManageProgramModule.getLnkLogoutNavigationBar().click();
		System.out.println("Admin clicks Logout link on Program page");
		LOGGER.info("Admin clicks Logout link on Program page");
	}

	@Then("Admin is re-directed to Login page")
	public void admin_is_re_directed_to_login_page() {
		String strTitle = driver.getTitle();
		assertEquals(strTitle, "Login", "Admin not redirected to Login page"); 
		LOGGER.info("Admin is re-directed to Login page");
	}


	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() {
		try {
			driver.switchTo().alert();
		}catch(NoAlertPresentException e){
			System.out.println("Confirm Alert does not appear");
			LOGGER.info("Pop up with Program Alert doesn't appear");
		}
		System.out.println("A New pop-up with Program Alert appears");
		LOGGER.info("Program Alert appears");
	}

	@When("Admin clicks <YES> button on the alert")
	public void admin_clicks_yes_button_on_the_alert() {
		objManageProgramModule.getBtnDelYes().click();
		LOGGER.info("Admin clicks yes option for confirm delete alert");	
	}

	@Then("Admin gets a message {string} alert and able to see that program deleted in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks <NO> button on the alert")
	public void admin_clicks_no_button_on_the_alert() {
		objManageProgramModule.getBtnDelNo().click();
		LOGGER.info("Admin clicks No option for confirm delete alert");
	}

	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
		boolean isPopupVisible = objManageProgramModule.getDeletePopup().isDisplayed();
		Assert.assertFalse("Delete popup should disappear", isPopupVisible);
	}
	@When("Admin clicks Cancel or Close\\(X) icon on Deletion alert")
	public void admin_clicks_cancel_or_close_x_icon_on_deletion_alert() {
		objManageProgramModule.clickCloseIcon();
		objManageProgramModule.clickcancelButton();
		LOGGER.info("Admin clicks Cancel or Close\\\\(X) icon on Deletion alert");

	}

	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {
		boolean isPopupVisible = objManageProgramModule.getDeletePopup().isDisplayed();
		Assert.assertFalse("Delete popup should disappear", isPopupVisible);
		LOGGER.info("Admin can see the deletion alert disappears without any changes");
	}


}
