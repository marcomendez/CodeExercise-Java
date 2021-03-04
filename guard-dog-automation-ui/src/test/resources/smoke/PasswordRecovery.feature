@Smoke @PasswordRecovery
Feature: Password recovery page

  @TC-70
  Scenario: TC-70 Verify that Password recovery page is displayed
    Given I navigate to 'Login' Page
    When I click Forgot your password? on Login page
    Then I verify that the following fields are displayed on Password Recovery page
      | Email             |
      | Send Email Button |
    And I verify that Title field contains 'Password recovery' on Password Recovery page
    And I verify that Message contains the following value on Password Recovery page
    """
    To reset your password, submit your email address below. An email will be sent to your email address, with instructions of how to get access again.
    """
