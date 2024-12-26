package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
    private WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Checks if the product was added successfully by verifying the notification message
     * and checking if the notification is visible (popped up).
     */
    public boolean isProductAdded() {
        // Locate the notification element using the CSS class "bar-notification success"
        WebElement cartNotification = driver.findElement(By.cssSelector("div.bar-notification.success"));

        // Check if the notification is displayed (popped up)
        if (cartNotification.isDisplayed()) {
            String notificationText = cartNotification.getText();
            // Check if the notification text contains the success message
            return notificationText.contains("The product has been added to your shopping cart");
        }
        return false;
    }
}
