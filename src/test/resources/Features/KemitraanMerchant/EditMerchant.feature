#Author: arsal fadilah
#Keywords Summary : CMS Geotara
#Feature: Edit Kemitraan merchant.

@SmokeScenario
Feature: feature to test edit kemitraan merchant functionality
	
	@EditMerchantTest
	Scenario Outline: Login
		Given browser is open
    Given user is on login page
    When user enters "<email>" and "<password>"
    And clicks on login button
    Then user is navigated to the home page
    
    Examples: 
      | email          		| password |
      | admin@geotara.com | admin    |
		
  @EditMerchantTest
  Scenario: Navigate to merchant page
    Given user in home page
    When user clicks on kemitraan_tab
    And clicks on merchant menu
    Then user is navigated to the merchant page
   
  #Scenario: Check valid input in all field
  #	Given user in merchant page
  #	When user clicks on btn edit
  #	Then user is navigated to edit merchant page
  #	When user enters "<nama>" "<thumbnail>" "<provinsi>" "<kota>" "<distrik>" "<desa>" "<alamat>"
  #	"<longitude>" "<latitude>"
    