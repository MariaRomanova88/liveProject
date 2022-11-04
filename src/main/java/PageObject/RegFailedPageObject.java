package PageObject;

import io.qameta.allure.Step;
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

    @Step("Click 'Submit' Btn;")
    public RegFailedPageObject clickSubmitBtn() {
        String submitBtn = "input[value='submit']";
        driver.findElement(By.cssSelector(submitBtn)).click();
        return this;
    }
    @Step("Check error message 'This field is required.'.")
    public String getFieldError() {
        String errorMessage = "#register_form p:nth-of-type(1) .error_p:nth-child(3)";
        return driver.findElement(By.cssSelector(errorMessage)).getText();
    }
}
