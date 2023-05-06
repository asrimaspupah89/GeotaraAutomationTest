#Author : Decia Safira Alfitri
#Date	: 06/05/2023
#Description : Testing View Event in Portal Geotara
@MenampilkanRestoran
Feature: Feature to check view event in Portal Geotara

  #TC1
  @MenampilkanRestoran1
  Scenario: Check page restoran
    Given User restoran has opened the browser
    And User restoran has navigated on the landing page
    When User restoran click on header Rencanakan Perjalanan Anda
    And User restoran click on Restoran
    Then User restoran should be able to see Restoran page

  #TC2
  @MenampilkanRestoran2
  Scenario: Check page artikel
    Given User restoran has opened the browser
    And User restoran has navigated on the landing page
    When User restoran click on header Rencanakan Perjalanan Anda
    And User restoran click on Restoran
    And User restoran click button Lihat Artikel on article banner
    Then User restoran should be able to see article page about Restoran

  #TC3-5
  @MenampilkanRestoran3
  Scenario Outline: Check sorting
    Given User restoran has opened the browser
    And User restoran has navigated on the landing page
    When User restoran click on header Rencanakan Perjalanan Anda
    And User restoran click on Restoran
    And User restoran click dropdown on sort by button
    And User restoran click item "<item>"
    Then User restoran should be able to see card sort by "<sort>" on page about Restoran

    Examples: 
      | item               | sort               |
      | A-Z                | alphabetically A-Z |
      | Z-A                | alphabetically Z-A |
      | Price, Low to High | Price, Low to High |