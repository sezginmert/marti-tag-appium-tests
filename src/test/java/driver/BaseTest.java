package driver;

import io.appium.java_client.AppiumDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import utilities.LoggerHelper;
import utilities.ReusableMethods;
import utilities.ScreenshotUtil;

public class BaseTest {

    LoggerHelper loggerHelper = new LoggerHelper();

    @BeforeClass
    public void setup() {
        Driver.getAppiumDriver();
        ReusableMethods.wait(15);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtil.captureScreenshot();  // Allure'a ekran görüntüsü eklenir
        }
        Driver.quitAppiumDriver();  // Screenshot'tan sonra kapat
    }

    @AfterClass
    public void teardownClass() {
        Driver.quitAppiumDriver();

    }
}
