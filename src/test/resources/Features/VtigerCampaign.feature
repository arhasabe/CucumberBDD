#Author: your.email@your.domain.com

Feature: Vtiger campaign create delete functionality test scenario

Background: Pre-requisite
  Given User is on the Vtiger login page
  And   User login with valid credentials
  And 	User navigates to campaign page  

Scenario Outline: Test the Create new campaign functionality with "<campaign>"
  When  Click on Add campaign button
  And   User enters campaign name "<campaignName>" and expected close date "<expectedCloseDate>" and click on save button
  And   User click on campaign header link
  Then  Verify the created camapign with "<campaignName>"
  
Examples:
  |campaignName      | expectedCloseDate |
  |Java Learning     | 11-31-2023        |
  |Selenium Learning | 11-30-2023        |
  
@Rerun
Scenario: Test the delete functionality of campaign
   When  User click on select all campaign checkbox
   And   User click on delete button
   And   User click on confirm button appeared on the pop up
   Then  Verify that all the created campaigns are deleted