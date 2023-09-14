@Deletemultiplebatches 
Feature: Delete multiple batches 

Background: 
Given Logged on the LMS portal
When Admin is on dashboard page after Login
And Admin clicks "Batch" from navigation bar 

@Test_suit_batch01
  Scenario: Validate the delete icon below the header 
    Given Batch_None of the checkboxes in data table are selected
    Then The delete icon under the Manage Batch header should be disabled
    
@Test_suit_batch02
  Scenario: Check for single row delete
    Given One of the checkbox row is selected
    When Click delete icon below Manage Batch header
    Then Batch_The respective row in the data table is deleted
    
@Test_suit_batch03
  Scenario: Check for multi row delete
    Given Two or more checkboxes/row is selected
    When Click delete icon below Manage Batch header
    Then Batch_The respective row in the data table is deleted