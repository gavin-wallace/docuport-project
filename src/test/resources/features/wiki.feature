Feature: Wikipedia Search Functionality Verification

  Background:
    Given the user is on the Wikipedia home page

  @wikipedia
  Scenario: Title Verification
    Then the user searches the following items and validates the text in the "page title"
      | Steve Jobs        |
      | George Washington |
      | Sam Smith         |
      | Taylor Swift      |

  @wikipedia
  Scenario: Header Verification
    Then the user searches the following items and validates the text in the "main header"
      | Steve Jobs        |
      | George Washington |
      | Sam Smith         |
      | Taylor Swift      |

  @wikipedia
  Scenario: Image Header Verification
    Then the user searches the following items and validates the text in the "image header"
      | Steve Jobs        |
      | George Washington |
      | Sam Smith         |
      | Taylor Swift      |
