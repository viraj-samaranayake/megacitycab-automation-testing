package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setUpTest() {
        driver.get("http://localhost:5173/login");
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1, description = "Verify successful login with valid credentials")
    public void testValidLogin() {
        loginPage.login("jhn@gmail.com", "123456");
        Assert.assertFalse(loginPage.getStatusMessage().contains("Invalid"), "Login failed with valid credentials!");
    }

    @Test(priority = 2, dataProvider = "invalidCredentials", description = "Verify unsuccessful login with invalid credentials")
    public void testInvalidLogin(String username, String password) {
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.getStatusMessage().contains("Invalid"), "Login succeeded with invalid credentials!");
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] getInvalidCredentials() {
        return new Object[][] {
                {"invaliduser@example.com", "123456"},
                {"jhn@gmail.com", "WrongPassword"},
                {"", "12345"}, // Empty username
                {"jhn@gmail.com", ""}, // Empty password
                {"", ""} // Both empty
        };
    }
}