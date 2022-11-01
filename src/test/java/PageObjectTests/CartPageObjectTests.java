package PageObjectTests;

import PageObject.AddingCartPageObject;
import PageObject.DeletingCartPageObject;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPageObjectTests {
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

        String productQuantity = new AddingCartPageObject(driver)
        .clickWomenBtn()
        .clickDressesLink()
        .clickEveningDressesLink()
        .clickProductName()
        .clickAddToCart()
        .getProductQuantity();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#layer_cart_product_quantity")));
       Assertions.assertEquals("1", productQuantity);

        String addProduct = new AddingCartPageObject(driver)
        .getAddProduct();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-md-6.col-xs-12.layer_cart_product > h2")));
        Assertions.assertEquals("Product successfully added to your shopping cart", addProduct);
    }
    @Test
    @DisplayName("Check the possibility of deleting items from the Cart (in the up-right side) using the 'icon-trash'.")
    void testDeleting() {
        driver.get("http://automationpractice.com/index.php");

        // Precondition: There is an item in the cart.
        String cartTitle = new DeletingCartPageObject(driver)
        .clickWomenBtn()
        .clickDressesLink()
        .clickEveningDressesLink()
        .clickProductName()
        .clickAddToCart()
        .clickContShopping()
        .clickViewCart()
        .getCartTitle();
        Assertions.assertEquals("Cart 1 Product", cartTitle);

        String cartEmpty = new DeletingCartPageObject(driver)
        .clickIconTrash()
        .getCartEmpty();
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-warning")));
        Assertions.assertEquals("Your shopping cart is empty.", cartEmpty);

    }
}
