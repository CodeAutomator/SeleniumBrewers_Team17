@User
Feature: User 
		Background: Given Logged on the LMS portal
	Given User_Admin is on dashboard page after Login	
	
    @TestUser1
    Scenario: Validate landing in User page 
    #Given User_Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar	
    Then Admin should see the Manage User in the URL
    
	  @TestUser2
    Scenario: Validate header in the User Page 
    #Given User_Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar	
    Then Admin should see the Manage User in the header
    
   	@TestUser3
    Scenario: Validate pagination in the User Page 
   	#Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar	
    Then User_Admin should see the pagination controls under the data table
    
   	@TestUser4
    Scenario: Validate data table headers in the User Page 
    #Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar
    Then Admin Should see the data table with headers Id, Name, location, Phone Number, Edit&Delete	
    
   	@TestUser5
    Scenario: Validate Delete button in User Page
    #Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar
    Then Admin should be able to see the Delete icon button that is disabled	
    
   	@TestUser6
    Scenario: Validate "+ A New user" button in User Page 
    #Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar	
    Then Admin should be able to see the + A New User button
    
   	@TestUser7
    Scenario: Validate "+ Assign staff"  button in User page
    #Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar	
    Then Admin should be able to see the + Assign staff button
    
   	@TestUser8
    Scenario: Validate search box in User page 
   	#Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar	
    Then Admin should be able to see the search text box
    
   	@TestUser9
    Scenario: Validate data rows
    #Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar	
    Then Each row in the data table should have a checkbox 
    
   	@TestUser10
    Scenario: Validate data rows
    #Given Admin is on dashboard page after Login	
    When Admin clicks User from navigation bar
    Then Each row in the data table should have a edit icon that is enabled	
    
    @TestUser11
    Scenario: Validate data rows 
    When Admin clicks User from navigation bar
    Then Each row in the data table should have a delete icon that is enabled
    
    @TestUser12
    Scenario: Validate pop up for adding user
    Given User_Admin is on dashboard page after Login and Admin clicks User from navigation bar	
    When Admin clicks + A New User button	
    Then A new pop up with UserDetails appears
    