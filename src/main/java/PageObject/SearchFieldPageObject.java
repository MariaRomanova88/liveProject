package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchFieldPageObject {

    private final WebDriver driver;

    private final String searchFld = "search_query_top";

    public SearchFieldPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public SearchFieldPageObject inputSearchFld() {
        driver.findElement(By.id(searchFld)).click();
        return this;
    }
    public SearchFieldPageObject clickSearchBtn() {
        String searchBtn = ".button-search";
        driver.findElement(By.cssSelector(searchBtn)).click();
        return this;
    }
    public SearchFieldPageObject sendValidValue() {
        driver.findElement(By.id(searchFld)).sendKeys("Dress");
        return this;
    }
    public SearchFieldPageObject clearSearchFld() {
        driver.findElement(By.id(searchFld)).clear();
        return this;
    }
    public SearchFieldPageObject sendInvalidValue() {
        driver.findElement(By.id(searchFld)).sendKeys("Pijamas");
        return this;
    }
    public String getSearchValid() {
        String validValueTextViewCss = ".heading-counter";
        return driver.findElement(By.cssSelector(validValueTextViewCss)).getText();
    }
    public String getSearchInvalid() {
        String invalidValueTextViewCss = ".heading-counter";
        return driver.findElement(By.cssSelector(invalidValueTextViewCss)).getText();
    }
    public String getEmptySearch() {
        String emptyValueTextViewCss = ".alert-warning";
        return driver.findElement(By.cssSelector(emptyValueTextViewCss)).getText();
    }

}




