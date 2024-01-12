Feature: Passing Multiple Parameters To The Same Step

  @googlesearch @wip
  Scenario: Searching Multiple items
    Given user is on Google search page
    Then user search the following items in the google search box
      | loop academy |
      | Java         |
      | selenium     |
      | cucumber bdd |
      | sql          |
      | zahid        |
      | anna         |
      | anything     |
