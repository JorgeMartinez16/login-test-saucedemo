package utils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutPage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void goToCheckoutCar(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn_action.checkout_button"))).click();
    }

    public void checkoutInformation(String firstName, String lastName, String postalCode){

            driver.navigate().to("https://www.saucedemo.com/v1/checkout-step-one.html");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name"))).sendKeys(firstName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name"))).sendKeys(lastName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postal-code"))).sendKeys(postalCode);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn_primary.cart_button"))).click();
    }

    public void finishShipping(){
        driver.navigate().to("https://www.saucedemo.com/v1/checkout-step-two.html");
        WebElement finishButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn_action.cart_button")));
        finishButton.click();
    }

    public void waitForThreeSeconds() {
        try {
            Thread.sleep(3000); // Espera 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
