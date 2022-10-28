package RegistrationForm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/* 1. Check Requared fields in User Registration form (Do not fill in the fields and click Submit).

 Expected Result: Error messages appear for fields marked as requared (there is no mark (*) on the webpage).
 Actual result: Error message "This field is required." appeared for fields:
                First Name, Hobby, Phone N., Username, E-mail, Password, Confirm Password.
*/

public class Check_1 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

        driver.findElement(By.cssSelector("input[value='submit']")).click();
        System.out.println("This field is required!!");
        Thread.sleep(3000);
        driver.quit();

    }
}
