@Login
Feature: Login page

  Background: Go to Login Page
    Given I navigate to 'Login' Page

  @TC-01
  Scenario: TC-01 Verify that the 'Keep me logged in" checkmark works correctly
    When I set 'omar.ors@gmail.com' in Email
    And I set '1234567' in Password
    When I check Keep me logged in on Login page
    Then I verify that Keep me logged in is checked on Login page
    And I click Log in Button

  @TC-04
  Scenario: TC-04 Verify that a user with valid credentials is able to access to the portal
    When I set 'omar.ors@gmail.com' in Email
    And I set '1234567' in Password
    And I click Log in Button
    Then I verify that Welcome label field contains 'Welcome to Protective' on Dashboard page
    And I verify that Guard Dog Logo field is displayed on Dashboard page

  @TC-05 @TC-06 @TC-07 @TC-08 @TC-09 @TC-10 @TC-11
  Scenario: TC-05 Verify that "Don't have an account?" label is displayed on Log In Page
  TC-06 Verify that "Sign Up" label is displayed on Log In Page
  TC-07 Verify that "Forgot your password?" link is displayed on Log In Page
  TC-08 Verify that "Log in" title is displayed on Log In Page
  TC-09 Verify that "Log in with your data that you entered during sign up" label is displayed on Log In Page
  TC-10 Verify that "Keep me logged in" checkbox is displayed on Log In Page
  TC-11 Verify that "Slider" is displayed on Log In page
    Then I verify that Don't have an account? field is displayed on Login page
    And I verify that Sign up field is displayed
    And I verify that Forgot your password? field is displayed
    Then I verify that Title field contains 'Log in'
    Then I verify that Sub Title field contains 'Log in with your data that you entered during sign up'
    And I verify that Keep me logged in field is displayed
    And I verify that Forgot your password? field is displayed
    And I verify that Slider field is displayed


  @TC-05 @TC-13
  Scenario: TC-13 Verify that "The password is invalid or the user does not have a password." error label is displayed after set credential fake
    Given I set 'marticus123@gmail.com' in Email on Login page
    And I set 'fakePassword' in Password
    When I click Log in Button
    Then I verify that Error field contains 'The password is invalid or the user does not have a password.' on Login page

  @TC-05 @TC-14
  Scenario: TC-14 Verify that "I am not a Robot required.." error label is displayed after set twice time fake credential
    Given I set 'marticus123@gmail.com' in Email on Login page
    And I set 'fakePassword' in Password
    When I click Log in Button
    And I verify that Error field contains 'The password is invalid or the user does not have a password.' on Login page
    And I set 'fakePass' in Password
    And I click Log in Button
    Then I verify that Error field contains 'I am not a Robot required.' on Login page