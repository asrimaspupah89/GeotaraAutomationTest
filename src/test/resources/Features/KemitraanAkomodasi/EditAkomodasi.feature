#Author: arsal fadilah
#Keywords Summary : CMS Geotara
#Feature: Edit Kemitraan merchant.

@EditAccomodationTestScenario
Feature: feature to test edit kemitraan accomodation functionality
	
	Scenario Outline: Login
		Given browser is open
    Given user is on login page
    When user enters "admin@geotara.com" and "admin"
    And clicks on login button
    Then user is navigated to the home page

  Scenario: Check valid input in all field
    Given user in dashboard page
    When user clicks on kemitraan tab
    And clicks on akomodasi menu
    Then user is navigated to the accomodation page
    When user clicks on btn edit
  	Then user is navigated to edit accomodation page
  	When user enters accomodation info "<nama>" and "<deskripsi>" and "<banner>" and "<provinsi>" and "<kota>" and "<distrik>" and "<desa>" and "<alamat>" and "<longitude>" and "<latitude>" and "<no_telp>" and "<email>" and "<harga>" and "<rating>" and "<fasilitas>"
  	And clicks submit btn
  	Then user see message "Akomodasi berhasil diedit"
	
    Examples:
      | nama       | deskripsi             | banner                 | provinsi  | kota          | distrik | desa   | alamat                        | longitude | latitude | no_telp      | email                  | harga    | rating | fasilitas    |
      | Hotel ABC  | Hotel terbaik di kota | D:\\stiker-geotara.png | JAWA TIMUR| KOTA SURABAYA | SAWAHAN | KEDUNG | Jl. Raya Kedung Kandang No. 10| 112.7329  | -7.2575  | 081234567890 | info@hotelabc.com      | 500000   | 4.5    | kamar,toilet |
      
	Scenario: Check invalid input in a field
    Given user in dashboard page
    When user clicks on kemitraan tab
    And clicks on akomodasi menu
    Then user is navigated to the accomodation page
    When user clicks on btn edit
  	Then user is navigated to edit accomodation page
  	When user enters accomodation info "<nama>" and "<deskripsi>" and "<banner>" and "<provinsi>" and "<kota>" and "<distrik>" and "<desa>" and "<alamat>" and "<longitude>" and "<latitude>" and "<no_telp>" and "<email>" and "<harga>" and "<rating>" and "<fasilitas>"
  	And clicks submit btn
  	Then user see message "Akomodasi gagal diedit"
	
    Examples:
      | nama       | deskripsi             | banner                 | provinsi  | kota          | distrik | desa   | alamat                        | longitude | latitude | no_telp      | email               | harga    | rating | fasilitas    |
      | Hotel ABC  | Hotel terbaik di kota | D:\\stiker-geotara.png | JAWA TIMUR| KOTA SURABAYA | SAWAHAN | KEDUNG | Jl. Raya Kedung Kandang No. 10| 112.7329  | -7.2575  | 081234567890 | amail.com           | 500000   | 4.5    | kamar,toilet |
      | Hotel ABC  | Hotel terbaik di kota | D:\\stiker-geotara.png | JAWA TIMUR| KOTA SURABAYA | SAWAHAN | KEDUNG | Jl. Raya Kedung Kandang No. 10| 112.7329  | -7.2575  | 081234567890 | amail@mail.com      | 500000   | *      | kamar,toilet |
      | Hotel ABC  | Hotel terbaik di kota | D:\\stiker-geotara.png | JAWA TIMUR| KOTA SURABAYA | SAWAHAN | KEDUNG | Jl. Raya Kedung Kandang No. 10| 112.7329  | -7.2575  | 081234567890111 | amail@mail.com   | 500000   | 4.5    | kamar,toilet |
      | Hotel ABC  | Hotel terbaik di kota | D:\\stiker-geotara.png | JAWA TIMUR| KOTA SURABAYA | SAWAHAN | KEDUNG | Jl. Raya Kedung Kandang No. 10| 112.7329  | -7.2575  | 081234567890 | amil@mail.com       | 500000   | 4.5    |  |