package PageObjectTests;

import PageObject.RegFailedPageObject;
import PageObject.SucsRegPageObject;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Epic("Registration Tests Epic.")
@Feature("Adding and Deleting item to/from the Cart Features.")

public class RegistrationFormsPageObjectTests {
    WebDriver driver;
    @BeforeEach()
    void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
    }

    @AfterEach()
    void quit() {
        driver.quit();
    }

    /*
        Expected Result:
            Error messages appear for fields marked as required (there is no mark (*) on the webpage).
        Actual result:
            Error message "This field is required." appeared for fields:
            First Name, Hobby, hobby N., Username, E-mail, Password, Confirm Password.
    */
    @Test
    @DisplayName("Registration is Failed.")
    @Story("User tries to do invalid registration.")
    @Description("Check Required fields in User Registration form (Do not fill in the fields and click Submit).")
    void testRegistrationFailed() {

        String fieldError = new RegFailedPageObject(driver)
        .clickSubmitBtn()
        .getFieldError();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#register_form p:nth-of-type(1) .error_p:nth-child(3)")));
        Assertions.assertEquals("This field is required.", fieldError);

    }

    /*
    Expected result:
        1. A successful registration message appears.
        2. User receives mailbox notification.
    Actual result:
        Field data reset with no messages anywhere.
 */
    @Test
    @DisplayName("Successful Registration.")
    @Story("User tries to fill in valid datas in requared fields.")
    @Description("Check User Registration form with valid data/Fill in only Required fields (see Description in Test Case 1)")
    void testSuccessfulRegistration() {

        String registration = String.valueOf(new SucsRegPageObject(driver)

        .clickNameField()
        .clickHobbyField()
        .clickPhoneField()
        .clickUsernameField()
        .clickEmailField()
        .clickPasswordField()
        .clickCpasswordField()
        .clickSubmitBtn()
        .getRegistration());
        Assertions.assertEquals("Registration Form", registration);


    }
}