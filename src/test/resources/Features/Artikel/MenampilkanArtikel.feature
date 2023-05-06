#Author : Nuno Alwi Azimah
#Date	: 06/05/2023
#Description : Testing View Event in Portal Geotara
@MenampilkanArtikel
Feature: Feature to check view event in Portal Geotara

  #TC1
  @MenampilkanArtikel1
  Scenario: Check page artikel
    Given User artikel has opened the browser
    And User artikel has navigated on the landing page
    When User artikel click on header Rencanakan Perjalanan Anda
    And User artikel click on Artikel
    Then User artikel should be able to see Artikel page

  #TC2-3
  @MenampilkanArtikel2
  Scenario Outline: Check sorting
    Given User artikel has opened the browser
    And User artikel has navigated on the landing page
    When User artikel click on header Rencanakan Perjalanan Anda
    And User artikel click on Artikel
    And User artikel click item "<item>"

    Examples: 
      | item                     |
      | 64560bf3d491fbccae050682 |
      | 000000                   |