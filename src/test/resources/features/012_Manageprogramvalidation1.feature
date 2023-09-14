@programvalidationpart1
Feature: Manage program validation

Background: 
Given Logged on the LMS portal
Given Program_Admin is on dashboard page after Login



@Test_suit_program01
  Scenario: Validate landing in Program page
    #Given Program_Admin is on dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see URL with "Manage Program"
   

@Test_suit_program02
  Scenario: Validate the heading
    #Given Program_Admin is on dashboard page after Login  
     When Admin clicks "Program" on the navigation bar
    Then Admin should see a heading with text "Manage Program" on the page

  
@Test_suit_program03
  Scenario: Validate the text and pagination icon below the data table
    #Given Program_Admin is on dashboard page after Login  
     When Admin clicks "Program" on the navigation bar
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon

  
@Test_suit_program04
  Scenario: Validate the footer
    #Given Program_Admin is on dashboard page after Login  
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the footer as "In total there are z programs"
    
@Test_suit_program05
  Scenario: Validating the default state of Delete button
        #Given Program_Admin is on dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see a Delete button on the top left hand side as Disabled

@Test_suit_program06
  Scenario: Validate Add New Program 
    #Given Program_Admin is on dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see a "+A New Program" button on the program page above the data table
    
    
@Test_suit_program07
  Scenario: Validate that number of records (rows of data in the table) displayed
    #Given Program_Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
    Then Admin should see the number of records (rows of data in the table) displayed on the page are 5
    
@Test_suit_program08
  Scenario: Verify data table on the Program page
    #Given Program_Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
    Then Admin should see data table on the Manage Program Page with column headers like Program Name, Program Description, Program Status, Edit,Delete
 
@Test_suit_program09
  Scenario: Verify Sort arrow icon on the data table
        #Given Program_Admin is on dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the sort arrow icon beside to each column header except Edit and Delete   
    
@Test_suit_program10
  Scenario: Verify Check box on the data table
    #Given Program_Admin is on dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see check box on the left side in all rows of the data table   
    
@Test_suit_program11
  Scenario: Verify Edit and Delete buttons
   #Given Program_Admin is on dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the Edit and Delete buttons on each row of the data table    
     
@Test_suit_program12
  Scenario: Verify Search bar on the Program page
   #Given Program_Admin is on dashboard page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see Search bar with text as "Search..."   
    


        
    
     