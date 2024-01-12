Feature: Login and Print all task information
  Background:
    Given Given a user is on the CodingBat Java page
    Then assert "Java" tab is selected

  @codingBat
  Scenario: Coding Bat Login
    When the user enters their id or email
    And the user enters their password
    And the user clicks login
    Then the user is logged in

  @codingBat
  Scenario: Validate and print Java Help links
    Then assert "Java Help" is displayed
    And print the "Java" Help links

  @codingBat
  Scenario: Validate and print Python Help links
    Given the user selects the Python tab
    Then assert "Python" tab is selected
    And assert "Python Help" is displayed
    And print the "Python" Help links

  @codingBat
  Scenario: Print all Java task links and webpage title
    When the user clicks each "Java" problem group and each task
    Then the user prints each "Java" task link and webpage title

  @codingBat
  Scenario: Print all Python task links and webpage title
    Given the user selects the Python tab
    Then assert "Python" tab is selected
    When the user clicks each "Python" problem group and each task
    Then the user prints each "Python" task link and webpage title


