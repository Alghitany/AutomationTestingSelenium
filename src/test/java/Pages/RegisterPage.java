package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    WebDriver driver;
    // Constructor
    public RegisterPage(WebDriver driver) {this.driver=driver;}
    // Locators for the elements
    private final By maleRadioButton = By.id("gender-male");
    private final By femaleRadioButton = By.id("gender-female");
    private final By firstNameField = By.id("FirstName");
    private final By lastNameField = By.id("LastName");
    private final By dayDropdown = By.name("DateOfBirthDay");
    private final By monthDropdown = By.name("DateOfBirthMonth");
    private final By yearDropdown = By.name("DateOfBirthYear");
    private final By emailField = By.id("Email");
    private final By passwordField = By.id("Password");
    private final By confirmPasswordField = By.id("ConfirmPassword");
    private final By registerButton = By.id("register-button");
    private final By successMessage = By.className("result");

    // Actions
    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            driver.findElement(maleRadioButton).click();
        } else if (gender.equalsIgnoreCase("Female")) {
            driver.findElement(femaleRadioButton).click();
        } else {
            throw new IllegalArgumentException("Invalid gender: " + gender);
        }
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        new Select(driver.findElement(dayDropdown)).selectByVisibleText(day);
        new Select(driver.findElement(monthDropdown)).selectByVisibleText(month);
        new Select(driver.findElement(yearDropdown)).selectByVisibleText(year);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void confirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

}
