package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddDriverPage;

public class AddDriverTest extends BaseTest {

    AddDriverPage addDriverPage;

    @BeforeMethod
    public void setupTest() {
        addDriverPage = new AddDriverPage();
        driver.get("http://localhost:5173/admin/drivers/add"); // Assuming the Add Driver page URL
    }

    @Test
    public void testAddDriverSuccessfully() {

        String name = "John Doe";
        String nicNo = "123456789";
        String mobileNo = "0123456789";
        String email = "john.doe@example.com";


        addDriverPage.setName(name);
        addDriverPage.setNicNo(nicNo);
        addDriverPage.setMobileNo(mobileNo);
        addDriverPage.setEmail(email);
        addDriverPage.clickAddDriverButton();

        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:5173/admin/drivers");
    }

    @Test
    public void testAddDriverWithMissingFields() {
        // Given
        String name = "";  // Empty name should cause validation error
        String nicNo = "123456789";
        String mobileNo = "0123456789";
        String email = "john.doe@example.com";

        // When
        addDriverPage.setName(name);  // Missing name
        addDriverPage.setNicNo(nicNo);
        addDriverPage.setMobileNo(mobileNo);
        addDriverPage.setEmail(email);
        addDriverPage.clickAddDriverButton();

        // Then
        String errorMessage = addDriverPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Please fill in all fields."), "Error message should indicate missing fields.");
    }

    @Test
    public void testAddDriverWithInvalidEmail() {

        String name = "John Doe";
        String nicNo = "123456789";
        String mobileNo = "0123456789";
        String email = "invalid-email";  // Invalid email format

        addDriverPage.setName(name);
        addDriverPage.setNicNo(nicNo);
        addDriverPage.setMobileNo(mobileNo);
        addDriverPage.setEmail(email);
        addDriverPage.clickAddDriverButton();

        String errorMessage = addDriverPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Please fill in all fields."), "Error message should indicate invalid email.");
    }

    @Test
    public void testAddDriverWithInvalidMobileNo() {

        String name = "John Doe";
        String nicNo = "123456789";
        String mobileNo = "invalid-number";  // Invalid mobile number format
        String email = "john.doe@example.com";

        addDriverPage.setName(name);
        addDriverPage.setNicNo(nicNo);
        addDriverPage.setMobileNo(mobileNo);  // Invalid mobile number
        addDriverPage.setEmail(email);
        addDriverPage.clickAddDriverButton();

        String errorMessage = addDriverPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Please fill in all fields."), "Error message should indicate invalid mobile number.");
    }
}
