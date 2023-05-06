#Author : Faizal Abdul Hakim
#Date	: 05/05/2023
#Description : Testing Merchant And Souvenier View in Portal Geotara

@MenampilkanMerhcantAndSouvenir
Feature: feature untuk test tampilan merchant and souvenier

# TC 1
  @MenampilkanMerchantAndSouvenier1
  Scenario: Check page Merchant and Souveniers
    Given user has opened the browser
    And user has navigated on the landing page
    When user click on header "Rencanakan Perjalanan Anda"
    And user click on "Merchant & Souveniers"
    Then user should be able to see merchant and souvenier page

# TC 2
  @MenampilkanMerchantAndSouvenier2
  Scenario: Check link article on page Merchant and Souveniers
    Given user has opened the browser
    And user has navigated on the landing page
    When user click on header "Rencanakan Perjalanan Anda"
    And user click on "Merchant & Souveniers"
    And user click on Lihat Artikel
    Then user should be able to see article page

# TC 3
  @MenampilkanMerchantAndSouvenier3
  Scenario: Check sorting alphabetically from A-Z
    Given user has opened the browser
    And user has navigated on the landing page
    When user click on header "Rencanakan Perjalanan Anda"
    And user click on "Merchant & Souveniers"
    And user click on dropdown "Sort By"
    And user click item "A-Z"
    Then user should be able to see card sort by alphabetically A-Z on page about merchant and souveniers

# TC 4
  @MenampilkanMerchantAndSouvenier4
  Scenario: Check sorting alphabetically from Z-A
    Given user has opened the browser
    And user has navigated on the landing page
    When user click on header "Rencanakan Perjalanan Anda"
    And user click on "Merchant & Souveniers"
    And user click on dropdown "Sort By"
    And user click item "Z-A"
    Then user should be able to see card sort by alphabetically Z-A on page about merchant and souveniers

# TC 5
  @MenampilkanMerchantAndSouvenier5
  Scenario: Check sorting price from Low to High
    Given user has opened the browser
    And user has navigated on the landing page
    When user click on header "Rencanakan Perjalanan Anda"
    And user click on "Merchant & Souveniers"
    And user click on dropdown "Sort By"
    And user click item "Price, Low to High"
    Then user should be able to see card sort by price Low to High on page about merchant and souveniers