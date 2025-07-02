package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPages;
import pages.VerificationPage;

public class SmsVerificationTest {

    LoginPages loginPages = new LoginPages();
    HomePage homePage = new HomePage();
    VerificationPage verificationPage = new VerificationPage();

    @Test
    public void smsVerify(){

        // Telefon numarası gir
        loginPages.number.click();
        loginPages.number.sendKeys("5399479541");

        // Devam Et
        loginPages.butonNext.click();

        // Sms istegi ve Dogrulama
        verificationPage.smsRequest();
        Assert.assertTrue(homePage.startRidingButton.isDisplayed());


    }
}
