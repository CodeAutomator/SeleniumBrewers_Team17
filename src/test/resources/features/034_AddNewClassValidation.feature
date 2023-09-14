@04class_module_page
Feature: To verify Add New Class

  Background: Admin click +Add New Class button after reaching to Manage Class Page

  @class_test_01
  Scenario: Validate all batch id is reflecting in the dropdown
    Given Admin is in  class detail popup window
    When Admin clicks  Batch ID dropdown
    Then Batch id in the drop down should match with Batch id manage batch page table

  @class_test_02
  Scenario: Validate admin able to add new class with valid data in mandatory fields
    Given Admin is in  class detail popup window
    When Admin enters all mandatory field values with valid data and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id)
    Then Admin should see new class details is added in the data table

  @class_test_03
  Scenario: Validate admin able to add new class with invalid data in mandatory fields
    Given Admin is in  class detail popup window
    When Admin enters all mandatory field values with invalid data and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id, )
    Then Error message should appear in alert

  @class_test_04
  Scenario: Validate admin able to add new class with valid data  in all fields
    Given Admin is in  class detail popup window
    When Admin enters values in all fields with valid data and clicks save button (Batch ID , No of Classes, Class Date, Class Topic, Staff Id, Class description, Comments, Notes, Recordings)
    Then Admin should see new class details is added in the data table

  @class_test_05
  Scenario: Validate admin able to add new class with invalid data  in optional fields
    Given Admin is in  class detail popup window
    When Admin enters with invalid data in optional fields and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id)
    Then Error message should appear in alert

  @class_test_06
  Scenario: Validate admin able to add new class missing Batch Id
    Given Admin is in  class detail popup window
    When Admin enters  data missing value in Batch ID and clicks save button (No of Classes, Class Date, Staff Id)
    Then Batch Id is missing

  @class_test_07
  Scenario: Validate admin able to add new class missing No of Class
    Given Admin is in  class detail popup window
    When Admin enters data missing value in No of class and clicks save button (Batch ID ,  Class Date, Staff Id, )
    Then No of classes is missing

  @class_test_08
  Scenario: Validate admin able to add new class missing Class Date
    Given Admin is in  class detail popup window
    When Admin enters data missing value in  class date and clicks save button (Batch ID , No of Classes, Staff Id, )
    Then class date is missing

  @class_test_09
  Scenario: Validate admin able to add new class missing staff id
    Given Admin is in  class detail popup window
    When Admin enters data missing value in staff id and clicks save button (Batch ID , No of Classes, Class Date )
    Then staff id is missing

  @class_test_10
  Scenario: Validate  admin able to add new class passing past date
    Given Admin is in  class detail popup window
    When Admin enters passed date in the class date field and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id)
    Then class cannot be  created for the passed date

  @class_test_11
  Scenario: Validate date picker
    Given Admin is in  class detail popup window
    When Admin clicks date from date picker
    Then selected date should be their in class date text box

  @class_test_12
  Scenario: validate date picker should be correct format
    Given Admin is in  class detail popup window
    When Admin clicks date from date picker
    Then selected date should be in  mm/dd/yyyy format

  @class_test_13
  Scenario: Validate right arrow in data picker to navigate to next month
    Given Admin is in  class detail popup window
    When Admin clicks right arrow in the date picker near month
    Then Next month calender should visible

  @class_test_14
  Scenario: Validate left arrow in data picker to navigate to previous month
    Given Admin is in  class detail popup window
    When Admin clicks left arrow in the date picker near month
    Then previous month calender should visible

  @class_test_15
  Scenario: Validate current date is highlighted in the date picker
    Given Admin is in  class detail popup window
    When Admin clicks date picker button
    Then Admin should see current date is highled in the date picker

  @class_test_16
  Scenario: Validate selected date is highlighted in the date picker
    Given Admin is in  class detail popup window
    When Admin clicks date picker button and selects future date
    Then Admin should see selected date is highled in the date picker

  @class_test_17
  Scenario: Validate cancel button function in class details popup window
    Given Admin is in  class detail popup window
    When Admin clicks Cancel button without entering values in the fields
    Then Admin should land on Manage Class page

  @class_test_18
  Scenario: Validate cancel button function in class details popup window with values in field
    Given Admin is in  class detail popup window
    When Admin clicks Cancel button entering values in the fields
    Then Admin should land on Manage Class Page and validate new class is not created in the data table
