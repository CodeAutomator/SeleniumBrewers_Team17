Feature: Forgot username /password

  Background: Admin in login page after clicking login button in home page
    Given Admin is in login page
    When Admin clicks forgot username or password link
    
@forgotUnamePwd
  Scenario: Verify forgot username or password link
    Then Admin should land on forgot username or password page

@BrockenLink
  Scenario: verify broken link
   Then HTTP response >= 400. Then the link is broken


@DescriptiveEmail
  Scenario: verify input descriptive text for Email
    Then Admin should see "Email" text in gray color


@EmailTextField
  Scenario: Verify email text in text field
    Then Admin should see "Email" in text field
    
    
@SendButton
  Scenario: Verify send link button is present
    Then Admin should see "send Link"  button

@AsterikEmail
  Scenario: Verify asterik near Email text
    Then Admin should see asterik symbol need Email

@TextSpelling
  Scenario: Verify text spelling
    Then Admin should see correct spellings in all fields

@AlignmentSendButton
  Scenario: Verify the alignment of the send link button
    Then Admin should see send link button in center of the page