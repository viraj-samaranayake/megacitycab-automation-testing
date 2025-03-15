package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.BaseTest;

public class AddDriverPage extends BaseTest {

    // Web elements for Add Driver Form fields
    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "nicNo")
    private WebElement nicNoInput;

    @FindBy(id = "mobileNo")
    private WebElement mobileNoInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addDriverButton;

    @FindBy(xpath = "//p[@class='text-red-600 mb-4']")
    private WebElement errorMessage;

    // Initialize WebElements
    public AddDriverPage() {
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with form fields
    public void setName(String name) {
        nameInput.sendKeys(name);
    }

    public void setNicNo(String nicNo) {
        nicNoInput.sendKeys(nicNo);
    }

    public void setMobileNo(String mobileNo) {
        mobileNoInput.sendKeys(mobileNo);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void clickAddDriverButton() {
        addDriverButton.click();
    }

    // Get error message if displayed
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
