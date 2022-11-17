@Smoke @Login
Feature: Login page

  @TC-65
  Scenario: TC 65 Verify that Login Page is loaded with email, password, LogIn button, forgot Password, and Sign Up link
    Given I navigate to 'Login' Page
    Then I verify that Email field is displayed on Login page
    And I verify that Password field is displayed on Login page
    And I verify that Log in Button field is displayed on Login page
    And I verify that Keep me logged in field is displayed on Login page
    And I verify that Sign up field is displayed on Login page
    And I verify that Forgot your password? field is displayed on Login page

  @TC-66
  Scenario: TC-66 Verify that Login allows to access to portal with valid credentials
    Given I navigate to 'Login' Page
    When I set 'omar.ors@gmail.com' in Email
    And I set '1234567' in Password
    And I click Log in Button
    Then I verify that Welcome label field contains 'Welcome to Protective' on Dashboard page
    And I verify that Guard Dog Logo field is displayed on Dashboard page