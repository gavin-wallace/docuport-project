Feature: Docuport Login Logout Feature

  Background:


  @smoke @regression @gavin @userstory @testplan @testexecution @test
  Scenario: Login as client
    Given user is on Docuport login page
    When user enters username for client
    And user enters password for client
    And user clicks login button
    And user should see and click the continue button
    Then user should see the home page for client
    Given user is logged in
    When user clicks the user logo
    And the user clicks Log out
    Then the user return to the login page

  @smoke @regression @closed @wip
  Scenario: Login as employee
    Given user is on Docuport login page
    When user enters username for employee
    And user enters password for employee
    And user clicks login button
    And user closes left navigation window
    Then user should see the home page for employee
    Given user is logged in
    When user clicks the user logo
    And the user clicks Log out
    Then the user return to the login page

  @smoke @regression
  Scenario: Login as supervisor
    Given user is on Docuport login page
    When user enters username for supervisor
    And user enters password for supervisor
    And user clicks login button
    And user closes left navigation window
    Then user should see the home page for supervisor
    Given user is logged in
    When user clicks the user logo
    And the user clicks Log out
    Then the user return to the login page

  @smoke @regression
  Scenario: Login as advisor
    Given user is on Docuport login page
    When user enters username for advisor
    And user enters password for advisor
    And user clicks login button
    And user closes left navigation window
    Then user should see the home page for advisor
    Given user is logged in
    When user clicks the user logo
    And the user clicks Log out
    Then the user return to the login page