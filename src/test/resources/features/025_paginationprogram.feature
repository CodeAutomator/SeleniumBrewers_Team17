@Paginationprogram

Feature: Pagination Program

Background: 
Background: 
	Given Logged on the LMS portal
	When Admin is on Manage Program page after Login

@Test_suit_program01
  Scenario: Verify Next page link
    Given Admin is on Manage Program Page
    When Admin clicks Next page link on the program table 
    Then Admin should see the Pagination has "Next" link
    
@Test_suit_program02
  Scenario: Verify Last page link
    Given Admin is on Manage Program Page
    When Admin clicks Last page link
    Then Admin should see the last page record on the table with Next page link are disabled
    
@Test_suit_program03
  Scenario: Verify First page link
    Given Admin is on last page of Program table
    When Admin clicks First page link
    Then Admin should see the previous page record on the table with pagination has previous page link
    
@Test_suit_program04
  Scenario: Verify Start page link
    Given Admin is on Previous Program page 
    When Admin clicks Start page link
    Then Admin should see the very first page record on the table with Previous page link are disabled