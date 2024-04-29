Feature: Expense Management
Scenario: Retrieve all expenses
  Given that a user wants to retrieve all expenses
  When the user requests the list of all expenses
  Then the list of all expenses is returned successfully