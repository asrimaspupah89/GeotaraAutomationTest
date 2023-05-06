#Author : Faizal Abdul Hakim
#Date	: 05/05/2023
#Description : Testing Atraksi View in Portal Geotara

@MenampilkanAtraksi
Feature: feature untuk test tampilan atraksi

# TC 1
  @MenampilkanAtraksi1
  Scenario: Check page Atraksi
    Given user has opened the browser
    And user has navigated on the landing page
    When user click on header "Rencanakan Perjalanan Anda"
    And user click on "Atraksi"
    Then user should be able to see atraksi page

# TC 2
  @MenampilkanAtraksi2
  Scenario: Check link article on page Atraksi
    Given user has opened the browser
    And user has navigated on the landing page
    When user click on header "Rencanakan Perjalanan Anda"
    And user click on "Atraksi"
    And user click on Lihat Artikel
    Then user should be able to see article page

# TC 3
  @MenampilkanAtraksi3
  Scenario: Check sorting alphabetically from A-Z
    Given user has opened the browser
    And user has navigated on the landing page
    When user click on header "Rencanakan Perjalanan Anda"
    And user click on "Atraksi"
    And user click on dropdown "Sort By"
    And user click item "A-Z"
    Then user should be able to see card sort by alphabetically A-Z on page about atraksi

# TC 4
  @MenampilkanAtraksi4
  Scenario: Check sorting alphabetically from Z-A
    Given user has opened the browser
    And user has navigated on the landing page
    When user click on header "Rencanakan Perjalanan Anda"
    And user click on "Atraksi"
    And user click on dropdown "Sort By"
    And user click item "Z-A"
    Then user should be able to see card sort by alphabetically Z-A on page about atraksi

# TC 5
  @MenampilkanAtraksi5
  Scenario: Check sorting price from Low to High
    Given user has opened the browser
    And user has navigated on the landing page
    When user click on header "Rencanakan Perjalanan Anda"
    And user click on "Atraksi"
    And user click on dropdown "Sort By"
    And user click item "Price, Low to High"
    Then user should be able to see card sort by price Low to High on page about atraksi