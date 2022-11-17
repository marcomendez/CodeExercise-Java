@API @Account
Feature: Account

  Scenario: Validate Update Password
    Given I create a Post request for 'Update Password' endpoint
    And I set the following headers
    """
    {
      "Content-Type": "application/json"
     }
    """
    And I set the following body
    """
    {
    "idToken":"[USER_TOKEN]",
    "password":"1234567",
    "returnSecureToken":true
    }
    """
    When I send request
    Then I should get status 200
    And I should get 'identitytoolkit#SetAccountInfoResponse' in 'kind' response field
    And I should get 'kykFwxXiZebqFNW1TZHNq6NzSZ42' in 'localId' response field
    And I should get 'omar.ors@gmail.com' in 'email' response field
    And I should get 'Omar Rodriguez' in 'displayName' response field
    And I should get 'https://lh6.googleusercontent.com/-IHZnDoQ48s0/AAAAAAAAAAI/AAAAAAAAAAA/AMZuuclJCk5yEFF8wCgKsgHI45vsg9UeCg/s96-c/photo.jpg' in 'photoUrl' response field
    And I should get Boolean 'true' in 'emailVerified' response field
    And I should get 'password' in 'providerUserInfo[0].providerId' response field