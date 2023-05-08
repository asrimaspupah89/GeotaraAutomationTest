# Author Fadhil Muhammad
# Date 5 - 08 - 2023
# Description Menambahkan acara baru

@0.0
Feature: feature to test add Acara and travel functionality

  @0.0.1
  Scenario: Check add acara is successful with valid input
    Given User has opened the browser
    And User already in home page
    When User clicks on sidebar with tab name "Publikasi"
    And User clicks on sidebar with dropdown tab name "Acara"
    And User clicks on "Tambah" button
    When User fill form
      | nama_event           | test1                                                                                                                                                                                                                                                                                                                                                         |
      | flyer_image          | D:/Downloads/test.jpg                                                                                                                                                                                                                                                                                                                                         |
      | deskripsi            | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut consectetur pellentesque gravida. Vestibulum fermentum aliquet orci vel varius. Etiam sit amet magna libero. Proin commodo magna justo, eget feugiat leo suscipit ut. Praesent ac pellentesque orci. Quisque vel ipsum justo. Pellentesque at risus fermentum, faucibus dolor quis, aliquam nibh. |
      | nama_penyelenggara   | fulan1                                                                                                                                                                                                                                                                                                                                                        |
      | kontak_penyelanggara | 6282152132412                                                                                                                                                                                                                                                                                                                                                 |
      | harga                | 500000                                                                                                                                                                                                                                                                                                                                                        |
      | Wisata               | Pantai Karapyak                                                                                                                                                                                                                                                                                                                                               |
      | tanggal_mulai_1      | 2023-05-07                                                                                                                                                                                                                                                                                                                                                    |
      | tanggal_selesai_1    | 2023-05-10                                                                                                                                                                                                                                                                                                                                                    |
      | waktu_mulai_1        | 06:00 AM                                                                                                                                                                                                                                                                                                                                                      |
      | waktu_selesai_1      | 08:00 PM                                                                                                                                                                                                                                                                                                                                                      |
    And User clicks on "Simpan" button
    Then User should be able to see success notification with message "Acara berhasil ditambahkan"
    And User is navigated to the acara list page

  @0.0.2
  Scenario: Check add acara is unsuccessful with mandatory checking invalid. All field are empty
    Given User has opened the browser
    And User already in home page
    When User clicks on sidebar with tab name "Publikasi"
    And User clicks on sidebar with dropdown tab name "Acara"
    And User clicks on "Tambah" button
    And User clicks on "Simpan" button
    Then User should be able to see error notification with message "Validation errors in your request"

  @0.0.3
  Scenario: Check add acara is unsuccessful with mandatory checking invalid. Acara name field is empty
    Given User has opened the browser
    And User already in home page
    When User clicks on sidebar with tab name "Pulbikasi"
    And User clicks on sidebar with dropdown tab name "Acara"
    And User clicks on "Tambah" button
    And User fill form
      | nama                 |                                                                                                                                                                                                                                                                                                                                                               |
      | flyer_image          | D:/Downloads/test.jpg                                                                                                                                                                                                                                                                                                                                         |
      | deskripsi            | Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut consectetur pellentesque gravida. Vestibulum fermentum aliquet orci vel varius. Etiam sit amet magna libero. Proin commodo magna justo, eget feugiat leo suscipit ut. Praesent ac pellentesque orci. Quisque vel ipsum justo. Pellentesque at risus fermentum, faucibus dolor quis, aliquam nibh. |
      | nama_penyelenggara   | fulan1                                                                                                                                                                                                                                                                                                                                                        |
      | kontak_penyelanggara | 6282152132412                                                                                                                                                                                                                                                                                                                                                 |
      | harga                | 500000                                                                                                                                                                                                                                                                                                                                                        |
      | Wisata               | Pantai Karapyak                                                                                                                                                                                                                                                                                                                                               |
      | tanggal_mulai_1      | 2023-05-07                                                                                                                                                                                                                                                                                                                                                    |
      | tanggal_selesai_1    | 2023-05-10                                                                                                                                                                                                                                                                                                                                                    |
      | waktu_mulai_1        | 06:00 AM                                                                                                                                                                                                                                                                                                                                                      |
      | waktu_selesai_1      | 08:00 PM                                                                                                                                                                                                                                                                                                                                                      |
    And User clicks on "Simpan" button
    Then User should be able to see error notification with message "Validation errors in your request"

  @0.0.4
  Scenario: Check add acara is unsuccessful with format checking invalid. Thumbnail field has invalid image format
    Given User has opened the browser
    And User already in home page
    When User clicks on sidebar with tab name "Pulbikasi"
    And User clicks on sidebar with dropdown tab name "Acara"
    And User clicks on "Tambah" button
    And User fill form
      | nama_tur            | Bali Adventure Acara 2                                 |
      | thumbnail           | D:/Downloads/test.jpg                                  |
      | provinsi            | Bali                                                   |
      | kota                | Kabupaten Badung                                       |
      | distrik             | Kuta                                                   |
      | desa                | Legian                                                 |
      | alamat              | Jalan Legian No. 123                                   |
      | latitude            | -8.7152                                                |
      | longitude           | 115.1707                                               |
      | no_telp             | 62123456789                                            |
      | email               | info@baliadventureAcara.com                            |
      | rating              | 4.5                                                    |
      | fasilitas           | transportasi, guide, makan siang, tiket masuk wisata   |
      | tipe_1              | transportasi, guide, makan siang, tiket masuk wisata   |
      | harga_1             | 500000                                                 |
      | thumbnail_1         | raftingsungaiayung.jpg                                 |
      | keberangkatan_1     | Hotel di kawasan Kuta, Seminyak, Legian, atau Nusa Dua |
      | tujuan_1            | Sungai Ayung                                           |
      | jam_keberangkatan_1 | 09:30 AM                                               |
      | estimasi_sampai_1   | 08:00 PM                                               |
    And User clicks on "Simpan" button
    Then User should be able to see error notification with message "Validation errors in your request"
