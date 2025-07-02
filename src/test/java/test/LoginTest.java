package test;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.FindingScooterPage;
import pages.HomePage;
import pages.LoginPages;
import utilities.ReusableMethods;
import utilities.SmsReader;
import utilities.WaitUtils;

public class LoginTest extends WaitUtils{

    LoginPages loginPages = new LoginPages();
    HomePage homePage = new HomePage();
    FindingScooterPage findingScooterPage = new FindingScooterPage();

    WebDriver driver;

    @Test
    public void testValidLoginWithSmsCode() {

        ReusableMethods.wait(10);

        // Telefon numarası gir
        loginPages.number.click();
        loginPages.number.sendKeys("5399479541");

        loginPages.privacyNoticeClick.click();
        loginPages.commercialAgreementConfirm.click();

        // Devam Et
        loginPages.butonNext.click();

        // SMS ulaşması için bekle
        ReusableMethods.wait(10);

        // SMS’ten kodu al
        String smsCode = SmsReader.getLatestMartiCode();
        System.out.println("Gelen Kod: " + smsCode);

        // Kod giriş alanına yaz
        if (smsCode != null && smsCode.length() == 4) {
            loginPages.code1.sendKeys(String.valueOf(smsCode.charAt(0)));
            ReusableMethods.wait(1);
            loginPages.code2.sendKeys(String.valueOf(smsCode.charAt(1)));
            ReusableMethods.wait(1);
            loginPages.code3.sendKeys(String.valueOf(smsCode.charAt(2)));
            ReusableMethods.wait(1);
            loginPages.code4.sendKeys(String.valueOf(smsCode.charAt(3)));
            ReusableMethods.wait(1);
        } else {
            throw new RuntimeException("Gelen SMS kodu hatalı veya eksik: " + smsCode);
        }

        WaitUtils.waitForVisibility(Driver.getAppiumDriver(),homePage.startRidingButton,15);
        homePage.startRidingButton.click();

        ReusableMethods.wait(10);

        homePage.selectRandomScooter();
        findingScooterPage.ring.click();
        findingScooterPage.reserveButton.click();





        //Burası kartı sonra ekle yeri
        //WaitUtils.waitForClickability(Driver.getAppiumDriver(),loginPages.maybeLater,15);
        //loginPages.maybeLater.click();






    }

}
