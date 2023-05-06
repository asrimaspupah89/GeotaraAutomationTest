@0.1
Feature: feature to test update tour and travel functionality

  @0.1.1
  Scenario: Check update tour travel is successful with valid input
    Given User has opened the browser
    And User already in home page
    When User clicks on sidebar with tab name "Kemitraan"
    And User clicks on sidebar with dropdown tab name "Tur dan Travel"
    And User clicks on "Edit" button on specific tur
    And User edit form
      | nama_tur | Bali Adventure Tour Update |
    And User clicks on "Simpan" button
    Then User should be able to see success notification with message "Tour berhasil diubah"

  @0.1.2
  Scenario: Check update tour travel is unsuccessful with mandatory checking invalid. All field are empty except time picker field
    Given User has opened the browser
      And User already in home page
    When User clicks on sidebar with tab name "Kemitraan"
      And User clicks on sidebar with dropdown tab name "Tur dan Travel"
      And User clicks on "Edit" button on specific tur
      And User edit form
        | nama_tur |  |
        | alamat   |  |
        | latitude |  |
        | longitude |  |
        | no_telp   |  |
        | email     |  |
        | rating    |  |
        | fasilitas |  |
        | tipe_1    |  |
        | harga_1   |  |
        | keberangkatan_1 |  |
        | tujuan_1        |  |
      And User clicks on "Simpan" button
    Then User should be able to see error notification with message "Validation errors in your request"

  @0.1.3
  Scenario: Check update tour travel is unsuccessful with mandatory checking invalid. Tour name field is empty
    Given User has opened the browser
    And User already in home page
    When User clicks on sidebar with tab name "Kemitraan"
    And User clicks on sidebar with dropdown tab name "Tur dan Travel"
    And User clicks on "Edit" button on specific tur
    And User edit form
      | nama_tur |  |
    And User clicks on "Simpan" button
    Then User should be able to see error notification with message "Validation errors in your request"

  @0.1.4
  Scenario: Check update tour travel is unsuccessful with format checking invalid. Thumbnail field has invalid image format
    Given User has opened the browser
    And User already in home page
    When User clicks on sidebar with tab name "Kemitraan"
    And User clicks on sidebar with dropdown tab name "Tur dan Travel"
    And User clicks on "Edit" button on specific tur
    And User edit form
      | thumbnail | baliadventure.pdf  |
    And User clicks on "Simpan" button
    Then User should be able to see error notification with message "Validation errors in your request"