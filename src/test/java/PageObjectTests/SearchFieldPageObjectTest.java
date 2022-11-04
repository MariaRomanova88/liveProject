package PageObjectTests;

import PageObject.SearchFieldPageObject;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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

@Epic("'Search field' Tests Epic.")
@Feature("Searching item in Search menu (search button).")
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
    @Story("User tries to find the item in the search menu.")
    @Description("Check search button functionality.")
    void testSearch() {
        driver.get("http://automationpractice.com/index.php");

        String validValue = new SearchFieldPageObject(driver)
        .inputSearchFld()
        .sendValidValue()
        .clickSearchBtn()
        .getSearchValid();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".heading-counter")));
        assertEquals("7 results have been found.", validValue);

        String invalidValue = new SearchFieldPageObject(driver)
        .clearSearchFld()
        .sendInvalidValue()
        .clickSearchBtn()
        .getSearchInvalid();

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".heading-counter")));
        assertEquals("0 results have been found.", invalidValue);

        String emptySearch = new SearchFieldPageObject(driver)
        .clearSearchFld()
        .clickSearchBtn()
        .getEmptySearch();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-warning")));
        assertEquals("Please enter a search keyword", emptySearch);

    }
}