package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    WebDriver driver;

    // Locators for the dashboard page using @FindBy annotation
    @FindBy(linkText = "New Booking")
    WebElement newBookingButton;

    @FindBy(linkText = "My Bookings")
    WebElement myBookingsButton;

    @FindBy(xpath = "//h2[text()='Dashboard']")
    WebElement dashboardHeader;

    // Constructor to initialize the driver and page elements
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        // Initialize all the elements using PageFactory
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with the dashboard page

    // Method to click the "New Booking" button
    public void clickNewBookingButton() {
        newBookingButton.click();
    }

    // Method to click the "My Bookings" button
    public void clickMyBookingsButton() {
        myBookingsButton.click();
    }

    // Method to verify that the dashboard header is displayed
    public boolean isDashboardHeaderVisible() {
        return dashboardHeader.isDisplayed();
    }

    // Method to verify that the "New Booking" button is visible
    public boolean isNewBookingButtonVisible() {
        return newBookingButton.isDisplayed();
    }

    // Method to verify that the "My Bookings" button is visible
    public boolean isMyBookingsButtonVisible() {
        return myBookingsButton.isDisplayed();
    }
}
