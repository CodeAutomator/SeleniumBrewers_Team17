@Navigationvalidtaionprogram

Feature: Navigation Validation from Manage Program to other Pages

Background: 
	Given Logged on the LMS portal
	When Program_Admin is on dashboard page after Login
	Then Admin clicks Program from navigation bar

@Test_suit_program01
  Scenario: Student link on navigation bar
    Given Admin is on Manage Program Page
    When Admin clicks on Student link on Manage Program page
    Then Admin is re-directed to Student page
    
@Test_suit_program02
  Scenario: Batch link on navigation bar
    Given Admin is on Manage Program Page
    When Admin clicks "Batch" from navigation bar
    Then Admin is re-directed to Batch page
    
@Test_suit_program03
  Scenario: Class link on navigation bar
    Given Admin is on Manage Program Page
    When Admin clicks on Class link on Manage Program page
    Then Admin is re-directed to Class page
    
@Test_suit_program04
  Scenario: User link on navigation bar
    Given Admin is on Manage Program Page
    When Admin clicks on User link on Manage Program page
    Then Admin is re-directed to User page
    
@Test_suit_program05
  Scenario: Assignment link on navigation bar
    Given Admin is on Manage Program Page
    When Admin clicks on Assignment link on Manage Program page
    Then Admin is re-directed to Assignment page
    
@Test_suit_program06
  Scenario: Attendance link on navigation bar
    Given Admin is on Manage Program Page
    When Admin clicks on Attendance link on Manage Program page
    Then Admin is re-directed to Attendance page
    
@Test_suit_program07
  Scenario: Logout link on navigation bar
    Given Admin is on Manage Program Page
    When Admin clicks on Logout link on Manage Program page
    Then Admin is re-directed to Login page