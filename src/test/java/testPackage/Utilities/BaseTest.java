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

    //    protected SHAFT.GUI.WebDriver driver; // it is a custom driver wrapper provided by the SHAFT framework. It adds a lot of features on top of Selenium (logging, reporting, self-healing, etc. — but not via Healenium by default).
    protected SelfHealingDriver driver; //is a special WebDriver from the Healenium library. It wraps a Selenium WebDriver and adds its own self-healing logic.

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
