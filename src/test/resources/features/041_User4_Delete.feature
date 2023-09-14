@User
Feature: User 
		Background: 
		Given Logged on the LMS portal
		When User_Admin is on dashboard page after Login
		Then Admin clicks User from navigation bar

    @TestUser23
    Scenario: Validate row level delete icon 
    Given User_The delete icon on row level in data table is enabled	
    When Admin clicks the delete icon	
    Then Alert appears with yes and No option

	  @TestUser24
    Scenario: Validate accept alert
    Given Admin clicks the DeleteIcon	
    When Admin click yes option	
    Then User deleted alert pops and user is no more available in data table

   	@TestUser25
    Scenario: Validate reject alert 
    Given Admin clicks the delete icon
    When Admin click No option	
    Then User is still listed in data table
