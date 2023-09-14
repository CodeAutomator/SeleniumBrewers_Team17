@Multipledeleteprogram

Feature: Multiple Delete Program 
Background: 
	Given Admin is on Manage Program page after Login
	 When Admin clicks Multiple checkbox in the data table
	 Then Delete Button on the header Section 
	    
@Test_suit_program04
  Scenario: Validate multiple program deletion by selecting multiple check boxes
    Given Admin is on Confirm Deletion alert
    When Admin clicks <YES> button on the alert
    Then Admin should land on Manage Program page and can see the selected programs are deleted from the data table
    
@Test_suit_program05
  Scenario: Validate multiple program deletion by selecting multiple check boxes
    Given Admin is on Confirm Deletion alert
    When Admin clicks <NO> button on the alert
    Then Admin should land on Manage Program page and can see the selected programs are not deleted from the data table
    