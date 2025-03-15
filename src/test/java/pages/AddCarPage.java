package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCarPage {

    WebDriver driver;

    @FindBy(id = "vehicleType")
    private WebElement vehicleTypeDropdown;

    @FindBy(id = "brand")
    private WebElement brandInput;

    @FindBy(id = "model")
    private WebElement modelInput;

    @FindBy(id = "licensePlateNo")
    private WebElement licensePlateNoInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addCarButton;

    @FindBy(xpath = "//p[@class='mt-2 text-center text-green-600']")
    private WebElement successMessage;

    public AddCarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setVehicleType(String vehicleType) {
        vehicleTypeDropdown.sendKeys(vehicleType , Keys.ENTER);
    }

    public void setBrand(String brand) {
        brandInput.sendKeys(brand);
    }

    public void setModel(String model) {
        modelInput.sendKeys(model);
    }

    public void setLicensePlateNo(String licensePlateNo) {
        licensePlateNoInput.sendKeys(licensePlateNo);
    }

    public void clickAddCarButton() {
        addCarButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
