package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchFieldPageObject {

    private final WebDriver driver;

    private final String searchFld = "search_query_top";

    public SearchFieldPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void inputSearchFld() {
        driver.findElement(By.id(searchFld)).click();
    }
    public void clickSearchBtn() {
        String searchBtn = ".button-search";
        driver.findElement(By.cssSelector(searchBtn)).click();
    }
    public void sendValidValue() {
        driver.findElement(By.id(searchFld)).sendKeys("Dress");
    }
    public void cleanSearchFld() {
        driver.findElement(By.id(searchFld)).clear();
    }
    public void sendInvalidValue() {
        driver.findElement(By.id(searchFld)).sendKeys("Pijamas");
    }
    public String getSearchValid() {
        String validValueTextViewCss = ".heading-counter";
        return driver.findElement(By.cssSelector(validValueTextViewCss)).getText();
    }
    public String getSearchInvalid() {
        String invalidValueTextViewCss = ".heading-counter";
        return driver.findElement(By.id(invalidValueTextViewCss)).getText();
    }
    public String getEmptySearch() {
        String emptyValueTextViewCss = ".alert-warning";
        return driver.findElement(By.id(emptyValueTextViewCss)).getText();
    }

}




