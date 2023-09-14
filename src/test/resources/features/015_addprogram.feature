@Addprogram

Feature: Add New Program 

Background: 
	Given Logged on the LMS portal
	When Admin is on Manage Program page after Login
	Then Admin clicks Program from navigation bar

@Test_suit_program01
  Scenario: Empty form submission
    Given Admin is on "Program Details" Popup window
    When Admin clicks <Save> button without entering any data
    Then Admin gets a Error message alert     
    
@Test_suit_program02
  Scenario: Enter only Program Name
    Given Admin is on "Program Details" Popup window
    When Admin enters only "ProgramName" in text box and clicks Save button
    Then Admin gets a message alert 'Description is required'    
      | ProgramName       | 
      | Jan23-Seleniumbrewer-SDET-201-1001   | 
        
@Test_suit_program03
  Scenario: Enter only Program Description
    Given Admin is on "Program Details" Popup window
    When Admin enters only the Program Description "ProgramDescription" in text box and clicks Save button
    Then Admin gets a message alert for Descrption "Name is required"  
      | ProgramDescription       | 
      | Phase II testing   |     
    
@Test_suit_program04
  Scenario: Select Status only
    Given Admin is on "Program Details" Popup window
    When Admin selects only Status and clicks Save button
    Then Admin gets a message alert for Name and Description 'Name and Description required'
           
@Test_suit_program05
  Scenario: Validate invalid values on the text column
    Given Admin is on "Program Details" Popup window
    When Admin enters only "NumbersORSpecial" char in name and desc column
    Then Admin gets a Error message alert for special character
      | specialCharacter       | 
      | (W*%)%)^#)^   | 
    
@Test_suit_program06
  Scenario: Validate Cancel/Close(X) icon on Program Details form
    Given Admin is on "Program Details" Popup window
    When Admin clicks Cancel-Close(X) Icon on Program Details form
    Then Program Details popup window should be closed without saving
     
@Test_suit_program07
  Scenario: Validate Save button on Program Details form
    Given Admin is on "Program Details" Popup window
    When Enter all the required fields with valid values and click Save button
    Then Admin gets a message "Successful Program Created" alert and able to see the new program added in the data table
    
@Test_suit_program08
  Scenario: Validate Cancel button on Program Details form
    Given Admin is on "Program Details" Popup window
    When Admin clicks <Cancel>button 
    Then Admin can see the Program details popup disappears without creating any program
    