package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductAdded() {
        WebElement cartNotification = driver.findElement(By.cssSelector("div.cart-notification"));
        String notificationText = cartNotification.getText();
        return notificationText.contains("Product added successfully");
    }
}
