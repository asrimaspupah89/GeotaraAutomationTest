#Author
#Date
#Description
@HapusAkomodasi
Feature: feature to test hapus akomodasi functionality

  @HapusAkomodasi
  Scenario Outline: Check valid input in all field
    Given User hapus akomodasi has opened the browser
    And User hapus akomodasi already in home page
    When User hapus akomodasi clicks on sidebar with tab name Kemitraan
    And User hapus akomodasi clicks on sidebar with dropdown tab name Akomodasi
    And User hapus akomodasi clicks on Hapus "<row_data>" button
    And User hapus akomodasi gets a data delete notification
    And User hapus akomodasi clicks on "<choice>" button
    Then User hapus akomodasi should be "<condition>" to see notification Data berhasil Dihapus
    And User hapus akomodasi should be able to see the Accommodation home page "<result>"

    Examples: 
      | choice   | condition | result                                      | row_data |
      | Ya Hapus | able      | with the deleted data on the home page gone |        0 |
      | Ya Hapus | able      | with the deleted data on the home page gone |        1 |
      | Cancel   | not able  | succesfully                                 |        0 |
      
