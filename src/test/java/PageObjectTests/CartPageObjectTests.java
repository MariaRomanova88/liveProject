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

        AddingCartPageObject addingCartPageObject = new AddingCartPageObject(driver);
        addingCartPageObject.clickWomenBtn();
        addingCartPageObject.clickDressesLink();
        addingCartPageObject.clickEveningDressesLink();
        addingCartPageObject.clickProductName();
        addingCartPageObject.clickAddToCart();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span#layer_cart_product_quantity")));
        String productQuantity = addingCartPageObject.getProductQuantity();
        Assertions.assertEquals("1", productQuantity);

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-md-6.col-xs-12.layer_cart_product > h2")));
        String addProduct = addingCartPageObject.getAddProduct();
        Assertions.assertEquals("Product successfully added to your shopping cart", addProduct);

    }
    @Test
    @DisplayName("Check the possibility of deleting items from the Cart (in the up-right side) using the 'icon-trash'.")
    void testDeleting() {
        driver.get("http://automationpractice.com/index.php");

        // Precondition: There is an item in the cart.
        DeletingCartPageObject deletingCartPageObject = new DeletingCartPageObject(driver);
        deletingCartPageObject.clickWomenBtn();
        deletingCartPageObject.clickDressesLink();
        deletingCartPageObject.clickEveningDressesLink();
        deletingCartPageObject.clickProductName();
        deletingCartPageObject.clickAddToCart();
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[title='Continue shopping'] > span")));
        deletingCartPageObject.clickContShopping();

        new WebDriverWait(driver,5).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='View my shopping cart']")));
        deletingCartPageObject.clickViewCart();
        String cartTitle = deletingCartPageObject.getCartTitle();
        Assertions.assertEquals("Cart 1 Product", cartTitle);
        deletingCartPageObject.clickIconTrash();
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-warning")));
        String cartEmpty = deletingCartPageObject.getCartEmpty();
        Assertions.assertEquals("Your shopping cart is empty.", cartEmpty);

    }
}
