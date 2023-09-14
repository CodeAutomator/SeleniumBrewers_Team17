@Editprogram

Feature: Edit Program Details

Background: 
	Given Logged on the LMS portal
	When Admin is on dashboard page after Login
	Then Admin clicks Program from navigation bar


@Test_suit_program01
  Scenario: Validate Edit Feature
    Given Admin is on Manage Program Page
    When Admin clicks <Edit> button on the data table for any row
    Then Admin should see a popup open for Program details to edit 