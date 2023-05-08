# Author Fadhil Muhammad
# Date 5 - 08 - 2023
# Description Mengapus salah satu artikel
Feature: Menghapus data artikel

  Scenario: Menghapus data artikel
    Given browser dibuka
    And user membuka website geotara cms
    And user menginputkan username dan password
    And user berada di halaman artikel
    When user menekan tombol delete
    And notifikasi penghapusan data muncul
    And user menekan tombol hapus
    Then sistem membari notifikasi bahwa data telah dihapus