package page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import webdriver_manager.DriverManager;
public class Assigmentmodule{
	private static Assigmentmodule objAssignmentmodule;
	
	public Assigmentmodule(){
		
	}
	//this method prevents second object creation for the same type, Singleton pattern lazy loading
	public static Assigmentmodule getInstance()
	{
		if(objAssignmentmodule==null) {
			objAssignmentmodule = new Assigmentmodule();		
		}		
		return objAssignmentmodule;		
	}
	
	@FindBy(linkText = ("Assignment"))WebElement Assignmentlnk ;
	@FindBy(linkText = ("New Assignment"))WebElement newAssignment;
	@FindBy(linkText = ("upload Assignment"))WebElement uploadAssignment;
	@FindBy(linkText = ("search"))WebElement searchAssignment;
	@FindBy(linkText = ("edit"))WebElement editAssignment;
	@FindBy(linkText = ("delete"))WebElement deleteAssignment;
	@FindBy(linkText = ("enabledmuldelete"))WebElement muldeleteAssignmentenabled;
	@FindBy(linkText = ("disabledmuldelete"))WebElement muldeleteAssignmentdisabled;
	@FindBy(linkText = ("assignment name"))WebElement txtAssignmentname;
	@FindBy(linkText = ("Assignment description"))WebElement Assigndescription;
	@FindBy(linkText = ("Assignment Date"))WebElement AssignDate;
	@FindBy(linkText = ("Assignment Grade"))WebElement AssignGrade;
	@FindBy(linkText = ("check box symbol"))WebElement checkboxsymbol;
	@FindBy(linkText = ("sorting-icon"))WebElement Assgnsorting;
	@FindBy(linkText = "Manage User Page")WebElement txtHeaderassignPage;
	@FindBy(xpath = "//a[text()='<<'")WebElement txtFooterAssignmentText;
	
	@FindBy(linkText = ("Assigndetails"))WebElement popupAssigndetails;
	@FindBy(linkText = ("Program name"))WebElement popupProgramname;
	@FindBy(linkText = ("Assignment name"))WebElement popupAssignmentname;
	@FindBy(linkText = ("batch number"))WebElement popupbatchnumber;
	@FindBy(linkText = ("Assignment Description"))WebElement popupassigndesc;
	@FindBy(linkText = ("grade by"))WebElement popupgradeby; 
	@FindBy(linkText = ("Assignment file 1"))WebElement popupAssignmentFile1;
	@FindBy(linkText = ("Assignment file 2"))WebElement popupAssignmentfile2;
	@FindBy(linkText = ("Assignment file 3"))WebElement popupAssignmentfile3;
	@FindBy(linkText = ("save"))WebElement popupAssignsave;
	@FindBy(linkText = ("close"))WebElement popupassignclose;
	@FindBy(linkText = ("cancel"))WebElement popassigncancel;
	@FindBy(linkText = ("Program name dropdown"))WebElement popupProgramnamedrpdwn;
	@FindBy(linkText = ("batch number dropdown"))WebElement popupbatchnumberdropdown;
	@FindBy(linkText = ("calender icon"))WebElement popupcalicon;
	
	public WebElement getpopupProgramnamedrpdwn() {
		return popupProgramnamedrpdwn;
	}
	public WebElement getpopupbatchnumberdropdown() {
		return popupbatchnumberdropdown;
	}
	public WebElement getpopupcalicon() {
		return popupcalicon;
	}
	
	
	public WebElement getpopupAssignsave() {
		return popupAssignsave;
	}
	public WebElement getpopupassignclose (){
		return popupassignclose;
	}
	public WebElement getpopassigncancel() {
		return popassigncancel;
	}
	public WebElement getheaderpopupAssigndetails() {
		return popupAssigndetails;
	}
	
	public WebElement getpopassignname() {
		return popupAssignmentname;
	}
	public WebElement getpopupProgramname() {
		return popupProgramname;
	}

	public WebElement getpopupbatchnumber() {
		return popupbatchnumber;
	}
	public WebElement getpopupassigndesc() {
		return popupassigndesc;
	}
	
	public WebElement getpopupgradeby() {
		return popupgradeby;
	}
	
	public WebElement getpopupAssignmentFile1() {
		return popupAssignmentFile1;
	}
	public WebElement getpopupAssignmentFile2() {
		return popupAssignmentfile2;
	}
	public WebElement getFooterAssignpaginationTxt() {
		return txtFooterAssignmentText;
	}
	public WebElement gettxtHeaderassignPage() {
		return txtHeaderassignPage;
	}
	
	
	public WebElement getAssgnsorting() {
		txtAssignmentname.findElement((By) Assgnsorting);
		
		return Assgnsorting;
	}
	public WebElement getcheckboxsymbol() {
		return checkboxsymbol;
	}
	public WebElement geteditAssignment() {
		return editAssignment;
	}
	public WebElement getdeleteAssignment() {
		return deleteAssignment;
	}
	
	public WebElement getAssigndescription() {
		return Assigndescription;
	}
	public WebElement getAssignDate() {
		return AssignDate;
	}
	public WebElement getAssignGrade() {
		return AssignGrade;
	}
	public WebElement getAssignmentlnk() {
		return Assignmentlnk;
	}
	public WebElement gettxtAssignmentname() {
		return txtAssignmentname;
	}
	public WebElement getmuldeleteAssignmentdisabled() {
		return muldeleteAssignmentdisabled;
	}
	public WebElement getsearchAssignment() {
		return searchAssignment;
	}
	public WebElement getnewAssignment() {
		return newAssignment;
	}
	
	//popup
	
	
	
}

