package utils.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.pages.CheckoutPage;
import utils.pages.LoginPage;
import utils.pages.ProductsPage;

public class SauceDemonCheckoutTest {
    public WebDriver driver;
    public WebDriverWait wait;

    private CheckoutPage checkoutPage;
    private ProductsPage productsPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.waitForThreeSeconds();
        productsPage = new ProductsPage(driver);

    }


    @Test
    public void TestCheckoutCar() {
        productsPage.clickProduct("Sauce Labs Backpack");
        productsPage.addProductToCar();
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
        productsPage.clickProduct("Sauce Labs Bolt T-Shirt");
        productsPage.addProductToCar();
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
        productsPage.ClickToShowCar();
        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
        checkoutPage.goToCheckoutCar();
        checkoutPage.checkoutInformation("Jorge", "Martinez", "13007");
        checkoutPage.finishShipping();

    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
