package AutomationPracticeTest;

import MyStore.ProductPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductPageTest {

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
    @DisplayName("Check the clickability of the buttons on the product page 'Printed Dress'.")
    public void testProductPage() {
        driver.get("http://automationpractice.com/index.php?id_product=4&controller=product");

        String product = new ProductPage(driver)
        .quantityIncrease()
        .quantityDecrease()
        .sizeOption()
        .addToCartBtn()
        .homePageLink()
        .getProduct();
        Assertions.assertEquals("Automation Practice Website", product);

    }
}

