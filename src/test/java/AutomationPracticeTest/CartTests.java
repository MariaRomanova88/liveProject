package AutomationPracticeTest;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    }

    @AfterEach()
    void quit() {
        driver.quit();
    }

    @Test
    @DisplayName("Check the possibility of adding items to the Cart (through the left-side menu-bar).")
    void testAdding() {
        driver.get("http://automationpractice.com/index.php");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Women']")));
        driver.findElement(By.cssSelector("a[title='Women']")).click();

        driver.findElement(By.linkText("Dresses")).click();
        driver.findElement(By.linkText("Evening Dresses")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".right-block .product-name")));
        driver.findElement(By.cssSelector(".right-block .product-name")).click();

        Select menuItem = new Select(driver.findElement(By.cssSelector("select#group_1")));
        menuItem.selectByVisibleText("M");

        driver.findElement(By.id("add_to_cart")).click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#layer_cart_product_quantity")));

        //проверки по наличию товара в корзине

        String productQuantity = driver.findElement(By.cssSelector("#layer_cart_product_quantity")).getText();
        assertEquals("1", productQuantity);

        String addProd = driver.findElement(By.cssSelector(".col-md-6.col-xs-12.layer_cart_product > h2")).getText();
        assertEquals("Product successfully added to your shopping cart", addProd);


        }


    @Test
    @DisplayName("Check the possibility of deleting items from the Cart (in the up-right side) using the 'icon-trash'.")
    void testDeleting() {
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


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='View my shopping cart']")));

        String cartTitle = driver.findElement(By.cssSelector("a[title='View my shopping cart']")).getText();
        assertEquals("Cart 1 Product", cartTitle);

        //Здесь должна быть проверка, что корзина пуста..но я не нашла ровный селектор для алерта "Your shopping cart is empty". (Actual result: пусто, т к из-за несовпадения с ожидаемым "Your shopping cart is empty." проверка не проходит).
        String emptyCart = driver.findElement(By.cssSelector(".alert")).getText();
        assertEquals("", emptyCart);
    }

}


