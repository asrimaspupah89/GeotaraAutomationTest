#Author : Mochammad Zidan Al-Baihaqi
#Date	: 06/05/2023
#Description : Testing Edit Event's properties

@EditEventScenario
Feature: checking edit events functionality
  Scenario Outline: Edit event with valid input
    Given User already in home page
    And User click Publikasi on the sidebar
    And User click Acara on the sidebar
    And User click Edit button on Testing Acara
    When User edited the <title> <desc> <penyelenggara> <kontak> <price> events properties
    And click Submit button
    Then events properties has been edited

    Examples:
        | title           |   desc          |   penyelenggara   |   kontak          | price     |
        | "Testing Acara" | "Testing Acara" | "Testing Acara"   | "Testing Acara"   | "3000"    |
        | "123456"        | "123456"        | "123456"          | "123456"          | "123456"  |
        | "!@#$%^"        | "!@#$%^"        | "!@#$%^"          | "!@#$%^"          | "!@#$%^"  |