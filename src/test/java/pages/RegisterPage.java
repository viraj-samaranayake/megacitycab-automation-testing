package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;

    @FindBy(id = "name")
    WebElement nameInput;

    @FindBy(id = "address")
    WebElement addressInput;

    @FindBy(id = "phone")
    WebElement phoneInput;

    @FindBy(id = "nic")
    WebElement nicInput;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signUpButton;

    @FindBy(xpath = "//p[contains(@class, 'text-green-600')]")
    WebElement successMessage;

    @FindBy(xpath = "//p[contains(@class, 'text-red-500')]")
    WebElement errorMessage;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterAddress(String address) {
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void enterPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void enterNic(String nic) {
        nicInput.clear();
        nicInput.sendKeys(nic);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickSignUp() {
        signUpButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void register(String name, String address, String phone, String nic, String email, String password) {
        enterName(name);
        enterAddress(address);
        enterPhone(phone);
        enterNic(nic);
        enterEmail(email);
        enterPassword(password);
        clickSignUp();
    }
}