package testPackage.Actions.Login;

import Pages.Main.Login;
import testPackage.Utilities.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Epic("SHAFT Web GUI Template")
    @Story("Login Validations")
    @Description("Given I am on the Home page,\nWhen I login with valid credentials,\nThen I should be logged in successfully.")
    @Test(description = "Check that user can login successfully.", groups = {"Login"})
    public void checkUserCanLoginSuccessfully() {
    }
}