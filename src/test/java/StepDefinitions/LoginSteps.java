package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("user navigate to login page")
    public void user_navigate_to_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");  // Updated login URL
        loginPage = new LoginPage(driver);
    }

    @When("user enter {string} and {string}")
    public void user_enter_and(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @When("User click on login button")
    public void user_click_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User could login successfully and navigate to home page")
    public void user_could_login_successfully_and_navigate_to_home_page() {
        String homePageTitle = driver.getTitle();
        Assert.assertEquals("Home page - nopCommerce", homePageTitle);  // Adjust this based on actual page title after login
        driver.quit();
    }

    @Then("User couldn't login successfully")
    public void user_couldn_t_login_successfully() {
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue("Error message should be displayed", errorMessage.contains("Login was unsuccessful"));
        driver.quit();
    }
    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
