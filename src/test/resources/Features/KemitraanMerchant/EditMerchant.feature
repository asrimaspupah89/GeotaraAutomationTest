#Author: arsal fadilah
#Keywords Summary : CMS Geotara
#Feature: Edit Kemitraan merchant.

@EditMerchantTestScenario
Feature: feature to test edit kemitraan merchant functionality
	
	Scenario Outline: Login
		Given browser is open
    Given user is on login page
    When user enters "admin@geotara.com" and "admin"
    And clicks on login button
    Then user is navigated to the home page

  Scenario: Check valid input in all field
    Given user in dashboard page
    When user clicks on kemitraan tab
    And clicks on merchant menu
    Then user is navigated to the merchant page
    When user clicks on btn edit
  	Then user is navigated to edit merchant page
  	When user enters merchant info "<nama>" and "<thumbnail>" and "<provinsi>" and "<kota>" and "<distrik>" and "<desa>" and "<alamat>" and "<longitude>" and "<latitude>" and "<jam_buka>" and "<jam_tutup>"
  	And clicks submit btn
  	Then user see message "Merchant berhasil diedit"
	 	
	 	Examples:
	    | nama          | thumbnail                | provinsi   | kota        | distrik     | desa        | alamat                 | longitude  | latitude   | jam_buka  | jam_tutup |
	    | Cafe Kreasi 1 | D:\\stiker-geotara.png   | Jawa Tengah| Semarang    | Tembalang   | Candisari   | Jl. Candisari No. 15A   | 110.4062   | -7.0316    | 08:00     | 20:00     |

	Scenario: Check invalid input in a field
    Given user in dashboard page
    When user clicks on kemitraan tab
    And clicks on merchant menu
    Then user is navigated to the merchant page
    When user clicks on btn edit
  	Then user is navigated to edit merchant page
  	When user enters merchant info "<nama>" and "<thumbnail>" and "<provinsi>" and "<kota>" and "<distrik>" and "<desa>" and "<alamat>" and "<longitude>" and "<latitude>" and "<jam_buka>" and "<jam_tutup>"
	 	And clicks submit btn
  	Then user see message "Merchant berhasil diedit"
  	
	 	Examples:
	    | nama       | thumbnail                | provinsi   | kota        | distrik     | desa        | alamat                  | longitude  | latitude   | jam_buka  | jam_tutup |
	    | Toko Arsal | D:\\stiker-geotara.png   | JAWA TENGAH| SEMARANG    | Tembalang   | Candisari   | Jl. Candisari No. 15A   | 110.4062   | -7.0316    | 08:00     | 20:00     |
	    | Toko Arsal | D:\\stiker-geotara.png   | BALI       | DENPASAR    | Ubud        | Tegalalang  | Jl. Tegalalang No. 10   | 115.2664   | -8.4378    | 09:00     | 22:00     |

	Scenario: Check decrease a produk
    Given user in dashboard page
    When user clicks on kemitraan tab
    And clicks on merchant menu
    Then user is navigated to the merchant page
    When user clicks on btn edit
  	Then user is navigated to edit merchant page
  	When user clicks btn-danger in either one
	 	And clicks submit btn
  	Then user see message "Merchant berhasil diedit"
  	
  Scenario: Check increase a produk
    Given user in dashboard page
    When user clicks on kemitraan tab
    And clicks on merchant menu
    Then user is navigated to the merchant page
    When user clicks on btn edit
  	Then user is navigated to edit merchant page
  	When user clicks btn add
  	And user enters produk info "<nama>" and "<harga>" and "<rating>" and "<deskripsi>" and "<varian>" and "<thumbnail>"
	 	And clicks submit btn
  	Then user see message "Merchant berhasil diedit"
  	  	
  	Examples:
  	  | nama        | harga | rating | deskripsi          | varian   | thumbnail           |      
      | Produk A    | 20000 | 4.5    | Deskripsi Produk A | Varian A | image_produk_A.jpg |