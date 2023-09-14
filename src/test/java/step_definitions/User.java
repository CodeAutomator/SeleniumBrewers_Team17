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
import io.cucumber.java.en.*;
import page_objects.StudentModule;
import page_objects.UserModule;
import utilities.ExcelReader;
import utilities.common_utils;
import webdriver_manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;

public class User {
	UserModule objUserModule = UserModule.getInstance();
	WebDriver driver = DriverManager.getDriver();
	common_utils objCommounUtils = new common_utils();
	String txtLogMessage = "";
	private static final Logger LOGGER = 
			LogManager.getLogger(StudentModule.class);
	
	public User() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}
	
	//user1.feature
	@When("Admin clicks User from navigation bar")
	public void admin_clicks_User_from_navigation_bar() {
		objUserModule.getLnkUserNavigationBar().click();
		txtLogMessage = "Admin Clicks on Student on the navigation bar";
		System.out.println(txtLogMessage);
		LOGGER.info(txtLogMessage);
	}
	
	@Then("Admin should see the Manage User in the URL")
	public void admin_should_see_the_in_the_url() {
		String strURL = driver.getCurrentUrl();
		LOGGER.info("URL :" + strURL);
		assertTrue(strURL.toLowerCase().contains("Manage User")
				, "Manage User page not seen");
	}
	
	@Then("Admin should see the Manage User in the header")
	public void admin_should_see_the_in_the_header(String string) {
	    String strHeader = objUserModule.getTxtHeaderUserPage().getText();
		LOGGER.info("Header :" + strHeader);
		assertTrue(strHeader.toLowerCase().contains("Manage User")
				, "'Manage User' not seen in the header");
	}
	
	@Then("User_Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
		String txtFooter = objUserModule.getTxtFooterPaginationText().getText();
		LOGGER.info("Title of footer pagination text is :" + txtFooter);
		assertTrue(txtFooter.contains("<<"), 
				"Cant see pagination control under the data table");
	}
	
	@Then("Admin Should see the data table with headers Id, Name, location, Phone Number, Edit&Delete")
	public void admin_should_see_the_data_table_with_headers_id_name_location_phone_number_edit_delete() {
	    List<WebElement> el = objUserModule.getUserHeaderRows();
	    int i, cnt = el.size(), cntHeader=0;
	    boolean displayedFlag = false;
	    for(i=0;i<cnt;i++) {
	    	displayedFlag = el.get(i).findElement(By.xpath("//ID")).isDisplayed();
	    	if(displayedFlag) {
	    		cntHeader ++;
	    	}
	    }	
	    assertTrue(cntHeader == cnt, "Please check headers in each row of the data table");
	    if(cntHeader == cnt) {
	    	txtLogMessage="Each row has a header";
	    }else {
	    	txtLogMessage="Please check headers in each row of the data table";
	    }
		LOGGER.info(txtLogMessage);
	 }
	
	@Then("Admin should be able to see the Delete icon button that is disabled")
	public void admin_should_be_able_to_see_the_icon_button_that_is_disabled() {
		boolean btnEnabled = objUserModule.getBtnDelAll().isEnabled();
		LOGGER.info("Delete icon is disabled :" + btnEnabled);
		assertTrue(!btnEnabled, 
				"Delete icon should be disabled");
	}
	
	@Then("Admin should be able to see the + A New User button")
	public void admin_should_be_able_to_see_the_button() {
		boolean btnVisible = objUserModule.getBtnAddUser().isDisplayed();
		LOGGER.info("+ A New User icon is visible :" + btnVisible);
		assertTrue(btnVisible, 
				"+ A New User icon is not visible"); 
	}
	
	@Then("Admin should be able to see the + Assign staff button")
	public void admin_should_be_able_to_see_the_Assign_Staff_Button() {
		boolean btnVisible = objUserModule.getBtnAssignStaff().isDisplayed();
		LOGGER.info("+ Assign Staff icon is visible :" + btnVisible);
		assertTrue(btnVisible, 
				"+ Assign Staff icon is not visible");
	}
	

	@Then("Admin should be able to see the search text box")
	public void admin_should_be_able_to_see_the_search_text_box() {
		boolean btnVisible = objUserModule.getTxtSearch().isDisplayed();
		LOGGER.info("Search textbox is visible :" + btnVisible);
		assertTrue(btnVisible, 
				"Search textbox is not visible");
	}

	@Then("Each row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_a_checkbox() {
	    List<WebElement> el = objUserModule.getUserDetailRows();
	    int i, cnt = el.size(), cntChkBox=0;
	    boolean displayedFlag = false;
	    for(i=0;i<cnt;i++) {
	    	displayedFlag = el.get(i).findElement(By.xpath("//chkbox_xpath")).isDisplayed();
	    	if(displayedFlag) {
	    		cntChkBox ++;
	    	}
	    }
	    assertTrue(cntChkBox == cnt, "Please check checkboxes in each row of the data table");
	    if(cntChkBox == cnt) {
	    	txtLogMessage="Each row in the data has a checkbox";
	    }else {
	    	txtLogMessage="Please check checkboxes in each row of the data table";
	    }
		LOGGER.info(txtLogMessage);
	}
	
	@Then("Each row in the data table should have a edit icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
		List<WebElement> el = objUserModule.getUserDetailRows();
	    int i, cnt = el.size(), cntEditIconD=0, cntEditIconE=0;
	    boolean displayedFlag = false, enabledFlag = false;
	    for(i=0;i<cnt;i++) {
	    	displayedFlag = el.get(i).findElement
	    			(By.xpath("//edit_icon")).isDisplayed();
	    	enabledFlag = el.get(i).findElement
	    			(By.xpath("//edit_icon")).isEnabled();
	    	if(displayedFlag) {
	    		cntEditIconD ++;
	    	}
	    	if(enabledFlag) {
	    		cntEditIconE ++;
	    	}
	    }
	    assertTrue(cntEditIconD == cnt, 
	    		"Please check edit icons in each row of the data table");
	    if(cntEditIconD == cnt) {
	    	txtLogMessage="Each row in the data has an edit icon";
	    }else {
	    	txtLogMessage="Please check edit icons in each row of the data table";
	    }
		LOGGER.info(txtLogMessage);
		
		//check if enabled
		assertTrue(cntEditIconE == cnt, 
	    		"Please check if edit icons in each row of the data table are enabled");
	    if(cntEditIconD == cnt) {
	    	txtLogMessage="Each row in the data has an enabled edit icon";
	    }else {
	    	txtLogMessage="Some Edit icons in rows of the data table are not enabled";
	    }
		LOGGER.info(txtLogMessage);	
	}
	
	@Then("Each row in the data table should have a delete icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
		List<WebElement> el = objUserModule.getUserDetailRows();
	    int i, cnt = el.size(), cntDelIconD=0, cntDelIconE=0;
	    boolean displayedFlag = false, enabledFlag = false;
	    for(i=0;i<cnt;i++) {
	    	displayedFlag = el.get(i).findElement
	    			(By.xpath("//delete_icon")).isDisplayed();
	    	enabledFlag = el.get(i).findElement
	    			(By.xpath("//delete_icon")).isEnabled();
	    	if(displayedFlag) {
	    		cntDelIconD ++;
	    	}
	    	if(enabledFlag) {
	    		cntDelIconE ++;
	    	}
	    }
	    assertTrue(cntDelIconD == cnt, 
	    		"Please check Delete icons in each row of the data table");
	    if(cntDelIconD == cnt) {
	    	txtLogMessage="Each row in the data has an Delete icon";
	    }else {
	    	txtLogMessage="Please check Delete icons in each row of the data table";
	    }
		LOGGER.info(txtLogMessage);
		
		//check if enabled
		assertTrue(cntDelIconE == cnt, 
	    		"Please check if Delete icons in each row of the data table are enabled");
	    if(cntDelIconD == cnt) {
	    	txtLogMessage="Each row in the data has an enabled Delete icon";
	    }else {
	    	txtLogMessage="Some Delete icons in rows of the data table are not enabled";
	    }
		LOGGER.info(txtLogMessage);
	}
	@Given("User_Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		driver.get(Constants.SIGNIN_URL);
		//driver.manage().window().maximize();
		//SignPage.Signin(Constants.USERNAME, Constants.PASSWORD);
		LOGGER.info("Admin is on dashboard page : ");
		System.out.println("Admin is on dashboard page after login ");
	}
	
	@Given("User_Admin is on dashboard page after Login and Admin clicks User from navigation bar")
	public void admin_is_on_dashboard_page_after_login_and_admin_clicks_from_navigation_bar() {
		objUserModule.getLnkUserNavigationBar().click();
		System.out.println("Logged on to LMS portl as Admin");
	    LOGGER.info("Logged on to LMS portl as Admin");
	}
	
	@When("Admin clicks + A New User button")
	public void admin_clicks_button() {
	    objUserModule.getBtnAddUser().click();
	    System.out.println("Admin clicks + A New User button");
	    LOGGER.info("Admin clicks + A New User button");
	}
	
	@Then("A new pop up with UserDetails appears")
	public void a_new_pop_up_with_UserDetails_appears() {
	    try {
	    	driver.switchTo().alert();
	    }catch(NoAlertPresentException e){
		    System.out.println("Popup window does not appear");
		    LOGGER.info("Pop up with UserDetails doesn't appear");
	    }
	}
	
	//user2.feature
	@Given("Logged on the LMS portal")
	public void logged_on_the_lms_portal() {
		System.out.println("Logged on to LMS portl");
	    LOGGER.info("Logged on to LMS portl");
	}
	
	@Given("A new pop up with user details appears")
	public void a_new_pop_up_with_user_details_appears() {
		try {
	    	driver.switchTo().alert();
	    }catch(NoAlertPresentException e){
		    System.out.println("Popup window does not appear");
		    LOGGER.info("Pop up with UserDetails doesn't appear");
	    }
		System.out.println("A New pop-up with User details appears");
	    LOGGER.info("A New pop-up with User details appears");
	}
	
	@Then("The pop up should include the fields First Name,Middle name, Last Name, Location phone, email,linkedin Url,Undergraduate,postgraduate,time zone and user comments as text box User Role, Role status, visa status as drop down")
	public void the_pop_up_should_include_the_fields_first_name_middle_name_last_name_location_phone_email_linkedin_url_undergraduate_postgraduate_time_zone_and_user_comments_as_text_box_user_role_role_status_visa_status_as_drop_down() {
	    boolean flag = false;
		flag = objUserModule.getTxtFName().isDisplayed();
		assertTrue(flag, "First Name not visible");
		flag = objUserModule.getTxtMName().isDisplayed();
		assertTrue(flag, "Middle Name not visible");
		flag = objUserModule.getTxtLName().isDisplayed();
		assertTrue(flag, "Last Name not visible");
		flag = objUserModule.getTxtLocation().isDisplayed();
		assertTrue(flag, "Location not visible");
		flag = objUserModule.getTxtPhone().isDisplayed();
		assertTrue(flag, "Phone No not visible");
		flag = objUserModule.getTxtLinkedInURL().isDisplayed();
		assertTrue(flag, "LinkedIn URL not visible");
		flag = objUserModule.getTxtUnderGrad().isDisplayed();
		assertTrue(flag, "Under Graduate not visible");
		flag = objUserModule.getTxtPostGrad().isDisplayed();
		assertTrue(flag, "Post Graduate not visible");
		flag = objUserModule.getTxtTimeZone().isDisplayed();
		assertTrue(flag, "Timezone not visible");
		flag = objUserModule.getTxtUserComments().isDisplayed();
		assertTrue(flag, "User Comments not visible");
		flag = objUserModule.getTxtFName().isDisplayed();
		assertTrue(flag, "First Name not visible");
		flag = objUserModule.getTxtFName().isDisplayed();
		assertTrue(flag, "First Name not visible");		
		flag = objUserModule.getSelUserRole().isDisplayed();
		assertTrue(flag, "User Role not visible");
		flag = objUserModule.getSelRoleStatus().isDisplayed();
		assertTrue(flag, "Role status not visible");
		flag = objUserModule.getSelVisaStatus().isDisplayed();
		assertTrue(flag, "Visa status not visible");
	}
	
	@When("Fill in all the fields except optional fields with valid values and click submit")
	public void fill_in_all_the_fields_except_optional_fields_with_valid_values_and_click_submit() 
			throws IOException {
	    String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(0);
		ExcelReader.setRowNo(1);
		Row row = ExcelReader.GetRowData();
		String FName = row.getCell(0).toString();
		String MName = row.getCell(1).toString();
		String LName = row.getCell(2).toString();
		String Location = row.getCell(3).toString();
		String Phone = row.getCell(4).toString();
		String LinkedInURL = row.getCell(5).toString();
		String Email = row.getCell(6).toString();
		String UGrad = row.getCell(7).toString();
		String PGrad = row.getCell(8).toString();
		String TimeZone = row.getCell(9).toString();
		String UserComments = row.getCell(10).toString();
		
		objUserModule.getTxtFName().sendKeys(FName);
		//objUserModule.getTxtFName().sendKeys(MName);
		objUserModule.getTxtFName().sendKeys(LName);
		objUserModule.getTxtLocation().sendKeys(Location);
		objUserModule.getTxtPhone().sendKeys(Phone);
		//objUserModule.getTxtLinkedInURL().sendKeys(LinkedInURL);
		//objUserModule.getTxtEmail().sendKeys(Email);
		//objUserModule.getTxtUnderGrad().sendKeys(UGrad);
		//objUserModule.getTxtPostGrad().sendKeys(PGrad);
		//objUserModule.getTxtTimeZone().sendKeys(TimeZone);
		//objUserModule.getTxtUserComments().sendKeys(UserComments);
		
		Select selRS = new Select(objUserModule.getSelRoleStatus());
		selRS.selectByIndex(0);
		Select selUR = new Select(objUserModule.getSelUserRole());
		selUR.selectByIndex(0);
		Select selVS = new Select(objUserModule.getSelVisaStatus());
		selVS.selectByIndex(0);
		objUserModule.getBtnSubmit().click();
	    System.out.println("All fields except optional fields are filled in");
	    LOGGER.info("All fields except optional fields are filled in");	
	}
	
	@Then("The newly added user should be present in the data table in Manage User page")
	public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_page() 
			throws IOException {
	    List<WebElement> el = objUserModule.getUserDetailRows();
	    int i, cnt = el.size(), cntDelIconD=0, cntDelIconE=0;
	    boolean displayedFlag = false;
	    String data;
	    String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(0);
		ExcelReader.setRowNo(1);
		Row row = ExcelReader.GetRowData();
		String strPhone = row.getCell(4).toString();

	    for(i=0;i<cnt;i++) {
	    	data = el.get(i).findElement
	    			(By.xpath("//phoneNumber")).getText();
	    	if(data.equals(strPhone)) {
	    		displayedFlag = true;
	    		LOGGER.info("The newly added data is present in the data table");
	    		break;
	    	}
	    }
	    if(!displayedFlag) {
    		LOGGER.info("The newly added data not present in the data table");
	    }
	    assertTrue(displayedFlag, "The newly added data not present in the data table");
	}
	
	@When("Fill in all the fields with valid values and click submit")
	public void fill_in_all_the_fields_with_valid_values_and_click_submit() throws IOException {
		String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(0);
		ExcelReader.setRowNo(2);
		Row row = ExcelReader.GetRowData();
		String FName = row.getCell(0).toString();
		String MName = row.getCell(1).toString();
		String LName = row.getCell(2).toString();
		String Location = row.getCell(3).toString();
		String Phone = row.getCell(4).toString();
		String LinkedInURL = row.getCell(5).toString();
		String Email = row.getCell(6).toString();
		String UGrad = row.getCell(7).toString();
		String PGrad = row.getCell(8).toString();
		String TimeZone = row.getCell(9).toString();
		String UserComments = row.getCell(10).toString();
		
		objUserModule.getTxtFName().sendKeys(FName);
		objUserModule.getTxtFName().sendKeys(MName);
		objUserModule.getTxtFName().sendKeys(LName);
		objUserModule.getTxtLocation().sendKeys(Location);
		objUserModule.getTxtPhone().sendKeys(Phone);
		objUserModule.getTxtLinkedInURL().sendKeys(LinkedInURL);
		objUserModule.getTxtEmail().sendKeys(Email);
		objUserModule.getTxtUnderGrad().sendKeys(UGrad);
		objUserModule.getTxtPostGrad().sendKeys(PGrad);
		objUserModule.getTxtTimeZone().sendKeys(TimeZone);
		objUserModule.getTxtUserComments().sendKeys(UserComments);
		
		Select selRS = new Select(objUserModule.getSelRoleStatus());
		selRS.selectByIndex(0);
		Select selUR = new Select(objUserModule.getSelUserRole());
		selUR.selectByIndex(0);
		Select selVS = new Select(objUserModule.getSelVisaStatus());
		selVS.selectByIndex(0);
		objUserModule.getBtnSubmit().click();
	    System.out.println("All fields are filled in");
	    LOGGER.info("All fields are filled in");	   
	}
	
	@When("User_any of the fields have invalid values")
	public void any_of_the_fields_have_invalid_values() throws IOException {
		String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(0);
		ExcelReader.setRowNo(3);
		Row row = ExcelReader.GetRowData();
		String FName = row.getCell(0).toString();
		String MName = row.getCell(1).toString();
		String LName = row.getCell(2).toString();
		String Location = row.getCell(3).toString();
		String Phone = row.getCell(4).toString();
		String LinkedInURL = row.getCell(5).toString();
		String Email = row.getCell(6).toString();
		String UGrad = row.getCell(7).toString();
		String PGrad = row.getCell(8).toString();
		String TimeZone = row.getCell(9).toString();
		String UserComments = row.getCell(10).toString();
		
		objUserModule.getTxtFName().sendKeys(FName);
		objUserModule.getTxtFName().sendKeys(MName);
		objUserModule.getTxtFName().sendKeys(LName);
		objUserModule.getTxtLocation().sendKeys(Location);
		objUserModule.getTxtPhone().sendKeys(Phone);
		objUserModule.getTxtLinkedInURL().sendKeys(LinkedInURL);
		objUserModule.getTxtEmail().sendKeys(Email);
		objUserModule.getTxtUnderGrad().sendKeys(UGrad);
		objUserModule.getTxtPostGrad().sendKeys(PGrad);
		objUserModule.getTxtTimeZone().sendKeys(TimeZone);
		objUserModule.getTxtUserComments().sendKeys(UserComments);
		
		Select selRS = new Select(objUserModule.getSelRoleStatus());
		selRS.selectByIndex(0);
		Select selUR = new Select(objUserModule.getSelUserRole());
		selUR.selectByIndex(0);
		Select selVS = new Select(objUserModule.getSelVisaStatus());
		selVS.selectByIndex(0);
		objUserModule.getBtnSubmit().click();
	    System.out.println("one field has invalid value");
	    LOGGER.info("one field has invalid value");	
	}
	
	@Then("User_Error message should appear")
	public void error_message_should_appear() {
		boolean isDisplayed = objUserModule.getTxtError().isDisplayed();
		assertTrue(isDisplayed, "Error message should appear");
	}
	
	@When("User_Any of the mandatory fields are blank")
	public void any_of_the_mandatory_fields_are_blank() {
		objUserModule.getTxtFName().sendKeys("");
		objUserModule.getTxtFName().sendKeys("");
		objUserModule.getTxtFName().sendKeys("");
		objUserModule.getTxtLocation().sendKeys("");
		objUserModule.getTxtPhone().sendKeys("");
		objUserModule.getBtnSubmit().click();
	    System.out.println("Some mandetory fields are blank");
	    LOGGER.info("Some mandetory fields are blank");
	}

	//User3.feature

	@Given("User_The edit icon on row level in data table is enabled")
	public void the_edit_icon_on_row_level_in_data_table_is_enabled() {
		List<WebElement> el = objUserModule.getUserDetailRows();
	    boolean displayedFlag = false, enabledFlag = false;
	    displayedFlag = el.get(0).findElement(By.xpath("//edit_icon")).isDisplayed();
	    if(displayedFlag) {
	    	enabledFlag = el.get(0).findElement(By.xpath("//edit_icon")).isEnabled();	
	    }
	    assertTrue(enabledFlag, 
	    		"Please check edit icons in each row of the data table");
	    if(enabledFlag) {
	    	txtLogMessage="Edit icon for 1st record is enabled";
	    }else {
	    	txtLogMessage="Please check if edit icon for 1st record is editable";
	    }
		LOGGER.info(txtLogMessage);
	}
	
	@When("Admin clicks the EditIcon")
	public void admin_clicks_the_EditIcon() {
		List<WebElement> el = objUserModule.getUserDetailRows();
	    el.get(0).findElement(By.xpath("//edit_icon")).click();
		LOGGER.info("Admin clicks the edit Icon for 1st record"); 
	}
	
	@Given("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() {
		List<WebElement> el = objUserModule.getUserDetailRows();
	    el.get(0).findElement(By.xpath("//edit_icon")).click();
		LOGGER.info("Admin clicks the edit Icon for 1st record");
	}
	
	@When("Update the fields with valid values and click submit")
	public void update_the_fields_with_valid_values_and_click_submit() 
			throws IOException {
		String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(0);
		ExcelReader.setRowNo(0);
		Row row = ExcelReader.GetRowData();
		String MName = row.getCell(1).toString();
		String LinkedInURL = row.getCell(5).toString();
		String Email = row.getCell(6).toString();
		String UGrad = row.getCell(7).toString();
		String PGrad = row.getCell(8).toString();
		String TimeZone = row.getCell(9).toString();
		String UserComments = row.getCell(10).toString();
		objUserModule.getTxtFName().sendKeys(MName);
		objUserModule.getTxtLinkedInURL().sendKeys(LinkedInURL);
		objUserModule.getTxtEmail().sendKeys(Email);
		objUserModule.getTxtUnderGrad().sendKeys(UGrad);
		objUserModule.getTxtPostGrad().sendKeys(PGrad);
		objUserModule.getTxtTimeZone().sendKeys(TimeZone);
		objUserModule.getTxtUserComments().sendKeys(UserComments);
		
		objUserModule.getBtnSubmit().click();
	    System.out.println("Update the fields with valid values and click submit");
	    LOGGER.info("Update the fields with valid values and click submit");	
	}
	
	@Then("The updated user details should appear on the data table")
	public void the_updated_user_details_should_appear_on_the_data_table() 
			throws IOException {
		List<WebElement> el = objUserModule.getUserDetailRows();
	    int i, cnt = el.size();
	    boolean displayedFlag = false;
	    String data;
	    String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(0);
		ExcelReader.setRowNo(1);
		Row row = ExcelReader.GetRowData();
		String strMName = row.getCell(1).toString();

	    for(i=0;i<cnt;i++) {
	    	data = el.get(i).findElement
	    			(By.xpath("//Name")).getText();
	    	if(data.contains(strMName)) {
	    		displayedFlag = true;
	    		LOGGER.info("The updated data is present in the data table");
	    		break;
	    	}
	    }
	    if(!displayedFlag) {
    		LOGGER.info("The updated data not present in the data table");
	    }
	    assertTrue(displayedFlag, "The updated data not present in the data table");    
	}
	
	@When("Update the fields with invalid values and click submit")
	public void update_the_fields_with_invalid_values_and_click_submit() 
			throws IOException {
		String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(0);
		ExcelReader.setRowNo(3);
		Row row = ExcelReader.GetRowData();
		String Phone = row.getCell(4).toString();
		objUserModule.getTxtPhone().sendKeys(Phone);
		objUserModule.getBtnSubmit().click();
	    System.out.println("Update the fields with invalid values and click submit");
	    LOGGER.info("Update the fields with invalid values and click submit");	
	}
	
	@When("User_Erase data from mandatory field")
	public void erase_data_from_mandatory_field() {
		objUserModule.getTxtFName().sendKeys("");
		LOGGER.info("Erased data from mandetory field");
	}
	
//	@When("Erase data from mandatory field and click submit")
//	public void erase_data_from_mandatory_field_and_click_submit() {
//		objUserModule.getTxtFName().sendKeys("");
//	    objUserModule.getBtnSubmit().click();
//		LOGGER.info("Erased data from mandetory field and clicked submit");
//	}

//	@Then("The original user details should appear on the data table")
//	public void the_original_user_details_should_appear_on_the_data_table() {
//		
//	}

	
	//User4.feature
	@Given("User_The delete icon on row level in data table is enabled")
	public void the_delete_icon_on_row_level_in_data_table_is_enabled() {
		List<WebElement> el = objUserModule.getUserDetailRows();
	    int i, cnt = el.size(), cntEditIconD=0, cntEditIconE=0;
	    boolean enabledFlag = false;
	    for(i=0;i<cnt;i++) {
	    	enabledFlag = el.get(i).findElement
	    			(By.xpath("//delete_icon")).isEnabled();
	    	
	    	if(enabledFlag) {
	    		cntEditIconE ++;
	    	}
	    }	
		//check if enabled
		assertTrue(cntEditIconE == cnt, 
	    		"Please check if delete icons in each row of the data table are enabled");
	    if(cntEditIconD == cnt) {
	    	txtLogMessage="Each row in the data has an enabled delete icon";
	    }else {
	    	txtLogMessage="Some delete icons in rows of the data table are not enabled";
	    }
		LOGGER.info(txtLogMessage);	
	}

	@When("User_Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() {
		List<WebElement> el = objUserModule.getUserDetailRows();
	    el.get(0).findElement(By.xpath("//delete_icon")).click();
		LOGGER.info("Admin clicks the delete Icon for 1st record");	
	}

	@Then("Alert appears with yes and No option")
	public void alert_appears_with_yes_and_no_option() {
		try {
	    	driver.switchTo().alert();
		    LOGGER.info("Alert appears with yes and no option");
	    }catch(NoAlertPresentException e){
		    System.out.println("Alert doesn't appear with yes and no option");
		    LOGGER.info("Alert doesn't appear with yes and no option");
	    }
	}

	@Given("Admin clicks the DeleteIcon")
	public void admin_clicks_the_DeleteIcon() {
		List<WebElement> el = objUserModule.getUserDetailRows();
	    el.get(0).findElement(By.xpath("//delete_icon")).click();
		LOGGER.info("Admin clicks the delete Icon for 1st record");	
	}

	@When("Admin click yes option")
	public void admin_click_yes_option() {
	    objUserModule.getBtnDelYes().click();
		LOGGER.info("Admin clicks yes option for confirm delete alert");		    
	}

	@Then("User deleted alert pops and user is no more available in data table")
	public void user_deleted_alert_pops_and_user_is_no_more_available_in_data_table() 
			throws IOException {
		try {
	    	driver.switchTo().alert();
		    LOGGER.info("User deleted alert appears");
		    
		    //check if user got deleted
			List<WebElement> el = objUserModule.getUserDetailRows();
		    int i, cnt = el.size();
		    boolean displayedFlag = false;
		    String data;
		    String strFilePath  = System.getProperty("user.dir") + 
					"/src/test/resources/excelFiles/TestCaseData.xlsx";
			ExcelReader.setFilePath(strFilePath);
			ExcelReader.setSheetNo(0);
			ExcelReader.setRowNo(1);
			Row row = ExcelReader.GetRowData();
			String strPhone = row.getCell(4).toString();

		    for(i=0;i<cnt;i++) {
		    	data = el.get(i).findElement
		    			(By.xpath("//phone")).getText();
		    	if(data.equals(strPhone)) {
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

	@When("Admin click No option")
	public void admin_click_no_option() {
		objUserModule.getBtnDelNo().click();
		LOGGER.info("Admin clicks No option for confirm delete alert");
	}

	@Then("User is still listed in data table")
	public void user_is_still_listed_in_data_table() throws IOException {
		List<WebElement> el = objUserModule.getUserDetailRows();
	    int i, cnt = el.size();
	    boolean displayedFlag = false;
	    String data;
	    String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(0);
		ExcelReader.setRowNo(1);
		Row row = ExcelReader.GetRowData();
		String strPhone = row.getCell(4).toString();

	    for(i=0;i<cnt;i++) {
	    	data = el.get(i).findElement
	    			(By.xpath("//phone")).getText();
	    	if(data.equals(strPhone)) {
	    		displayedFlag = true;
	    		LOGGER.info("The user is still listed in the data table");
	    		break;
	    	}
	    }
	    if(!displayedFlag) {
    		LOGGER.info("The user deleted from the data table");
	    }
	    assertTrue(displayedFlag, "The user deleted from the data table");
	}

	@Given("None of the checkboxes in data table are selected")
	public void none_of_the_checkboxes_in_data_table_are_selected() {
	    if(objUserModule.getChkAll().isSelected()) {
	    	objUserModule.getChkAll().click();
	    }
		LOGGER.info("None of the checkboxes in data table are selected");  
	}

	@Then("The delete icon under the Manage User header should be disabled")
	public void the_delete_icon_under_the_header_should_be_disabled() {
	    boolean isEnabled = objUserModule.getBtnDelAll().isEnabled();
	    assertTrue(!isEnabled, "Delete icon under the Manage User header should be disabled");
	    if(isEnabled) {
			LOGGER.info("The delete icon under the Manage User header should be disabled");  
	    }else {
			LOGGER.info("The delete icon under the Manage User header is disabled");  	
	    }
	}


	@Given("One of the checkbox in a row is selected")
	public void one_of_the_checkbox_row_is_selected() {
		List<WebElement> el = objUserModule.getUserDetailRows();
	    if(!el.get(0).findElement(By.xpath("")).isSelected()) {
		    el.get(0).findElement(By.xpath("")).click();
	    }
		LOGGER.info("One of the checkbox in a row is selected");   
	}

	@When("Click delete icon below Manage User header")
	public void click_delete_icon_below_header() {
	    objUserModule.getBtnDelAll().click();
		LOGGER.info("Delete icon below Manage User is clicked");   
	}

	@Then("The respective row in the data table is deleted")
	public void the_respective_row_in_the_data_table_is_deleted() 
			throws IOException {
		List<WebElement> el = objUserModule.getUserDetailRows();
	    int i, cnt = el.size();
	    boolean displayedFlag = false;
	    String data;
	    String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(0);
		ExcelReader.setRowNo(3);
		Row row = ExcelReader.GetRowData();
		String strPhone = row.getCell(4).toString();

	    for(i=0;i<cnt;i++) {
	    	data = el.get(i).findElement
	    			(By.xpath("//phone")).getText();
	    	if(data.equals(strPhone)) {
	    		displayedFlag = true;
	    		LOGGER.info("The deleted data is present in the data table");
	    		break;
	    	}
	    }
	    if(!displayedFlag) {
    		LOGGER.info("The deleted data not present in the data table");
	    }
	    assertTrue(!displayedFlag, "The deleted data present in the data table");        
	}

	@Given("Two or more checkboxes in rows are selected")
	public void two_or_more_checkboxes_rows_are_selected() {
		List<WebElement> el = objUserModule.getUserDetailRows();
		if(el.size()>=1) {
			el.get(0).findElement(By.xpath("checkbox_id")).click();
		}
		if(el.size()>=2) {
			el.get(1).findElement(By.xpath("checkbox_id")).click();			
		}	
		LOGGER.info("Two or more checkboxes in rows are selected");   
	}
}