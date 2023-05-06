#Author
#Date
#Description
@SmokeFeature
Feature: feature to test add merchant functionality

  @smoketest
  Scenario: check merchant is successful with valid credentials
		Given browser open
	  And user at login page
	  When user enter email and password
	  And user clicks at login button
	  Then user is navigate to the dashboard page
	  When User click on the kemitraan button
	  And User click on Merchant dan Souvernir button
	  Then User is navigate to the merchant page
	  When User klik tombol hapus dan menghapus baris 7
	  And User click on Ya Hapus button
	  Then User is stay in the merchant page