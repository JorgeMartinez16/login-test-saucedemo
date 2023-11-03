package utils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Establece un tiempo máximo de espera de 10 segundos
    }

    public void login(String username, String password) {
        // Ingresamos user y password validos para iniciar sesion
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();


    }
    public WebElement getUsernameField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
    }

    public WebElement getPasswordField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    }

    public WebElement getLoginButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));

    }


}
