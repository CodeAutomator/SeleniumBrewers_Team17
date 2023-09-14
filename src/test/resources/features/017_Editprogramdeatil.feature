@Editprogramdeatil

Feature: Edit Program Details
Background: 
	Given Logged on the LMS portal
	When Admin is on Manage Program page after Login
	Then Admin clicks Program from navigation bar
    
@Test_suit_program01
  Scenario: Edit Program Name
    Given Admin is on Program Details Popup window to Edit
    When Admin edits the Name column and clicks save button
    Then Admin gets a message "Successful Program Updated" alert and able to see the updated name in the table for the particular program
      | expectedMessage       | 
      | Successful Program Updated  | 

@Test_suit_program02
  Scenario: Edit Program description
    Given Admin is on Manage Program Page
    When Admin edits the Description column and clicks save button
    Then Admin gets a message "Successful Program Updated" alert and able to see the updated description in the table for the particular program
      | expectedMessage       | 
      | Successful Program Updated  | 
        
@Test_suit_program03
  Scenario: Change Program Status
    Given Admin is on Program Details Popup window to Edit
    When Admin changes the Status and clicks save button
    Then Admin gets a message "Successful Program Updated" alert and able to see the updated status in the table for the particular program
      | expectedMessage       | 
      | Successful Program Updated  | 
          
@Test_suit_program04
  Scenario: Validate invalid values on the text column
    Given Admin is on Program Details Popup window to Edit
    When Admin enters only numbers or special "NumbersORSpecial" char in name and desc column
    Then Admin gets a Error message alert "Alert Message"
      | specialCharacter       | 
      | (W*%)%)^#)^   | 
          
@Test_suit_program05
  Scenario: Validate Cancel button on Edit popup
    Given Admin is on Program Details Popup window to Edit
    When Admin clicks <Cancel>button on edit popup
    Then Admin can see the Program details popup disappears and can see nothing changed for particular program 
    
@Test_suit_program06
  Scenario: Validate Save button on Edit popup
    Given Admin is on Program Details Popup window to Edit
    When Admin clicks <Save>button on edit popup
    Then Admin gets a message "Successful Program Updated" alert and able to see the updated details in the table for the particular program
      | expectedMessage       | 
      | Successful Program Updated   |  
    