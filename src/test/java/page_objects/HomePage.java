package page_objects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import constants.Constants;

//import dev.failsafe.internal.util.Assert;
import webdriver_manager.DriverManager;

public class HomePage {
	
	public static WebDriver driver = DriverManager.getDriver();
	private static HomePage objHomePage;
	
	
	@FindBy(id = "login-button") WebElement loginButton;
	@FindBy(xpath = "//html")  WebElement htmlEle;
	@FindBy (xpath ="//a[@class='navbar-brand']") WebElement homepage;
	@FindBy (xpath="//img[@title='LMS logo']") WebElement logoImage;
	@FindBy(id = "headerElementId") WebElement header_Element;
	 
		public  HomePage() {
			
			PageFactory.initElements(driver, this);
		}
	 	//this method prevents second object creation for the same type, Singleton pattern lazy loading
	 			public static HomePage getInstance()
	 			{
	 				if(objHomePage==null) {
	 					objHomePage = new HomePage();		
	 				}		
	 				return objHomePage;		
	 			}
	 			
	 			public void getHomepage() {
	 				driver.get(Constants.APP_URL);
	 				
	 				
	 			}
	 			
	 			
	 			public void getTitleOfHomepage()
	 			 {
	 				driver.getTitle().contains("Learning Management System");
	 					 				
	 			}
	 			public void InvalidHomeURL()
	 			{
	 				driver.get(Constants.INVALID_URL);
	 				
	 			}
	 			 public int getHTTPResponseCode() {
	 		    	int responseCode = 0;
	 		        try {
	 		            String status = htmlEle.getAttribute("status");
	 		            responseCode = Integer.parseInt(status);
	 		        } 
	 		        catch (Exception e) {
	 		            e.printStackTrace();
	 		        }
	 		        return responseCode;
	 		    }   
	 		         
	 			public Boolean ValidatePageNotFound()
	 			{
	 				if(driver.getTitle().contains("404"))
	 				return true;
	 			else
	 				return false;
					
	 				
	 			}
	 			  public void checkForBrokenLinks() {
	 			        List<WebElement> links = driver.findElements(By.tagName("a"));
	 			        
	 			        for (WebElement link : links) {
	 			            String href = link.getAttribute("href");
	 			            if (href != null && !href.isEmpty()) {
	 			                try {
	 			                  URL url = new URL(href);
	 			                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	 			                    connection.setRequestMethod("HEAD");
	 			                    connection.connect();
	 			                    int responseCode = connection.getResponseCode();
	 			                    if (responseCode >= 400) {
	 			                        System.out.println("Broken link found: " + href + " (Status code: " + responseCode + ")");
	 			                    }
	 			                    connection.disconnect();
	 			                } catch (Exception e) {
	 			                    e.printStackTrace();
	 			                }
	 			            }
	 			        }
	 			    }
	 			 public String logintext() {
	 			    return loginButton.getText();
	 			}
	 			 
	 			 public boolean verifyCorrectSpellings() {
	 		        String text = logintext();
	 		        // Replace with expected spellings
	 		        String expectedText = "Login";
	 		        boolean isFieldCorrect = text.equals(expectedText);
	 		        return isFieldCorrect ;
	 		    }
//	 			public void verifyLogo() {
//	 				
//	 				boolean logoPresent = logoImage.isDisplayed();
//	 				Assert.assertTrue(logoPresent, "LMS");		
//	 			}
	 			
	 			 public boolean isLogoPresent() {
	 		        
	 				return logoImage.isDisplayed(); 
	 		    }
	 			 
	 			public boolean verifyLogoAllignment() {
	 				 int logoX = logoImage.getLocation().getX();
	 		        int headerX = header_Element.getLocation().getX();
	 		        
	 		        boolean isAligned = logoX == headerX;

	 		        return isAligned;
	 			}

	 			public boolean isLoginButtonPresent() {
	 		       
	 				return loginButton.isDisplayed(); 
	 		    }

	 			
	 				 			
	 			public void ClickOnLoginBtn()
	 			{
	 				loginButton.click();
	 				
	 			}
	 			
	 			
	 			
}
