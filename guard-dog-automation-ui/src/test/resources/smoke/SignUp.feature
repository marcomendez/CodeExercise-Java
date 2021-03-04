@Smoke @SignUp
Feature: Sign Up page

  @TC-69
  Scenario: TC-69 Verify that Sign Up page is loaded
    Given I navigate to 'Login' Page
    When I click Sign up on Login page
    Then I verify that the following fields are displayed on Sign Up page
      | Firstname            |
      | Lastname             |
      | Company              |
      | Email                |
      | New Password         |
      | Confirm New Password |
      | Sign up Button       |


