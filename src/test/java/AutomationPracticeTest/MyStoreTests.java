package AutomationPracticeTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStoreTests {
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
    @DisplayName("Check the clickability of the logo, and the ability to return to the main page by clicking on the logo.")
    void testLogo() {
        driver.get("http://automationpractice.com/index.php");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(By.cssSelector("img[alt='My Store']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("About us")));
        driver.findElement(By.linkText("About us")).click();
        driver.findElement(By.cssSelector("img[alt='My Store']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='View my shopping cart']")));
        driver.findElement(By.cssSelector("[title='View my shopping cart']")).click();
        driver.findElement(By.cssSelector("img[alt='My Store']")).click();

        //Проверка наличия лого на странице (Expected: 'My Store').
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img[alt='My Store']")));
        String title = driver.findElement(By.cssSelector("img[alt='My Store']")).getText();
        assertEquals("", title);
    }
        @Test
        @DisplayName("'Search field' validation.")
        void testSearch() {
            driver.get("http://automationpractice.com/index.php");

            WebDriverWait wait = new WebDriverWait(driver, 10);

            driver.findElement(By.id("search_query_top")).sendKeys("Dress");
            driver.findElement(By.cssSelector(".button-search")).click();

            //Проверка, что поиск выдал результат по корректному запросу.
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".heading-counter")));
            String searchValid = driver.findElement(By.cssSelector(".heading-counter")).getText();
            assertEquals("7 results have been found.", searchValid);

            driver.findElement(By.id("search_query_top")).clear();
            driver.findElement(By.id("search_query_top")).sendKeys("Pijamas");
            driver.findElement(By.cssSelector(".button-search")).click();

            //Проверка сообщения при некорректном запросе.
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".heading-counter")));
            String searchInvalid = driver.findElement(By.cssSelector(".heading-counter")).getText();
            assertEquals("0 results have been found.", searchInvalid);

            driver.findElement(By.id("search_query_top")).clear();
            driver.findElement(By.cssSelector(".button-search")).click();

            //Проверка сообщения при некорретном запросе (пустое поле).
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert-warning")));
            String emptySearch = driver.findElement(By.cssSelector(".alert-warning")).getText();
            assertEquals("Please enter a search keyword", emptySearch);

    }
}