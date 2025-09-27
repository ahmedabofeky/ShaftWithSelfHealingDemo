package Pages.Main;

import com.epam.healenium.SelfHealingDriver;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Login {

    private final SelfHealingDriver driver;

    public Login(SelfHealingDriver driver) {
        this.driver = driver;
    }

    @Step("When I navigate to the Home page.")
    public void navigate() {
        driver.get(ConstData.LOGIN_URL);
    }

    public void performLogin(String username, String password) {
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}