#Author : Kiki Rizqi Amelia
#Date	: 29/04/2023
#Description : Testing View Penginapan in Portal Geotara

@MenampilkanPenginapan
Feature: Feature to check halaman penginapan

#	For TC 1	
  @MenampilkanPenginapan1
  Scenario: View penginapan page is successful
    Given user has opened the browser
    And user already in home page
    When user clicks on rencana perjalanan anda
    And user clicks on penginapan
    Then user must be able to see the navigation bar related to the displayed penginapan
    And user directed to penginapan page

#	For TC 2
	@MenampilkanPenginapan2
  Scenario: View penginapan list is successful
    Given user has opened the browser
    And user already in home page
    When user clicks on rencana perjalanan anda
    And user clicks on penginapan
    Then user must be able to see the navigation bar related to the displayed penginapan
    And user directed to penginapan page
    And user can view penginapan list
    
#	For TC 3
	@MenampilkanPenginapan3
  Scenario: View penginapan artikel is successful
    Given user has opened the browser
    And user already in home page
    When user clicks on rencana perjalanan anda
    And user clicks on penginapan
    And user clicks on artikel button
    Then user must be directed to the full information page of the penginapan artikel
    And user can view penginapan artikel
    
#	For TC 4
	@MenampilkanPenginapan4
  Scenario: Check Penginapan Filter is successful
    Given user has opened the browser
    And user already in home page
    When user clicks on rencana perjalanan anda
    And user clicks on penginapan
    And user clicks on filter
    And user filters the penginapan list with enters kecamatan, tipe, price, and stars
    And user clicks on confirm button and close button
    Then users can see a list of penginapan that have been filtered according to the expected choices
    
#	For TC 5
	@MenampilanPenginapan5
  Scenario: Check Penginapan searching is successful
    Given user has opened the browser
    And user already in home page
    When user clicks on rencana perjalanan anda
    And user clicks on penginapan
    And user enter data on searching
    Then user can see the search results as expected
    
 
 