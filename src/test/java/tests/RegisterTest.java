package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    RegisterPage registerPage;

    @BeforeMethod
    public void setUpTest() {
        driver.get("http://localhost:5173/register");
        registerPage = new RegisterPage(driver);
    }

    @Test(priority = 1, description = "Verify successful registration with valid details")
    public void testValidRegistration() {
        registerPage.register("John Doe", "123 Main Street", "9876543210", "123456789V",
                "johndoe@example.com", "SecurePass123");

        Assert.assertTrue(registerPage.getSuccessMessage().contains("registered successfully"),
                "Registration failed with valid details!");
    }

    @Test(priority = 2, dataProvider = "invalidRegistrationData", description = "Verify unsuccessful registration with invalid details")
    public void testInvalidRegistration(String name, String address, String phone, String nic, String email, String password, String expectedError) {
        registerPage.register(name, address, phone, nic, email, password);

        Assert.assertTrue(registerPage.getErrorMessage().contains(expectedError),
                "Expected error message not displayed!");
    }

    @DataProvider(name = "invalidRegistrationData")
    public Object[][] getInvalidRegistrationData() {
        return new Object[][] {
                {"", "123 Main Street", "9876543210", "123456789V", "johndoe@example.com", "SecurePass123", "Name is required"},
                {"John Doe", "", "9876543210", "123456789V", "johndoe@example.com", "SecurePass123", "Address is required"},
                {"John Doe", "123 Main Street", "", "123456789V", "johndoe@example.com", "SecurePass123", "Phone is required"},
                {"John Doe", "123 Main Street", "9876543210", "", "johndoe@example.com", "SecurePass123", "NIC is required"},
                {"John Doe", "123 Main Street", "9876543210", "123456789V", "", "SecurePass123", "Email is required"},
                {"John Doe", "123 Main Street", "9876543210", "123456789V", "invalidemail", "SecurePass123", "Invalid email format"},
                {"John Doe", "123 Main Street", "9876543210", "123456789V", "johndoe@example.com", "", "Password is required"},
                {"John Doe", "123 Main Street", "9876543210", "123456789V", "existinguser@example.com", "SecurePass123", "Email already exists"}
        };
    }
}