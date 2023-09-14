@Student
Feature: Student 
		Background: 
		Given Logged on the LMS portal as Admin 
    Given Student_Admin is on dashboard page after Login
    
    @TestStudent1
    Scenario: Validate the title of the page 
    #Given Student_Admin is on dashboard page after Login
    When Admin clicks Student on the navigation bar
    Then Admin should see the Student details Page Title
    
		@TestStudent2
    Scenario: Validate response time from dashboard page to student page
    #Given Student_Admin is on dashboard page after Login	
    When Admin clicks Student on the navigation bar	 
    Then Student_Maximum navigation time in milliseconds, defaults to 30 seconds
   
    @TestStudent3
    Scenario: Validate the broken link 
    #Given Student_Admin is on dashboard page after Login
    When Admin clicks Student on the navigation bar
    Then Student_HTTP response >= 400. Then the link is broken
    
    @TestStudent4
    Scenario: Verify LMS title 
    #Given Student_Admin is on dashboard page after Login
    When Admin clicks Student on the navigation bar
    Then Admin should see LMS -Learning management system as title
    
   	@TestStudent5
    Scenario: Verify the alignment of the Student detail title
    #Given Student_Admin is on dashboard page after Login	
    When Admin clicks Student on the navigation bar	
    Then Student Detail title should be in centre of the page
    
    @TestStudent6
    Scenario: Validate drop down is present in the page
    #Given Student_Admin is on dashboard page after Login	
    When Admin clicks Student on the navigation bar	
    Then 2 dropdowns should be present in the page
    
    @TestStudent7
    Scenario: Validate search bar in select student name drop down
    #Given Student_Admin is on dashboard page after Login	
    When Admin clicks Student on the navigation bar	
    Then Admin should see search box inside the drop down 
    
    @TestStudent8
    Scenario: Validate search bar in select batch id drop down
    #Given Student_Admin is on dashboard page after Login	
    When Admin clicks Student on the navigation bar	
		Then Admin should see search box inside batch id drop down

		@TestStudent9
    Scenario: Validate text spelling student name
    #Given Student_Admin is on dashboard page after Login	
    When Admin clicks Student on the navigation bar	
		Then Admin should see correct spelling select student name
		
		@TestStudent10
    Scenario: Validate text spelling select batch id
#		Given Student_Admin is on dashboard page after Login	
		When Admin clicks Student on the navigation bar	
		Then Admin should see correct spelling select batch id text
		
		@TestStudent11
    Scenario: Validate only numbers inside select batch id
#		Given Student_Admin is on dashboard page after Login	
		When Admin clicks Student on the navigation bar	
		Then Admin should see only numbers inside batch id drop down
			
		@TestStudent12
    Scenario: Validate gray color in student name drop down
#		Given Student_Admin is on dashboard page after Login	
		When Admin clicks Student on the navigation bar	
		Then Admin should see select student name in gray color

		@TestStudent13
    Scenario: Validate gray color in student name drop down
#		Given Student_Admin is on dashboard page after Login	
		When Admin clicks Student on the navigation bar	
		Then Admin should see select batch ID in gray color

		@TestStudent14
    Scenario: Validate first drop down label is select student name
#		Given Student_Admin is on dashboard page after Login	
		When Admin clicks Student on the navigation bar	
		Then Admin should see select student name in first

		@TestStudent15
    Scenario: Validate second drop down label is select batch id
#		Given Student_Admin is on dashboard page after Login	
		When  Admin clicks Student on the navigation bar	
		Then Admin should see select batch id in second

		@TestStudent16
    Scenario: Validate scroll down inside student name dropdown
#		Given Student_Admin is on dashboard page after Login	
		When  Admin clicks Student on the navigation bar	
		Then Admin should able to scroll down to select the name

		@TestStudent17
    Scenario: Validate scroll down inside batch id dropdown
#		Given Student_Admin is on dashboard page after Login	
		When  Admin clicks Student on the navigation bar	
		Then Admin should able to scroll down to select the batch id
		    