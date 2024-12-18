package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetPage {

    WebDriver driver;

    // Constructor
    public ResetPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By emailField = By.id("Email");
    private final By recoveryButton = By.cssSelector("button[name='send-email']");
    private final By successMessage = By.className("result");
    private final By errorMessage = By.className("message-error");

    // Actions
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickRecoveryButton() {
        driver.findElement(recoveryButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
