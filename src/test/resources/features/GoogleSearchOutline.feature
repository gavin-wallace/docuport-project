Feature: Scenario outline practice

  @googlesearchoutline
  Scenario Outline: Google search for capital cities
    Given user is on Google search page
    When user searches for the "<country>"
    Then the user should see the "<capital>" in the result
    Examples:
      | country       | capital    |
      | Azerbaijan    | Baku       |
      | Ukraine       | Kyiv       |
      | Afghanistan   | Kabul      |
      | Unites States | Washington |
      | Turkey        | Ankara     |
      | uzbekistan    | Tashkent   |
