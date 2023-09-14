package page_objects;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import org.openqa.selenium.interactions.Action;


import webdriver_manager.DriverManager;

public class LoginPage {
	private static LoginPage objLoginPage;
	public static WebDriver driver = DriverManager.getDriver();
	
	
	@FindBy(xpath="//h2[contains(text(), 'Please login to LMS application')]")WebElement loginPageTitle;
	@FindBy(xpath = "//input[@id='id_username']") WebElement userName;
	@FindBy(xpath = "//input[@id='id_password']") WebElement password;
	@FindBy (xpath = "//input[@type = 'symbol']") WebElement userAsterik;
	@FindBy (xpath = "//input[@type = 'symbol']") WebElement pwdAsterik;
	@FindBy (xpath="//input[@type='submit'] ")WebElement login_btn;
	//@FindBy(xpath = "//header[@id='header-id']") WebElement header;
	@FindBy (xpath = "//*[contains(text(),'forget username_Password')]") WebElement forgetUnamePwsdLink;
	@FindBy (xpath="//*[contains(text(),'Reset Password)]") WebElement ResetPwdLink;
	@FindBy (xpath = "//*[@class='alert alert-primary']") WebElement Message;
		@FindBy (xpath = "//input[@type = 'text']") WebElement email;
	@FindBy (xpath ="//button[text()='Send Link']") WebElement sendLinkBtn;
	@FindBy (xpath = "//input[@type = 'symbol']") WebElement emailAsterik;

	@FindBy (xpath = "//input[@type = 'retype-password']") WebElement reTypePwd;
	@FindBy (xpath = "//input[@type = 'password']") WebElement newPwd;
	@FindBy (xpath ="//button[text()='Send Link']") WebElement submitBtn;
	@FindBy(id = "headerElementId") WebElement headerElement;
	@FindBy (xpath ="//button[text()='Send Link']") WebElement submitBtnText;
	@FindBy (xpath = "//input[@type = 'retype-password']") WebElement reTypePwdText;
	@FindBy (xpath = "//input[@type = 'password']") WebElement pwdText;
	@FindBy (xpath= "//a[@href='/reset-password']") WebElement resetPwd;
	@FindBy (xpath ="//button[text()='Confirmation message']") WebElement pwdResetSuccessMsg;
	
	
public  LoginPage() {
		
		PageFactory.initElements(driver, this);
	
	}
 	//this method prevents second object creation for the same type, Singleton pattern lazy loading
 			public static LoginPage getInstance()
 			
 			{
 				if(objLoginPage==null) {
 					objLoginPage = new LoginPage();		
 				}		
 				return objLoginPage;		
 			}
 			
 			public void verifyLoginPageTitle() {

 				String title = driver.getTitle();
 				Assert.assertEquals("Please login to LMS application", title);
 				System.out.println("Admin is on " + title + "page");
 			}
 			
 			public String getLoginPageHeaderText() {
 				return loginPageTitle.getText();
 			}
 			
 			public boolean isLinkBroken(String url, int expectedRespCode) {
 		        try {
 		            CloseableHttpClient httpClient = HttpClients.createDefault();
 		            HttpGet httpGet = new HttpGet(url);
 		            HttpResponse response = httpClient.execute(httpGet);
 		            int actualRespCode = response.getStatusLine().getStatusCode();
 		            return actualRespCode >= expectedRespCode;
 		        } catch (Exception e) {
 		          
 		            return true; 
 		        }
 		    }
 			public boolean textFieldsVisible() {	           
 		        return userName.isDisplayed() && password.isDisplayed();
 		    }
 			
			/*
			 * public String getuserNameText() { return userName.getAttribute("value"); }
			 */
 			
 			public String getuserNameText(String uname) {
 				userName.sendKeys(uname);
				return uname;
 			}
 			public String getPwdText(String pwd) {
 				password.sendKeys(pwd);
				return pwd;
 			}
 			public void verifyUserAsterikIsDisplayed() {
 		        
 	 		     
 		        if (userAsterik.isDisplayed()) {
 		            System.out.println("The * symbol next to user text is displayed.");
 		        } else {
 		            System.out.println("The * symbol next to user text is not displayed.");
 		            
 		        }
 		    }
 			
 			public void verifyPwdAsterikIsDisplayed() {
 		        
 		     
 		        if (pwdAsterik.isDisplayed()) {
 		            System.out.println("The * symbol next to password text is displayed.");
 		        } else {
 		            System.out.println("The * symbol next to password text is not displayed.");
 		            
 		        }
 		    }
 			public boolean isLoginButtonVisible() {
 				return login_btn.isDisplayed();
 			}
 			public void clickLoginBtn() {
 				login_btn.click();
 			}
 			
 			
 			 public void logout() {
 				login_btn.click();
 		    }
 			
 			 public boolean isLoginButtonCentered() {
 		        
 		            int buttonCenterX = login_btn.getLocation().getX() + (login_btn.getSize().getWidth() / 2);
 		            int windowCenterX = driver.manage().window().getSize().getWidth() / 2;
 		            int tolerance = 10; 
 		            return Math.abs(buttonCenterX - windowCenterX) <= tolerance;
 		        }

				/*
				 * public void validateTextbox() { action.isEnabled(driver, userName);
				 * action.isEnabled(driver, password);
				 }*/

 			
 			public void validatePositionOfFields() {
 				int idx1 = userName.getLocation().x;
 				int idx2 = password.getLocation().y;
 				Assert.assertEquals(idx1, idx2);
 			}
 			
			/*
			 * public void validatePositionOfLoginButton() { int idx1 =
			 * login_btn.getLocation().x; int idx2 = login_btn.getLocation().y;
			 * Assert.assertEquals(idx1, idx2); }
			 */
 			 public boolean isForgotLinkDisplayed() {
 		        return forgetUnamePwsdLink.isDisplayed();
 		        
 		    }
 		 
 		 public boolean resetPwdLinkDisplayed() {
 		        return ResetPwdLink.isDisplayed();
 		        
 		    }

 		 
 		 public String getUserTextColor() {
 	        return userName.getCssValue("color");
 	 }
 	 public String getPwdTextColor() {
 	        return password.getCssValue("color");
 	 }
 	
 	 public void verifyInputFieldCentered() {
		 WebElement inputField = getYourInputField();
		 	
	        Point inputFieldLocation = inputField.getLocation();
	        Dimension inputFieldSize = inputField.getSize();

	     
	        Dimension windowSize = driver.manage().window().getSize();

	        int windowCenterX = windowSize.getWidth() / 2;
	        int windowCenterY = windowSize.getHeight() / 2;
	       
	        int expectedInputFieldCenterX = inputFieldLocation.getX() + (inputFieldSize.getWidth() / 2);
	        int expectedInputFieldCenterY = inputFieldLocation.getY() + (inputFieldSize.getHeight() / 2);

	        int tolerance = 5; 
	        Assert.assertTrue(Math.abs(expectedInputFieldCenterX - windowCenterX) <= tolerance);
	        Assert.assertTrue(Math.abs(expectedInputFieldCenterY - windowCenterY) <= tolerance);
			 
	 }
 			
 			 public void enterUsername() {
 				
 			    }
 			 	public void loginWithValidCredentials() 
 			 	{

 			 	}
 			 	 public void enterpassword() {
 					
 					 	       
 				    }
 				   
 			 	public void loginWithInvalidCredentials() {
	
 			 	}
 			 	
 			 	public void validateDashboardPage() {
 	 				String dashboardTitle = driver.getTitle();
 	 				Assert.assertEquals("DashBoard",dashboardTitle);
 	 			}
 	 			
 	 			public String Message(String expectedmsg) {

 	 				return Message.getText();

 	 			}
 	 			
 				
 	 			public void keyboardClick() {
					
 	 				Actions actions  = new Actions(driver);
 	 				actions.sendKeys(login_btn, Keys.ENTER).perform();
 	 				
 	 			}
 	 			public void mouseClick() {
 	 				
 	 				Actions actions = new Actions(driver);
 	 				 /* perform a mouse click on the search button */
 	 	            actions.click(login_btn).build().perform();
 	 	            
 	 	            
 	 			}
 	 			 public void clickResetPwdLink() {
 	 	   	        
 	 				ResetPwdLink.click();;
 	 		    }
 	 			
 	 			
 	 			
 	 			 public void clickForgotUnamePwdLink() {
 	 				forgetUnamePwsdLink.click();
 	 			 }
 	 			 public String verifyPageTitle() {
 	 					return driver.getTitle();
 	 				}

 	 			public String verifyForgotPage() {
 	 				return driver.getTitle();
 	 			}
 	 			public String getEmailTextColor() {
 	 		        return email.getCssValue("color");
 	 		 }
 	 			public String getTextFieldText() {
 	 		        return email.getAttribute("value");
 	 		    }
 	 			 public boolean isSendLinkDisplayed() {
 	 			        return sendLinkBtn.isDisplayed();
 	 			        
 	 			    }
 	 			 
 	 			public boolean isSendLinkButtonCentered() {
 	 		        
 		            int buttonCenterX = sendLinkBtn.getLocation().getX() + (sendLinkBtn.getSize().getWidth() / 2);
 		            int windowCenterX = driver.manage().window().getSize().getWidth() / 2;
 		            int tolerance = 10; 
 		            return Math.abs(buttonCenterX - windowCenterX) <= tolerance;
 		        }
 	 			 public void clickSendLink() {
 	 					sendLinkBtn.click();
 	 				 }
 	 			 public void verifyEmailAsterikIsDisplayed() {
 	 			        
 	 			        // Check if the * symbol element is displayed
 	 			        if (emailAsterik.isDisplayed()) {
 	 			            System.out.println("The * symbol next to user text is displayed.");
 	 			        } else {
 	 			            System.out.println("The * symbol next to user text is not displayed.");
 	 			            
 	 			        }
 	 			    }
 	 			 public WebElement getInputField() {
 	 			        return email;
 	 			    }
 	 			 
 	 			 public void enterValidEmail(String emailid) {
 	 			    	email.sendKeys(emailid);
 	 		      }
 	 			 public boolean hasResetLinkEmailArrived() {
 	 			        
 	 			        return true; 
 	 			    }
 	 			 public void enterInvalidEmail(String emailid) {
 	 			    	email.sendKeys(emailid);
 	 		   }
 	 			 public boolean resetLinknotreceived() {
 	 			        
 	 			        return true; 
 	 			    }		
 	 			public void clickSubmitBtn() {
 	 				submitBtn.click();
 	 			 }
 	 			 public String submittext() {
 				    return submitBtn.getText();
 				}
 	 			 public boolean areSpellingsCorrectInAllFields() {
 			        boolean isSpellingCorrect = true;

 			      
 			        String headerText = headerElement.getText();
 			        String submitButtonText = submitBtnText.getText();
 			        String firstTextBoxPlaceholder = pwdText.getAttribute("placeholder");
 			        String secondTextBoxPlaceholder = reTypePwdText.getAttribute("placeholder");

 			        
 			        if (!headerText.equals("Reset Password") ||
 			            !submitButtonText.equals("Submit") ||
 			            !firstTextBoxPlaceholder.equals("Type in new Password") ||
 			            !secondTextBoxPlaceholder.equals("ReType Password")) {
 			            isSpellingCorrect = false;
 			        }

 			        return isSpellingCorrect;
 			    }
 	 			 
 	 			 public boolean issubmitBtnDisplayed() {
 			        return submitBtn.isDisplayed();
 			        
 			    }
 			    public boolean areTextFieldsVisible() {	           
 			        return newPwd.isDisplayed() && reTypePwd.isDisplayed();
 			    }
 			    public WebElement getYourInputField() {
 			        return submitBtn;
 			    }
 			    public String getNewPwdText() {
 			        return pwdText.getText();
 			    }
 			    public String getRetypePwdText() {
 			        return reTypePwdText.getText();
 			    }
 			    public boolean isTextBoxDisabled() {
 			        return !newPwd.isEnabled();
 			    }
 			    public void clickTypeNewPasswordField() {
 			        newPwd.click();
 			    }
 			    public boolean isTypeNewPasswordTextBoxEnabled() {
 			        return newPwd.isEnabled();
 			    }
 			    public boolean isRetypePasswordTextBoxEnabled() {
 			        return reTypePwd.isEnabled();
 		   
 			}
 			    public void clickRetypePasswordField() {
 			        reTypePwd.click();
 			    }
 			    public void enterSamePasswordInFieldsAndSubmit() {
 			        String password = "auto123@"; 
 			        newPwd.sendKeys(password);
 			        reTypePwd.sendKeys(password);
 			        submitBtn.click();
 			    }
 			    public String getResetPasswordConfirmationMessage() {
 			        return pwdResetSuccessMsg.getText();
 			    }
 				
 			    public void enterInvalidPasswordInFieldsAndSubmit() {
 			        String password = "user123"; 
 			        newPwd.sendKeys(password);
 			        reTypePwd.sendKeys(password);
 			        submitBtn.click();
 			    }
 			    public String getErrorMessage() {
 			        return Message.getText();
 			    }
 			    public void enterMismatchpwdAndClickSubmit() {
 			        	        
 			        newPwd.sendKeys("admin123@"); 
 			        reTypePwd.sendKeys("@admin"); 

 			        submitBtn.click();
 			    }
}
