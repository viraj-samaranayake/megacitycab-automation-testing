package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AddCarPage;

import java.time.Duration;

public class AddCarTest extends BaseTest {

    AddCarPage addCarPage;

    @BeforeMethod
    public void setupTest() {
        driver.get("http://localhost:5173/admin/addcar");
        addCarPage = new AddCarPage(driver);
    }

    @Test(priority = 1)
    public void testAddCar() {

        String vehicleType = "SUV";
        String brand = "Toyota";
        String model = "Highlander";
        String licensePlateNo = "ABC-1234";

        addCarPage.setVehicleType(vehicleType);
        addCarPage.setBrand(brand);
        addCarPage.setModel(model);
        addCarPage.setLicensePlateNo(licensePlateNo);
        addCarPage.clickAddCarButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        String successMessage = addCarPage.getSuccessMessage();
        Assert.assertTrue(successMessage.contains("added successfully"), "Car was not added successfully.");
    }

    @Test(priority = 2)
    public void testAddCarWithoutLicensePlate() {

        String vehicleType = "Car";
        String brand = "Honda";
        String model = "Civic";

        addCarPage.setVehicleType(vehicleType);
        addCarPage.setBrand(brand);
        addCarPage.setModel(model);
        addCarPage.clickAddCarButton();

        String successMessage = addCarPage.getSuccessMessage();
        Assert.assertFalse(successMessage.contains("added successfully"), "Car should not be added without a license plate.");
    }

    @Test(priority = 3)
    public void testAddCarWithInvalidBrand() {

        String vehicleType = "Mini Car";
        String brand = "12345"; // Invalid brand input
        String model = "MiniModel";
        String licensePlateNo = "XYZ5678";

        addCarPage.setVehicleType(vehicleType);
        addCarPage.setBrand(brand);
        addCarPage.setModel(model);
        addCarPage.setLicensePlateNo(licensePlateNo);
        addCarPage.clickAddCarButton();

        String successMessage = addCarPage.getSuccessMessage();
        Assert.assertFalse(successMessage.contains("added successfully"), "Car should not be added with invalid brand.");
    }
}
