package testPackage.Utilities;

import Pages.Main.ConstData;
import Pages.Main.Login;
import com.epam.healenium.SelfHealingDriver;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    //is a special WebDriver from the Healenium library.
    // It wraps a Selenium WebDriver and adds its own self-healing logic.
    protected SelfHealingDriver driver;

    @BeforeClass(description = "Setup Browser instance.", alwaysRun = true)
    public void beforeClass() {
        WebDriver delegate = new ChromeDriver();
        driver = SelfHealingDriver.create(delegate);
        new Login(driver).navigate();
        new Login(driver).performLogin(ConstData.LOGIN_USERNAME, ConstData.LOGIN_PASSWORD);
    }

    @AfterClass(description = "Teardown Browser instance.", alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
