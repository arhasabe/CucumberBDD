#Author: your.email@your.domain.com

Feature: SwagLabs login and product buy functionality test scenario with excel data

Background: Prerequisite for testing SwagLabs buy functionality
Given User opens browser and SwagLabs application using data provided on "UserData" sheet
When  User enter username and password from "UserData" sheet
And   User click on the login button after enter the data from sheet

@Sanity @Regression
Scenario: Test the product buy functionality of SwagLabs for lowest price product
When user sort the products in ascending order of price
And  User add the lowest price product to the cart
And  User navigate to the cart page
Then Lowest price product should be added in the cart
When User click on checkout button
And  User enters firstname, lastname and zip code provided on "UserData" sheet
Then Verify the total amount is addition of item cost and tax amount
When User click on the finish button
Then Order confirmation message should be displayed

@Regression
Scenario: Test the product buy functionality of SwagLabs for highest price product
When user sort the products in descending order of price
And  User add the highest price product to the cart
And  User navigate to the cart page
Then Highest price product should be added in the cart
When User click on checkout button
And  User enters firstname, lastname and zip code provided on "UserData" sheet
Then Verify the total amount is addition of item cost and tax amount
When User click on the finish button
Then Order confirmation message should be displayed