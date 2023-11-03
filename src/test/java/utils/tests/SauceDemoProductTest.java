package utils.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.pages.LoginPage;
import utils.pages.ProductsPage;

public class SauceDemoProductTest {
    private WebDriver driver;
    private ProductsPage productsPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        productsPage = new ProductsPage(driver);
        productsPage.waitForThreeSeconds();
    }

    @Test
    public void testProductPage() {
        productsPage.clickProduct("Sauce Labs Backpack");
        productsPage.waitForThreeSeconds();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
