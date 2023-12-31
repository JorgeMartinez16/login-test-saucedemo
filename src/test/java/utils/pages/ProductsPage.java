package utils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickProduct(String productName) {
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + productName + "']")));
        product.click();
    }

    public void addProductToCar() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn_primary.btn_inventory"))).click();
    }

    public void ClickToShowCar() {
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.shopping_cart_link")));
        cartButton.click();
    }

    public void waitForThreeSeconds() {
        try {
            Thread.sleep(3000); // Espera 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForOneSeconds() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
