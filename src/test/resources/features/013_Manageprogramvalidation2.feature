@programvalidationpart2
Feature: Manage program validation

Background: 
	Given Logged on the LMS portal
	When Admin is on dashboard page after Login
	Then Admin clicks Program from navigation bar


@Test_suit_program13
  Scenario: Search Program By Name
    Given Admin is on Manage Program Page
    When Admin enters <Program name> into search box.
    Then Admin should see the Programs displayed based on the Program Name
  
@Test_suit_program14
  Scenario: Search Program By Description
    Given Admin is on Manage Program Page
    When Admin enters <Program description phrase> into search box
    Then Admin should see the Programs displayed based on the Program Description 
    
@Test_suit_program15
  Scenario: Search Program By Status
    Given Admin is on Manage Program Page
    When Admin enters <Program status phrase> into search box.
    Then Admin should see the Programs displayed based on the Program Status  
    
@Test_suit_program16
  Scenario: Validating the Search with unrelated keyword
    Given Admin is on Manage Program Page
    When Admin enters the "keywords" not present in the data table on the Search box 
    Then Admin should see zero entries on the data table