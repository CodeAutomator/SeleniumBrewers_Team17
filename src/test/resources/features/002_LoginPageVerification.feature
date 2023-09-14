@HomePage

Feature: Login page Validation


Background: Admin gives the correct LMS portal URL
   Given Admin is in home page
    When Admin clicks Login button

  @LoginPage
  Scenario: Verify the login page
    Then Admin should land on the login page 
   
   @BrockenLink 
   Scenario: Verify for broken link
		Then Login_HTTP response >= 400. Then the link is broken
    
  @LoginHeader
  Scenario: Verify the header of the login page
  Then Admin should see "Please login to LMS application" in the header
   
  @TextSpelling  
 	Scenario: Verify the text spelling in login page 
	Then Admin should see correct spellings in all fields  
    
  @LoginUserNameText
  Scenario: Verify text on the first text field
    Then Admin should see "user" in the first text field
    
   @LoginTextfield
  Scenario: Verify text field is present
    Then Admin should see two text field
    
  @AsterikToUser
  Scenario: Verify asterik next to user text
	Then Admin should see * symbol next to user text
    
  @LoginPasswordText
  Scenario: Verify text on the second text field
    Then Admin should "password" in the second text field
    
  @AsterikToPassword
  Scenario: Verify asterik next to password text
	Then Admin should see * symbol next to password text
    
  @LoginTextFieldsAlignment
  Scenario: Verify the alignment input field for the login
   Then Admin should see input field on the centre of the page
    
   @LoginButtonPresent
  Scenario: verify Login is present
  Then Admin should see login button 
  
  @LoginButtonAlignment
  Scenario: Verify the alignment of the login button
  Then Admin should see login button on the centre of the page 
  
  @LoginForgotUsernameOrPassword
  Scenario: Verify forgot username or password link
  Then Admin should see forgot username or password link  
  
   @LoginResetPassword
  Scenario: Verify the alignment of the login button
  Then Admin should see reset password link 
  
   @LoginDescriptivetestUser
  Scenario: Verify the alignment of the login button
  Then Admin should see user in gray color
  
   @LoginDescriptivetestPassword
  Scenario: Verify the alignment of the login button
  Then Admin should see password in gray color
  