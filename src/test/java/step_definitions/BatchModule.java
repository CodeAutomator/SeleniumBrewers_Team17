package step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
//import static org.testng.Assert.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.BatchPageObj;
import utilities.ExcelReader;
import utilities.common_utils;
import webdriver_manager.DriverManager;

public class BatchModule {

	WebDriver driver = DriverManager.getDriver();
	BatchPageObj objBatchModule = BatchPageObj.getInstance();
	common_utils objCommounUtils = new common_utils();
	String txtLogMessage = "";

	public List<WebElement> columnHeaders;

	private static final Logger LOGGER = LogManager.getLogger(BatchModule.class);

	public BatchModule() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String string) throws InterruptedException {
		objBatchModule.Batchnavigationbarbutton();
		System.out.println("Admin Clicks on batch on the navigation bar");

	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String string) {
		String url = objBatchModule.getManagebatchpageURL();
		LOGGER.info("URL of current page is :" + url);
		assertEquals(url, "https://managebatch.herokuapp.com/");

	}

	@Then("Admin should see the {string} in the header")
	public void admin_should_see_the_in_the_header(String string) {
		String Title = objBatchModule.getManagebatchPageTitle();
		LOGGER.info("Title of current page is :" + Title);
		assertEquals(Title, "Manage Batch", "Title not matched");

	}

	@Then("Batch_Admin should see the pagination controls under the data table")
	public void admin_should_see_the_pagination_controls_under_the_data_table() {
		String txtFooter = objBatchModule.getTxtFooterPaginationText().getText();
		LOGGER.info("Title of footer pagination text is :" + txtFooter);
		assertTrue(txtFooter.contains("<<"), 
				"Cant see pagination control under the data table");

	}

	@Then("Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete")
	public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {

		String batchnamedatatable = objBatchModule.getbatchnametextondatatable();
		LOGGER.info("batch name on data table text is :" + batchnamedatatable);
		assertEquals(batchnamedatatable, "Batch Name", "Text not matched");

		String batchdescdatatable = objBatchModule.getbatchdesctextondatatable();
		LOGGER.info("Batch description on data table text is :" + batchdescdatatable);
		assertEquals(batchdescdatatable, "Batch Description", "Text not matched");

		String statusdatatable = objBatchModule.getstatustextondatatable();
		LOGGER.info("Batch status on data table text is :" + statusdatatable);
		assertEquals(statusdatatable, "Status", "Text not matched");

		String programnamedatatable = objBatchModule.getprogramnametextondatatable();
		LOGGER.info("program name on data table text is :" + programnamedatatable);
		assertEquals(programnamedatatable, "Program Name", "Text not matched");

		String noofclasses = objBatchModule.getnoofclasses();
		LOGGER.info("No of classes on data table text is :" + noofclasses);
		assertEquals(noofclasses, "No of classes", "Text not matched");

		String editdatatable = objBatchModule.getedittextondatatable();
		LOGGER.info("save on data table text is :" + editdatatable);
		assertEquals(editdatatable, "Edit", "Text not matched");

		String deletedatatable = objBatchModule.getdeletetextondatatable();
		LOGGER.info("cancel on data table text is :" + deletedatatable);
		assertEquals(deletedatatable, "Delete", "Text not matched");

	}

	@Then("Admin should be able to see the {string} icon button that is disabled")
	public void admin_should_be_able_to_see_the_icon_button_that_is_disabled(String string) throws InterruptedException {
		objBatchModule.Deletetopbutton();
		assert(objBatchModule.isbuttondisabled());

	}

	@Then("Admin should be able to see the {string} button")
	public void admin_should_be_able_to_see_the_button(String string) {
		String anewbatch = objBatchModule.getaddbatchtext();
		LOGGER.info("add new program button text is :" + anewbatch);
		assertEquals(anewbatch, "+A New Program", "Text not matched");


	}

	@Then("Each row in the data table should have a checkbox,edit icon is enabled,delete icon is enabled")
	public void each_row_in_the_data_table_should_have_a_checkbox_edit_icon_is_enabled_delete_icon_is_enabled() {


		// Get the number of rows in the data table
		int rowCount = objBatchModule.getRowCount();

		// Loop through each row and perform actions
		for (int i = 0; i < rowCount; i++) {
			// Check if the checkbox is enabled for the current row
			WebElement checkbox = objBatchModule.getCheckboxForRow(i);
			if (checkbox.isEnabled()) {
				checkbox.click();
			}

			// Check if the edit icon is enabled for the current row
			WebElement editIcon = objBatchModule.getEditIconForRow(i);
			if (editIcon.isEnabled()) {
				editIcon.click();
			}

			// Check if the delete icon is enabled for the current row
			WebElement deleteIcon = objBatchModule.getDeleteIconForRow(i);
			if (deleteIcon.isEnabled()) {
				deleteIcon.click();
			}
		}
	}

	@When("Admin clicks {string} button")
	public void admin_clicks_button(String string) throws InterruptedException {

		objBatchModule.Addnewbatchbutton();
		System.out.println("Admin Clicks on add new batch button");
	}

	@Then("A new pop up with Batch details appears")
	public void a_new_pop_up_with_batch_details_appears() {
		boolean isPopupVisible = objBatchModule.getbatchDetailsPopup().isDisplayed();
		Assert.assertFalse("Batch Details popup should disappear", isPopupVisible);

	}

	/// Feature ADD Batch Module
	@Then("The pop up should include the fields Name, Numberofclasses and Description as textbox,status as radio button,programname")
	public void the_pop_up_should_include_the_fields_name_numberofclasses_and_description_as_textbox_status_as_radio_button_programname() {
		boolean flag = false;
		flag = objBatchModule.getTxtName().isDisplayed();
		assertTrue(flag, "Name not visible");
		flag = objBatchModule.getTxtDescrption().isDisplayed();
		assertTrue(flag, "Description not visible");
		flag = objBatchModule.getSelProgName().isDisplayed();
		assertTrue(flag, "Program Name not visible");	
		flag = objBatchModule.getActiveSelRoleStatus().isDisplayed();
		assertTrue(flag, "ACTIVE status not visible");
		flag = objBatchModule.getinActiveSelRoleStatus().isDisplayed();
		assertTrue(flag, "INACTIVE status not visible");
		flag = objBatchModule.getTxtNumberofClass().isDisplayed();
		assertTrue(flag, "Number of Class not visible");
	}


	@When("Fill in all the fields except description with valid values")
	public void fill_in_all_the_fields_except_description_with_valid_values() throws IOException {

		String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(1);
		ExcelReader.setRowNo(1);
		Row row = ExcelReader.GetRowData();
		String nameInput = row.getCell(0).toString();
		//String pgrmDescriptionInput = row.getCell(1).toString();
		String noOfClass = row.getCell(2).toString();

		objBatchModule.getTxtName().sendKeys(nameInput);
		//objBatchModule.getTxtDescrption().sendKeys(pgrmDescriptionInput);
		objBatchModule.getTxtNumberofClass().sendKeys(noOfClass);

		Select selProgramName = new Select(objBatchModule.getSelProgName());
		selProgramName.selectByIndex(0);
		Select selActive = new Select(objBatchModule.getActiveSelRoleStatus());
		selActive.selectByIndex(0);
		Select selinActive = new Select(objBatchModule.getinActiveSelRoleStatus());
		selinActive.selectByIndex(0);

	}

	@When("click save")
	public void click_save() {
		objBatchModule.getSaveButton().click();
		System.out.println("All fields except Descrption fields are filled in");
		LOGGER.info("All fields except optional fields are filled in");	

	}

	@Then("The newly added batch should be present in the data table in Manage Batch page")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page() throws IOException {
		List<WebElement> el = objBatchModule.getBatchDetailRows();
		@SuppressWarnings("unused")
		int i, cnt = el.size(), cntDelIconD=0, cntDelIconE=0;
		boolean displayedFlag = false;
		String data;
		String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(1);
		ExcelReader.setRowNo(1);
		Row row = ExcelReader.GetRowData();
		String strProgramName = row.getCell(1).toString();

		for(i=0;i<cnt;i++) {
			data = el.get(i).findElement
					(By.xpath("//ProgramName")).getText();
			if(data.equals(strProgramName)) {
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

	@When("Fill in all the fields with valid values")
	public void fill_in_all_the_fields_with_valid_values() throws IOException {
		String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(1);
		ExcelReader.setRowNo(3);
		Row row = ExcelReader.GetRowData();
		String nameInput = row.getCell(0).toString();
		//String pgrmDescriptionInput = row.getCell(1).toString();
		String noOfClass = row.getCell(3).toString();

		objBatchModule.getTxtName().sendKeys(nameInput);
		//objBatchModule.getTxtDescrption().sendKeys(pgrmDescriptionInput);
		objBatchModule.getTxtNumberofClass().sendKeys(noOfClass);

		Select selProgramName = new Select(objBatchModule.getSelProgName());
		selProgramName.selectByIndex(0);
		Select selActive = new Select(objBatchModule.getActiveSelRoleStatus());
		selActive.selectByIndex(0);
		Select selinActive = new Select(objBatchModule.getinActiveSelRoleStatus());
		selinActive.selectByIndex(0);
		objBatchModule.getSaveButton().click();
		System.out.println("All fields except Descrption fields are filled in");
		LOGGER.info("All fields except optional fields are filled in");	

	}

	@When("Batch_any of the fields have invalid values")
	public void any_of_the_fields_have_invalid_values() throws IOException {

		String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(1);
		ExcelReader.setRowNo(3);
		Row row = ExcelReader.GetRowData();
		String nameInput = row.getCell(0).toString();
		//String pgrmDescriptionInput = row.getCell(1).toString();
		String noOfClass = row.getCell(5).toString();

		objBatchModule.getTxtName().sendKeys(nameInput);
		//objBatchModule.getTxtDescrption().sendKeys(pgrmDescriptionInput);
		objBatchModule.getTxtNumberofClass().sendKeys(noOfClass);

		Select selProgramName = new Select(objBatchModule.getSelProgName());
		selProgramName.selectByIndex(0);
		Select selActive = new Select(objBatchModule.getActiveSelRoleStatus());
		selActive.selectByIndex(0);
		Select selinActive = new Select(objBatchModule.getinActiveSelRoleStatus());
		selinActive.selectByIndex(0);
		objBatchModule.getSaveButton().click();
		System.out.println("one field has invalid value");
		LOGGER.info("one field has invalid value");	
	}

	@Then("Batch_Error message should appear")
	public void error_message_should_appear() {

		boolean isDisplayed = objBatchModule.getTxtError().isDisplayed();
		assertTrue(isDisplayed, "Error message should appear");
	}

	@When("Batch_Any of the mandatory fields are blank")
	public void any_of_the_mandatory_fields_are_blank() {
		objBatchModule.getTxtName().sendKeys("");
		objBatchModule.getTxtNumberofClass().sendKeys("");
		System.out.println("Some mandetory fields are blank");
		LOGGER.info("Some mandetory fields are blank");
	}

	@Given("Batch_The delete icon on row level in data table is enabled")
	public void the_delete_icon_on_row_level_in_data_table_is_enabled() {

		List<WebElement> el = objBatchModule.getBatchDetailRows();
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

	@When("Batch_Admin clicks on the delete icon")
	public void admin_clicks_on_the_delete_icon()  {
		List<WebElement> el = objBatchModule.getBatchDetailRows();
		el.get(0).findElement(By.xpath("//delete_icon")).click();
		LOGGER.info("Admin clicks the delete Icon for 1st record");

	}

	@Then("Batch_Alert appears with yes and No option")
	public void alert_appears_with_yes_and_no_option() {
		try {
			driver.switchTo().alert();
			LOGGER.info("Alert appears with yes and no option");
		}catch(NoAlertPresentException e){
			System.out.println("Alert doesn't appear with yes and no option");
			LOGGER.info("Alert doesn't appear with yes and no option");
		}

	}

	@Given("Batch_Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() {

		List<WebElement> el = objBatchModule.getBatchDetailRows();
		el.get(0).findElement(By.xpath("//delete_icon")).click();
		LOGGER.info("Admin clicks the delete Icon for 1st record");	
	}

	@When("You click yes option")
	public void you_click_yes_option() {

		objBatchModule.getBtnDelYes().click();
		LOGGER.info("Admin clicks yes option for confirm delete alert");
	}

	@Then("Batch deleted alert pops and batch is no more available in data table")
	public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table() throws IOException {
		try {
			driver.switchTo().alert();
			LOGGER.info("User deleted alert appears");

			//check if user got deleted
			List<WebElement> el = objBatchModule.getBatchDetailRows();
			int i, cnt = el.size();
			boolean displayedFlag = false;
			String data;
			String strFilePath  = System.getProperty("user.dir") + 
					"/src/test/resources/excelFiles/TestCaseData.xlsx";
			ExcelReader.setFilePath(strFilePath);
			ExcelReader.setSheetNo(1);
			ExcelReader.setRowNo(1);
			Row row = ExcelReader.GetRowData();
			String strProgramName = row.getCell(0).toString();

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

	@When("You click no option")
	public void you_click_no_option() {
		objBatchModule.getBtnDelNo().click();
		LOGGER.info("Admin clicks NO option for confirm delete alert");

	}

	@Then("Batch is still listed in data table")
	public void batch_is_still_listed_in_data_table() throws IOException {

		List<WebElement> el = objBatchModule.getBatchDetailRows();
		int i, cnt = el.size();
		boolean displayedFlag = false;
		String data;
		String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(1);
		ExcelReader.setRowNo(1);
		Row row = ExcelReader.GetRowData();
		String strProgramName = row.getCell(4).toString();

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

	@Given("Batch_None of the checkboxes in data table are selected")
	public void none_of_the_checkboxes_in_data_table_are_selected() {

		if(objBatchModule.getChkAll().isSelected()) {
			objBatchModule.getChkAll().click();
		}
		LOGGER.info("None of the checkboxes in data table are selected"); 
	}

	@Then("The delete icon under the Manage Batch header should be disabled")
	public void the_delete_icon_under_the_manage_batch_header_should_be_disabled() {
		boolean isEnabled = objBatchModule.getBtnDelAll().isEnabled();
		assertTrue(!isEnabled, "Delete icon under the Manage Batch header should be disabled");
		if(isEnabled) {
			LOGGER.info("The delete icon under the Manage Batch header should be disabled");  
		}else {
			LOGGER.info("The delete icon under the Manage Batch header is disabled");  	
		}
	}

	@Given("One of the checkbox row is selected")
	public void one_of_the_checkbox_row_is_selected() {
		List<WebElement> el = objBatchModule.getBatchDetailRows();
		if(!el.get(0).findElement(By.xpath("")).isSelected()) {
			el.get(0).findElement(By.xpath("")).click();
		}
		LOGGER.info("One of the checkbox in a row is selected");
	}
	

	@When("Click delete icon below Manage Batch header")
	public void click_delete_icon_below_manage_batch_header() {
		objBatchModule.getBtnDelAll().click();
		LOGGER.info("Delete icon below Manage User is clicked");   
	}

	@Then("Batch_The respective row in the data table is deleted")
	public void the_respective_row_in_the_data_table_is_deleted() throws IOException {
		List<WebElement> el = objBatchModule.getBatchDetailRows();
		int i, cnt = el.size();
		boolean displayedFlag = false;
		String data;
		String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(1);
		ExcelReader.setRowNo(1);
		Row row = ExcelReader.GetRowData();
		String strProgramName = row.getCell(4).toString();

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
	}

	@Given("Two or more checkboxes\\/row is selected")
	public void two_or_more_checkboxes_row_is_selected() {
		List<WebElement> el = objBatchModule.getBatchDetailRows();
		if(el.size()>=1) {
			el.get(0).findElement(By.xpath("checkbox_id")).click();
		}
		if(el.size()>=2) {
			el.get(1).findElement(By.xpath("checkbox_id")).click();			
		}	
		LOGGER.info("Two or more checkboxes in rows are selected");   
	}

// Feature EDIT Batch Module
	@Given("Batch_The edit icon on row level in data table is enabled")
	public void the_edit_icon_on_row_level_in_data_table_is_enabled() {
		List<WebElement> el = objBatchModule.getBatchDetailRows();
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

	@When("Admin clicks the edit icon to validate row level edit icon")
	public void admin_clicks_the_edit_icon_to_validate_row_level_edit_icon() {
		List<WebElement> el = objBatchModule.getBatchDetailRows();
	    el.get(0).findElement(By.xpath("//edit_icon")).click();
		LOGGER.info("Admin clicks the edit Icon for 1st record"); 
	}

	@Given("Batch_Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() {
		List<WebElement> el = objBatchModule.getBatchDetailRows();
	    el.get(0).findElement(By.xpath("//edit_icon")).click();
		LOGGER.info("Admin clicks the edit Icon for 1st record");
	}

	@When("Update the fields with valid values")
	public void update_the_fields_with_valid_values() throws IOException {
		String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(1);
		ExcelReader.setRowNo(4); 
		Row row = ExcelReader.GetRowData();
		String nameInput = row.getCell(0).toString();
		//String pgrmDescriptionInput = row.getCell(1).toString();
		String noOfClass = row.getCell(3).toString();

		objBatchModule.getTxtName().sendKeys(nameInput);
		//objBatchModule.getTxtDescrption().sendKeys(pgrmDescriptionInput);
		objBatchModule.getTxtNumberofClass().sendKeys(noOfClass);

		Select selProgramName = new Select(objBatchModule.getSelProgName());
		selProgramName.selectByIndex(0);
		Select selActive = new Select(objBatchModule.getActiveSelRoleStatus());
		selActive.selectByIndex(0);
		Select selinActive = new Select(objBatchModule.getinActiveSelRoleStatus());
		selinActive.selectByIndex(0);
		objBatchModule.getSaveButton().click();
		System.out.println("All fields except Descrption fields are filled in");
		LOGGER.info("All fields except optional fields are filled in");	
	}

	@Then("The updated batch details should appear on the data table")
	public void the_updated_batch_details_should_appear_on_the_data_table() throws IOException {
		List<WebElement> el = objBatchModule.getBatchDetailRows();
	    int i, cnt = el.size();
	    boolean displayedFlag = false;
	    String data;
	    String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(1);
		ExcelReader.setRowNo(4);
		Row row = ExcelReader.GetRowData();
		String strProgramName = row.getCell(1).toString();

	    for(i=0;i<cnt;i++) {
	    	data = el.get(i).findElement
	    			(By.xpath("//ProgramName")).getText();
	    	if(data.contains(strProgramName)) {
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

	@When("Update the fields with invalid values")
	public void update_the_fields_with_invalid_values() throws IOException {
		String strFilePath  = System.getProperty("user.dir") + 
				"/src/test/resources/excelFiles/TestCaseData.xlsx";
		ExcelReader.setFilePath(strFilePath);
		ExcelReader.setSheetNo(1); 
		ExcelReader.setRowNo(3);
		Row row = ExcelReader.GetRowData();		
		String Name = row.getCell(1).toString();
		objBatchModule.getTxtName().sendKeys(Name);
	    System.out.println("Update the fields with invalid values and click submit");
	    LOGGER.info("Update the fields with invalid values and click submit");	
	}

	@When("Batch_Erase data from mandatory field")
	public void erase_data_from_mandatory_field() {
		objBatchModule.getTxtName().sendKeys("");
		LOGGER.info("Erased data from mandetory field");
	}

	@When("Erase data from description field")
	public void erase_data_from_description_field() {
		objBatchModule.getTxtDescrption().sendKeys("");
		LOGGER.info("Erased data from description field ");
	}

}
