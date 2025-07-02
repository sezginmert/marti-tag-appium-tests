package test;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.FindingScooterPage;
import pages.HomePage;
import pages.LoginPages;
import pages.VerificationPage;
import utilities.ReusableMethods;
import utilities.WaitUtils;

public class LoginTest extends WaitUtils{

    LoginPages loginPages = new LoginPages();
    HomePage homePage = new HomePage();
    FindingScooterPage findingScooterPage = new FindingScooterPage();
    VerificationPage verificationPage = new VerificationPage();

    WebDriver driver;

    @Test
    public void testValidLoginWithSmsCode() {


        loginPages.number.click();
        loginPages.number.sendKeys("5399479541");
        loginPages.privacyNoticeClick.click();
        loginPages.commercialAgreementConfirm.click();
        loginPages.butonNext.click();
        verificationPage.smsRequest();
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
