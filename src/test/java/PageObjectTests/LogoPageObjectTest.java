package PageObjectTests;

import PageObject.LogoPageObject;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;
@Epic("Logo Tests Epic.")
@Feature("Clickability of logo, and the ability to return to the Homepage.")

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
    @DisplayName("Logo.")
    @Story("User tries to return to Homepage by clicking on logo.")
    @Description("Check the clickability of logo, and the ability to return to the main page by clicking on logo.")
    void testLogo() {
        driver.get("http://automationpractice.com/index.php");

        WebElement getLogo = new LogoPageObject(driver)
        .clickLogoBtn()
        .clickAboutLink()
        .clickLogoBtn()
        .clickCartBtn()
        .clickLogoBtn()
        .getLogo();
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='My Store']")));
        assertTrue(getLogo.isDisplayed(), "Logo hasn't been displayed.");

    }
}