Feature: Wikipedia Search Functionality Verification

  Background:
    Given the user is on the Wikipedia home page

  @wikipedia @B2G1-193 @B2G1-207
  Scenario: Title Verification
    Then the user searches the following items, clicks "search" button, and validates the text in the "page title"
      | Steve Jobs        |
      | George Washington |
      | Sam Smith         |
      | Taylor Swift      |

  @wikipedia @B2G1-194 @B2G1-208
  Scenario: Header Verification
    Then the user searches the following items, clicks "search" button, and validates the text in the "main header"
      | Steve Jobs        |
      | George Washington |
      | Sam Smith         |
      | Taylor Swift      |

  @wikipedia @B2G1-195 @B2G1-209
  Scenario: Image Header Verification
    Then the user searches the following items, clicks "search" button, and validates the text in the "image header"
      | Steve Jobs        |
      | George Washington |
      | Sam Smith         |
      | Taylor Swift      |
