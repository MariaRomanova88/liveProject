package AutomationPracticeTest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTests {
    WebDriver driver;

    @BeforeEach()
    void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterEach()
    void quit() {
        driver.quit();
    }

    @Test
    @DisplayName("Check the possibility of adding items to the Cart (through the left-side menu-bar).")
    void testAdding() {

        driver.findElement(By.cssSelector("a[title='Women']")).click();
        driver.findElement(By.linkText("Dresses")).click();
        driver.findElement(By.linkText("Evening Dresses")).click();
        driver.findElement(By.cssSelector(".right-block .product-name")).click();

        Select menuItem = new Select(driver.findElement(By.cssSelector("select#group_1")));
        menuItem.selectByVisibleText("M");

        driver.findElement(By.id("add_to_cart")).click();

        //Assertions (Checking if a product is in the cart).
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#layer_cart_product_quantity")));
        WebElement productQuantity = driver.findElement(By.cssSelector("span#layer_cart_product_quantity"));
        assertEquals("1", productQuantity.getText());

        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-md-6.col-xs-12.layer_cart_product > h2")));
        WebElement addProd = driver.findElement(By.cssSelector(".col-md-6.col-xs-12.layer_cart_product > h2"));
        assertEquals("Product successfully added to your shopping cart", addProd.getText());
    }

    @Test
    @DisplayName("Check the possibility of deleting items from the Cart (in the up-right side) using the 'icon-trash'.")
    void testDeleting() {

        // Precondition: There is an item in the cart.
        driver.findElement(By.cssSelector("a[title='Women']")).click();
        driver.findElement(By.linkText("Dresses")).click();
        driver.findElement(By.linkText("Evening Dresses")).click();
        driver.findElement(By.cssSelector(".right-block .product-name")).click();

        Select menuItem = new Select(driver.findElement(By.cssSelector("select#group_1")));
        menuItem.selectByVisibleText("M");

        driver.findElement(By.id("add_to_cart")).click();

        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[title='Continue shopping'] > span")));
        driver.findElement(By.cssSelector("span[title='Continue shopping'] > span")).click();

        // Checking the possibility of deleting items from the Cart.
        new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='View my shopping cart']")));
        driver.findElement(By.cssSelector("a[title='View my shopping cart']")).click();
        driver.findElement(By.cssSelector(".icon-trash")).click();

        //Assertions (Checking if a product has deleted).
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-warning")));
        WebElement emptyCart = driver.findElement(By.cssSelector(".alert-warning"));
        assertEquals("Your shopping cart is empty.", emptyCart.getText());

    }
}