@Deleteprogramdeatil1

Feature: Delete Program

Background: 
	Given Logged on the LMS portal
	When Admin is on Manage Program page after Login
	Then Admin clicks Program from navigation bar

@Test_suit_program03
  Scenario: Click Yes on deletion window
    Given Admin is on Confirm Deletion alert
    When Admin clicks <YES> button on the alert
    Then Admin gets a message "Successful Program Deleted" alert and able to see that program deleted in the data table
    
@Test_suit_program04
  Scenario: Click No on deletion window
    Given Admin is on Confirm Deletion alert
    When Admin clicks <NO> button on the alert
    Then Admin can see the deletion alert disappears without deleting
  
@Test_suit_program05
  Scenario: Validate Cancel/Close(X) icon on Confirm Deletion alert
    Given Admin is on Confirm Deletion alert
    When Admin clicks Cancel or Close(X) icon on Deletion alert
    Then Admin can see the deletion alert disappears without any changes