package page_objects;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import utilities.LOGGER;
import webdriver_manager.DriverManager;

public class DashboardPage {

	
	private static DashboardPage objDashboard;
	public static WebDriver driver = DriverManager.getDriver();

	

	@FindBy(xpath = "//header[contains(text(), 'Manage Program')]") WebElement manageProgramHeader;
	
	

	@FindBy(xpath = "//title[contains(text(), 'LMS - Learning management system')]") WebElement lmsPageTitle;
	 
	@FindBy(xpath = "//div[@id='navigation-bar']")WebElement navigationBar;
	
	@FindBy(linkText = ("Student"))WebElement studentNavLink;
	@FindBy(linkText = ("Program"))WebElement programNavLink;
	@FindBy(linkText = ("Batch"))WebElement batchNavLink;
	@FindBy(linkText = ("Class"))WebElement classNavLink;
	@FindBy(linkText = ("User"))WebElement userNavLink;
	@FindBy(linkText = ("Assignment"))WebElement assignmentNavLink;
	@FindBy(linkText = ("Attendance"))WebElement attendanceNavLink;
	@FindBy(linkText = ("Lgout"))WebElement logoutNavLink;
    
   //Dummy private constructor prevents the object creation
	public DashboardPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	//this method prevents second object creation for the same type, Singleton pattern lazy loading
	public static DashboardPage getInstance()
	{
		if(objDashboard==null) {
			objDashboard = new DashboardPage();		
		}		
		return objDashboard;		
	}
	
	
	

	public WebElement getManageProgramHeader() {
        return manageProgramHeader;
    }

    public WebElement getLMSPageTitle() {
		return lmsPageTitle;
	}
	
	
	public WebElement getNavigationBar() {
		return navigationBar;
	}

	
	public WebElement getStudentNavLink() {
		return studentNavLink;
	}

	
	public WebElement getProgramNavLink() {
		return programNavLink;
	}

	
	public WebElement getBatchNavLink() {
		return batchNavLink;
	}

	
	public WebElement getClassNavLink() {
		return classNavLink;
	}

		public WebElement getUserNavLink() {
		return userNavLink;
	}

	

	public WebElement getAssignmentNavLink() {
		return assignmentNavLink;
	}

	
	public WebElement getAttendanceNavLink() {
		return attendanceNavLink;
	}

	
	public WebElement getLogoutNavLink() {
		return logoutNavLink;
	}



        public boolean verifyNavBarAlignment() {
        return navigationBar.isDisplayed();
    }
	/*
	 * public boolean verifyNavBarText() {
	 * 
	 * WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5)); return
	 * wait.until(ExpectedConditions.textToBePresentInElement(navigationBar,
	 * "Correct Spelling")); }
	 */
	/*
	 * public boolean verifyNavBarOrder() { String[] expectedOrder = {"Student",
	 * "Program", "Batch", "Class", "User", "Assignment", "Attendance", "Logout"};
	 * WebElement[] navLinks = {studentNavLink, programNavLink, batchNavLink,
	 * classNavLink, userNavLink, assignmentNavLink, attendanceNavLink,
	 * logoutNavLink};
	 * 
	 * for (int i = 0; i < expectedOrder.length; i++) { if
	 * (!navLinks[i].getText().equals(expectedOrder[i])) { return false; } } return
	 * true; }
	 */

    public void verifyBrokenLink() throws IOException {
    	HttpURLConnection cn = 
      		  (HttpURLConnection)new 
      		  URL(constants.Constants.Dashboard_URL)
      		  .openConnection();
        cn.setRequestMethod("HEAD");
        cn.connect();
        int respCode = cn.getResponseCode();
       LOGGER.info("HTTP Resonse code : " + respCode );
  	     assertTrue(respCode>=400, "Link os broken with Response code :" + respCode );
    }

}
