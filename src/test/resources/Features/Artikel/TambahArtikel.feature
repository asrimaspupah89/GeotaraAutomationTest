# author : Temmy Mahesa Ridwan
# Date : 17 April 2023
# Description : menambahkan informasi dan detail tentang artikel baru ke dalam daftar artikel yang tersedia pada website.

Feature: menambah data artikel baru

  Scenario Outline: menambah data artikel baru dengan semua data valid
    Given user has opened the browser
    And user has opened geotara cms
    And user enter email and password
    And user already in dashboard
    And user is navigated to artikel page
    When user menekan tombol tambah artikel
    Then Halaman pindah ke form penambahan artikel
    When user mengupload foto <thumbnail>
    And user menginputkan <title> untuk title artikel
    And user megninputkan <tags> untuk tags artikel
    And user menginputkan <content> untuk konten artikel
    And user menekan tombol submit
    Then menampilkan notifikasi bahwa artikel sudah dibuat
    Examples:
      | thumbnail                     | title     | tags      | content   |
#      | E:\\picture\\meme\\okoklh.png | okoklh    | Indonesia | testing 1 |
#      | E:\\picture\\meme\\okoklh.png | okoklh    | Indonesia | testing 1 |
      | E:\\picture\\meme\\valo.png   | shaq valo | Indonesia |           |




