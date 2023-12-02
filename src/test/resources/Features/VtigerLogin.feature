#Author: your.email@your.domain.com
Feature: Vtiger Login functionality Test Scenarios

@Smoke
Scenario: Vtiger login functionality test with valid credentials
    Given opens the chrome browser and Vtiger application is loaded
    When  enters username and password
    And   click on the sign in button
    Then  verify login was successful