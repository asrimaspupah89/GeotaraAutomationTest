#Author : Kiki Rizqi Amelia
#Date	: 30/04/2023
#Description : Testing Tour And Travel View in Portal Geotara

@MenampilkanTourAndTravel
Feature: Feature to check tampilan tour and travel
	
#	TC 1
  @MenampilkanTourAndTravel1
  Scenario: View Tour and Travel page is successful
    Given user has opened the browser
    And user already in home page
    When user clicks on rencana perjalanan anda
    And user clicks on travel and tour
    Then user must be able to see the navigation bar related to the displayed tour and travel
    And user directed to tour and travel page
	
#	TC 2
  @MenampilkanTourAndTravel2
  Scenario: View Tour and Travel page is successful
    Given user has opened the browser
    And user already in home page
    When user clicks on rencana perjalanan anda
    And user clicks on travel and tour
    Then user must be able to see the navigation bar related to the displayed tour and travel
    And user directed to tour and travel page
    And user can view tour and travel list
 
 #TC 3
 @MenampilkanTourAndTravel3
  Scenario: View Tour and Travel artikel is successful
    Given user has opened the browser
    And user already in home page
    When user clicks on rencana perjalanan anda
    And user clicks on travel and tour
    And user clicks on artikel button
    Then user must be directed to the full information page of the tour and travel artikel
    And user can view tour and travel artikel
    
 #TC 4
 @MenampilkanTourAndTravel4
  Scenario: Check Tour and Travel Filter is successful
    Given user has opened the browser
    And user already in home page
    When user clicks on rencana perjalanan anda
    And user clicks on travel and tour
    And user clicks on filter
    And user filters the tour and travel list with enters city, tipe, price, and ratings
    And user clicks on confirm button and close button
    Then users can see a list of tour and travel that have been filtered according to the expected choices
    
 #TC 5
 @MenampilkanTourAndTravel5
  Scenario: Check Tour and Travel searching is successful
    Given user has opened the browser
    And user already in home page
    When user clicks on rencana perjalanan anda
    And user clicks on travel and tour
    And user enter data on searching
    Then user can see the search results as expected
    