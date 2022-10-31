package MyStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
1. Check the clickability of the logo, and the ability to return to the main page by clicking on the logo.
*/
public class Logo {
    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(By.cssSelector("img[alt='My Store']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("About us")));
        driver.findElement(By.linkText("About us")).click();
        driver.findElement(By.cssSelector("img[alt='My Store']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='View my shopping cart']")));
        driver.findElement(By.cssSelector("[title='View my shopping cart']")).click();
        driver.findElement(By.cssSelector("img[alt='My Store']")).click();
        driver.quit();



    }
}
