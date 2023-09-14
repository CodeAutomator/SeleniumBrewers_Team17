@DashBoard

Feature: Dashboard Page

Background: Admin clicks Login button after giving correct URL
Given Admin is in login page
When Admin enter valid credentials  and clicks login button 

@ManagePgmHeader
	Scenario: Verify after login admin lands on manage program as dashboard page
	Then Admin should see manage program as header 

@ResponseTime
	Scenario: Verify the response time
	Then  Maximum navigation time in milliseconds, defaults to 30 seconds

@VerifyBrockenLink
	Scenario: Verify broken link
	Then Dashboard_HTTP response should be >= 400 for broken link


@LMS-Title
	Scenario: Verify LMS title 
	Then Admin should see LMS -Learning management system  as title 	

@LMSAlignment
	Scenario: Verify LMS title alignment
	Then LMS title should be on the top left corner of page

@NavigationBarText
	Scenario: Validate navigation bar text
	Then Admin should see correct spelling in navigation bar text

@SpellingLMSTitle	
 Scenario: Validate LMS title has correct spelling and space
	Then Admin should see correct spelling and space in LMS title

@NavigationAlignmentBar
	Scenario: Validate alignment for navigation bar
	Then Admin should see the navigation bar text on the top right side

@StudentNavigation
	Scenario: Validate navigation bar order 1st Student
  Then Admin should see student in the 1st place

@ProgramNavigation
	Scenario: Validate navigation bar order 2nd Program
	Then Admin should see program in the 2nd place

@BatchNavigation	
	Scenario: Validate navigation bar order 3rd Batch
	Then Admin should see batch in the 3rd place 

@ClassNavigation
	Scenario: Validate navigation bar order 4th Class
	Then Admin should see class in the 4th place

@UserNavigation	
	Scenario: Validate navigation bar order 5th User
	Then Admin should see student in the 5th user	

@AssignmentNavigation
	Scenario: Validate navigation bar order 6th Assignment
	Then Admin should see student in the 6th assignment 
	
@AttendenceNavigation
	Scenario: Validate navigation bar order 7th Attendance
	Then Admin should see student in the 7th attendance	

@LogoutNavigation
	Scenario: Validate navigation bar order 8th Logout 

	Then Admin should see student in the 8th logout