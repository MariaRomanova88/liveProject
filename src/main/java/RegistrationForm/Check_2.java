package RegistrationForm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

/*
2. Check User Registration form with valid data/Fill in only Requared fields (see Description in Test Case 1).

 Expected result: 1. A successful registration message appears.
                  2. User receives mailbox notification.
 Actual result: Field data reset with no messages anywhere.
*/

public class Check_2 {
    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // setting an implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

        //First Name input[name='name']
        //Hobby (//input[@name='hobby'])[3]
        //Phone input[name='phone']
        //Username input[name='username']
        //Email input[name='email']
        //Password input[name='password']
        //Confirm password input[name='c_password']
        //Submit input[value='submit']

        driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Maria");
        driver.findElement(By.xpath("(//input[@name='hobby'])[3]")).click();
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("+911198765432");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Maria Romanova");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("test.romashka88@gmail.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("12345maria");
        driver.findElement(By.cssSelector("input[name='c_password'")).sendKeys("12345maria");
        driver.findElement(By.cssSelector("input[value='submit']")).click();
        System.out.println("Registration is successfull.");
        driver.quit();
    }
}
