package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserModule {
	private static UserModule objUserModule;
	
	//Dummy private constructor prevents the object creation
	private UserModule() {
		
	}
	
	//this method prevents second object creation for the same type, Singleton pattern lazy loading
	public static UserModule getInstance()
	{
		if(objUserModule==null) {
			objUserModule = new UserModule();		
		}		
		return objUserModule;		
	}
	@FindBy(id = "idSearchTextbox")WebElement txtSearch;
	@FindBy(linkText = "+ Add New User")WebElement btnAddUser;
	@FindBy(linkText = "+ Assign Staff")WebElement btnAssignStaff;

	@FindBy(id = "idDeleteAll")WebElement btnDelAll;
	@FindBy(id = "chkAll")WebElement chkAll;
	@FindBy(linkText = ("User"))WebElement lnkUserNavigationBar;
	@FindBy(linkText = "Manage User Page")WebElement txtHeaderUserPage;
	@FindBy(xpath = "//a[text()='<<'")
					WebElement txtFooterPaginationText;
	@FindBy(xpath = "//table/rows")List<WebElement> userDetailRows;
	@FindBy(xpath = "//table/rowHeaders")List<WebElement> userHeaderRows;
	@FindBy(linkText = "User details")WebElement txtUserDetailsHeader;
	@FindBy(id = "idFName")WebElement txtFName;
	@FindBy(id = "idMName")WebElement txtMName;
	@FindBy(id = "idLName")WebElement txtLName;
	@FindBy(id = "idLocation")WebElement txtLocation;
	@FindBy(id = "idPhone")WebElement txtPhone;
	@FindBy(id = "idLinkedInURL")WebElement txtLinkedInURL;
	@FindBy(id = "idUserRole")WebElement selUserRole;
	@FindBy(id = "error")WebElement txtError;
	@FindBy(id = "idRoleStatus")WebElement selRoleStatus;
	@FindBy(id = "idVisaStatus")WebElement selVisaStatus;
	@FindBy(id = "idEmail")WebElement txtEmail;
	@FindBy(id = "idUnderGrad")WebElement txtUnderGrad;
	@FindBy(id = "idPostGrad")WebElement txtPostGrad;
	@FindBy(id = "idTimezone")WebElement txtTimeZone;
	@FindBy(id = "idUserComments")WebElement txtUserComments;
	@FindBy(id = "btnCancel")WebElement btnCancel;
	@FindBy(id = "btnDelYes")WebElement btnDelYes;
	@FindBy(id = "btnDelNo")WebElement btnDelNo;
	
	
	public WebElement getTxtError() {
		return txtError;
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

	public void setTxtError(WebElement txtError) {
		this.txtError = txtError;
	}

	public List<WebElement> getUserHeaderRows() {
		return userHeaderRows;
	}

	public void setUserHeaderRows(List<WebElement> userHeaderRows) {
		this.userHeaderRows = userHeaderRows;
	}
	public WebElement getSelUserRole() {
		return selUserRole;
	}

	public void setSelUserRole(WebElement selUserRole) {
		this.selUserRole = selUserRole;
	}

	public WebElement getSelRoleStatus() {
		return selRoleStatus;
	}

	public void setSelRoleStatus(WebElement selRoleStatus) {
		this.selRoleStatus = selRoleStatus;
	}

	public WebElement getSelVisaStatus() {
		return selVisaStatus;
	}

	public void setSelVisaStatus(WebElement selVisaStatus) {
		this.selVisaStatus = selVisaStatus;
	}
	
	public WebElement getTxtUserDetailsHeader() {
		return txtUserDetailsHeader;
	}

	public void setTxtUserDetailsHeader(WebElement txtUserDetailsHeader) {
		this.txtUserDetailsHeader = txtUserDetailsHeader;
	}

	public WebElement getTxtFName() {
		return txtFName;
	}

	public void setTxtFName(WebElement txtFName) {
		this.txtFName = txtFName;
	}

	public WebElement getTxtMName() {
		return txtMName;
	}

	public void setTxtMName(WebElement txtMName) {
		this.txtMName = txtMName;
	}

	public WebElement getTxtLName() {
		return txtLName;
	}

	public void setTxtLName(WebElement txtLName) {
		this.txtLName = txtLName;
	}

	public WebElement getTxtLocation() {
		return txtLocation;
	}

	public void setTxtLocation(WebElement txtLocation) {
		this.txtLocation = txtLocation;
	}

	public WebElement getTxtPhone() {
		return txtPhone;
	}

	public void setTxtPhone(WebElement txtPhone) {
		this.txtPhone = txtPhone;
	}

	public WebElement getTxtLinkedInURL() {
		return txtLinkedInURL;
	}

	public void setTxtLinkedInURL(WebElement txtLinkedInURL) {
		this.txtLinkedInURL = txtLinkedInURL;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(WebElement txtEmail) {
		this.txtEmail = txtEmail;
	}

	public WebElement getTxtUnderGrad() {
		return txtUnderGrad;
	}

	public void setTxtUnderGrad(WebElement txtUnderGrad) {
		this.txtUnderGrad = txtUnderGrad;
	}

	public WebElement getTxtPostGrad() {
		return txtPostGrad;
	}

	public void setTxtPostGrad(WebElement txtPostGrad) {
		this.txtPostGrad = txtPostGrad;
	}

	public WebElement getTxtTimeZone() {
		return txtTimeZone;
	}

	public void setTxtTimeZone(WebElement txtTimeZone) {
		this.txtTimeZone = txtTimeZone;
	}

	public WebElement getTxtUserComments() {
		return txtUserComments;
	}

	public void setTxtUserComments(WebElement txtUserComments) {
		this.txtUserComments = txtUserComments;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(WebElement btnCancel) {
		this.btnCancel = btnCancel;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(WebElement btnSubmit) {
		this.btnSubmit = btnSubmit;
	}
	@FindBy(id = "btnSubmit")WebElement btnSubmit;

	
	public List<WebElement> getUserDetailRows() {
		return userDetailRows;
	}

	public void setUserDetailRows(List<WebElement> userDetailRows) {
		this.userDetailRows = userDetailRows;
	}

	public WebElement getTxtFooterPaginationText() {
		return txtFooterPaginationText;
	}

	public void setTxtFooterPaginationText(WebElement txtFooterPaginationText) {
		this.txtFooterPaginationText = txtFooterPaginationText;
	}
	

	public WebElement getTxtSearch() {
		return txtSearch;
	}

	public WebElement getTxtHeaderUserPage() {
		return txtHeaderUserPage;
	}

	public void setTxtHeaderUserPage(WebElement txtHeaderUserPage) {
		this.txtHeaderUserPage = txtHeaderUserPage;
	}

	public void setTxtSearch(WebElement txtSearch) {
		this.txtSearch = txtSearch;
	}

	public WebElement getBtnAddUser() {
		return btnAddUser;
	}

	public void setBtnAddUser(WebElement btnAddUser) {
		this.btnAddUser = btnAddUser;
	}

	public WebElement getBtnAssignStaff() {
		return btnAssignStaff;
	}

	public void setBtnAssignStaff(WebElement btnAssignStaff) {
		this.btnAssignStaff = btnAssignStaff;
	}

	public WebElement getBtnDelAll() {
		return btnDelAll;
	}

	public void setBtnDelAll(WebElement btnDelAll) {
		this.btnDelAll = btnDelAll;
	}

	public WebElement getChkAll() {
		return chkAll;
	}

	public void setChkAll(WebElement chkAll) {
		this.chkAll = chkAll;
	}

	public WebElement getLnkUserNavigationBar() {
		return lnkUserNavigationBar;
	}

	public void setLnkUserNavigationBar(WebElement lnkUserNavigationBar) {
		this.lnkUserNavigationBar = lnkUserNavigationBar;
	}

}
