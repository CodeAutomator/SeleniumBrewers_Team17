@Addbatch

Feature: Add new Batch

Background: 
Given Logged on the LMS portal
When Admin is on dashboard page after Login
And Admin clicks "Batch" from navigation bar 
And Admin clicks "+ A New Batch" button

@Test_suit_batch01
  Scenario: Check if the fields exist in pop
    Given A new pop up with Batch details appears
    When Admin clicks "Batch" from navigation bar
    Then The pop up should include the fields Name, Numberofclasses and Description as textbox,status as radio button,programname
    
@Test_suit_batch02
  Scenario: Check if description is optional field
    Given A new pop up with Batch details appears
    When Fill in all the fields except description with valid values
		And click save
    Then The newly added batch should be present in the data table in Manage Batch page
   
    
    
@Test_suit_batch03
  Scenario: Check if the program details are added in data table
    Given A new pop up with Batch details appears
    When Fill in all the fields with valid values
		And click save
    Then The newly added batch should be present in the data table in Manage Batch page
    
@Test_suit_batch04
  Scenario: Check for error messages for invalid fields
    Given A new pop up with Batch details appears
    When Batch_any of the fields have invalid values
    Then Batch_Error message should appear
    
@Test_suit_batch05
  Scenario: Check for error messages for mandatory fields
    Given A new pop up with Batch details appears
    When Batch_Any of the mandatory fields are blank
    Then Batch_Error message should appear