@Student
Feature: Student 
	Background: 
	Given Admin is logged in and on the student Details page
		
		@TestStudent25
    Scenario: Program link on navigation bar
		Given Admin is on student details page
		When Admin clicks on program link on student page	
		Then Admin is redirected to Program page
		
		@TestStudent26
    Scenario: Batch link on navigation bar
		Given Admin is on student details page
		When Admin clicks on Batch link on student page
		Then Admin is redirected to Batch page
		
		@TestStudent27
    Scenario: Class link on navigation bar
		Given Admin is on student details page
		When Admin clicks on Class link on student page	
		Then Admin is redirected to Class page
		
		@TestStudent28
    Scenario: User link on navigation bar
		Given Admin is on student details page
		When Admin clicks on User link on student page	
		Then Admin is redirected to User page
		
		@TestStudent29
    Scenario: Assignment link on navigation bar
		Given Admin is on student details page
		When Admin clicks on Assignment link on student page	
		Then Admin is redirected to Assignment page
		
		@TestStudent30
    Scenario: Attendance link on navigation bar
		Given Admin is on student details page
		When Admin clicks on Attendance link on student page	
		Then Admin is redirected to Attendance page
		
		@TestStudent31
    Scenario: Logout link on navigation bar
		Given Admin is on student details page
		When Admin clicks on Logout link on student page	
		Then Admin is redirected to Login page
		
		    
		    