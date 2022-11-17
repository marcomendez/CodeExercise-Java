@API @User
Feature: Login API

  Background: Login
    Given I create a Post request for 'Login' endpoint
    And I set the following body
    """
     {
     "email":"marco@gmail.com",
     "password":"123456789",
     "returnSecureToken":true
     }
    """
    And I send request
    And I save 'idToken' as "[USER_TOKEN]"
    And I save 'refreshToken' as "[REFRESH_TOKEN]"

  Scenario: Validate Login Schema
    Then I should get status 200
    And I should get 'identitytoolkit#VerifyPasswordResponse' in 'kind' response field
    And I should get 'marco@gmail.com' in 'email' response field
    And I should get 'stFtmPUMKZgQDNMzDNs1sn2J0go2' in 'localId' response field
    And I should get Boolean 'true' in 'registered' response field
    And I should get '3600' in 'expiresIn' response field
    And I validate json 'LoginUser' schema
    And I should get the following response body
    """
    {
    "kind": "identitytoolkit#VerifyPasswordResponse",
    "localId": "stFtmPUMKZgQDNMzDNs1sn2J0go2",
    "email": "marco@gmail.com",
    "displayName": "",
    "idToken": "[USER_TOKEN]",
    "registered": true,
    "refreshToken": "[REFRESH_TOKEN]",
    "expiresIn": "3600"
    }
    """

  Scenario: Validate get user Info
    Given I create a Get request for '/api/user/info' endpoint
    And I set the following headers
    """
    {
       "authorization": "[USER_TOKEN]"
    }
    """
    When I send request
    Then I should get status 200
    And I should get the following response body
    """
     {
    "email": "marco@gmail.com",
    "uid": "stFtmPUMKZgQDNMzDNs1sn2J0go2",
    "company": "XXX",
    "first_name": "Marco",
    "last_name": "Mendez"
    }
    """