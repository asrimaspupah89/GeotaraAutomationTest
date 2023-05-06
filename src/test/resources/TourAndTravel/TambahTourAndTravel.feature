@0.0
Feature: feature to test add tour and travel functionality

  @0.0.1
  Scenario: Check add tour travel is successful with valid input
    Given User has opened the browser
      And User already in home page
    When User clicks on sidebar with tab name "Kemitraan"
      And User clicks on sidebar with dropdown tab name "Tur dan Travel"
      And User clicks on "Tambah" button
      And User fill form
        | nama_tur | Bali Adventure Tour |
        | thumbnail | baliadventure.jpg  |
        | provinsi | Bali                |
        | kota     | Kabupaten Badung    |
        | distrik  | Kuta                |
        | desa     | Legian              |
        | alamat   | Jalan Legian No. 123 |
        | latitude | -8.7152              |
        | longitude | 115.1707            |
        | no_telp   | 62123456789         |
        | email     | info@baliadventuretour.com |
        | rating    | 4.5                        |
        | fasilitas | transportasi, guide, makan siang, tiket masuk wisata  |
        | tipe_1    | transportasi, guide, makan siang, tiket masuk wisata  |
        | harga_1   | 500000                                                |
        | thumbnail_1 | raftingsungaiayung.jpg                              |
        | keberangkatan_1 | Hotel di kawasan Kuta, Seminyak, Legian, atau Nusa Dua  |
        | tujuan_1        | Sungai Ayung                                            |
        | jam_keberangkatan_1 | 09:30 AM                                            |
        | estimasi_sampai_1   | 12:30 PM                                            |
      And User clicks on "Simpan" button
    Then User should be able to see success notification with message "Tour berhasil ditambahkan"
      And User is navigated to the tour and travel list page

  @0.0.2
  Scenario: Check add tour travel is unsuccessful with mandatory checking invalid. All field are empty
    Given User has opened the browser
      And User already in home page
    When User clicks on sidebar with tab name "Kemitraan"
      And User clicks on sidebar with dropdown tab name "Tur dan Travel"
      And User clicks on "Tambah" button
      And User clicks on "Simpan" button
    Then User should be able to see error notification with message "Validation errors in your request"

  @0.0.3
  Scenario: Check add tour travel is unsuccessful with mandatory checking invalid. Tour name field is empty
    Given User has opened the browser
      And User already in home page
    When User clicks on sidebar with tab name "Kemitraan"
      And User clicks on sidebar with dropdown tab name "Tur dan Travel"
      And User clicks on "Tambah" button
      And User fill form
        | nama_tur |  |
        | thumbnail | baliadventure.jpg  |
        | provinsi | Bali                |
        | kota     | Kabupaten Badung    |
        | distrik  | Kuta                |
        | desa     | Legian              |
        | alamat   | Jalan Legian No. 123 |
        | latitude | -8.7152              |
        | longitude | 115.1707            |
        | no_telp   | 62123456789         |
        | email     | info@baliadventuretour.com |
        | rating    | 4.5                        |
        | fasilitas | transportasi, guide, makan siang, tiket masuk wisata  |
        | tipe_1    | Paket Menginap Premium                                |
        | harga_1   | 500000                                                |
        | thumbnail_1 | raftingsungaiayung.jpg                              |
        | keberangkatan_1 | Hotel di kawasan Kuta, Seminyak, Legian, atau Nusa Dua  |
        | tujuan_1        | Sungai Ayung                                            |
        | jam_keberangkatan_1 | 09:30 AM                                            |
        | estimasi_sampai_1   | 12:30 PM                                            |
      And User clicks on "Simpan" button
    Then User should be able to see error notification with message "Validation errors in your request"

  @0.0.4
  Scenario: Check add tour travel is unsuccessful with format checking invalid. Thumbnail field has invalid image format
    Given User has opened the browser
      And User already in home page
    When User clicks on sidebar with tab name "Kemitraan"
      And User clicks on sidebar with dropdown tab name "Tur dan Travel"
      And User clicks on "Tambah" button
      And User fill form
        | nama_tur | Bali Adventure Tour 2 |
        | thumbnail | baliadventure.pdf  |
        | provinsi | Bali                |
        | kota     | Kabupaten Badung    |
        | distrik  | Kuta                |
        | desa     | Legian              |
        | alamat   | Jalan Legian No. 123 |
        | latitude | -8.7152              |
        | longitude | 115.1707            |
        | no_telp   | 62123456789         |
        | email     | info@baliadventuretour.com |
        | rating    | 4.5                        |
        | fasilitas | transportasi, guide, makan siang, tiket masuk wisata  |
        | tipe_1    | transportasi, guide, makan siang, tiket masuk wisata  |
        | harga_1   | 500000                                                |
        | thumbnail_1 | raftingsungaiayung.jpg                              |
        | keberangkatan_1 | Hotel di kawasan Kuta, Seminyak, Legian, atau Nusa Dua  |
        | tujuan_1        | Sungai Ayung                                            |
        | jam_keberangkatan_1 | 09:30 AM                                            |
        | estimasi_sampai_1   | 12:30 PM                                            |
      And User clicks on "Simpan" button
    Then User should be able to see error notification with message "Validation errors in your request"