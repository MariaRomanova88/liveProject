package PageObjectTests;

import PageObject.SearchFieldPageObject;
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
    @DisplayName("'Search field' validation.")
    void testSearch() {
        driver.get("http://automationpractice.com/index.php");

        SearchFieldPageObject searchFieldPageObject = new SearchFieldPageObject(driver);
        searchFieldPageObject.inputSearchFld();
        searchFieldPageObject.sendValidValue();
        searchFieldPageObject.clickSearchBtn();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".heading-counter")));
        String validValue = searchFieldPageObject.getSearchValid();
        assertEquals("7 results have been found.", validValue);

        searchFieldPageObject.clearSearchFld();
        searchFieldPageObject.sendInvalidValue();
        searchFieldPageObject.clickSearchBtn();



        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".heading-counter")));
        String invalidValue = searchFieldPageObject.getSearchInvalid();
        assertEquals("0 results have been found.", invalidValue);

        searchFieldPageObject.clearSearchFld();
        searchFieldPageObject.clickSearchBtn();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-warning")));
        String emptySearch = searchFieldPageObject.getEmptySearch();
        assertEquals("Please enter a search keyword", emptySearch);

    }
}