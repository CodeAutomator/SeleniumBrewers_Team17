package page_objects;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;

import org.openqa.selenium.WebDriver;
import webdriver_manager.DriverManager;

public class ManageProgramPageObj {

	private static ManageProgramPageObj loginPageInstance;

	// Dummy private constructor prevents the object creation
	public ManageProgramPageObj() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public static ManageProgramPageObj getInstance() {
		if (loginPageInstance == null) {
			loginPageInstance = new ManageProgramPageObj();
		}

		return loginPageInstance;

	}


	@FindBy(linkText = ("Program"))WebElement Programnavigationbar; 	// Admin clicks "Program" on the navigation bar
	@FindBy(xpath = "//a[normalize-space()='In total there are z programs']") WebElement footerpaginationtext; // manage program page footer pagination text
	@FindBy(xpath = "//button[@type='deletetop']") WebElement deletetop; //top left delete icon button on manage program page

	//+A new program button on manage program page
	@FindBy(xpath = "//button[@type='+A New Program']") WebElement newprogrambutton; 
	@FindBy(xpath = "//a[normalize-space()='Program Name']") WebElement programnamedatatable; // text of program name on data table
	@FindBy(xpath = "//a[normalize-space()='Program Description']") WebElement programdescriptiondatatable; //text of program Description on data table
	@FindBy(xpath = "//a[normalize-space()='Program Status']") WebElement programstatusdatatable; 	//text of program status on data table
	@FindBy(xpath = "//a[normalize-space()='Edit']") WebElement editdatatable; //text of edit on data table
	@FindBy(xpath = "//a[normalize-space()='Delete']") WebElement deletedatatable; // Locator for all column headers
	@FindBy(xpath = "//th[@class='sortable']") By columnHeaderLocator;
	@FindBy(xpath = "//th[contains(text(),'Edit') or contains(text(),'Delete')]']") By excludeColumnsLocator; // Locator for "Edit" and "Delete" column headers
	@FindBy(xpath = "//input[@id='search']") WebElement searchbar; 	//search bar
	@FindBy(xpath = "//table[@id='data-table']//tr") List<WebElement> allRows;	// All rows check boxes in data table
	// Find all the rows with edit and delete
	@FindAll({
		@FindBy(xpath = "//table[@id='data-table']//tr"),
		@FindBy(xpath = "//table[@id='data-table']//tr/td[contains(button/text(),'Edit') and contains(button/text(),'Delete')]")
	}) List<WebElement> rowsWithEditDeleteButtons;

	
	@FindBy(id = "search-bar") WebElement searchBar; // Search Bar with Search..
	@FindBy(id = "search-magnify-button") WebElement searchMagnifyButton; //search Magnify Button
	@FindBy(id = "search-results") WebElement searchResults; //search Results
	@FindBy(id = "data-table") WebElement dataTable; 	//datatable of manage program page

	//Feature Add Program -1
	
	@FindBy(id = "program-details-popup") WebElement programDetailsPopup; //Program detail popup window
	@FindBy(id = "program-details-form") WebElement programDetailsForm; //popup window form
	@FindBy(id = "save-button") WebElement saveButton; //Save button popup window
	@FindBy(id = "cancel-button") WebElement cancelButton; //cancel button popup window
	@FindBy(id = "close-icon")  WebElement closeIcon; 	//close icon button popup window
	@FindBy(id = "program-name-input") WebElement programNameInput; //program name input field
	@FindBy(id = "program-description-input") WebElement programDescriptionInput; //program description input field
	@FindBy(id = "radio-active") WebElement radioActive; //radio button for program status active
	@FindBy(id = "radio-inactive") WebElement radioInactive; //radio button for program status inactive
	// Feature ADD 2
	@FindBy(id = "error-message") WebElement errorMessage; //validation Error message
	@FindBy(id = "status-radio") WebElement statusRadio; //program Status
	@FindBy(id = "success-message") WebElement successMessage; //Successful Program Created 
	// Feature Edit Single Scenario
	//data table
	@FindBy(id = "data-table") WebElement editdataTable;
	//edit button on data table
	@FindBy(xpath = "//button[text()='Edit']") List<WebElement> editButtons;
	@FindBy(id = "program-details-popup") WebElement editprogramDetailsPopup;
	@FindBy(id = "program-name-input") WebElement editprogramNameInput;	//program name input field
	@FindBy(id = "program-description-input") WebElement editprogramDescriptionInput; 	//program description input field
	@FindBy(id = "error-message") WebElement editerrorMessage; //validation Error message
	@FindBy(id = "success-message") WebElement editsuccessMessage;//Successful Program Created 
	@FindBy(id = "save-button") WebElement editSaveButton; 	//Save button popup window
	@FindBy(id = "statusRadioInactive") WebElement editstatusRadioInactive; 	//Save button statusRadioInactive window
	@FindBy(id = "statusRadioActive") WebElement editstatusRadioActive; 	//Save button statusRadioActive window
	@FindBy(id = "cancel-button") WebElement editcancelButton;	//cancel button popup window 
	//Sorting 
	@FindBy(id = "program-table") WebElement programTable; //manage program data table
	@FindBy(xpath = "//th[@data-field='programName']") WebElement programNameHeader; // Program name header column
	@FindBy(xpath = "//th[@data-field='programDesc']") WebElement programDescHeader; // Program Desc header column
	@FindBy(xpath = "//th[@data-field='programStatus']") WebElement programStatusHeader; // Program Desc header column

	// Admin clicks on the navigation bar
	@FindBy(linkText = ("Student"))WebElement lnkStudentNavigationBar;
	@FindBy(linkText = ("Class"))WebElement lnkClassNavigationBar; 
	@FindBy(linkText = ("Batch"))WebElement lnkBatchNavigationBar;
	@FindBy(linkText = ("User"))WebElement lnkUserNavigationBar;
	@FindBy(linkText = ("Assignment"))WebElement lnkAssignmentNavigationBar;
	@FindBy(linkText = ("Attendance"))WebElement lnkAttendanceNavigationBar;
	@FindBy(linkText = ("Lgout"))WebElement lnkLogoutNavigationBar;
	@FindBy(id = "btnDelYes")WebElement btnDelYes;
	@FindBy(id = "btnDelNo")WebElement btnDelNo;
	@FindBy(id = "idDeleteAll")WebElement btnDelAll; //Delete ALL
	//Delete popup window
	@FindBy(id = "alert-delete-popup") WebElement alertDeletePopup; //
	@FindBy(xpath = "//table/rows")List<WebElement> pgmDetailRows;
	//Feature -- Delete
	// Delete button on the webpage
	@FindBy(xpath = "//table[@id='studentTable']/tbody/tr[1]/td[4]/button") WebElement deleteButton;

	@FindBy(id = "table") WebElement table;
	@FindBy(id = "pagination") WebElement pagination;
	@FindBy(id = "entries-info") WebElement entriesInfo;
// Pagination 
	 @FindBy(id = "programTable") WebElement pageprogramTable; // data table on program page
	 @FindBy(id = "nextPageLink") WebElement nextPageLink; // pagination next page link
	 @FindBy(id = "lastPageLink") WebElement lastPageLink; // pagination last page link
	 @FindBy(id = "previousPageLink") WebElement previousPageLink;// previous page link
	 @FindBy(id = "firstPageLink") WebElement firstPageLink; //first page link
	 @FindBy(id = "start-page-link") WebElement startPageLink; //start page link


	public WebElement getLnkProgramNavigationBar() {
		return Programnavigationbar;
	}

	public void setLnkProgramNavigationBar(WebElement lnkProgramNavigationBar) {
		this.Programnavigationbar = lnkProgramNavigationBar;
	}

	public void navigateToManageprogramPage() throws InterruptedException {
		//DriverManager.getDriver().get(Constants.ManageprogrampageURL);
		Thread.sleep(1000);

	}


	public void Programnavigationbarbutton() throws InterruptedException {
		Thread.sleep(1000);
		Programnavigationbar.click();
		Thread.sleep(1000);
	}

	// The Admin directed to manage program page
	public String getManageprogrampageURL() {
		String url = DriverManager.getDriver().getCurrentUrl();
		return url;
	}

	// get title of  manage program page
	public String getManageprogramPageTitle() {
		String title = DriverManager.getDriver().getTitle();
		return title;
	}

	// to get footer text for pagination
	public String getfootertext() {

		return footerpaginationtext.getText();
	}

	//deletetop button on manage program page
	public void Deletetopbutton() throws InterruptedException {
		Thread.sleep(1000);
		deletetop.click();
		Thread.sleep(1000);
	}	

	public boolean isbuttondisabled()
	{
		return !deletetop.isEnabled();

	}

	//a new program button on manage program page
	public void newprogrambutton() throws InterruptedException {
		Thread.sleep(1000);
		newprogrambutton.click();
		Thread.sleep(1000);
	}

	// to get add new program text on manage program page
	public String getaddprogramtext() {

		return newprogrambutton.getText();
	}
	// to get program name text on manage program page data table
	public String getprogramnametextondatatable() {

		return programnamedatatable.getText();
	}
	// to get program description text on manage program page data table
	public String getprogramdesctextondatatable() {

		return programdescriptiondatatable.getText();
	}

	// to get program status text on manage program page data table
	public String getprogramstatustextondatatable() {

		return programstatusdatatable.getText();
	}

	// to get edit text on manage program page data table
	public String getedittextondatatable() {

		return editdatatable.getText();
	}

	// to get delete text on manage program page data table
	public String getdeletetextondatatable() {

		return deletedatatable.getText();
	}

	//Sort by Header on the Program Module - Method to get all column header elements
	public List<WebElement> getColumnHeaders() {
		return DriverManager.getDriver().findElements(columnHeaderLocator);
	}
	// Method to check if a column header has a sort arrow icon
	public boolean hasSortArrowIcon(WebElement columnHeader) {
		By sortArrowIconLocator = By.cssSelector("i.sort-arrow-icon");
		return columnHeader.findElement(sortArrowIconLocator).isDisplayed();
	}

	// Method to check if a column header should be excluded from the check
	public boolean isExcludedColumn(WebElement columnHeader) {
		return columnHeader.findElements(excludeColumnsLocator).size() > 0;
	}

	public boolean isCheckboxPresentInRow(WebElement row) {
		// Modify this locator to match the structure of your checkboxes
		return row.findElement(By.xpath(".//td/input[@type='checkbox']")).isDisplayed();
	}

	public List<WebElement> getAllRows() {
		return allRows;
	}

	public List<WebElement> getRowsWithEditDeleteButtons() {
		return rowsWithEditDeleteButtons;
	}
	// to get searchbar
	public WebElement getSearchBar() {
		return searchBar;
	}

	// Manageprogramvalidation2.feature
	public WebElement getSearchMagnifyButton() {
		return searchMagnifyButton;
	}

	public void enterSearchPhrase(String phrase) {
		searchBar.sendKeys(phrase);
	}

	public void clickSearchMagnifyButton() {
		searchMagnifyButton.click();
	}

	public boolean areSearchResultsVisible() {
		return searchResults.isDisplayed();
	}

	public String getSearchResultsText() {
		return searchResults.getText();
	}

	public boolean isDataTableEmpty() {
		// Check if the data table has zero entries
		return dataTable.findElements(By.tagName("tr")).size() == 0;
	}

	// Feature 3 ADD
	public void navigateToAddprogramPage() throws InterruptedException {
		DriverManager.getDriver().get(Constants.AddprogrampageURL);
		Thread.sleep(1000);

	}

	public void Addnewprogrambutton() throws InterruptedException {
		Thread.sleep(1000);
		newprogrambutton.click();
		Thread.sleep(1000);
	}

	public boolean isProgramDetailsPopupVisible() {
		return programDetailsPopup.isDisplayed();
	}

	public boolean isSaveButtonVisible() {
		return saveButton.isDisplayed();
	}

	public boolean isCancelButtonVisible() {
		return cancelButton.isDisplayed();
	}

	public boolean isCloseIconVisible() {
		return closeIcon.isDisplayed();
	}

	public boolean isProgramDetailsFormEmpty() {
		// check if the form is empty
		return programDetailsForm.getText().isEmpty();
	}

	public boolean isProgramDetailsFieldEmpty() {
		// Check if both input fields are empty
		return programNameInput.getText().isEmpty() && programDescriptionInput.getText().isEmpty();
	}

	public WebElement getRadioActive() {
		return radioActive;
	}

	public WebElement getRadioInactive() {
		return radioInactive;
	}

	public boolean isRadioActiveVisible() {
		return radioActive.isDisplayed();
	}

	public boolean isRadioInactiveVisible() {
		return radioInactive.isDisplayed();
	}

	public void savebuttonpopup() throws InterruptedException {
		Thread.sleep(1000);
		saveButton.click();
		Thread.sleep(1000);
	}

	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public void programnameinput() throws InterruptedException {
		programNameInput.sendKeys("Jan23-Seleniumbrewer-SDET-201-1001");
		Thread.sleep(1000);
	}

	public WebElement getProgramNameInput() {
		return programNameInput;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public void enterProgramName(String programName) {
		programNameInput.sendKeys(programName);
	}

	public void clickStatusRadio() {
		statusRadio.click();
	}

	public void clickSaveButton() {

		saveButton.click();
	}	

	public void clickcancelButton() {
		cancelButton.click();
	}	
	public WebElement getProgramDescriptionInput() {
		return programDescriptionInput;
	}

	public void enterProgramDescription(String programName) {
		programDescriptionInput.sendKeys(programName);
	}

	public WebElement getprogramDetailsPopup() {
		return programDetailsPopup;
	}

	public WebElement getCloseIcon() {
		return closeIcon;
	}

	public void clickCloseIcon() {
		closeIcon.click();
	}

	public WebElement getSuccessMessage() {
		return successMessage;
	}

	public WebElement getDataTable() {
		return dataTable;
	}
	// Feature EDIT


	public WebElement editgetDataTable() {
		return editdataTable;
	}

	public List<WebElement> getEditButtons() {
		return editButtons;
	}

	public WebElement editgetProgramDetailsPopup() {
		return editprogramDetailsPopup;
	}

	public void editProgramName(String programName) {
		editprogramNameInput.clear();
		editprogramNameInput.sendKeys(programName);
	}

	public WebElement editgetprogramDescriptionInput() {
		return editprogramNameInput;
	}

	public void editprogramDescription(String programDescription) {
		editprogramDescriptionInput.clear();
		editprogramDescriptionInput.sendKeys(programDescription);
	}

	public WebElement editgetprogramDescription() {
		return editprogramDescriptionInput;
	}
	public String editgetSuccessMessage() {
		return editsuccessMessage.getText();
	}

	public void editselectInactiveStatus() {
		editstatusRadioInactive.click();
	}

	public void editselectActiveStatus() {
		editstatusRadioActive.click();
	}

	public void editclickSaveButton() {
		editSaveButton.click();
	}	

	public void editclickcancelButton() {
		// TODO Auto-generated method stub
		editcancelButton.click();
	}	

	public WebElement editgetprogramDetailsPopup() {
		return editprogramDetailsPopup;
	}

	public void editenterProgramName(String programName) {
		editprogramNameInput.sendKeys(programName);
	}
	public void editenterProgramDescription(String programName) {
		editprogramDescriptionInput.sendKeys(programName);
	}

	public void editclickStatusRadio() {
		editstatusRadioActive.click();
	}

	public WebElement editgetErrorMessage() {
		return editerrorMessage;
	}

	public void clickDeleteButtonForRow(int rowIndex) {
		// Find the delete button for the specified row and click it
		WebElement deleteButtonForRow = DriverManager.getDriver().findElement(By.xpath("//table[@id='studentTable']/tbody/tr[" + rowIndex + "]/td[4]/button"));
		deleteButtonForRow.click();
	}

	//Sorting
	public void clickProgramNameHeader() {
		programNameHeader.click();
	}

	public void clickProgramDescHeader() {
		programDescHeader.click();
	}

	public void clickProgramStatusHeader() {
		programStatusHeader.click();
	}


	//program name sort
	public boolean isProgramNameColumnSortedAscending() {
		// Assuming program names are listed in ascending order
		return programTable.findElements(By.xpath("//tr/td[1]")).stream()
				.map(WebElement::getText)
				.collect(Collectors.toList())
				.equals(
						programTable.findElements(By.xpath("//tr/td[1]")).stream()
						.map(WebElement::getText)
						.sorted()
						.collect(Collectors.toList())
						);
	}



	public boolean isProgramNameColumnSortedDescending() {
		// Assuming program names are listed in descending order
		return programTable.findElements(By.xpath("//tr/td[1]")).stream()
				.map(WebElement::getText)
				.collect(Collectors.toList())
				.equals(
						programTable.findElements(By.xpath("//tr/td[1]")).stream()
						.map(WebElement::getText)
						.sorted(Collections.reverseOrder())
						.collect(Collectors.toList())
						);
	}

	//program description sort
	public boolean isProgramDescColumnSortedAscending() {
		// Assuming program names are listed in ascending order
		return programTable.findElements(By.xpath("//tr/td[1]")).stream()
				.map(WebElement::getText)
				.collect(Collectors.toList())
				.equals(
						programTable.findElements(By.xpath("//tr/td[1]")).stream()
						.map(WebElement::getText)
						.sorted()
						.collect(Collectors.toList())
						);
	}


	public boolean isProgramDescColumnSortedDescending() {
		// Assuming program desc are listed in descending order
		return programTable.findElements(By.xpath("//tr/td[1]")).stream()
				.map(WebElement::getText)
				.collect(Collectors.toList())
				.equals(
						programTable.findElements(By.xpath("//tr/td[1]")).stream()
						.map(WebElement::getText)
						.sorted(Collections.reverseOrder())
						.collect(Collectors.toList())
						);
	}


	//program status sort
	public boolean isProgramStatusColumnSortedAscending() {
		// Assuming program status are listed in ascending order
		return programTable.findElements(By.xpath("//tr/td[1]")).stream()
				.map(WebElement::getText)
				.collect(Collectors.toList())
				.equals(
						programTable.findElements(By.xpath("//tr/td[1]")).stream()
						.map(WebElement::getText)
						.sorted()
						.collect(Collectors.toList())
						);
	}

	public boolean isProgramStatusColumnSortedDescending() {
		// Assuming program status are listed in descending order
		return programTable.findElements(By.xpath("//tr/td[1]")).stream()
				.map(WebElement::getText)
				.collect(Collectors.toList())
				.equals(
						programTable.findElements(By.xpath("//tr/td[1]")).stream()
						.map(WebElement::getText)
						.sorted(Collections.reverseOrder())
						.collect(Collectors.toList())
						);
	}
	public WebElement getLnkStudentNavigationBar() {

		return lnkStudentNavigationBar;
	}

	public void setLnkStudentNavigationBar(WebElement lnkStudentNavigationBar) {
		this.lnkStudentNavigationBar = lnkStudentNavigationBar;
	}

	public WebElement getLnkClassNavigationBar() {
		return lnkClassNavigationBar;
	}

	public void setLnkClassNavigationBar(WebElement lnkClassNavigationBar) {
		this.lnkClassNavigationBar = lnkClassNavigationBar;
	}

	public WebElement getLnkBatchNavigationBar() {
		return lnkBatchNavigationBar;
	}

	public void setLnkBatchNavigationBar(WebElement lnkClassNavigationBar) {
		this.lnkClassNavigationBar = lnkBatchNavigationBar;
	}

	public WebElement getLnkUserNavigationBar() {
		return lnkUserNavigationBar;
	}

	public void setLnkUserNavigationBar(WebElement lnkUserNavigationBar) {
		this.lnkUserNavigationBar = lnkUserNavigationBar;
	}

	public WebElement getLnkAssignmentNavigationBar() {
		return lnkAssignmentNavigationBar;
	}

	public void setLnkAssignmentNavigationBar(WebElement lnkAssignmentNavigationBar) {
		this.lnkAssignmentNavigationBar = lnkAssignmentNavigationBar;
	}

	public WebElement getLnkAttendanceNavigationBar() {
		return lnkAttendanceNavigationBar;
	}

	public void setLnkAttendanceNavigationBar(WebElement lnkAttendanceNavigationBar) {
		this.lnkAttendanceNavigationBar = lnkAttendanceNavigationBar;
	}

	public WebElement getLnkLogoutNavigationBar() {
		return lnkLogoutNavigationBar;
	}

	public void setLnkLogoutNavigationBar(WebElement lnkLogoutNavigationBar) {
		this.lnkLogoutNavigationBar = lnkLogoutNavigationBar;
	}

	public WebElement getBtnDelYes() {
		return btnDelYes;
	}

	public void setBtnDelYes(WebElement btnDelYes) {
		this.btnDelYes = btnDelYes;
	}

	public WebElement getBtnDelNo() {
		return btnDelNo;
	}

	public void setBtnDelNo(WebElement btnDelNo) {
		this.btnDelNo = btnDelNo;
	}

	public WebElement getDeletePopup() {
		return alertDeletePopup;
	}


	public boolean isTableDisplayed() {
		return table.isDisplayed();
	}

	public boolean isPaginationDisplayed() {
		return pagination.isDisplayed();
	}

	public String getEntriesInfoText() {
		return entriesInfo.getText();
	}

	public WebElement getTable() {
		return table;
	}

	public int getRowCount() {
		// Assuming the table rows are represented as <tr> elements within the table
		return table.findElements(By.tagName("tr")).size();
	}

	public WebElement getBtnDelAll() {
		return btnDelAll;
	}

	public void setBtnDelAll(WebElement btnDelAll) {
		this.btnDelAll = btnDelAll;
	}
	public List<WebElement> getProgramDetailRows() {
		return pgmDetailRows;
	}
	public void setProgramDetailRows(List<WebElement> pgmDetailRows) {
		this.pgmDetailRows = pgmDetailRows;
	}
	
    
    public void clickNextPageLink() {
        nextPageLink.click();
    }

    public boolean isNextPageLinkPresent() {
        return nextPageLink.isDisplayed();
    }

    public void clickLastPageLink() {
        lastPageLink.click();
    }
    
    
    
    public void clickStartPageLink() {
        startPageLink.click();
    }
    
    public boolean isNextPageLinkDisabled() {
        return !nextPageLink.isEnabled();
    }
    
    public boolean areLastPageRecordsDisplayed() {
        WebElement lastRow = programTable.findElement(By.xpath("//tbody/tr[last()]"));
        return lastRow.isDisplayed();
    }
    
    
    public void clickFirstPageLink() {
        firstPageLink.click();
    }

    public boolean isPreviousPageLinkPresent() {
        return previousPageLink.isDisplayed();
    }

    public String getFirstRecordData() {
       
        WebElement firstRow = pageprogramTable.findElement(By.xpath("//tbody/tr[1]"));
        return firstRow.getText();
    }
    
        public boolean isProgramTableDisplayed() {
        return pageprogramTable.isDisplayed();
    }

    public boolean isPreviousPageLinkDisabled() {
        return !previousPageLink.isEnabled();
    }
}





