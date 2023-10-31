package utils.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.pages.LoginPage;

public class SauceDemoLoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testStandardUserLogin() {
        loginPage.getUsernameField().sendKeys("standard_user");
        loginPage.getPasswordField().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();
        waitThreeSeconds();
    }

    @Test
    public void testLockedOutUserLogin() {
        loginPage.getUsernameField().clear(); // limpiamos campos de ingreso antes de ingresar los nuevos
        loginPage.getUsernameField().sendKeys("locked_out_user");
        loginPage.getPasswordField().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();
        waitThreeSeconds();
    }

    @Test
    public void testProblemUserLogin() {
        loginPage.getUsernameField().clear();
        loginPage.getUsernameField().sendKeys("problem_user");
        loginPage.getPasswordField().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();
        waitThreeSeconds();
    }

    private void waitThreeSeconds() {   //creamos un metodo para llamarlo en los casos y esperar un tiempo
        try {
            Thread.sleep(3000); // Esperar 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void returnToMainPage() {
        // Cerraramos el navegador después de cada prueba
        if (driver != null) {
            driver.quit();
        }
    }
}
