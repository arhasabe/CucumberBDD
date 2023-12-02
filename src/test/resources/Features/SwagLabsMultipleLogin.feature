#Author: your.email@your.domain.com

Feature:  SwagLabs login functionality with multiple credentials test scenario

@Regression
Scenario Outline: SwagLabs login functionality with valid multiple credentials at enviroment "<Environment>"
    Given User open the "<browser>" browser and launch the swagLabs login page "<appUrl>"
    When User enters username "<username>" and password "<password>" on the login page
    And User click on the login button after entering username and password
    Then Verify that login is successful or not with  "<scenario>" scenario

    Examples:  
   |scenario | browser  | username      | password      |  appUrl                    | Environment |
   |positive | chrome   | standard_user | secret_sauce  | https://www.saucedemo.com/ | Dev         |
   #|positive | edge     | problem_user  | secret_sauce  | https://www.saucedemo.com/ | QA          |
	 |negative | chrome   | standard_user | secret_sauce1 | https://www.saucedemo.com/ | Dev         |
		   
