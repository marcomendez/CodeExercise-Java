@API @Devices
Feature: Devices

  @TC-01
  Scenario: Validate Find Devices Schema
    Given I create a Get request for '/api/user/devices?ip=191.92.74.181' endpoint
    And I set the following headers
    """
    {
       "authorization": "[USER_TOKEN]"
    }
    """
    When I send request
    Then I should get status 200
    And I validate json Devices schema

  Scenario: Validate Post FIDOs Schema
    Given I create a Post request for '/api/pull-data' endpoint
    And I set the following headers
    """
    {
      "Content-Type": "application/json",
      "authorization": "[USER_TOKEN]"
     }
    """
    And I set the following body
    """
    {"ip":"200.87.208.237"}
    """
    When I send request
    Then I should get status 200
    And I validate json Pull data schema

  Scenario: Validate Get Networks Schema
    Given I create a Get request for '/api/pull-network-data' endpoint
    And I set the following headers
    """
    {
      "authorization": "[USER_TOKEN]"
     }
    """
    When I send request
    Then I should get status 200
    And I validate json Pull data Networks schema
