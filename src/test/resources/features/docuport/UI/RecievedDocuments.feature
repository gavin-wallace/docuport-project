Feature: Received Docs and My Uploads Feature

  @day18_automation
  Scenario Outline: Validate Received Documents and My Uploads for all userTypes
    When user logs into "<userType>"
    And the user navigates to "Received docs"
    Then assert search button, download button, and "Received docs" is displayed
    When the user navigates to "My uploads"
    Then assert search button, download button, and "My uploads" is displayed
    Examples:
      | userType   |
      | client     |
      | supervisor |
      | advisor    |
      | employee   |