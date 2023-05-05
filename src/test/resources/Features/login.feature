#Author
#Date
#Description

@SmokeScenario
Feature: feature to test login functionality

	@SmokeTest
  Scenario: check login is successful with valid credentials
    Given browser is open
    Given user is on login page
    When user enters "<email>" and "<password>"
    And clicks on login button
    Then user is navigated to the home page
    
    Examples: 
      | email          		| password |
      | admin@geotara.com | admin    |