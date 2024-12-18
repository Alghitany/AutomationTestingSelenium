package StepDefinitions;

import Pages.LoginPage;
import Pages.ResetPage;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ResetSteps {

    WebDriver driver;
    LoginPage loginPage;
    ResetPage resetPasswordPage;

    @Given("user navigate to login page for reset")
    public void user_navigate_to_login_page() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");
        loginPage = new LoginPage(driver);
    }

    @When("user click on forgetPassword")
    public void user_click_on_forgetPassword() {
        loginPage.clickForgotPassword();
    }

    @Then("user navigate to forgetPage and enter his email {string}")
    public void user_navigate_to_forgetPage_and_enter_his_email(String email) {
        resetPasswordPage = new ResetPage(driver);
        resetPasswordPage.enterEmail(email);
    }

    @And("user click on Recovery Button")
    public void user_click_on_Recovery_Button() {
        resetPasswordPage.clickRecoveryButton();
    }

    @And("password will be reset")
    public void password_will_be_reset() {
        String successMessage = resetPasswordPage.getSuccessMessage();
        Assert.assertTrue("Password reset message is not displayed", successMessage.contains("Email with instructions has been sent to you"));
        driver.quit();
    }

    @And("password will not be reset")
    public void password_will_not_be_reset() {
        String errorMessage = resetPasswordPage.getErrorMessage();
        Assert.assertTrue("Error message is not displayed", errorMessage.contains("The email could not be found"));
    }
    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
