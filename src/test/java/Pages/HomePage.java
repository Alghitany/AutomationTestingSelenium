package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage navigateToProductPage() {
        driver.findElement(By.linkText("Product")).click();
        return new ProductPage(driver);  // Returning the next page object
    }
}
