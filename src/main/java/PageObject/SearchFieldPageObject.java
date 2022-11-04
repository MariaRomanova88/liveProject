package PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchFieldPageObject {
    private final WebDriver driver;
    private final String searchFld = "search_query_top";
    public SearchFieldPageObject(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click 'Search' field;")
    public SearchFieldPageObject inputSearchFld() {
        driver.findElement(By.id(searchFld)).click();
        return this;
    }
    @Step("Click 'Search' btn;")
    public SearchFieldPageObject clickSearchBtn() {
        String searchBtn = ".button-search";
        driver.findElement(By.cssSelector(searchBtn)).click();
        return this;
    }
    @Step("Fill 'Search field' valid value 'Dress';")
    public SearchFieldPageObject sendValidValue() {
        driver.findElement(By.id(searchFld)).sendKeys("Dress");
        return this;
    }
    @Step("Clear 'Search field';")
    public SearchFieldPageObject clearSearchFld() {
        driver.findElement(By.id(searchFld)).clear();
        return this;
    }
    @Step("Fill 'Search field' invalid value 'Pijamas';")
    public SearchFieldPageObject sendInvalidValue() {
        driver.findElement(By.id(searchFld)).sendKeys("Pijamas");
        return this;
    }
    @Step("Check 'Search field' valid message '7 results have been found.';")
    public String getSearchValid() {
        String validValueTextViewCss = ".heading-counter";
        return driver.findElement(By.cssSelector(validValueTextViewCss)).getText();
    }
    @Step("Check 'Search field' invalid message '0 results have been found.';")
    public String getSearchInvalid() {
        String invalidValueTextViewCss = ".heading-counter";
        return driver.findElement(By.cssSelector(invalidValueTextViewCss)).getText();
    }
    @Step("Check 'Search field' invalid message 'Please enter a search keyword.';")
    public String getEmptySearch() {
        String emptyValueTextViewCss = ".alert-warning";
        return driver.findElement(By.cssSelector(emptyValueTextViewCss)).getText();
    }
}




