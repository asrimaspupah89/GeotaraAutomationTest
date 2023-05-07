#Author: Nuno Alwi Azimah
#Keywords Summary : CMS Geotara
#Feature: Edit Kemitraan Restoran.

@EditRestoran
Feature: feature to test edit kemitraan restoran functionality
	
	Scenario Outline: Login
		Given browser is open
    Given user is on login page
    When user enters "admin@geotara.com" and "admin"
    And clicks on login button
    Then user is navigated to the home page

  Scenario: Check valid input in all field
    Given user in dashboard page
    When user clicks on kemitraan tab
    And clicks on restaurant menu
    Then user is navigated to the restaurant page
    When user clicks on btn edit
  	Then user is navigated to edit restaurant page
  	When user enters restaurant info "<nama>" and "<banner>" and "<provinsi>" and "<kota>" and "<distrik>" and "<desa>" and "<alamat>" and "<longitude>" and "<latitude>" and "<no_telp>" and "<email>" and "<rating>" and "<jamBuka>" and "<jamTutup>"
  	And clicks submit btn
  	Then user see message "Restoran berhasil diedit"
	
    Examples:
      | nama            | banner    | provinsi  | kota          | distrik | desa   | alamat                        | longitude | latitude | no_telp      | email          | rating | jamBuka    | jamTutup |
      | Restaurant 123  | D:\\1.jpg | JAWA TIMUR| KOTA SURABAYA | SAWAHAN | KEDUNG | Jl. Raya Kedung Kandang No. 10| 112.7329  | -7.2575  | 0265639098   | chez@gmail.com | 4      | 07:30 AM   | 11:30 PM |
      
	Scenario: Check invalid input in a field
    Given user in dashboard page
    When user clicks on kemitraan tab
    And clicks on restaurant menu
    Then user is navigated to the restaurant page
    When user clicks on btn edit
  	Then user is navigated to edit restaurant page
  	When user enters restaurant info "<nama>" and "<banner>" and "<provinsi>" and "<kota>" and "<distrik>" and "<desa>" and "<alamat>" and "<longitude>" and "<latitude>" and "<no_telp>" and "<email>" and "<rating>" and "<jamBuka>" and "<jamTutup>"
  	And clicks submit btn
  	Then user see message "Restoran gagal diedit"
	
    Examples:
      | nama            | banner    | provinsi  | kota          | distrik | desa   | alamat                        | longitude | latitude | no_telp      | email          | rating | jamBuka    | jamTutup |
      |                 | D:\\1.jpg | JAWA TIMUR| KOTA SURABAYA | SAWAHAN | KEDUNG | Jl. Raya Kedung Kandang No. 10| 112.7329  | -7.2575  | 0265639098   | chez@gmail.com | 4      | 07:30 AM   | 11:30 PM |
      | Restaurant 123  | D:\\1.jpg | JAWA TIMUR| KOTA SURABAYA | SAWAHAN | KEDUNG | Jl. Raya Kedung Kandang No. 10| 112.7329  | -7.2575  |              | chez@gmail.com | 4      | 07:30 AM   | 11:30 PM |
      | Restaurant 123  | D:\\1.jpg | JAWA TIMUR| KOTA SURABAYA | SAWAHAN | KEDUNG | Jl. Raya Kedung Kandang No. 10| 112.7329  | -7.2575  | 0265639098   |                | 4      | 07:30 AM   | 11:30 PM |
      | Restaurant 123  | D:\\1.jpg | JAWA TIMUR| KOTA SURABAYA | SAWAHAN | KEDUNG | Jl. Raya Kedung Kandang No. 10| 112.7329  | -7.2575  | 0265639098   | chez@gmail.com |        | 07:30 AM   | 11:30 PM |      