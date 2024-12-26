package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private final WebDriver driver;

    // Locators for the product features dropdowns
    private final By processorDropdown = By.cssSelector("select[id=\"product_attribute_1\"]");
    private final By ramDropdown = By.id("product_attribute_2");
    private final By hddDropdown = By.id("product_attribute_3_6");
    private final By osDropdown = By.id("product_attribute_4_8");
    private final By software = By.id("product_attribute_5_10");

    // Locator for the "Add to Cart" button
    private final By addToCartButton = By.cssSelector("button.button-2.product-box-add-to-cart-button");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Helper method to select an option from a dropdown by its value
     */
    private void selectOptionFromDropdown(By dropdownLocator, String value) {
        WebElement dropdown = driver.findElement(dropdownLocator);
        dropdown.click();
        WebElement option = driver.findElement(By.cssSelector("option[value='" + value + "']"));
        option.click();
    }

    /**
     * Select product features (processor, RAM, HDD, Graphics Card, OS)
     */
    public void selectProductFeatures() {
        selectOptionFromDropdown(processorDropdown, "1");  // Example: Select Processor Option 1
        selectOptionFromDropdown(ramDropdown, "5");       // Example: Select 8GB RAM
        selectOptionFromDropdown(hddDropdown, "6");       // Example: Select 1TB HDD
        selectOptionFromDropdown(osDropdown, "1");  // Example: Select Graphics Card 1
        selectOptionFromDropdown(software, "1");        // Example: Select Operating System Option 1
    }

    /**
     * Add the selected product to the shopping cart
     */
    public ShoppingCartPage addToCart() {
        WebElement addToCartButtonElement = driver.findElement(addToCartButton);
        addToCartButtonElement.click();
        return new ShoppingCartPage(driver);  // Navigate to shopping cart page
    }
}
