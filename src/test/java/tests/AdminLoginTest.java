package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AdminLoginPage;
import pages.LoginPage;

import java.time.Duration;

public class AdminLoginTest extends BaseTest {

    AdminLoginPage adminLoginPage;

    @BeforeMethod
    public void setUpTest() {
        driver.get("http://localhost:5173/admin/login");
        adminLoginPage = new AdminLoginPage(driver);
    }

    @Test(priority = 1, description = "Verify successful login with valid credentials")
    public void testValidLogin() {
        adminLoginPage.login("admin@megacity.com", "12345");
        Assert.assertFalse(adminLoginPage.getStatusMessage().contains("Invalid"), "Login failed with valid credentials!");
    }

    @Test(priority = 2, dataProvider = "invalidCredentials", description = "Verify unsuccessful login with invalid credentials")
    public void testInvalidLogin(String username, String password) {
        adminLoginPage.login(username, password);
        Assert.assertTrue(adminLoginPage.getStatusMessage().contains("Invalid"), "Login succeeded with invalid credentials!");
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] getInvalidCredentials() {
        return new Object[][] {
                {"invaliduser@example.com", "12345"},
                {"admin@megacity.com", "WrongPassword"},
                {"", "12345"}, // Empty username
                {"admin@megacity.com", ""}, // Empty password
                {"", ""} // Both empty
        };
    }
}

