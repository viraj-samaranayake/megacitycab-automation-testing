package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateCarPage {

    private WebDriver driver;

    // Locators
    @FindBy(id = "brand")
    private WebElement brandInput;

    @FindBy(id = "model")
    private WebElement modelInput;

    @FindBy(id = "licensePlateNo")
    private WebElement licensePlateInput;

    @FindBy(xpath = "//button[text()='Update Car']")
    private WebElement updateButton;

    @FindBy(xpath = "//p[text()='Please fill in all fields.']")
    private WebElement errorMessage;

    @FindBy(xpath = "//button[contains(text(), 'Set as Available')]")
    private WebElement statusButton;

    // Constructor to initialize the PageFactory elements
    public UpdateCarPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializes elements
    }

    // Methods to interact the page

    public WebElement getBrandInput() {
        return brandInput;
    }

    public WebElement getModelInput() {
        return modelInput;
    }

    public WebElement getLicensePlateInput() {
        return licensePlateInput;
    }

    public WebElement getUpdateButton() {
        return updateButton;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getStatusButton() {
        return statusButton;
    }

    // Actions

    public void enterBrand(String brand) {
        brandInput.clear();
        brandInput.sendKeys(brand);
    }

    public void enterModel(String model) {
        modelInput.clear();
        modelInput.sendKeys(model);
    }

    public void enterLicensePlate(String licensePlate) {
        licensePlateInput.clear();
        licensePlateInput.sendKeys(licensePlate);
    }

    public void clickUpdateButton() {
        updateButton.click();
    }

    public void clickStatusButton() {
        statusButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
}