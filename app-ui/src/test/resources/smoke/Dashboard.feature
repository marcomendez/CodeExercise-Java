@Smoke @Dashboard
Feature: Dashboard page

  @Dashboard @TC-67
  Scenario: TC-67 Verify that dashboard panel display Devices, Device Logs, Find Devices, Account, Support and LogOut option
    Given I am logged in on Guard Dog portal
    Then I verify that the following fields are displayed on Dashboard page
      | Devices Tab      |
      | Device Logs Tab  |
      | Find Devices Tab |
      | Account Tab      |
      | Support Tab      |
      | Log Out Tab      |

  @DevicesTab @TC-68
  Scenario: TC-68 Verify that a user can navigate to Devices page
    Given I am logged in on Guard Dog portal
    When I click Devices Tab on Dashboard page
    Then I verify that Device Search Device field is displayed on Devices page
    And I verify that Devices Table field is displayed on Devices page

  @DeviceLos @TC-71
  Scenario: TC-71 Verify that a user can navigate to Devices Logs page
    Given I am logged in on Guard Dog portal
    When I click Device Logs Tab on Dashboard page
    Then I verify that Logs Search Log field is displayed on Devices page
    And I verify that Logs Table field is displayed on Devices page

  @FindDevices @TC-72
  Scenario: TC-72 Verify that a user can navigate to Find Devices page
    Given I am logged in on Guard Dog portal
    When I click Find Devices Tab on Dashboard page
    Then I verify that Find Devices Search Device field is displayed on Find Devices page
    And I verify that Find Devices Table field is displayed on Find Devices page

  @AccountTab @TC-73
  Scenario: TC-73 Verify that a user can navigate to Account page
    Given I am logged in on Guard Dog portal
    When I click Account Tab on Dashboard page
    Then I verify that the following fields are displayed on Account page
      | Firstname              |
      | Lastname               |
      | Company                |
      | Email                  |
      | Update User Button     |
      | Current Password       |
      | New Password           |
      | Confirm Password       |
      | Update Password Button |