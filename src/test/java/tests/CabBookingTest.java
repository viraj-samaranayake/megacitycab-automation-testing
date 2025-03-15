package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CabBookingPage;
import pages.DashboardPage;
import pages.LoginPage;

import java.time.Duration;

public class CabBookingTest extends BaseTest{

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CabBookingPage cabBookingPage;

    // Initialize the WebDriver and Page Objects before each test
    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();

        // Instantiate the Page Object classes
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        cabBookingPage = new CabBookingPage(driver);

        // Open the login page
        driver.get("http://localhost:5173/login");
    }

    @Test
    public void testLoginAndBooking() {

        // Step 1: Log in to the application
        loginPage.enterUsername("jhn@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        // Step 2: Verify successful login by checking the dashboard page
        Assert.assertTrue(dashboardPage.isNewBookingButtonVisible(), "New Booking button is not visible on Dashboard");

        // Step 3: Click the "New Booking" button and verify that user is redirected to the booking page
        dashboardPage.clickNewBookingButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

        // Step 4: Verify that the correct details are pre-populated in the cab booking form
        Assert.assertEquals(cabBookingPage.getCustomerName(), "John", "Customer name mismatch");
        Assert.assertEquals(cabBookingPage.getAddress(), "154/A CA", "Address mismatch");
        Assert.assertEquals(cabBookingPage.getPhone(), "51545455", "Phone number mismatch");

        // Step 5: Fill out the cab booking form and submit
        cabBookingPage.selectVehicleType("Car");
        cabBookingPage.enterPickupLocation("Matara");
        cabBookingPage.enterDestination("Galle");
        cabBookingPage.clickSubmitButton();

        // Step 6: Verify success message or next action
        String assignedVehicle = cabBookingPage.getAssignedVehicle();
        Assert.assertNotNull(assignedVehicle, "Vehicle should be assigned for booking.");
    }

    // After the test, close the WebDriver
    @Test(dependsOnMethods = {"testLoginAndBooking"})
    public void tearDown() {
        driver.quit();
    }
}