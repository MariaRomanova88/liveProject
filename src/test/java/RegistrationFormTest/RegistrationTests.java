package RegistrationFormTest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTests {

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
            First Name, Hobby, Phone N., Username, E-mail, Password, Confirm Password.
    */
    @Test
    @DisplayName("Check Required fields in User Registration form (Do not fill in the fields and click Submit).")
    void registrationFailed() {
        submitForm();

        checkFieldError("name");
        checkFieldError("hobby");
        checkFieldError("phone");
        checkFieldError("username");
        checkFieldError("email");
        checkFieldError("password");
        checkFieldError("c_password");
    }

    /*
        Expected result:
            1. A successful registration message appears.
            2. User receives mailbox notification.
        Actual result:
            Field data reset with no messages anywhere.
     */
    @Test
    @DisplayName("Check User Registration form with valid data/Fill in only Required fields (see Description in Test Case 1)")
    void successfulRegistration() {
        setTextFiledValue("name", "Maria");
        driver.findElement(By.xpath("(//input[@name='hobby'])[3]")).click();
        setTextFiledValue("phone", "+911198765432");
        setTextFiledValue("username", "Maria Romanova");
        setTextFiledValue("email", "test.romashka88@gmail.com");
        setTextFiledValue("password", "12345maria");
        setTextFiledValue("c_password", "12345maria");
        submitForm();

        checkNoFieldError("name");
        checkNoFieldError("hobby");
        checkNoFieldError("phone");
        checkNoFieldError("username");
        checkNoFieldError("email");
        checkNoFieldError("password");
        checkNoFieldError("c_password");
    }

    void checkFieldError(String fieldName) {
        By errorLabelSelector = By.cssSelector(String.format("label[for=%s]", fieldName));
        String actualMessage = driver.findElement(errorLabelSelector).getText();
        Assertions.assertEquals("This field is required.", actualMessage);
    }

    void checkNoFieldError(String fieldName) {
        By errorLabelSelector = By.cssSelector("label[for=%s]".formatted(fieldName));
        Assertions.assertThrows(NoSuchElementException.class, () -> driver.findElement(errorLabelSelector));
    }

    void setTextFiledValue(String fieldName, String value) {
        By fieldSelector = By.cssSelector("input[name=%s]".formatted(fieldName));
        driver.findElement(fieldSelector).sendKeys(value);
    }

    void submitForm() {
        driver.findElement(By.cssSelector("input[value='submit']")).click();
    }

}

