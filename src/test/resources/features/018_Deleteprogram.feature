@Deleteprogramdeatil

Feature: Delete Program

Background: 
	Given Logged on the LMS portal
	When Admin is on dashboard page after Login
	Then Admin clicks Program from navigation bar

@Test_suit_program01
  Scenario: Delete Feature
    Given Admin is on Manage Program Page
    When Admin clicks <Delete> button on the data table for any row 1
    Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion
      | expectedHeading       | 
      | "Confirm" <YES> and <NO> button for deletion  | 
    
@Test_suit_program02
  Scenario: Validate details for Confirm Deletion form
    Given Admin is on Manage Program Page
    When Admin clicks <Delete> button on the data table for any row 1
    Then Admin should see a message for Program Name "Are you sure you want to delete <Program name>?"
      | expectedMessage       | 
      | "Are you sure you want to delete <Program name>?  |      
