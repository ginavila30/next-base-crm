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


  Scenario Outline: user can not login with invalid credentials
    Given User is on login page
    When User enters invalid "<Username>" and invalid "<Password>" and clicks login button
    Then User should see error message "Incorrect login or password"

    Examples:
      | Username                     | Password |
      | helpdesk@cybertekschool.com  | invalid  |
      | hr@cybertekschool.com        | invalid  |
      | marketing@cybertekschool.com | invalid  |

  Scenario: user can check "Remember me on this computer"
    Given User is on login page
    When User clicks on Remember me on this computer checkbox
    Then Checkbox should be selected

  Scenario: users access to  "FORGOT YOUR PASSWORD?" link page
    Given User is on login page
    When User clicks on FORGOT YOUR PASSWORD? link
    Then User should see "Get Password" header and "Reset Password" Button

