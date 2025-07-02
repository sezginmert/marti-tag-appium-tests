package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static driver.Driver.getAppiumDriver;

public class LoginPages {

    public LoginPages() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }


    @AndroidFindBy(id = "com.martitech.marti:id/phoneNumber")
    public WebElement number;

    @AndroidFindBy(id = "com.martitech.marti:id/explicitConsentTextConfirm")
    public WebElement privacyNoticeClick;

    @AndroidFindBy(id = "com.martitech.marti:id/commercialAgreementConfirm")
    public WebElement commercialAgreementConfirm;

    @AndroidFindBy(id = "com.martitech.marti:id/btnNext")
    public WebElement butonNext;

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




}
