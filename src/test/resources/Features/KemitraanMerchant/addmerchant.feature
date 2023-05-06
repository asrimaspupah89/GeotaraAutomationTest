#Author
#Date
#Description
@SmokeFeature
Feature: feature to test add merchant functionality

  @smoketest
  Scenario: check merchant is successful with valid credentials
		Given browser opened
	  And user on login page
	  When user enters email and password
	  And user click on login button
	  Then user is navigated to the dashboard page
	  When User clicks on the kemitraan button
	  And User clicks on Merchant dan Souvernir button
	  Then User is navigated to the merchant page
		When User clicks on the tambah button
		Then User is navigated to the tambah page
		When user enters merchant name
		And User clicks on choose file button
		And User clicks on Provinsi
		And User clicks on Kota
		And User clicks on Distrik
		And User clicks on Desa
		And User clicks on Alamat
		And User clicks on Longitude