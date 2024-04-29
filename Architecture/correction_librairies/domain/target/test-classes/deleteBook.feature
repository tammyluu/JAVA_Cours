Feature: delete book
  Scenario: delete existed book
    Given there are two books, one with id 1
    And second with id 2 in the library
    When I delete the book with id 1
    Then list with one book with id 2 should be returned
