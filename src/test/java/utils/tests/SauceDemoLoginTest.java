package utils.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.pages.LoginPage;

public class SauceDemoLoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testImplicitWait() {
        loginPage.getUsernameField().sendKeys("standard_user");
        loginPage.getPasswordField().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();

    }

    @Test
    public void testExplicitWait() {
        loginPage.getUsernameField().sendKeys("locked_out_user");
        loginPage.getPasswordField().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();

    }

    @Test
    public void testFluentWait() {
        loginPage.getUsernameField().sendKeys("problem_user");
        loginPage.getPasswordField().sendKeys("secret_sauce");
        loginPage.getLoginButton().click();

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}