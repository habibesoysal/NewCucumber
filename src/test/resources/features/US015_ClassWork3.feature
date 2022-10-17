@auto
Feature: US015 Kullanici giris testi

  Scenario: Kullanici sitede hesap olusturur
  #http://automationpractice.com/index.php sayfasina gidelim

    Given kullanici "autoUrl" user web sayfasinda
    And kullanici sign in linkine tiklar
    And kullanici Create and account bölümüne email adresi girer
    And kullanici Create an Account butonuna basar
    And kullanici kisisel bilgilerini ve iletisim bilgilerini girer  And user Register butonuna basar
    Then kullanicinin hesap olusturuldugunu dogrulayin
    And sayfayı kapatir