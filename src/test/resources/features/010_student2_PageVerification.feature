@Student
Feature: Student 
	Background: 
	Given Admin is logged in and on the student Details page
		
		@TestStudent18
    Scenario: Validate select student name is fading
		Given Admin is on student details page	
		When Admin select student name from the drop down 
		Then Admin should not see select student name text 
		
		@TestStudent19
    Scenario: Validate select batch id  is fading
		Given Admin is on student details page	
		When Admin select batch id from the drop down 	
		Then Admin should not see select batch id text 
		
		@TestStudent20
    Scenario: Validate select student name using search box
		Given Admin is on student details page	
		When Admin clicks select student name and enters x alphabet in the search box 	
		Then Admin should see student name start with x is listed below
		
		@TestStudent21
    Scenario: Validate select batch id using search box
		Given Admin is on student details page	
		When Admin  clicks select batch id and enter 1 number in the search box 	
		Then Admin should see batch id start with 1 is listed below
		
		@TestStudent22
    Scenario: Validate selecting only  student name  will not display any details
		Given Admin is on student details page	
		When Admin selects only student name	
		Then Student details should not be displayed
		
		@TestStudent23
    Scenario: Validate selecting only  batch id  will not display any details
		Given Admin is on student details page	
		When Admin selects only  batch id	
		Then Student details should not be displayed
		
		@TestStudent24
    Scenario: Validate selecting student name and batch id
		Given Admin is on student details page	
		When Admin selects  student name and batch id	
		Then Particular student information should be displayed

		    