package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* 1. Check Requared fields in User Registration form (Do not fill in the fields and click Submit).
 Expected Result: Error messages appear for fields marked as requared (there is no mark (*) on the webpage).
 Actual result: Error message "This field is required." appeared for fields:
                First Name, Hobby, Phone N., Username, E-mail, Password, Confirm Password.
*/

public class RegFailedPageObject {

    private final WebDriver driver;

    public RegFailedPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public RegFailedPageObject clickSubmitBtn() {
        String submitBtn = "input[value='submit']";
        driver.findElement(By.cssSelector(submitBtn)).click();
        return this;
    }
    public String getFieldError() {
        String errorMessage = "/html//form[@id='register_form']/fieldset[1]/p[1]/label[@class='error_p']";
        return driver.findElement(By.xpath(errorMessage)).getText();
    }
}
