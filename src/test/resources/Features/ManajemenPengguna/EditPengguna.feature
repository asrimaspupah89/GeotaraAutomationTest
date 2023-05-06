#Author: Dimas Kurniawan
#Date : 6 Mei 2023
#Feature: Edit Pengguna

@MaskurScenario

Feature: EditUser

	#@EditPengguna
  Scenario: Edit User
    Given web browser telah dibuka
    And user mengakses web geotara
    And user menginput email dan password
    And user masuk di dashboard geotara
    And user mengakses ke halaman pengguna
    When user menekan tombol edit
    And user memasukan nama pengguna baru dengan <name> <email>
    And menekan tombol update
    Then notifikasi user berhasil di edit

    Examples: 
      | name      | email 						   |
      | Maskur10  | maskur@gmail.com 		 |
      | Maskur29  | maskur1999@gmail.com |
      | Maskur13_ | maskur9090@gmail.com |