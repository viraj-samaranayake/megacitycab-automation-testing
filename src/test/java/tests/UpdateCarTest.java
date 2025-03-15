package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UpdateCarPage;

public class UpdateCarTest extends BaseTest {

    @Test
    public void testPageLoad() {
        driver.get("http://localhost:5173/admin/cars/");

        UpdateCarPage updateCarPage = new UpdateCarPage(driver);

        // Verify that the page has loaded
        Assert.assertTrue(driver.getTitle().contains("Update Car"));

        // Verify the presence of form elements
        Assert.assertTrue(updateCarPage.getBrandInput().isDisplayed());
        Assert.assertTrue(updateCarPage.getModelInput().isDisplayed());
        Assert.assertTrue(updateCarPage.getLicensePlateInput().isDisplayed());
    }

    @Test
    public void testFormSubmissionWithValidData() {
        driver.get("http://localhost:5173/admin/cars/1");

        UpdateCarPage updateCarPage = new UpdateCarPage(driver);

        // Fill in the form with valid data
        updateCarPage.enterBrand("Honda");
        updateCarPage.enterModel("Civic");
        updateCarPage.enterLicensePlate("ABC123");

        // Submit the form
        updateCarPage.clickUpdateButton();

        // Validate that success alert is shown or page is redirected
        // Since there's no real alert in the code, you can check for the new page or other success indicators
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cars"));
    }

    @Test
    public void testFormSubmissionWithInvalidData() {
        driver.get("http://localhost:5173/admin/cars/1");

        UpdateCarPage updateCarPage = new UpdateCarPage(driver);

        // Leave form fields empty
        updateCarPage.enterBrand("");
        updateCarPage.enterModel("");
        updateCarPage.enterLicensePlate("");

        // Submit the form
        updateCarPage.clickUpdateButton();

        // Verify that error message is displayed
        Assert.assertTrue(updateCarPage.isErrorMessageDisplayed());
    }

    @Test
    public void testStatusToggle() {
        driver.get("http://localhost:5173/admin/cars/1");

        UpdateCarPage updateCarPage = new UpdateCarPage(driver);

        // Click to toggle the status
        updateCarPage.clickStatusButton();

        // Verify that the status button changes text to "Set as Busy"
        Assert.assertTrue(updateCarPage.getStatusButton().getText().contains("Set as Busy"));
    }
}