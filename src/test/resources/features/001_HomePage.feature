@HomePage
Feature: Home Page Verification of LMS portal
Given Admin launch the browser
When Admin gives the correct LMS portal URL

  @HomePageNavigation
	  Scenario: Verify admin is able to land on home page
	  Then Admin should land on the home page
	   
   @HomPageInvalidUrl
 	Scenario: Verify admin is able to land on home page with invalid URL
	When Admin gives the invalid LMS portal URL
	Then Admin should recieve 404 page not found error 
	
	@HomePageBrocken
	Scenario: Verify for broken link	
	Then HTTP response code should be greater than or equal to 400 indicating broken links

	
	@TextSpelling
	Scenario: Verify the text spelling in the page 
	Then Admin should see correct spellings in all fields
	
	@Logo
	Scenario: Verify the logo of the LMS
	Then Admin should see correct logo of the LMS
	
	@LogoAligned
	Scenario: Verify the logo properly aligned
	Then Admin should see logo is properly aligned
	
    
  @LoginButtonPresent
  Scenario: Verify login button is present 
  Then Admin should see login button 
    
	@LoginButtonClickable
  Scenario: Verify login button is present
  Then Admin should able to click the Login button