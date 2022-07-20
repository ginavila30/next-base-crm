@wip
Feature: As a user, I should be able to create a poll

  Scenario Outline: Verify users can create a poll with Q/A
    Given User logged in nextBaseCRM with valid "<Username>" and valid "<Password>"
    When User clicks on "poll" link
    And Fills out all required fields inputs "<Poll name>" and send poll
    Then User can see and verify poll created with "<Poll name>"

    Examples:
      | Username                       | Password | Poll name           |
      | helpdesk22@cybertekschool.com  | UserUser | poll from helpdesk22  |
      | marketing22@cybertekschool.com | UserUser | poll from marketing22 |
      | hr22@cybertekschool.com        | UserUser | poll from hr22      |
