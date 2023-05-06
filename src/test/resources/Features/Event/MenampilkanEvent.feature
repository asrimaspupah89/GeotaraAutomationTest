#Author : Decia Safira Alfitri
#Date	: 06/05/2023
#Description : Testing View Event in Portal Geotara
@MenampilkanEvent
Feature: Feature to check view event in Portal Geotara

  #TC1
  @MenampilkanEvent1
  Scenario: Check page event
    Given User has opened the browser
    And User has navigated on the landing page
    When User click on header Event
    Then User should be able to see event page

  #TC2
  @MenampilkanEvent2
  Scenario Outline: Check page event
    Given User has opened the browser
    And User has navigated on the landing page
    When User click on header Event
    And User click button Lihat Event "<event>" on article banner
    Then User should be able to see article page about selected event "<event>" "<id>"

    Examples: 
      | event                    | id                       |
      | PAMERAN COOPERATIVE FAIR | 6437753c7adf73de8b0c7960 |

  #TC3
  @MenampilkanEvent3
  Scenario Outline: Check order ticket
    Given User has opened the browser
    And User has navigated on the landing page
    When User click on header Event
    And User click button Lihat Event "<event>" on article banner
    And User click button Pesan Sekarang
    Then User should be able to see pembayaran page "page>"

    Examples: 
      | event                    | page       |
      | PAMERAN COOPERATIVE FAIR | Pembayaran |
