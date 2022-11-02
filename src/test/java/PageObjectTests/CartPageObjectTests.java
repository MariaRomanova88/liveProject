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
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterEach()
    void quit() {
        driver.quit();
    }

    @Test
    @DisplayName("Check the possibility of adding items to the Cart (through the left-side menu-bar).")
    void testAdding() {

        String productQuantity = new AddingCartPageObject(driver)
        .clickWomenBtn()
        .clickDressesLink()
        .clickEveningDressesLink()
        .clickProductName()
        .clickAddToCart()
        .getProductQuantity();

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(productQuantity)));
        Assertions.assertEquals("1", productQuantity);

        String addProduct = new AddingCartPageObject(driver)
        .getAddProduct();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(addProduct)));
        Assertions.assertEquals("Product successfully added to your shopping cart", addProduct);

    }
    @Test
    @DisplayName("Check the possibility of deleting items from the Cart (in the up-right side) using the 'icon-trash'.")
    void testDeleting() {

        // Precondition: There is an item in the cart.
        String cartEmpty = new DeletingCartPageObject(driver)
        .clickWomenBtn()
        .clickDressesLink()
        .clickEveningDressesLink()
        .clickProductName()
        .clickAddToCart()
        .clickContShopping()
        .clickViewCart()
        .clickIconTrash()
        .getCartEmpty();
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cartEmpty)));
        Assertions.assertEquals("Your shopping cart is empty.", cartEmpty);

    }
}
