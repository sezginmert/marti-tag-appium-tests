package pages;

import driver.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumElementLocatorFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import java.util.List;
import java.util.Random;

public class HomePage {

    AppiumDriver driver = Driver.getAppiumDriver();

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()),this);
    }


    @AndroidFindBy(id = "com.martitech.marti:id/marti_action")
    public WebElement startRidingButton;


    public void selectRandomScooter() {
        // Scooter marker'ları temsil eden tüm elementleri bul
        List<WebElement> scooterList = driver.findElements(By.xpath("(//android.view.View[@content-desc=\"Map Marker\"])[.]"));

        // Eğer listede scooter varsa
        if (!scooterList.isEmpty()) {
            System.out.println("Bulunan scooter sayısı: " + scooterList.size());

            // Rastgele bir scooter seç
            Random rand = new Random();
            int index = rand.nextInt(scooterList.size());

            WebElement selectedScooter = scooterList.get(index+1);
            selectedScooter.click();

            System.out.println("Scooter seçildi. Index: " + (index+1));
        } else {
            System.out.println("Scooter bulunamadı.");
        }
    }
}
