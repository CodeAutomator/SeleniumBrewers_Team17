@Editbatches
Feature: Edit Batch

Background: 
Given Logged on the LMS portal
When Admin is on dashboard page after Login
And Admin clicks "Batch" from navigation bar 


@Test_suit_batch01
  Scenario: Validate row level edit icon
    Given Batch_The edit icon on row level in data table is enabled
    When Admin clicks the edit icon to validate row level edit icon
    Then A new pop up with Batch details appears
    
@Test_suit_batch02
  Scenario: Check if the fields are updated
    Given Batch_Admin clicks the edit icon
    When Update the fields with valid values 
    And  click save
    Then The updated batch details should appear on the data table
    

@Test_suit_batch03
  Scenario: Check if the update throws error with invalid valued
Given Batch_Admin clicks the edit icon
    When Update the fields with invalid values 
    And  click save
    Then Batch_Error message should appear
    
@Test_suit_batch04
  Scenario: Check if you get error message when mandatory fields are erased
    Given Batch_Admin clicks the edit icon
    When Batch_Erase data from mandatory field
    And  click save
    Then Batch_Error message should appear
    
@Test_suit_batch05
  Scenario: Check if description field is optional in update
   Given Batch_Admin clicks the edit icon
    When Erase data from description field
    And  click save
    Then The updated batch details should appear on the data table