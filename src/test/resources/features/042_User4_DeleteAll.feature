@User
Feature: User 
		Background: 
		Given Logged on the LMS portal
		When User_Admin is on dashboard page after Login
		Then Admin clicks User from navigation bar

    @TestUser26
    Scenario: Validate the delete icon below the header 
    Given None of the checkboxes in data table are selected
    Then The delete icon under the Manage User header should be disabled
    
    @TestUser27
    Scenario: Check for single row delete
    Given One of the checkbox in a row is selected
    When Click delete icon below Manage User header	
    Then The respective row in the data table is deleted
   
    @TestUser28
    Scenario: Check for multi row delete
    Given Two or more checkboxes in rows are selected
    When Click delete icon below Manage User header	
    Then The respective row in the data table is deleted
