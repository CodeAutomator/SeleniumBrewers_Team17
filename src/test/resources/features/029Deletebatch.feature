@Deleteprogramdeati
Feature: Delete Batch

Background: 
Given Logged on the LMS portal
When Admin is on dashboard page after Login
And Admin clicks "Batch" from navigation bar 

@Test_suit_batch01
  Scenario: Validate row level delete icon
    Given Batch_The delete icon on row level in data table is enabled
    When Batch_Admin clicks on the delete icon
    Then Alert appears with yes and No option
    
@Test_suit_batch02
  Scenario: Validate accept alert
    Given Batch_Admin clicks the delete icon
    When You click yes option
    Then Batch deleted alert pops and batch is no more available in data table
    
@Test_suit_batch03
  Scenario:Validate reject alert
    Given Batch_Admin clicks the delete icon
    When You click no option
    Then Batch is still listed in data table