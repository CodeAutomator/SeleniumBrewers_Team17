package page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriver_manager.DriverManager;

public class BatchPageObj {
	private static BatchPageObj loginPageInstance;

	// Dummy private constructor prevents the object creation
	public BatchPageObj() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public static BatchPageObj getInstance() {
		if (loginPageInstance == null) {
			loginPageInstance = new BatchPageObj();
		}

		return loginPageInstance;

	}


	@FindBy(linkText = ("Batch"))WebElement Batchnavigationbar; // Admin clicks "batch" on the navigation bar
	@FindBy(xpath = "//button[@type='deletetop']") WebElement deletetop; //top left delete icon button on manage batch page
	@FindBy(xpath = "//button[@type='+A new batch']") WebElement newbatchbutton; //+A new batch button on manage program page
	@FindBy(xpath = "//a[normalize-space()='Name']") WebElement batchnamedatatable; // text of batch name on data table
	@FindBy(xpath = "//a[normalize-space()='Description']") WebElement batchdescriptiondatatable; //text of batch Description on data table
	@FindBy(xpath = "//a[normalize-space()='No of classes']") WebElement noofclassesdatatable; //text of no of classes on data table
	@FindBy(xpath = "//a[normalize-space()='Status']") WebElement batchstatusdatatable; //text of batch status on data table
	@FindBy(xpath = "//a[normalize-space()='Edit']") WebElement editdatatable; //text of edit on data table
	@FindBy(xpath = "//a[normalize-space()='Delete']") WebElement deletedatatable; //text of delete on data table
	@FindBy(xpath = "//table[@id='data-table']//tr") List<WebElement> tableRows; //table rows
	@FindBy(xpath = "//a[normalize-space()='Program Name']") WebElement programnamedatatable; // text of program name on data table
	@FindBy(id = "batch-details-popup") WebElement bacthDetailsPopup; //Batchdetail pop up
	@FindBy(id = "program-name-input") WebElement NameInput; //program name input field
	@FindBy(id = "program-description-input") WebElement programDescriptionInput; //program description input field
	@FindBy(id = "idProgramName")WebElement ProgramName; //Select Program Name
	@FindBy(id = "radio-active") WebElement radioActive; //radio button for program status active
	@FindBy(id = "radio-inactive") WebElement radioInactive; //radio button for program status inactive
	@FindBy(id = "Number-of-Class") WebElement noOfCalss; //Number of Class
	@FindBy(id = "save-button") WebElement saveButton;
	@FindBy(xpath = "//table/rows")List<WebElement> batchDetailRows;
	@FindBy(id = "error")WebElement txtError;
	@FindBy(id = "btnDelYes")WebElement btnDelYes; // Batch Yes
	@FindBy(id = "btnDelNo")WebElement btnDelNo;   // Batch No
	@FindBy(id = "chkAll")WebElement chkAll;      // Check ALL
	@FindBy(id = "idDeleteAll")WebElement btnDelAll; //Delete ALL
	@FindBy(xpath = "//a[text()='<<'") WebElement txtFooterPaginationText;//footer pagination text


	public void Batchnavigationbarbutton() throws InterruptedException {
		Thread.sleep(1000);
		Batchnavigationbar.click();
		Thread.sleep(1000);
	}

	// The Admin directed to manage program page
	public String getManagebatchpageURL() {
		String url = DriverManager.getDriver().getCurrentUrl();
		return url;
	}

	// get title of  manage batch page
	public String getManagebatchPageTitle() {
		String title = DriverManager.getDriver().getTitle();
		return title;
	}

	//deletetop button on manage batch page
	public void Deletetopbutton() throws InterruptedException {
		Thread.sleep(1000);
		deletetop.click();
		Thread.sleep(1000);
	}	
	
	public WebElement getTxtFooterPaginationText() {
		return txtFooterPaginationText;
	}

	public boolean isbuttondisabled()
	{
		return !deletetop.isEnabled();

	}

	// to get add new batch text on manage program page
	public String getaddbatchtext() {

		return newbatchbutton.getText();
	}

	// to get batch name text on manage program page data table
	public String getbatchnametextondatatable() {

		return batchnamedatatable.getText();
	}
	// to get batch description text on manage program page data table
	public String getbatchdesctextondatatable() {

		return batchdescriptiondatatable.getText();
	}

	// to get batch status text on manage program page data table
	public String getstatustextondatatable() {

		return batchstatusdatatable.getText();
	}

	// to get no of classes text on manage batch page data table
	public String getnoofclasses() {

		return noofclassesdatatable.getText();
	}

	// to get edit text on manage program page data table
	public String getedittextondatatable() {

		return editdatatable.getText();
	}

	// to get delete text on manage program page data table
	public String getdeletetextondatatable() {

		return deletedatatable.getText();
	}

	public WebElement getCheckboxForRow(int rowIndex) {
		return tableRows.get(rowIndex).findElement(By.xpath(".//input[@type='checkbox']"));
	}

	public WebElement getEditIconForRow(int rowIndex) {
		return tableRows.get(rowIndex).findElement(By.xpath(".//span[@class='edit-icon']"));
	}

	public WebElement getDeleteIconForRow(int rowIndex) {
		return tableRows.get(rowIndex).findElement(By.xpath(".//span[@class='delete-icon']"));
	}

	public int getRowCount() {
		return tableRows.size();
	}

	public void Addnewbatchbutton() throws InterruptedException {
		Thread.sleep(1000);
		newbatchbutton.click();
		Thread.sleep(1000);
	}

	// to get program name text on manage program page data table
	public String getprogramnametextondatatable() {

		return programnamedatatable.getText();
	}

	public WebElement getbatchDetailsPopup() {
		return bacthDetailsPopup;
	}

	/// Feature Add Batch 
public WebElement getTxtName() {
		
		return NameInput;
	}

	public WebElement getTxtDescrption() {
		
		return programDescriptionInput;
	}

	public WebElement getSelProgName() {
		
		return ProgramName;
	}

	public WebElement getActiveSelRoleStatus() {
		
		return radioActive;
	}

	public WebElement getinActiveSelRoleStatus() {
		
		return radioInactive;
	}

	public WebElement getTxtNumberofClass() {
		
		return noOfCalss;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public List<WebElement> getBatchDetailRows() {
		return batchDetailRows;
	}
	public void setBatchDetailRows(List<WebElement> batchDetailRows) {
		this.batchDetailRows = batchDetailRows;
	}

	public WebElement getTxtError() {
		return txtError;
	}
	public void setTxtError(WebElement txtError) {
		this.txtError = txtError;
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
	
	public WebElement getChkAll() {
		return chkAll;
	}
	
	public void setChkAll(WebElement chkAll) {
		this.chkAll = chkAll;
	}
	
	public WebElement getBtnDelAll() {
		return btnDelAll;
	}

	public void setBtnDelAll(WebElement btnDelAll) {
		this.btnDelAll = btnDelAll;
	}
	
}
