package testPackage.Utilities;

import Pages.Main.ConstData;
import Pages.Main.Login;
import Utilities.LogConfiguration.ForLinux.SSHLogFetcher;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest extends SSHLogFetcher {

    protected SHAFT.GUI.WebDriver driver;

    @BeforeClass(description = "Setup Browser instance.", alwaysRun = true)
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
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
