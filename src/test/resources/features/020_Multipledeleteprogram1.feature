@Multipledeleteprogram

Feature: Multiple Delete Program
Background: 
	Given Logged on the LMS portal
	When Program_Admin is on dashboard page after Login
	Then Admin clicks Program from navigation bar
	
@Test_suit_program01
  Scenario: Validate Common Delete button enabled after clicking on any checkbox
    Given Admin is on Manage Program Page
    When Admin clicks any checkbox in the data table
    Then Admin should see common delete option enabled under header Manage Program
