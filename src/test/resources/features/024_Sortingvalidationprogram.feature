@sortingvalidation

Feature: Sorting(Data Ordering) Validation
Background: 
	Given Logged on the LMS portal
	When Admin is on Manage Program page after Login
	Then Admin clicks Program from navigation bar

@Test_suit_program01
  Scenario: Validates Sorting(data ordering) on the Program Data table
    Given Admin is on Manage Program Page
    When Admin clicks the sort icon of program name column
    Then The data get sorted on the table based on the program name column values in ascending order
    
    
@Test_suit_program02
  Scenario: Validates Sorting(data ordering) on the Program Data table
    Given The data is in the ascending order on the table based on Program Name column
    When Admin clicks the sort icon of program name column
    Then The data get sorted on the table based on the program name column values in descending order
    
@Test_suit_program03
  Scenario: Validates Sorting(data ordering) on the Program Data table
    Given Admin is on Manage Program Page
    When Admin clicks the sort icon of program Desc column
    Then The data get sorted on the table based on the program description column values in ascending order
    
@Test_suit_program04
  Scenario: Validates Sorting(data ordering) on the Program Data table
    Given The data is in the ascending order on the table based on Program Description column
    When Admin clicks the sort icon of program Desc column
    Then The data get sorted on the table based on the program description column values in descending order
    
@Test_suit_program05
  Scenario: Validates Sorting(data ordering) on the Program Data table
    Given Admin is on Manage Program Page
    When Admin clicks the sort icon of program Status column
    Then The data get sorted on the table based on the program status column values in ascending order
    
@Test_suit_program06
  Scenario: Validates Sorting(data ordering) on the Program Data table
    Given The data is in the ascending order on the table based on Program Status column
    When Admin clicks the sort icon of program Status column
    Then The data get sorted on the table based on the program status column values in descending order