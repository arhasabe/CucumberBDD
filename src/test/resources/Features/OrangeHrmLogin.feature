#Author: your.email@your.domain.com

Feature: OrangeHRM Login functionality Test Scenarios

@Sanity
Scenario: OrangeHRM login functionality test with valid credentials
    Given user opens the chrome browser and OrangeHrm application is loaded
    Given user has username and password
    When  user enters username and password
    And   user click on the login button
    Then  user should be logged in successfully and navigated to home page