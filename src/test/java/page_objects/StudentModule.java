package page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import webdriver_manager.DriverManager;

public class StudentModule {
	private static StudentModule objStudentModule;
		
	//Dummy private constructor prevents the object creation
	public StudentModule() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	//this method prevents second object creation for the same type, Singleton pattern lazy loading
	public static StudentModule getInstance()
	{
		if(objStudentModule==null) {
			objStudentModule = new StudentModule();		
		}		
		return objStudentModule;		
	}
	
	@FindBy(linkText = "Select Student Name")WebElement selStudentName;
	@FindBy(linkText = "Select batch id")WebElement selBatchId;
	@FindBy(linkText = "Student Details Page")WebElement txtPageTitle;
	@FindBy(linkText = "text inside a student name dropdown")
				WebElement txtSearchName;
	@FindBy(linkText = "text inside a batch id dropdown")
				WebElement txtSearchid;
	@FindBy(linkText = "student details can not be displayed")WebElement txtError;
	@FindBy(linkText = "Student Details")WebElement txtStudentDetails;
	
	public WebElement getTxtStudentDetails() {
		return txtStudentDetails;
	}

	public void setTxtStudentDetails(WebElement txtStudentDetails) {
		this.txtStudentDetails = txtStudentDetails;
	}

	public WebElement getTxtError() {
		return txtError;
	}

	public void setTxtError(WebElement txtError) {
		this.txtError = txtError;
	}

	// Admin clicks on the navigation bar
	@FindBy(linkText = ("Student"))WebElement lnkStudentNavigationBar;
	@FindBy(linkText = ("Program"))WebElement lnkProgramNavigationBar;
	@FindBy(linkText = ("Batch"))WebElement lnkBatchNavigationBar;
	@FindBy(linkText = ("Class"))WebElement lnkClassNavigationBar;
	@FindBy(linkText = ("User"))WebElement lnkUserNavigationBar;
	@FindBy(linkText = ("Assignment"))WebElement lnkAssignmentNavigationBar;
	@FindBy(linkText = ("Attendance"))WebElement lnkAttendanceNavigationBar;
	@FindBy(linkText = ("Lgout"))WebElement lnkLogoutNavigationBar;
		
	public List<WebElement> getAllDropdownElements() {
		return DriverManager.getDriver().findElements
				(By.xpath("search by select"));
	}
	
	public WebElement getLnkStudentNavigationBar() {
		return lnkStudentNavigationBar;
	}

	public void setLnkStudentNavigationBar(WebElement lnkStudentNavigationBar) {
		this.lnkStudentNavigationBar = lnkStudentNavigationBar;
	}

	public WebElement getLnkProgramNavigationBar() {
		return lnkProgramNavigationBar;
	}

	public void setLnkProgramNavigationBar(WebElement lnkProgramNavigationBar) {
		this.lnkProgramNavigationBar = lnkProgramNavigationBar;
	}

	public WebElement getLnkBatchNavigationBar() {
		return lnkBatchNavigationBar;
	}

	public void setLnkBatchNavigationBar(WebElement lnkBatchNavigationBar) {
		this.lnkBatchNavigationBar = lnkBatchNavigationBar;
	}

	public WebElement getLnkClassNavigationBar() {
		return lnkClassNavigationBar;
	}

	public void setLnkClassNavigationBar(WebElement lnkClassNavigationBar) {
		this.lnkClassNavigationBar = lnkClassNavigationBar;
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

	public WebElement getTxtSearchName() {
		return txtSearchName;
	}

	public void setTxtSearchName(WebElement txtSearchName) {
		this.txtSearchName = txtSearchName;
	}

	public WebElement getTxtSearchid() {
		return txtSearchid;
	}

	public void setTxtSearchid(WebElement txtSearchid) {
		this.txtSearchid = txtSearchid;
	}

	public WebElement getTxtPageTitle() {
		return txtPageTitle;
	}

	public void setTxtPageTitle(WebElement txtPageTitle) {
		this.txtPageTitle = txtPageTitle;
	}

	public WebElement getSelStudentName() {
		return selStudentName;
	}

	public void setSelStudentName(WebElement selStudentName) {
		this.selStudentName = selStudentName;
	}

	public WebElement getSelBatchId() {
		return selBatchId;
	}

	public void setSelBatchId(WebElement selBatchId) {
		this.selBatchId = selBatchId;
	}
}
