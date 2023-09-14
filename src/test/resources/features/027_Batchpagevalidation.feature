@Batchvalidation

Feature: Batch Page Validation

Background: 
Given Logged on the LMS portal

@Test_suit_batch01
  Scenario: Validate landing in Batch page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin should see the "Manage Batch" in the URL
    
@Test_suit_batch02
  Scenario: Validate header in the Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin should see the "Manage Batch" in the header
    
    
@Test_suit_batch03
  Scenario: Validate pagination in the Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Batch_Admin should see the pagination controls under the data table
    
@Test_suit_batch04
  Scenario: Validate data table headers in the Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes, Program Name, EditDelete
    
@Test_suit_batch05
  Scenario: Validate Delete button in Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin should be able to see the "Delete" icon button that is disabled
    
@Test_suit_batch06
  Scenario: Validate "+ A New batch" in Batch Page
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Admin should be able to see the "+ A New batch" button
    
@Test_suit_batch07
  Scenario: Validate data rows
    Given Admin is on dashboard page after Login
    When Admin clicks "Batch" from navigation bar
    Then Each row in the data table should have a checkbox,edit icon is enabled,delete icon is enabled
    
@Test_suit_batch08
  Scenario: Validate pop up for adding batch
    Given Admin is on dashboard page after Login
    When Admin clicks "+ A New Batch" button
    Then A new pop up with Batch details appears