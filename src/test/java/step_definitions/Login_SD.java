package step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.HomePage;
import page_objects.LoginPage;
import utilities.common_utils;
import webdriver_manager.DriverManager;

public class Login_SD extends Constants {
	
	HomePage objhomepage = HomePage.getInstance();
	LoginPage objlogin = LoginPage.getInstance();
	WebDriver driver = DriverManager.getDriver();
	common_utils objCommounUtils = new common_utils();
	String txtLogMessage = "";
	//private static final Logger LOGGER = LogManager.getLogger(Login_SD.class);
	private static final Logger LOGGER = LogManager.getLogger();
	
	@Given("Admin is in home page")
	public void admin_is_in_home_page() {
		objhomepage.getHomepage();
	}

	@When("Admin clicks Login button")
	public void admin_clicks_login_button() {
		objhomepage.ClickOnLoginBtn();
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		objlogin.verifyLoginPageTitle();
	}

	@Then("Admin should see {string} in the header")
	public void admin_should_see_in_the_header(String Title) {
		String title = objlogin.getLoginPageHeaderText();
	    Assert.assertEquals(Title,title);	
	    }

	@Then("Login_HTTP response >= {int}. Then the link is broken")
	 public void http_response_then_the_link_is_broken(Integer expectedResponseCode) {
		 boolean isBroken = objlogin.isLinkBroken("actual", expectedResponseCode);
		 Assert.assertTrue(isBroken, "The link is not broken.");
		 
		
	 }
	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
		 boolean TextFieldsVisible = objlogin.textFieldsVisible();   
	     Assert.assertTrue(TextFieldsVisible, "Two text fields should be visible");
	 }
	
	@Then("Admin should see {string} in the first text field")
	public void admin_should_see_in_the_first_text_field(String expectedText) {
		
		 String actualText = objlogin.getuserNameText(expectedText);
	     Assert.assertEquals(expectedText, actualText);
	 }


	@Then("Admin should see * symbol next to user text")
	public void admin_should_see_symbol_next_to_user_text() {
		objlogin.verifyUserAsterikIsDisplayed();
	}

	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String expectedText) {
		
		String actualText = objlogin.getPwdText(expectedText);
	     Assert.assertEquals(expectedText, actualText);
	}

	@Then("Admin should see * symbol next to password text")
	public void admin_should_see_symbol_next_to_password_text() {
		objlogin.verifyPwdAsterikIsDisplayed();
	}

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
		objlogin.validatePositionOfFields();
	}

	@Then("Admin should see login button on the centre of the page")
	public void admin_should_see_login_button_on_the_centre_of_the_page() {
		
		 boolean isLoginButtonCentered = objlogin.isLoginButtonCentered(); 
	     Assert.assertTrue(isLoginButtonCentered, "Login button is not in the center of the page.");
	}

	@Then("Admin should see forgot username or password link")
	public void admin_should_see_forgot_username_or_password_link() {
		
		 boolean isForgotLinkDisplayed = objlogin.isForgotLinkDisplayed();
		 Assert.assertTrue(isForgotLinkDisplayed, "Forgot username or password link is not displayed.");
	}

	@Then("Admin should see reset password link")
	public void admin_should_see_reset_password_link() {
	
		 boolean resetlink = objlogin.resetPwdLinkDisplayed();
		 Assert.assertTrue(resetlink, "Reset  Password link is not displayed.");
	}

	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
	
		 String userTextColor = objlogin.getUserTextColor();
		 String expectGrayColor = "rgb(128, 128, 128)";
		  Assert.assertEquals(expectGrayColor, userTextColor, "User text is not displayed in gray color.");
	}

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		
		 String pwdTextColor = objlogin.getPwdTextColor();
		 
		  String expectedGrayColor = "rgb(128, 128, 128)";
		  Assert.assertEquals(expectedGrayColor, pwdTextColor, "User text is not displayed in gray color.");
	}

	@Given("Admin is in login page")
	public void admin_is_in_login_page() {
		objlogin.clickLoginBtn();
		objlogin.verifyLoginPageTitle();
	}

	@When("Admin enter valid credentials  and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
		objlogin.getuserNameText("admin");
		objlogin.getPwdText("pwd123");
		objlogin.clickLoginBtn();
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
		
		boolean isLogoutButtonVisible = objlogin.isLoginButtonVisible(); 
	     Assert.assertTrue(isLogoutButtonVisible, "Admin is not on dashboard page.");
	     objlogin.logout();
		
	}

	@When("Admin enter invalid credentials  and clicks login button")
	public void admin_enter_invalid_credentials_and_clicks_login_button() {
		objlogin.getuserNameText("**12%**");
		objlogin.getPwdText("&*4_5g");
		objlogin.clickLoginBtn();
	}

	@Then("Error message please check username\\/password")
	public void error_message_please_check_username_password() {
		String actualmsg =objlogin.Message("Please Check username/password");
		Assert.assertEquals("Please Check username/password" ,actualmsg);	
	}

	@When("Admin enter valid username  and clicks login button")
	public void admin_enter_valid_username_and_clicks_login_button() {
		objlogin.getuserNameText("admin");
		objlogin.clickLoginBtn();
	}

	@Then("Error message please check password")
	public void error_message_please_check_password() {
		String actualmsg =objlogin.Message("Please Check password");
		Assert.assertEquals("Please Check password",actualmsg);
	}

	@When("Admin enter valid  password  and clicks login button")
	public void admin_enter_valid_password_and_clicks_login_button() {
		objlogin.getPwdText("pwd123");
		objlogin.clickLoginBtn();
	}

	@Then("Error message please check username")
	public void error_message_please_check_username() {
		String actualmsg =objlogin.Message("Please Check username");
		Assert.assertEquals("Please Check username",actualmsg);
	}

	@When("Admin enter blank in username   and clicks login button")
	public void admin_enter_blank_in_username_and_clicks_login_button() {
		objlogin.getuserNameText("");
		objlogin.getPwdText("pwd123");
		objlogin.clickLoginBtn();
	}

	@When("Admin enter blank in password  and clicks login button")
	public void admin_enter_blank_in_password_and_clicks_login_button() {
		objlogin.getuserNameText("admin");
		objlogin.getPwdText("");
		objlogin.clickLoginBtn();
	}

	@When("Admin clicks Login button with empty values in both columns")
	public void admin_clicks_login_button_with_empty_values_in_both_columns() {
		objlogin.getuserNameText("");
		objlogin.getPwdText("");
		objlogin.clickLoginBtn();
	}

	@When("Admin enter valid credentials  and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
		objlogin.getuserNameText("admin");
		objlogin.getPwdText("pwd123");
		objlogin.keyboardClick();
	}

	@When("Admin enter valid credentials  and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
		objlogin.getuserNameText("admin");
		objlogin.getPwdText("pwd123");
		objlogin.mouseClick();
	}

	
	
	
	
	
	@When("Admin clicks forgot username or password link")
	public void admin_clicks_forgot_username_or_password_link() {
		objlogin.clickForgotUnamePwdLink();
	}

	@Then("Admin should land on forgot username or password page")
	public void admin_should_land_on_forgot_username_or_password_page() {
		 String title = objlogin.verifyPageTitle();
		 Assert.assertEquals("Forgot Username or Password Page", title);
	}

	@Then("Admin should see {string} text in gray color")
	public void admin_should_see_text_in_gray_color(String string) {
		 String userTextColor = objlogin.getEmailTextColor();
		
		  String expectedGrayColor = "rgb(128, 128, 128)";
		  Assert.assertEquals(expectedGrayColor, userTextColor, "User text is not displayed in gray color.");
	}

	@Then("Admin should see {string} in text field")
	public void admin_should_see_in_text_field(String string) {
		 String actualText = objlogin.getTextFieldText();
	     Assert.assertEquals("Email", actualText);
	}

	@Then("Admin should see {string}  button")
	public void admin_should_see_button(String string) {
		 boolean isSendLinkDisplayed = objlogin.isSendLinkDisplayed(); 
	        Assert.assertTrue(isSendLinkDisplayed, "Send Link button is not displayed.");
	}

	@Then("Admin should see asterik symbol need Email")
	public void admin_should_see_asterik_symbol_need_email() {
		objlogin.verifyEmailAsterikIsDisplayed();
	}

	@Then("Admin should see send link button in center of the page")
	public void admin_should_see_send_link_button_in_center_of_the_page() {
		
		 boolean isSendButtonCentered = objlogin.isSendLinkButtonCentered(); 
	     Assert.assertTrue(isSendButtonCentered, "Send Link button is not in the center of the page.");
		
	}
	
		
	
	@Given("Admin is in forgot username and password page")
	public void admin_is_in_forgot_username_and_password_page() {
		objlogin.clickForgotUnamePwdLink();
		   String title = objlogin.verifyPageTitle();
		   Assert.assertEquals("Forgot Username or Password Page", title);
	}

	@When("Admin enters valid email id clicks send link button on forgot username or password page")
	public void admin_enters_valid_email_id_clicks_send_link_button_on_forgot_username_or_password_page() {
		objlogin.enterValidEmail("team17@seleniumbrewers.com");
		objlogin.clickSendLink();
	}

	@Then("Admin should receive link in mail for  reset  username or password")
	public void admin_should_receive_link_in_mail_for_reset_username_or_password() {
		boolean emailReceived = objlogin.hasResetLinkEmailArrived();
	    Assert.assertTrue(emailReceived, "Admin should receive the reset link email");
	}

	@When("Admin enters invalid email id clicks send link button on forgot username or password page")
	public void admin_enters_invalid_email_id_clicks_send_link_button_on_forgot_username_or_password_page() {
		objlogin.enterValidEmail("team17@seleniumbrewers.org");
		objlogin.clickSendLink();
	}

	@Then("Admin should not receive link in mail for reset username or password")
	public void admin_should_not_receive_link_in_mail_for_reset_username_or_password() {
		 boolean linkNotReceived = objlogin.resetLinknotreceived();
		 Assert.assertTrue(linkNotReceived, "Admin should not receive the reset link email");
	}

	
	

	
	
	
	
	@When("Admin clicks reset password link")
	public void admin_clicks_reset_password_link() {
		objlogin.clickResetPwdLink();
	}

	@Then("Admin should land on reset password page")
	public void admin_should_land_on_reset_password_page() {
		 String title = objlogin.verifyPageTitle();
		 Assert.assertEquals("Reset Password Page", title);
	}

	@Then("Admin should see submit button in center of the page")
	public void admin_should_see_submit_button_in_center_of_the_page() {
		objlogin.verifyInputFieldCentered();
	}

	@Then("Admin should see two text box")
	public void admin_should_see_two_text_box() {
		boolean areTextFieldsVisible = objlogin.areTextFieldsVisible();   
	     Assert.assertTrue(areTextFieldsVisible, "Two text fields should be visible");
	}

	@Then("Admin should see {string} in the first label text")
	public void admin_should_see_in_the_first_label_text(String expText) {
		String actualText = objlogin.getNewPwdText();
	     Assert.assertEquals(expText, actualText);
	}

	@Then("Admin should see {string} in the second label text")
	public void admin_should_see_in_the_second_label_text(String expText) {
		String actualText = objlogin.getRetypePwdText();
	     Assert.assertEquals(expText, actualText);
	}

	@Then("Admin should see text box in disabled state")
	public void admin_should_see_text_box_in_disabled_state() {
		boolean isTextBoxDisabled = objlogin.isTextBoxDisabled();
	    Assert.assertTrue(isTextBoxDisabled, "Text box is not in a disabled state.");
	}
	
	
	
	
	
	@Given("Admin reset password page")
	public void admin_reset_password_page() {
		objlogin.clickResetPwdLink();
	}

	@When("Admin clicks on type in new password field")
	public void admin_clicks_on_type_in_new_password_field() {
		objlogin.clickTypeNewPasswordField();
	}

	@Then("Admin should see text box is enabled state")
	public void admin_should_see_text_box_is_enabled_state() {
		boolean isTextBoxEnabled = objlogin.isTypeNewPasswordTextBoxEnabled();
	    Assert.assertTrue(isTextBoxEnabled, "Text box is not in an enabled state.");
	}

	@When("Admin clicks on retype password field")
	public void admin_clicks_on_retype_password_field() {
		objlogin.clickRetypePasswordField();
	}

	@When("Admin enters same password on both field and clicks submit button")
	public void admin_enters_same_password_on_both_field_and_clicks_submit_button() {
		objlogin.enterSamePasswordInFieldsAndSubmit();
	}

	@Then("Admin should recieve  : {string}. Please click here to login")
	public void admin_should_recieve_please_click_here_to_login(String expectMsg) {
		String actualMessage = objlogin.getResetPasswordConfirmationMessage(); 
	    Assert.assertEquals(expectMsg, actualMessage);
	}

	@When("Admin enters same password on both field with invalid details and clicks submit button")
	public void admin_enters_same_password_on_both_field_with_invalid_details_and_clicks_submit_button() {
		objlogin.enterInvalidPasswordInFieldsAndSubmit();
	}

	@Then("Error message {string}")
	public void error_message(String errorMsg) {
		String actualErrorMessage = objlogin.getErrorMessage(); 
	    Assert.assertEquals(errorMsg, actualErrorMessage);
	}

	@When("Admin enters  empty details on both fieldand clicks submit button")
	public void admin_enters_empty_details_on_both_fieldand_clicks_submit_button() {
		objlogin.clickTypeNewPasswordField();
		objlogin.clickRetypePasswordField();
		objlogin.clickSubmitBtn();
	}

	@When("Admin enters  mismatch values and clicks submit button")
	public void admin_enters_mismatch_values_and_clicks_submit_button() {
		objlogin.enterMismatchpwdAndClickSubmit();
	}
	
}
