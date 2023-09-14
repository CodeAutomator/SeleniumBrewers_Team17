@User
Feature: User 
	Background: 
	Given Logged on the LMS portal
	When User_Admin is on dashboard page after Login
	Then Admin clicks User from navigation bar

    @TestUser13
    Scenario: Check if the fields exist in pop
    Given A new pop up with user details appears
    Then The pop up should include the fields First Name,Middle name, Last Name, Location phone, email,linkedin Url,Undergraduate,postgraduate,time zone and user comments as text box User Role, Role status, visa status as drop down

	  @TestUser14
    Scenario: Check if Middle name, linkedIn url, email, user comments.under graduate,post graduate,time zone are optional
    Given A new pop up with user details appears
    When Fill in all the fields except optional fields with valid values and click submit	
    Then The newly added user should be present in the data table in Manage User page
     
   	@TestUser15
    Scenario: Check if the program details are added in data table 
    Given A new pop up with user details appears
    When Fill in all the fields with valid values and click submit	
    Then The newly added user should be present in the data table in Manage User page  
    			  
   	@TestUser16
    Scenario: Check for error messages for invalid fields
    Given A new pop up with user details appears
    When User_any of the fields have invalid values
    Then User_Error message should appear
    
   	@TestUser17
    Scenario: Check for error messages for mandatory fields
    Given A new pop up with user details appears
    When User_Any of the mandatory fields are blank
    Then User_Error message should appear
    