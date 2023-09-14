Feature: Forgot username /password

Background: Admin Clicks forgot username and password after reaching login page
Given Admin is in forgot username and password page

Scenario: Validate email sent for forgot password in login page
When Admin enters valid email id clicks send link button on forgot username or password page
Then Admin should receive link in mail for  reset  username or password

Scenario: Validate email sent for forgot password with invalid email id
When Admin enters invalid email id clicks send link button on forgot username or password page
Then Admin should not receive link in mail for reset username or password