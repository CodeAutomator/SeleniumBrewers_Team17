@Addprogram1

Feature: Add New Program 

Background: 
	Given Logged on the LMS portal
	When Admin is on dashboard page after Login
	Then Admin clicks Program from navigation bar

@Test_suit_program01
  Scenario: Validate Program Details Popup window
    Given Admin is on Manage Program Page
    When Admin clicks <A New Program>button
    Then Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window  
  
@Test_suit_program02
  Scenario: Validate input fields and their text boxes in Program details form 
    Given Admin is on Manage Program Page
    When Admin clicks <A New Program>button
    Then Admin should see two input fields and their respective text boxes in the program details window    
       
    
@Test_suit_program03
  Scenario: Validate radio button for Program Status 
    Given Admin is on Manage Program Page
    When Admin clicks <A New Program>button
    Then Admin should see two radio button for Program Status 