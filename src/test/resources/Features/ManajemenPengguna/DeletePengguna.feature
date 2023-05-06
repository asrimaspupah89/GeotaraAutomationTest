#Author: Caturiani Pratidina Bintari
#Date : 5 April 2023
#Feature: Add Pengguna
@DeletePengguna
Feature: Delete User

  #@AddPengguna1
  Scenario: delete user
    Given membuka broswe
    And user membuka web geotara
    And user memasukkan email dan password
    And user berada di dashboard geotara
    And user dinavigasikan ke halaman pengguna
    When user menekan tombol hapus
    Then menekan tombol konfirmasi
    And notifikasi user berhasil dihapus
