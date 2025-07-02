package pages;

import driver.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FindingScooterPage {

    public FindingScooterPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()),this);
    }

    @AndroidFindBy(id = "com.martitech.marti:id/llRingBell")
    public WebElement ring;

    @AndroidFindBy(id = "com.martitech.marti:id/btnReserve")
    public WebElement reserveButton;
}
