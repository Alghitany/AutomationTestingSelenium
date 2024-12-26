package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage navigateToProductPage() {
        driver.findElement(By.cssSelector("div[data-productid=\"1\"]>div[class=\"details\"]>div[class=\"add-info\"]>div[class=\"buttons\"]>button[class=\"button-2 product-box-add-to-cart-button\"]")).click();
        return new ProductPage(driver);  // Returning the next page object
    }
}
