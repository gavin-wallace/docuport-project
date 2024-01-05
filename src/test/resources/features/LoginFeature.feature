Feature: Docuport Login Logout Feature

  Scenario: Login as client
    Given user is on Docuport login page
    When user enters username for client
    And user enters password for client
    And user clicks login button
    And user should see and click the continue button
    Then user should see the home page for client

  Scenario: Logout as client
    Given user is logged in
    When user clicks the user logo
    And the user clicks Log out
    Then the user return to the login page

  Scenario: Login as employee
    Given user is on Docuport login page
    When user enters username for employee
    And user enters password for employee
    And user clicks login button
    And user closes left navigation window
    Then user should see the home page for employee

  Scenario: Logout as employee
    Given user is logged in
    When user clicks the user logo
    And the user clicks Log out
    Then the user return to the login page

  Scenario: Login as supervisor
    Given user is on Docuport login page
    When user enters username for supervisor
    And user enters password for supervisor
    And user clicks login button
    And user closes left navigation window
    Then user should see the home page for supervisor

  Scenario: Logout as supervisor
    Given user is logged in
    When user clicks the user logo
    And the user clicks Log out
    Then the user return to the login page

  Scenario: Login as advisor
    Given user is on Docuport login page
    When user enters username for advisor
    And user enters password for advisor
    And user clicks login button
    And user closes left navigation window
    Then user should see the home page for advisor

  Scenario: Logout as advisor
    Given user is logged in
    When user clicks the user logo
    And the user clicks Log out
    Then the user return to the login page