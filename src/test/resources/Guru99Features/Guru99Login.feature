#Author: your.email@your.domain.com

Feature: Verify login page elements are displayed and login functionality for the applications
Scenario: Verify the elements present on the login page
Given User is on the login page of the Guru99 application
Then  Verify the elements present on the login page

Scenario: Test the login functionality of the Guru99 Application
Given User is on the login page of the Guru99 application
When  User enters the valid credentials for username and password
And   User click on the login button after entering the login credentials
Then  Verify that user is successfully logged in and redirected to the homepage