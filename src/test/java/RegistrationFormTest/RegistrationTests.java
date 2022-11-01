package RegistrationFormTest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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

    void testRegistrationFailed() {

        driver.findElement(By.cssSelector("input[value='submit']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//form[@id='register_form']/fieldset[1]/p[1]/label[@class='error_p']")));
        WebElement fieldError = driver.findElement(By.xpath("/html//form[@id='register_form']/fieldset[1]/p[1]/label[@class='error_p']"));
        Assertions.assertEquals("This field is required.", fieldError.getText());

    }

    /*
    Expected result:
        1. A successful registration message appears.
        2. User receives mailbox notification.
    Actual result:
        Field data reset with no messages anywhere.
 */
    @Test
    @DisplayName("Check User Registration form with valid data/Fill in only Required fields (see Description in Test Case 1).")
    void successfulRegistration() {

        driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Maria");
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='hobby'])[3]")));
        driver.findElement(By.xpath("(//input[@name='hobby'])[3]")).click();
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("+911198765432");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Maria Romanova");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("test.romashka88@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("12345maria");
        driver.findElement(By.cssSelector("input[name='c_password'")).sendKeys("12345maria");
        driver.findElement(By.cssSelector("input[value='submit']")).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//section[@id='wrapper']//h2[.='Registration Form']")));
        WebElement registration = driver.findElement(By.xpath("/html//section[@id='wrapper']//h2[.='Registration Form']"));
        Assertions.assertEquals("Registration Form", registration.getText());

    }
}

