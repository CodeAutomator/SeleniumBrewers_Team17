@06Class_module_page

Feature: To verify delete class and delete multiple class

Background: Admin logged into LMS portal and clicks class button on the navigation bar 

Scenario: Verify Delete class alert
Given Admin is in Manage class page
When Admin clicks delete button in data table row level
Then Admin should see alert

Scenario: Verify  accept enabled in alert
Given Admin is in Manage class page
When Admin clicks delete button in data table row level
Then Alert should have yes button to accept 

Scenario: Verify reject enabled in alert
Given Admin is in Manage class page
When Admin clicks delete button in data table row level
Then Alert should have No button to reject 
