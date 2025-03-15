package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CabBookingPage {

    WebDriver driver;

    // Locators for the cab booking page using @FindBy annotations
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/form/div[1]/input")
    WebElement customerNameInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/form/div[2]/input")
    WebElement addressInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/form/div[3]/input")
    WebElement phoneInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/form/div[4]/select")
    WebElement vehicleTypeDropdown;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/form/div[5]/input")
    WebElement assignedVehicleInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/form/div[6]/input")
    WebElement startLocationInput;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/form/div[7]/input")
    WebElement destinationInput;

    @FindBy(xpath = "//button[text()='Confirm Booking']")
    WebElement confirmBookingButton;

    @FindBy(xpath = "//p[@class='status-message']")
    WebElement statusMessage;

    // Constructor to initialize the driver and page elements
    public CabBookingPage(WebDriver driver) {
        this.driver = driver;
        // Initialize all the elements using PageFactory
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with the Cab Booking page

    // Method to get customer name from the form
    public String getCustomerName() {
        return customerNameInput.getAttribute("value");
    }

    // Method to get address from the form
    public String getAddress() {
        return addressInput.getText();
    }

    // Method to get phone number from the form
    public String getPhone() {
        return phoneInput.getText();
    }

    // Method to select a vehicle type from the dropdown
    public void selectVehicleType(String vehicleType) {
        vehicleTypeDropdown.sendKeys(vehicleType , Keys.ENTER);
    }

    // Method to get the assigned vehicle (license plate number)
    public String getAssignedVehicle() {
        return assignedVehicleInput.getText();
    }

    // Method to enter the pickup location
    public void enterPickupLocation(String pickupLocation) {
        startLocationInput.clear();
        startLocationInput.sendKeys(pickupLocation);
    }

    // Method to enter the destination
    public void enterDestination(String destination) {
        destinationInput.clear();
        destinationInput.sendKeys(destination);
    }

    // Method to click the Confirm Booking button
    public void clickSubmitButton() {
        confirmBookingButton.click();
    }

    // Method to get the status message after booking
    public String getStatusMessage() {
        return statusMessage.getText();
    }
}
