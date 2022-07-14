@login
Feature: login

  User Story:1. As a user, I should be able to login to the app

  Scenario Outline: Verify user can login
    Given User is on login page
    When User enters valid "<Username>" and valid "<Password>" and clicks login button
    Then Title page should be "<PageTitle>"

    Examples:
      | Username                       | Password | PageTitle |
      | helpdesk22@cybertekschool.com  | UserUser | Portal    |
      | hr22@cybertekschool.com        | UserUser | Portal    |
      | marketing22@cybertekschool.com | UserUser | Portal    |