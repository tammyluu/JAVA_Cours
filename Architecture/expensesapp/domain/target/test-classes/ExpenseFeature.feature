Feature: Expense Management

  Scenario: Add a new expense
    Given that a user wants to add an expense with title "Purchase" and amount 50
    When the user adds the expense
    Then the expense is successfully added