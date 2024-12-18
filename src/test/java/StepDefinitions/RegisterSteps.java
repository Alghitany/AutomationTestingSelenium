package StepDefinitions;

import Pages.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegisterSteps {

    WebDriver driver;
    RegisterPage registrationPage;

    @Given("User go to register page")
    public void user_go_to_register_page() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
        registrationPage = new RegisterPage(driver);
    }

    @When("User select the type of gender")
    public void user_select_the_type_of_gender() {
        registrationPage.selectGender("Male"); // Change to "Female" if required
    }

    @When("User enter the first and last name")
    public void user_enter_the_first_and_last_name() {
        registrationPage.enterFirstName("John");
        registrationPage.enterLastName("Doe");
    }

    @When("User enter the date of birth")
    public void user_enter_the_date_of_birth() {
        registrationPage.selectDateOfBirth("15", "March", "1990");
    }

    @When("User enter the email")
    public void user_enter_the_email() {
        registrationPage.enterEmail("johndoe@test3.com");
    }

    @When("User enter and confirm the password")
    public void user_enter_and_confirm_the_password() {
        registrationPage.enterPassword("Test@1234");
        registrationPage.confirmPassword("Test@1234");
    }

    @When("User click on register button")
    public void user_click_on_register_button() throws InterruptedException {

        registrationPage.clickRegisterButton();

        Thread.sleep(5000);
    }

    @Then("success message is displayed")
    public void success_message_is_displayed() {
        String successMessage = registrationPage.getSuccessMessage();
        Assert.assertEquals("Your registration completed", successMessage);
    }
    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
