package StepDefinitions;

import Pages.HomePage;
import Pages.ProductPage;
import Pages.ShoppingCartPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AddToCartSteps {

    private final WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    public AddToCartSteps() {
        // Initialize WebDriver (assuming EdgeDriver for this example)
        this.driver = new EdgeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);  // Initialize the page objects
    }

    @When("user click on the add to cart button")
    public void user_click_on_the_add_to_cart_button() {
        // Navigate to the product page
        productPage = homePage.navigateToProductPage();
    }

    @And("choose the specified features of the product")
    public void user_choose_the_specified_features_of_the_product() {
        // Choose the product features (e.g., size, color)
        productPage.selectProductFeatures();
    }

    @And("confirm adding to shopping cart")
    public void user_confirm_adding_to_shopping_cart() {
        // Add the product to the cart and navigate to the shopping cart page
        shoppingCartPage = productPage.addToCart();
    }

    @Then("The product added successfully to shopping cart")
    public void the_product_added_successfully_to_shopping_cart() {
        // Verify that the product was successfully added to the cart
        Assert.assertTrue(shoppingCartPage.isProductAdded());
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
