package pages;

import driver.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;
import utilities.SmsReader;

public class VerificationPage {

    public VerificationPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()),this);
    }

    @AndroidFindBy(id = "com.martitech.marti:id/p1")
    public WebElement code1;

    @AndroidFindBy(id = "com.martitech.marti:id/p2")
    public WebElement code2;

    @AndroidFindBy(id = "com.martitech.marti:id/p3")
    public WebElement code3;

    @AndroidFindBy(id = "com.martitech.marti:id/p4")
    public WebElement code4;

    @AndroidFindBy(id = "com.martitech.marti:id/btnLater")
    public WebElement maybeLater;


    public void smsRequest(){

        // SMS ulaşması için bekle
        ReusableMethods.wait(7);

        // SMS’ten kodu al
        String smsCode = SmsReader.getLatestMartiCode();
        System.out.println("Gelen Kod: " + smsCode);

        // Kod giriş alanına yaz
        if (smsCode != null && smsCode.length() == 4) {
            code1.sendKeys(String.valueOf(smsCode.charAt(0)));
            ReusableMethods.wait(1);
            code2.sendKeys(String.valueOf(smsCode.charAt(1)));
            ReusableMethods.wait(1);
            code3.sendKeys(String.valueOf(smsCode.charAt(2)));
            ReusableMethods.wait(1);
            code4.sendKeys(String.valueOf(smsCode.charAt(3)));
            ReusableMethods.wait(1);
        } else {
            throw new RuntimeException("Gelen SMS kodu hatalı veya eksik: " + smsCode);
        }
    }
}
