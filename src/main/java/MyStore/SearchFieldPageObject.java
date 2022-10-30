package MyStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchFieldPageObject {
    private final WebDriver driver;

    private final String searchField = "search_query_top";


    public SearchFieldPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void searchBtnClick() {
        driver.findElement(By.id(searchField)).click();
    }

    public void validValue() {
        driver.findElement(By.id(searchField)).sendKeys("Dress");
    }

    public String searchValidMessage() {
        String validMessage = ".heading-counter";
        return driver.findElement(By.cssSelector(validMessage)).getText();
    }

        public void searchBtnClear() {
        driver.findElement(By.id(searchField)).clear();
    }

    public void invalidValue() {
        driver.findElement(By.id(searchField)).sendKeys("Pijamas");
    }

    public String searchInvalidMessage() {
        String invalidMessage = ".heading-counter";
        return driver.findElement(By.cssSelector(invalidMessage)).getText();
    }

    public void searchFieldIcon() {
        String searchFieldIcon = "#header > div:nth-child(3) .row";
        driver.findElement(By.cssSelector(searchFieldIcon)).click();

    }

    public String searchInvalidEmptyMessage() {
        String emptyMessage = ".alert-warning";
        return driver.findElement(By.cssSelector(emptyMessage)).getText();

    }
}

