#Author: Caturiani Pratidina Bintari
#Date : 5 April 2023
#Feature: Add Pengguna
@AddPengguna
Feature: AddUser

  #@AddPengguna1
  Scenario: menambah data pengguna baru dengan semua data vali
    Given browser terbuka
    And user membuka cms geotara
    And user memasukkan "<email>" dan "<password>"
    And user berada di dashboard
    And user diarahkan ke halaman pengguna
    When user menekan tombol tambah pengguna
    Then user diarahkan ke form tambah pengguna
    When user add <nama> untuk nama baru
    And user add <email> untuk email baru
    And user add <kataSandi> untuk password
    And user add <confKataSandi> untuk konfir pass
    And user pilih <peran> untuk peran
    Then menampilkan notifikasi berhasil Add Pengguna
Examples: 
  | nama  | email            	| kataSandi | confKataSandi | peran   |
  | crumy | ocaaa@yahoo.com 	| ocaaa 		| ocaaa      		| admin 	|

