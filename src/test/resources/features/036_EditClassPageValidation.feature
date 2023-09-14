@5class_module_page
Feature: To verify edit Class

  Background: Admin clicks Edit Button in manage class after reaching manage class page

  @class_test_01
  Scenario: Validate admin able to update class with valid data in mandatory fields
    Given Admin is in  Edit class detail popup window
    When Admin enters all mandatory field values with valid data and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id)
    Then Admin should see particular class details is updated in the data table

  @class_test_02
  Scenario: Validate admin able to  update class with invalid data in mandatory fields
    Given Admin is in  Edit class detail popup window
    When Admin enters all mandatory field values with invalid data and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id, )
    Then Error message should appear in alert

  @class_test_03
  Scenario: Validate admin able to  update class with valid data  in all fields
    Given Admin is in  Edit class detail popup window
    When Admin enters values in all fields with valid data and clicks save button (Batch ID , No of Classes, Class Date, Class Topic, Staff Id, Class description, Comments, Notes, Recordings)
    Then Admin should see particular class details is updated in the data table

  @class_test_04
  Scenario: Validate admin able to  update  class with invalid data  in all fields
    Given Admin is in  Edit class detail popup window
    When Admin enters with invalid data in optional fields and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id)
    Then Error message should appear in alert

  @class_test_05
  Scenario: Validate admin able to update class missing Batch Id
    Given Admin is in  Edit class detail popup window
    When Admin enters  data missing value in Batch ID and clicks save button (No of Classes, Class Date, Staff Id)
    Then Batch Id is missing

  @class_test_06
  Scenario: Validate admin able to update  class missing No of Class
    Given Admin is in  Edit class detail popup window
    When Admin enters data missing value in No of class and clicks save button (Batch ID ,  Class Date, Staff Id, )
    Then No of classes is missing

  @class_test_07
  Scenario: Validate admin able to update class missing Class Date
    Given Admin is in  Edit class detail popup window
    When Admin enters data missing value in  class date and clicks save button (Batch ID , No of Classes, Staff Id, )
    Then class date is missing

  @class_test_08
  Scenario: Validate admin able to update class missing staff id
    Given Admin is in  Edit class detail popup window
    When Admin enters data missing value in staff id and clicks save button (Batch ID , No of Classes, Class Date )
    Then staff id is missing

  @class_test_09
  Scenario: Validate  admin able to update class passing past date
    Given Admin is in  Edit class detail popup window
    When Admin enters passed date in the class date field and clicks save button ( Batch ID , No of Classes, Class Date, Staff Id)
    Then class cannot be updated for the passed date

  @class_test_10
  Scenario: Validate cancel button function in Edit class details popup window
    Given Admin is in  Edit class detail popup window
    When Admin clicks Cancel button without entering values in the fields
    Then Admin should land on Manage Class page

  @class_test_10
  Scenario: Validate cancel button function in Edit class details popup window with values in field
    Given Admin is in  Edit class detail popup window
    When Admin clicks Cancel button entering values in the fields
    Then Admin should land on Manage Class Page and validate particular class details are not changed  in the data table
