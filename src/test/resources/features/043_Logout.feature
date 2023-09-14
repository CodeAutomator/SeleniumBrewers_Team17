Feature: Logout function

Background: Admin  is in dashboard page after logged in
Given Admin is in dashboard page

Scenario: Verify Logout button function
When Admin click Logout button on navigation bar
Then Admin should land on login in page