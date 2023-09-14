package page_objects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;
import webdriver_manager.DriverManager;

public class ClassPageObject {
	
	private static ClassPageObject objClassModule;
	
	//Dummy private constructor prevents the object creation
	public ClassPageObject() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	//this method prevents second object creation for the same type, Singleton pattern lazy loading
	public static ClassPageObject getInstance()
	{
		if(objClassModule==null) {
			objClassModule = new ClassPageObject();		
		}		
		return objClassModule;		
	}

	@FindBy(linkText = "class")
	WebElement classlink;
	@FindBy(id = "Searchbar")
	WebElement Searchbar;
	@FindBy(name = "+AddNewClassBtn")
	WebElement AddNewClassLBtn;
	@FindBy(xpath = "//a[@class='DelIconBelowHeader']")
	WebElement DelIconBelowHeader;
	@FindBy(xpath = "//Tagname[@Name = 'EnabledDelBtn']")
	WebElement enabledDelBtn;
	@FindBy(xpath = "//a[@class='Manage Class']")
	WebElement PageHeader;
	@FindBy(xpath = "//a[normalize-space()='In total there are 3 classes']")
	WebElement PagefooterText;
	@FindBy(xpath = "//a[@class='editIcon']")
	WebElement editIcon;
	@FindBy(xpath = "//a[@class=Datatable']")
	WebElement DataTable;
	@FindBy(xpath = "//a[@class=CheckBox']")
	WebElement CheckBox;
	@FindBy(xpath = "//a[@class=classDetailPopup']")
	WebElement ClassDetailPopup;
	@FindBy(xpath = "//a[@class=batchTable']")
	WebElement batchTable;
	@FindBy(xpath = "//a[@class=classTable']")
	WebElement classTable;
	@FindBy(xpath = "//a[@class=topicTable']")
	WebElement topicTable;
	@FindBy(xpath = "//a[@class=sortIcon']")
	WebElement sortIcon;
	@FindBy(xpath = "//a[normalize-space()='PaginationControlArrow']")
	WebElement PaginationControlArrow;
	@FindBy(xpath = "//a[normalize-space()='numberEntries']")
	WebElement numberEntries;
	@FindBy(xpath = "//a[normalize-space()='navigationBar']")
	WebElement navigationBar;
	@FindBy(name = "+AddNewClassBtn")
	WebElement CancelBtn;
	@FindBy(xpath = "//a[@class='DelIconBelowHeader']")
	WebElement SaveBtn;
	@FindBy(xpath = "//Tagname[@Name = 'CloseBtn']")
	WebElement CloseBtn;
	@FindBy(linkText = "NoBtn")
	WebElement NoBtn;
	@FindBy(linkText = "YesBtn")
	WebElement YesBtn;
	@FindBy(xpath = "//Tagname[@Name = 'CrossBtn']")
	WebElement CrossBtn;
	@FindBy(linkText = "DropdownInBatchId")
	WebElement DropdownInBatchId;
	@FindBy(linkText = "DropdownInStaffId")
	WebElement DropdownInStaffId;
	@FindBy(id = "CalenderIcon")
	WebElement CalenderIcon;
	@FindBy(id = "batchIdDropdown")
	WebElement batchIdDropdown;
	@FindBy(id = "batchIdTable")
	WebElement batchIdTable;
	@FindBy(id = "AllText")
	WebElement AllTextFields;
	@FindBy(id="totalClassesText")
	WebElement totalClassesText;
	@FindBy(id="paginationText")
	WebElement paginationText;
	@FindBy(id="AllMandatoryFields")
	WebElement AllMandatoryFields;
	@FindBy(id="ErrorMessage")
	WebElement ErrorMessage;
	@FindBy(id="optionalFields")
	WebElement OptionalFields;
	@FindBy(id="optionalFieldsValues")
	WebElement OptionalFieldsValues;
	@FindBy(id="batchId")
	WebElement BatchID;
	@FindBy(id="staffIdField")
	WebElement staffIdField;
	@FindBy(id="deleteAlertBtn")
	WebElement deleteAlert;
	@FindBy(id="saveButton")
	WebElement saveButton;
	@FindBy(id="editPopupWindow")
	WebElement editPopupWindow;
//	batchIdTextboxLocator
//	numOfClassesTextboxLocator
//	classDateTextboxLocator
//	classTopicTextboxLocator
//	classTopicTextboxLocator
//	classDescriptionTextboxLocator
//	commentsTextboxLocator
//	notesTextboxLocator
//	recordingsTextboxLocator
//	
	public boolean isSelected() {
		return editPopupWindow.isSelected();
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public boolean isDisplayed() {
		return AddNewClassLBtn.isDisplayed();
	}

	public WebElement getTopicTable() {
		return topicTable;
	}
	
	public Alert getdeleteAlertBtn() {
		deleteAlert.click();
		return null;

	}
	public WebElement getStaffIdField() {
		return staffIdField;
	}


	public String getOptionalFieldsValues() {
		return OptionalFieldsValues.getText();
	}
	
public WebElement getBatchId() {
	BatchID.click();
	return BatchID;
	
}
	public void selectBatchID() {
		BatchID.isSelected();
		BatchID.click();
		BatchID.getText();
	}
	public String getErrorMessage() {
		return ErrorMessage.getText();
	}
	
	public void enterDataInSearchBox() {
		Searchbar.click();
		Searchbar.clear();
		Searchbar.sendKeys("StaffID");
	}
	public void enterInvalidDataInSearchBox() {
		Searchbar.click();
		Searchbar.clear();
		Searchbar.sendKeys("InvalidStaffID");
	}
	public void enterInvalidDataInOptionalFields() {
		OptionalFields.click();
		OptionalFields.clear();
		OptionalFields.sendKeys("InvalidStaffID");
	}
	public void enterDateInSearchBox() {
		Searchbar.click();
		Searchbar.clear();
		Searchbar.sendKeys("MM/DD/YYYY");
	}
	public void enterInvalidDateInSearchBox() {
		Searchbar.click();
		Searchbar.clear();
		Searchbar.sendKeys("MM/DD/YYYY");
		
	}
	public void entersValuesInAllMandatoryFields() {
		AllMandatoryFields.click();
		AllMandatoryFields.clear();
		AllMandatoryFields.sendKeys("Values");{
			}
		}
	public String getPaginationText() {
		return paginationText.getText();
	}
	public String getTotalClassesText() {
		return totalClassesText.getText();
	}
	public WebElement getAllTextFields() {
		return AllTextFields;
	}
	public WebElement getBatchIdTable() {
		return batchIdTable;
	}
	public WebElement getBatchIdDropdown() {
		return batchIdDropdown;
	}
	public WebElement getClasslink() {
		return classlink;
	}

	public void setClasslink(WebElement classlink) {
		this.classlink = classlink;
	}

	public void navigateToClassDetailPopup() {
		ClassDetailPopup.click();
	}

	public WebElement getSearchbar() {
		return Searchbar;
	}

	public WebElement getBatchTable() {
		return batchTable;
	}

	public WebElement getClassTable() {
		return classTable;
	}

	public void setSearchbar(WebElement searchbar) {
		Searchbar = searchbar;
	}

	public WebElement getAddNewClassLBtn() {
		return AddNewClassLBtn;
	}

	public void setAddNewClassLBtn(WebElement addNewClassLBtn) {
		AddNewClassLBtn = addNewClassLBtn;
	}

	public WebElement getDelIconBelowHeader() {
		return DelIconBelowHeader;
	}

	public void setDelIconBelowHeader(WebElement delIconBelowHeader) {
		DelIconBelowHeader = delIconBelowHeader;
	}

	public WebElement getEnabledDelBtn() {
		return enabledDelBtn;
	}

	public void setEnabledDelBtn(WebElement enabledDelBtn) {
		this.enabledDelBtn = enabledDelBtn;
	}

	public WebElement getPageHeader() {
		return PageHeader;
	}

	public void setPageHeader(WebElement pageHeader) {
		PageHeader = pageHeader;
	}

	public WebElement getPagefooterText() {
		return PagefooterText;
	}

	public void setPagefooterText(WebElement pagefooterText) {
		PagefooterText = pagefooterText;
	}

	public WebElement getEditIcon() {
		return editIcon;
	}

	public void setEditIcon(WebElement editIcon) {
		this.editIcon = editIcon;
	}

	public WebElement getDataTable() {
		return DataTable;
	}
	// public WebElement getDatatableWithAllHeader() {
	// return ataTableWithAllHeader;
	// }

	public void setDataTable(WebElement dataTable) {
		DataTable = dataTable;
	}

	public WebElement getCheckBox() {
		return CheckBox;
	}

	public void setCheckBox(WebElement checkBox) {
		CheckBox = checkBox;
	}

	public WebElement getSortIcon() {
		return sortIcon;
	}

	public void setSortIcon(WebElement sortIcon) {
		this.sortIcon = sortIcon;
	}

	public WebElement getPaginationControlArrow() {
		return PaginationControlArrow;
	}

	public void setPaginationControlArrow(WebElement paginationControlArrow) {
		PaginationControlArrow = paginationControlArrow;
	}

	public WebElement getNumberEntries() {
		return numberEntries;
	}

	public void setNumberEntries(WebElement numberEntries) {
		this.numberEntries = numberEntries;
	}

	public WebElement getNavigationBar() {
		return navigationBar;
	}

	public void setNavigationBar(WebElement navigationBar) {
		this.navigationBar = navigationBar;
	}

	public WebElement getCancelBtn() {
		return CancelBtn;
	}

	public void setCancelBtn(WebElement cancelBtn) {
		CancelBtn = cancelBtn;
	}
	

	public void clickOnSaveBtn() {
		SaveBtn.click();
	}

	public void clickOnYesBtn() {
		YesBtn.click();
	}

	public void setSaveBtn(WebElement saveBtn) {
		SaveBtn = saveBtn;
	}

	public WebElement getCloseBtn() {
		return CloseBtn;
	}

	public void setCloseBtn(WebElement closeBtn) {
		CloseBtn = closeBtn;
	}

	public WebElement getNoBtn() {
		return NoBtn;
	}

	public void setNoBtn(WebElement noBtn) {
		NoBtn = noBtn;
	}

	public WebElement getYesBtn() {
		return YesBtn;
	}

	public void setYesBtn(WebElement yesBtn) {
		YesBtn = yesBtn;
	}

	public WebElement getCrossBtn() {
		return CrossBtn;
	}

	public void setCrossBtn(WebElement crossBtn) {
		CrossBtn = crossBtn;
	}

	public WebElement getDropdownInBatchId() {
		return DropdownInBatchId;
	}

	public void setDropdownInBatchId(WebElement dropdownInBatchId) {
		DropdownInBatchId = dropdownInBatchId;
	}

	public WebElement getDropdownInStaffId() {
		return DropdownInStaffId;
	}

	public void setDropdownInStaffId(WebElement dropdownInStaffId) {
		DropdownInStaffId = dropdownInStaffId;
	}

	public WebElement getCalenderIcon() {
		return CalenderIcon;
	}

	public void setCalenderIcon(WebElement calenderIcon) {
		CalenderIcon = calenderIcon;
	}

	public static ClassPageObject getLoginPageInstance() {
		return loginPageInstance;
	}

	public static void setLoginPageInstance(ClassPageObject loginPageInstance) {
		ClassPageObject.loginPageInstance = loginPageInstance;
	}

	private static ClassPageObject loginPageInstance;

	// Dummy private constructor prevents the object creation
	
	public void clickOnClassLink() {
		classlink.click();
	}

//Admin is directed to manage class page
	public String getClassPageURL() {
		String url = DriverManager.getDriver().getCurrentUrl();
		return url;
	}

	public void clickOnNavigationBar() {
		navigationBar.click();
	}

	public void getResponseTime() {

		// driver.get("http://zyxware.com");

		// new WebDriverWait(driver, 10).until(ExpectedConditions.

		// presenceOfElementLocated(By.id("Calculate")));

		long endTime = System.currentTimeMillis();

		long startTime = 0;
		long totalTime = endTime - startTime;

		System.out.println("Total Page Load Time: " + totalTime + " milliseconds");
	}

	public boolean isbuttondisabled() {

		return false;
	}

	public boolean verifySearchButton() {

		return false;
	}

	public String getText() {
		return null;
	}
	public String getSelectedDate() {
		
		return null;
	}
	public WebElement getRightArrow() {
		
		return null;
	}
	public WebElement getDatePickerButton() {
		return null;
	}
	public boolean isClassCreationPreventedForPastDate() {
		return false;
	}
	public WebElement getClassDetailPopup() {
		return ClassDetailPopup;
	}

	public void navigateToManageClassPage() {
		
		
	}

	public boolean verifyAlertButtons(String string) {
		return false;
	}

	public void clickOnNoBtn() {
		
		
	}

	public void clickOnAddNewClassButton() {
		
		
	}

	public WebElement getPopUp() {
		
		return null;
	}

	public WebElement getnumOfClasses() {
		return null;
	}
	
}
