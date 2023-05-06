#Author
#Date
#Description
@HapusRestoran
Feature: feature to test hapus restoran functionality

  @HapusAkomodasi
  Scenario Outline: Check valid input in all field
    Given User hapus restoran has opened the browser
    And User hapus restoran already in home page
    When User hapus restoran clicks on Kemitraan button
    And User hapus restoran clicks on Restoran button
    And User hapus restoran clicks on Hapus "<row_data>" button
    And User hapus restoran gets a data delete notification
    And User hapus restoran clicks on "<choice>" button
    Then User hapus restoran should be "<condition>" to see notification Data berhasil Dihapus
    And User hapus restoran should be able to see the Restoran home page "<result>"