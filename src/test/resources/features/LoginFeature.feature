Feature: Docuport Login Logout Feature

  Background:
    Given user is on Docuport login page

  @smoke @regression @gww @us_B2G1-184 @tp_B2G1-136 @te_B2G1-137 @t_B2G1-185
  Scenario: Login and out as client
    When user enters username for "client"
    And user enters password for "client"
    And user clicks login button
    And user should see and click the continue button
    Then user should see the home page for "client"
    When user clicks the user logo
    And the user clicks Log out
    Then the user return to the login page

  @smoke @regression
  Scenario: Login and out as employee
    When user enters username for "employee"
    And user enters password for "employee"
    And user clicks login button
    And user closes left navigation window
    Then user should see the home page for "employee"
    When user clicks the user logo
    And the user clicks Log out
    Then the user return to the login page

  @smoke @regression
  Scenario: Login and out as supervisor
    When user enters username for "supervisor"
    And user enters password for "supervisor"
    And user clicks login button
    And user closes left navigation window
    Then user should see the home page for "supervisor"
    When user clicks the user logo
    And the user clicks Log out
    Then the user return to the login page

  @smoke @regression
  Scenario: Login and out as advisor
    When user enters username for "advisor"
    And user enters password for "advisor"
    And user clicks login button
    And user closes left navigation window
    Then user should see the home page for "advisor"
    When user clicks the user logo
    And the user clicks Log out
    Then the user return to the login page


