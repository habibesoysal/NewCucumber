package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.AutoPage;
import utilities.ConfigReader;
import utilities.Driver;

public class AutoStepDefinition {
    AutoPage autoPageObje = new AutoPage();
    Faker faker = new Faker();
    Actions actions = new Actions(Driver.getDriver());

    @Given("kullanici {string} user web sayfasinda")
    public void kullaniciUserWebSayfasinda(String arg0) {
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));


    }

    @And("kullanici sign in linkine tiklar")
    public void kullaniciSignInLinkineTiklar() {
        autoPageObje.login.click();
    }

    @And("kullanici Create and account bölümüne email adresi girer")
    public void kullaniciCreateAndAccountBölümüneEmailAdresiGirer() {
        autoPageObje.createEmail.sendKeys(faker.internet().emailAddress());
    }

    @And("kullanici Create an Account butonuna basar")
    public void kullaniciCreateAnAccountButonunaBasar() {
        actions.sendKeys(Keys.TAB, Keys.ENTER).perform();

    }

    @And("kullanici kisisel bilgilerini ve iletisim bilgilerini girer  And user Register butonuna basar")
    public void kullaniciKisiselBilgileriniVeIletisimBilgileriniGirerAndUserRegisterButonunaBasar() {
        autoPageObje.radioButton.click();
        actions.sendKeys(Keys.TAB).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).sendKeys(Keys.TAB, Keys.TAB).
                sendKeys(faker.internet().password()).sendKeys(Keys.TAB, "1").
                sendKeys(Keys.TAB, "June").sendKeys(Keys.TAB, "1984").
                sendKeys(Keys.TAB, Keys.SPACE).sendKeys(Keys.TAB, Keys.SPACE).
                sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, faker.company().name()).sendKeys(Keys.TAB).
                sendKeys(faker.address().country()).sendKeys(Keys.TAB).
                sendKeys(faker.address().city()).sendKeys(Keys.TAB).
                sendKeys("kansa").sendKeys(Keys.TAB).
                sendKeys("Alaska").sendKeys(Keys.TAB, "07100").sendKeys(Keys.TAB).
                sendKeys("United States").sendKeys(Keys.TAB, Keys.TAB, Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).perform();

    } // actions.sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER);

    @Then("kullanicinin hesap olusturuldugunu dogrulayin")
    public void kullanicininHesapOlusturuldugunuDogrulayin() {
        Assert.assertTrue(autoPageObje.myAccountText.isDisplayed());

    }


    @And("sayfayı kapatir")
    public void sayfayıKapatir() {
        Driver.closeDriver();
    }

    @And("kullanici Create and account bolumune email adresi girer")
    public void kullaniciCreateAndAccountBolumuneEmailAdresiGirer() {
    }

    @And("kullanici kisisel bilgilerini ve iletisim bilgilerini girer")
    public void kullaniciKisiselBilgileriniVeIletisimBilgileriniGirer() {
    }

    @And("kullanici Register butonuna basar")
    public void kullaniciRegisterButonunaBasar() {

    }

}
