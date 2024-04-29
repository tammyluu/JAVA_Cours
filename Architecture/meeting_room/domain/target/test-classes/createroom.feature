Feature: Room Management

  Scenario: Creating a Room
    Given there are no rooms
    When a new room is created with name "Conference Room" and capacity 10
    Then the room should be created successfully