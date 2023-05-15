#Author: Dimas Kurniawan
#Keywords Summary : 06 Mei 2023
#Feature: Edit Atraksi

@EditAtraksi
Feature: Fitur untuk menguji atraksi 

  Scenario: Cek keberhasilan Input Field
  Given web browser telah dibuka
  And user mengakses web geotara
  And user menginput email dan password
  And user masuk di dashboard geotara
  When user mengklik kemitraan
  And mengklik atraksi
  When user mengkilk tombol edit
  When user memasukan info atraksi "<nama>" and "<harga>" and "<provinsi>" and "<kota>" and "<distrik>" and "<desa>" and "<alamat>" and "<longitude>" and "<latitude>"
  And menekan tombol update
  Then notifikasi user berhasil di edit
  
  Examples:
  | nama        | provinsi	| kota          | distrik | desa   | alamat                        																	   | longitude | latitude | harga    |
  | Arum Jeram  | BENGKULU	| KOTA SORONG   | MASNI   | DISRA  | Desa Selasari, Kecamatan Parigi, Kabupaten Pangandaran, Jawa Barat| 112.7329  | -7.2575  | 500000   |