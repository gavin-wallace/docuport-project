Feature: Docuport Login Logout Feature

  Background:
    Given user is on Docuport login page


  @smoke @regression @gavin @userstory @testplan @testexecution @test
  Scenario: Login as client
    When user enters username for client
    And user enters password for client
    And user clicks login button
    And user should see and click the continue button
    Then user should see the home page for client
#    Given user is logged in
#    When user clicks the user logo
#    And the user clicks Log out
#    Then the user return to the login page

  @smoke @regression
  Scenario: Login as employee
    When user enters username for employee
    And user enters password for employee
    And user clicks login button
    And user closes left navigation window
    Then user should see the home page for employee
#    Given user is logged in
#    When user clicks the user logo
#    And the user clicks Log out
#    Then the user return to the login page

  @smoke @regression
  Scenario: Login as supervisor
    When user enters username for supervisor
    And user enters password for supervisor
    And user clicks login button
    And user closes left navigation window
    Then user should see the home page for supervisor
#    Given user is logged in
#    When user clicks the user logo
#    And the user clicks Log out
#    Then the user return to the login page

  @smoke @regression
  Scenario: Login as advisor
    When user enters username for advisor
    And user enters password for advisor
    And user clicks login button
    And user closes left navigation window
    Then user should see the home page for advisor
#    Given user is logged in
#    When user clicks the user logo
#    And the user clicks Log out
#    Then the user return to the login page