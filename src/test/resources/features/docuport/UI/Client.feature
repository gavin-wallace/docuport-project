Feature: Client creation feature

  @B2G1-236 @B2G1-237
  Scenario: Validate client creation - personal
    Given user logs into "advisor"
    When the user navigates to "Clients"
    And create a personal client
      | Elton               |
      | John                |
      | eltonjohn@gmail.com |
      | 5712345432          |
      | Password1!          |
    Then verify new client is created
    And logout
    And login as newly created user
    And logout
    Then Delete user from the database

  @B2G1-236 @B2G1-237
  Scenario: Validate client creation - business
    Given user logs into "advisor"
    When the user navigates to "Clients"
    And create a business client
      | Donald                |
      | Trump                 |
      | donaldtrump@gmail.com |
      | 4049312523            |
      | Password1!            |
      | MAGA Inc.             |
    Then verify new client is created
    And logout
    And login as newly created user
    And logout
    Then Delete user from the database



