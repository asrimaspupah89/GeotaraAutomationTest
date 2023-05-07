#Author 		: Nisa Hauna Yusriyyah
#Date				: 06/05/2023
#Description: Menambah data atraksi pada CMS Geotara

@TambahAtraksi
Feature: Menambah data atraksi

  @TambahAtraksi1
  Scenario Outline: Check valid input in all field
    Given Browser already opened
    And User has opened cms geotara web app
    And User inputs valid email and password
    When User click kemitraan on sidebar
    And User click Atraksi on dropdown list
    And User clicks button tambah
    And User input "<nama>" "<banner>" "<harga_tiket>" "<provinsi>" "<kota>" "<distrik>" "<desa>" "<alamat>" "<longitude>" "<latitude>" "<tipe_atraksi>" "<rating>" "<deskripsi>" "<durasi>" dan "<kapasitas>"
    And User click button simpan
    Then User tambah akomodasi should be "<condition>" to see notifications Data Tersimpan

    Examples: 
      | nama                 | banner 																       | harga_tiket  | provinsi   | kota         | distrik  | desa        | alamat       | longitude          | latitude           | tipe_atraksi | rating  | deskripsi                               | durasi | kapasitas | condition |
      | Data Testing Atraksi | C:/Users/Nisa Hauna/KULIAH/atraksiTesting.jpg | 50.000       | JAWA BARAT | KOTA BANDUNG | SUKASARI | GEGERKALONG | Jl. Ciwaruga | 108.65524047681636 | -7.698458123297598 | Air          | 4       | Ini merupakan dummy data untuk testing. | 30     | 5         | able      |
      |                      |                                               |              |            |              |          |             |              |                    |                    |              |         |                                         |        |           | not able  |
      | Data Testing Atraksi | C:/Users/Nisa Hauna/KULIAH/atraksiTesting.jpg | 50.000       | JAWA BARAT | KOTA BANDUNG | SUKASARI | GEGERKALONG | Jl. Ciwaruga | 108.65524047681636 | -7.698458123297598 | Air          | 4       |                                         | 30     | 5         | not able  |
      | Data Testing Atraksi | C:/Users/Nisa Hauna/KULIAH/atraksiTesting.pdf | 50.000       | JAWA BARAT | KOTA BANDUNG | SUKASARI | GEGERKALONG | Jl. Ciwaruga | 108.65524047681636 | -7.698458123297598 | Air          | 4       | Ini merupakan dummy data untuk testing. | 30     | 5         | not able  |
      | Data Testing Atraksi | C:/Users/Nisa Hauna/KULIAH/atraksiTesting.jpg | 50.000       | JAWA BARAT | KOTA BANDUNG | SUKASARI | GEGERKALONG | Jl. Ciwaruga | 108.65524047681636 | -7.698458123297598 | Air          | 4 per 5 | Ini merupakan dummy data untuk testing. | 30     | 5         | not able  |
     