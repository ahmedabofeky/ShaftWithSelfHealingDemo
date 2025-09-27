package Pages.Main;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Login {

    private final SHAFT.GUI.WebDriver driver;

    public Login(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("When I navigate to the Home page.")
    public void navigate() {
        driver.browser().navigateToURL(ConstData.LOGIN_URL);
    }

    public void performLogin(String username, String password) {
        driver.element().type(By.id("email"), username);
        driver.element().type(By.id("password"), password);
        driver.element().click(By.xpath("/html/body/app-root/app-login/div/div/div[2]/div/form/fw-button/button"));
    }
}