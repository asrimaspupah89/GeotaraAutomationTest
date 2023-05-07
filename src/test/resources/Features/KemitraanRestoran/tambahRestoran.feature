#Author
#Date
#Description
@TambahRestoran
Feature: feature to test tambah restoran functionality

  @TambahRestoran
  Scenario Outline: Check valid input in all field
    Given User tambah restoran has opened the browser
    And User tambah restoran already in home page
    When User tambah restoran clicks on  Kemitraan button
    And User tambah restoran clicks on Restoran button
    And User tambah restoran clicks on Tambah button
    And User tambah restoran mengisi "<nama>" "<banner>" "<provinsi>" "<kota>" "<distrik>" "<desa>" "<alamat>" "<longitude>" "<latitude>" "<no_telp>" "<email>" "<rating>" "<jamBuka>" "<jamTutup>"
    And User tambah restoran clicks on "<simpan>" button
    Then User tambah restoran should be "<condition>" to see notifications Data Tersimpan

    Examples:
      | nama            | banner    | provinsi  | kota          | distrik | desa   | alamat                        | longitude | latitude | no_telp      | email          | rating | jamBuka    | jamTutup |
      | Restaurant A  | D:\\1.jpg | JAWA TIMUR| KOTA SURABAYA | SAWAHAN | KEDUNG | Jl. Raya Kedung Kandang No. 10| 112.7329  | -7.2575  | 0265639098   | chez@gmail.com | 4      | 07:30 AM   | 11:30 PM |
      | Restaurant B  | D:\\2.jpg | JAWA BARAT| KOTA CIMAHI | CIMAHI UTARA | KEDUNG | Jl. Raya Kedung Kandang No. 10| 112.7329  | -7.2575  | 0265639098   | chez@gmail.com | 4      | 07:30 AM   | 11:30 PM |
      | Restaurant C  | D:\\3.jpg | JAWA BARAT| KOTA BANDUNG | SAWAHAN | KEDUNG | Jl. Raya Kedung Kandang No. 10| 112.7329  | -7.2575  | 0265639098   | chez@gmail.com | 4      | 07:30 AM   | 11:30 PM |
      | Restaurant D  | D:\\4.jpg | JAWA TIMUR| KOTA BANDUNG | SAWAHAN | KEDUNG | Jl. Raya Kedung Kandang No. 10| 112.7329  | -7.2575  | 0265639098   | chez@gmail.com | 4      | 07:30 AM   | 11:30 PM |