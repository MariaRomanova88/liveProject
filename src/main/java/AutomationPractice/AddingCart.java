package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


//1. Check the possibility of adding items to the Cart (through the left-side menu-bar).
public class AddingCart {
    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Women']")));
        driver.findElement(By.cssSelector("a[title='Women']")).click();

        driver.findElement(By.linkText("Dresses")).click();
        driver.findElement(By.linkText("Evening Dresses")).click();
        driver.findElement(By.cssSelector(".right-block .product-name")).click();

        Select menuItem = new Select(driver.findElement(By.cssSelector("select#group_1")));
        menuItem.selectByVisibleText("M");

        driver.findElement(By.id("add_to_cart")).click();
        driver.quit();

    }
}
