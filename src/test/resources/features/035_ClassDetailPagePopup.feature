Feature: To verify class detail popup window

  Background: Admin logged into LMS portal and clicks class button on the navigation bar

  @class_test_01
  Scenario: Verify class details popup window
    Given Admin is on Manage Class Page
    When Admin click +Add New Class button
    Then Admin should see a popup  with  heading class details

  @class_test_02
  Scenario: Verify input fields in class details popup window
    Given Admin is on Manage Class Page
    When Admin click +Add New Class button
    Then Admin should see input fields Text (Batch ID , No of Classes, Class Date, Class Topic, Staff Id, Class description, Comments, Notes, Recordings)

  @class_test_03
  Scenario: Verify text box present in class details popup window
    Given Admin is on Manage Class Page
    When Admin click +Add New Class button
    Then Six textbox should be  present in Class details popup window

  @class_test_04
  Scenario: Verify drop down in Batch Id  in class details popup window
    Given Admin is on Manage Class Page
    When Admin click +Add New Class button
    Then Admin should see  dropdown option for Batch ID

  @class_test_05
  Scenario: Verify drop down in Staff Id  in class details popup window
    Given Admin is on Manage Class Page
    When Admin click +Add New Class button
    Then Admin should see  dropdown option for Staff Id

  @class_test_06
  Scenario: Verify calendar icon in class date  in class details popup window
    Given Admin is on Manage Class Page
    When Admin click +Add New Class button
    Then Admin should see  calendar icon for class date

  @class_test_07
  Scenario: Verify save button is present
    Given Admin is on Manage Class Page
    When Admin click +Add New Class button
    Then Admin should see  save button in the class detail popup window

  @class_test_08
  Scenario: Verify cancel button is present
    Given Admin is on Manage Class Page
    When Admin click +Add New Class button
    Then Admin should see  cancel button in the class detail popup window

  @class_test_09
  Scenario: Verify close button   in class details popup window
    Given Admin is on Manage Class Page
    When Admin click +Add New Class button
    Then Admin should see  close button on the class details popup window

  @class_test_10
  Scenario: Verify edit class popup window
    Given Admin is in Manage class page
    When Admin clicks Edit button in data table
    Then Edit popup window appears with heading Class Details

  @class_test_11
  Scenario: Verify values in popup window
    Given Admin is in Manage class page
    When Admin clicks Edit button from one of the row in data table
    Then Edit popup window appears with same row values in the all fields
