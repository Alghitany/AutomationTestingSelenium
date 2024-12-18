package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProductFeatures() {
        WebElement colorOption = driver.findElement(By.cssSelector("select#color"));
        colorOption.click();
        WebElement selectedColor = driver.findElement(By.cssSelector("option[value='Blue']"));
        selectedColor.click();

        WebElement sizeOption = driver.findElement(By.cssSelector("select#size"));
        sizeOption.click();
        WebElement selectedSize = driver.findElement(By.cssSelector("option[value='M']"));
        selectedSize.click();
    }

    public ShoppingCartPage addToCart() {
        WebElement addToCartButton = driver.findElement(By.cssSelector("button.add-to-cart"));
        addToCartButton.click();
        return new ShoppingCartPage(driver);  // Navigate to shopping cart page
    }
}
