# Author : Hilma Sri Rahayu
# Date : 06 Mei 2023
# Description : Menghapus data wisata
@SmokeScenario
Feature: Menghapus data wisata

  @HapusWisata
  Scenario: Menghapus data wisata
    Given browser starts up
    And user open geotara cms web
    And user enter invalid username and password
    And user presses ok button
    And user enter valid username and password
    And user presses wisata
    When user presses delete button
    And notification shown
    Then user presses cancel button
    When user presses delete button again
    And notification shown again
    Then user presses hapus button
