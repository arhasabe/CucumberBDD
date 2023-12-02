#Author: your.email@your.domain.com

Feature: Swaglab login test functionality

@Smoke
Scenario: Swaglabs login with valid credentials
    Given user launches the chrome browser and opens the Swaglabs application
    When  user enters the username and password as
    |standard_user|secret_sauce|
    |problem_user|secret_sauce|
    And   user click on the sign in button
    Then  verify the user is logged in