# Author : Nisa Hauna Yusriyyah
# Date : 06/05/2023
# Description : Menghapus data atraksi pada CMS Geotara

@HapusAtraksi
Feature: Menghapus data atraksi

#TC 1
	@HapusAtraksi1
  Scenario: Batal menghapus data atraksi
    Given User has opened the browser
    And User open website cms geotara
    And User inputs valid authorization
    When User click on sidebar Kemitraan
    And User click Atraksi
    When User click button delete
    And User gets notification message
    Then User click button cancel
    
#TC 2
	@HapusAtraksi2
	Scenario: Berhasil menghapus data atraksi
	  Given User has opened the browser
    And User open website cms geotara
    And User inputs valid authorization
    When User click on sidebar Kemitraan
    And User click Atraksi
    When User click button delete again
    And User gets notification message again
    And User click button hapus
    Then User gets notification success message