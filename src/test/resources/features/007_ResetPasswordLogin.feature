Feature: Reset Password in Login Page

  Background: Admin clicks reset password link after  reaching in login page
    Given Admin reset password page
    
@EnabledNewPWD
  Scenario: verify text box is in enabled in new password field
    When Admin clicks on type in new password field
    Then Admin should see text box is enabled state

@EnabledRetypePWD
  Scenario: verify text box is in enabled in retype password field
    When Admin clicks on retype password field
    Then Admin should see text box is enabled state

@ResetwithValid
  Scenario: Validate reset password with valid details
    When Admin enters same password on both field and clicks submit button
    Then Admin should recieve  : "Your password has been reset". Please click here to login

@ResetwithInvalid
  Scenario: Validate reset password with invalid details
    When Admin enters same password on both field with invalid details and clicks submit button
    Then Error message " Please try agin"

@ResetwithEmpty
  Scenario: Validate reset password with empty details
    When Admin enters  empty details on both fieldand clicks submit button
    Then Error message " Please try agin"

@ResetwithMismatch
  Scenario: Validate reset password mismatch values
    When Admin enters  mismatch values and clicks submit button
    Then Error message " Please try agin"