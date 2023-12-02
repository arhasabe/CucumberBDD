#Author: your.email@your.domain.com

Feature: Test the new Customer Functionality of the Guru99 Application

Background: pre-requisite to add new customer
Given User is on the login page of the Guru99 application
When  User enters the valid credentials for username and password
And   User click on the login button after entering the login credentials

Scenario: Add new customer on the Guru99 application
Given User is on the homepage and clicks on new customer menu button
When  User enters the new customer details
And   User submit the details
Then  Verify that the new customer is added