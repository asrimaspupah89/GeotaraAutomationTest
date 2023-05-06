# Author : Hilma Sri Rahayu
# Date : 06 Mei 2023
# Description : Menghapus data tur dan travel
@SmokeScenario
Feature: Menghapus data tur dan travel

	@HapusTourAndTravel
  Scenario: Menghapus data tur dan travel
    Given browser is launched
    And user opens geotara cms web
    And user inputs invalid email and password
    And user presses the ok button
    And user inputs valid email and password
    And user presses tur dan travel menu
    When user presses the delete button
    And notification displayed
    Then user presses the cancel button
    When user presses the delete button again
    And notification displayed again
    And user presses the hapus button
    Then notification success