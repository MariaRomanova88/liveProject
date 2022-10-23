package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


//2. Check the possibility of deleting items from the Cart (in the up-right side) using the 'icon-trash'.

public class Run02 {
    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        // creating a WebDriverWait object and assigning the driver instance and a max wait time
        WebDriverWait wait = new WebDriverWait(driver, 10);

        // Precondition: There is an item in the cart.

        // setting an expected condition to check visibility of the element and parsing the locator
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Women']")));
        driver.findElement(By.cssSelector("a[title='Women']")).click();

        driver.findElement(By.linkText("Dresses")).click();

        driver.findElement(By.linkText("Evening Dresses")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".right-block .product-name")));
        driver.findElement(By.cssSelector(".right-block .product-name")).click();

        Select menuItem = new Select(driver.findElement(By.cssSelector("select#group_1")));
        menuItem.selectByVisibleText("M");

        driver.findElement(By.id("add_to_cart")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title='Continue shopping'] span")));
        driver.findElement(By.cssSelector("[title='Continue shopping'] span")).click();

        // Checking the possibility of deleting items from the Cart.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='View my shopping cart']")));
        driver.findElement(By.cssSelector("a[title='View my shopping cart']")).click();

        driver.findElement(By.cssSelector(".icon-trash")).click();
        driver.quit();

    }
}

