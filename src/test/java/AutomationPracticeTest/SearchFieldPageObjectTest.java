package AutomationPracticeTest;

import MyStore.SearchFieldPageObject;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFieldPageObjectTest {
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
    @DisplayName("Check the 'Search field'.")
    public void testSearchFieldPage() {
        driver.get("http://automationpractice.com/index.php");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        SearchFieldPageObject searchFieldPageObject = new SearchFieldPageObject(driver);
        searchFieldPageObject.searchBtnClick();
        searchFieldPageObject.validValue();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".heading-counter")));
        String validMessage = searchFieldPageObject.searchValidMessage();
        Assertions.assertEquals("7 results have been found.", validMessage);

        searchFieldPageObject.searchBtnClear();
        searchFieldPageObject.invalidValue();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".heading-counter")));
        String invalidMessage = searchFieldPageObject.searchInvalidMessage();
        Assertions.assertEquals("0 results have been found.", invalidMessage);

        searchFieldPageObject.searchFieldIcon();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert-warning")));
        String emptyMessage = searchFieldPageObject.searchInvalidEmptyMessage();
        Assertions.assertEquals("Please enter a search keyword", emptyMessage);
        }

    }