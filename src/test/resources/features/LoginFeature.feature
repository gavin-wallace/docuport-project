Feature: Docuport Login Logout Feature

  Scenario: Login as client
    Given user is on Docuport login page
    When user enters username for client
    And user enters password for client
    And user clicks login button
    Then user should see the home page for client

  Scenario: Login as employee
    Given user is on Docuport login page
    When user enters username for employee
    And user enters password for employee
    And user clicks login button
    Then user should see the home page for employee

  Scenario: Login as supervisor
    Given user is on Docuport login page
    When user enters username for supervisor
    And user enters password for supervisor
    And user clicks login button
    Then user should see the home page for supervisor

  Scenario: Login as advisor
    Given user is on Docuport login page
    When user enters username for advisor
    And user enters password for advisor
    And user clicks login button
    Then user should see the home page for advisor