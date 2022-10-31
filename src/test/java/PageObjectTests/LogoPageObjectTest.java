package PageObjectTests;

import PageObject.LogoPageObject;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoPageObjectTest {
    WebDriver driver;

    @BeforeEach()
    void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach()
    void quit() {
        driver.quit();
    }

    @Test
    @DisplayName("Check the clickability of logo, and the ability to return to the main page by clicking on logo.")
    void testLogo() {
        driver.get("http://automationpractice.com/index.php");

        LogoPageObject logoPageObject = new LogoPageObject(driver);
        logoPageObject.clickLogoBtn();
        logoPageObject.clickAboutLink();
        logoPageObject.clickLogoBtn();
        logoPageObject.clickCartBtn();
        logoPageObject.clickLogoBtn();
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='My Store']")));
        WebElement logo = logoPageObject.getLogo();
        assertTrue(logo.isDisplayed(), "Logo hasn't been displayed.");

    }
}